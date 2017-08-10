
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
window.onload=function (){
	
	$.ajax({
		url:"filecAction_categoryList",
		type:"POST",
		dataType:"json",
		success:function(data){
			for(var i=0;i<data.length;i++){
				 var d = data[i];
			 $("#categoryId").append("<option value="+d.categoryId+">"+d.category+"</option>");
		
			}	
			 		 
		}
	});
	$.ajax({
		url:"filecAction_filecList",
		type:"POST",
		dataType:"json",
		success:function(filecdata){
			for(var i=0;i<filecdata.length;i++){
			 	var d = filecdata[i];
				$("#filectable").append("<tr>"+"<td>"+"<input type=\"checkbox\" name=\"ids\" value="+d.id+">"+"</checkbox>"+"</td>"+"<td>"+d.id+"</td>"+"<td>"+d.fileFileName+"</td>"+"<td>"
						+d.fileContentType+"</td>"+"<td>"+d.path+"</td>"+"<td>"+d.fileTitle+"</td>"
						+"<td>"+d.fileContent+"</td>"+"<td>"+d.categoryId+"</td>"+"<td>"+"<a href="+"filecAction_filecDelete?id="+d.id+">"
								+"删除"+"</a>"+"<a href="+"updatefilec.jsp?id="+d.id+">"+"修改"+"</a>"+"</td>"+"</tr>");
				
			}	
		}
	
	});

};

//批量删除
var n=1;
function delArc(){
    //函数调用,获取选中id,所组成的字符串
	ids = getSelectCheckboxValues();
	if(ids !=null && ids != ""){
		if(confirm("删除的数据将无法恢复，确认删除?")) {
			window.location.href='filecAction_filecDeleteSeveral?many_id='+ids;
			alert("你已经成功删除记录！");
		}
	}else{
		alert("请至少选择一行！");
	}
}
//选中id,组成的字符串
function getSelectCheckboxValues(){
	//获取名称为ids的checkbox,形成数组
	var objArray = document.getElementsByName('ids');
	//定义返回结果
	var result ='';
	for (var i=0;i<objArray.length;i++){
	    //如果名称为ids的checkbox被选中了，就进行id拼接
		if (objArray[i].checked==true){
				result += objArray[i].value+",";
			}
	}
	//返回拼接结果,之所以截取到 result.length-1，因为result结果最后一个字符是,
	return result.substring(0, result.length-1);
}


//全选
function selAll(){
	for(i=0;i<document.form1.ids.length;i++){
		if(!document.form1.ids[i].checked){
			document.form1.ids[i].checked=true;
		 }
	}
}
function noSelAll(){
	for(i=0;i<document.form1.ids.length;i++){
		if(document.form1.ids[i].checked){
			document.form1.ids[i].checked=false;
		}
	}
}
//checkbox选择全部，或不选择
function selectAllOrNo(){
	n=n+1; 
	if(n%2==0){
		selAll();
	}else{
		noSelAll();
	}
}
//反选
function selOther(){
	for(i=0;i<document.form1.ids.length;i++){
		if(document.form1.ids[i].checked){
			document.form1.ids[i].checked=false;
		}else{
			document.form1.ids[i].checked=true;
		}
	}
}




</script>

</head>
<body>
	<form name="form1" action="filecAction_execute" method="post" enctype="multipart/form-data">
	
		<select id="categoryId" name="categoryId">
		
		</select><br>
		上传文件 : <input type="file" name="file" /> <br> 
  				  文件标题(页面)<input type="text" name="fileTitle"><br>
  				  文件内容<textarea rows="10" name="fileContent"></textarea><br>
  				   <input type="submit" value="上传"><br>
  		<table id="filectable" border="1px">
  			<tr>
  				<td>
  					选择
  				</td>
  				<td>
  					编号
  				</td>
  				<td>
  					文件名
  				</td>
  				<td>
  					文件类型
  				</td>
  				<td>
  					文件路径
  				</td>
  				<td>
  					文件标题（页面）
  				</td>
  				<td>
  					文件内容
  				</td>
  				<td>
  					文件类别
  				</td>
  				<td>
  					操作
  				</td>
  			</tr>
  		</table>
	</form>
	<input type="button"  value="全选" onclick="selectAllOrNo()">
	<input type="button"  value="删除所选内容" onclick="delArc()"><br>
	
</body>
</html>