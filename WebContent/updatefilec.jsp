<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改文件</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">  
window.onload = function(){
	var id = $("#uid").val();
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
	url:"filecAction_findone",
	type:"POST",
	data:{"id":id},
	dataType:"json",
	success:function(filecdata){
		for(var i=0;i<filecdata.length;i++){
		 	var d = filecdata[i];
			$("#id").append(d.id);
			$("#fileFileName").append(d.fileFileName);
			$("#fileContentType").append(d.fileContentType);
			$("#path").append(d.path);
			$("#cId").append(d.categoryId);
		}	
	}

});
	
	
	
}
</script>

</head>
<body>
	
	<table id="updatetable" border="1px">
  			<tr>
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
  					文件类别
  				</td>
  			</tr>
  				<tr>
  				<td id="id">
  					
  				</td>
  				<td id="fileFileName">
  					
  				</td>
  				<td id="fileContentType">
  					
  				</td>
  				<td id="path">
  					
  				</td>
  				<td id="cId">
  					
  				</td>
  			</tr>
  			
  	</table>
  	<form action="filecAction_filecUpdate" method="post" enctype="multipart/form-data">
  	<input type="hidden" id="uid" value="<%out.print( request.getParameter("id")); %>">
  	<select id="categoryId" name="categoryId">
		
		</select><br>
  	上传<input type="File" name="file">
		<input type="submit" value="确认修改">
		<a href="loginsuccess.jsp">返回</a>
  	</form>

</body>
</html>