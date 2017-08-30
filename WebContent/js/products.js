/**
 * Created by Administrator on 2017/7/18.
 */
$(function () {
//   瀵艰埅鏍�
    $('.header_box span').on('mouseenter mouseleave', function () {
        $(this).find('ul').slideToggle()
    })
    //涓昏惀涓氬姟
    $('.con1').on("mouseenter mouseleave", function () {
        $(this).find('.con_box2').slideToggle()
    })

    // 闈㈠寘灞戜笅鎷夋
    $('.mianbaoxie').on('click', function () {
        $('.media ul').slideToggle();
    })
    $(".media ul li").on("click",function(){
        $(this).find("img").addClass("img_animate")
        $(this).find('div').slideToggle()
    })
    //导航跳转
    $('#contact').on('click',function(){
        location.href = "contact.html"
    })
    $('#product').on('click',function(){
        location.href = "products.html"
    })
    $('#yewus').on('click',function(){
        location.href = "index.html"
    })
    $('#jianjie').on('click',function(){
        location.href = "information.html"
    })


    function myBrowser(){
        var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
        var isOpera = userAgent.indexOf("Opera") > -1;
        if (isOpera) {
            return "Opera"
        }; //判断是否Opera浏览器
        if (userAgent.indexOf("Firefox") > -1) {
            return "FF";
        } //判断是否Firefox浏览器
        if (userAgent.indexOf("Chrome") > -1){
            return "Chrome";
        }
        if (userAgent.indexOf("Safari") > -1) {
            return "Safari";
        } //判断是否Safari浏览器
        if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera) {
            return "IE";
        }; //判断是否IE浏览器
    }

    //以下是调用上面的函数
    var mb = myBrowser();
    if ("IE" == mb) {
//         alert("我是 IE");
        $.ajax({
            type:"POST",
            url:"filecAction_filecWebList",
            dataType:"json",
            success: function(msg){
//               var data = eval("("+msg+")");
                $(msg).each(function(i,v){
             	   if(i%2==0){
             		   console.log(i)
             	  	   $('.color').append("<div class=\"product_list\">"
                                +"<div class=\"product_box\">"
                                +"<div class=\"list\">"
                                +"<span>"+(v.id)/2+"</span>"
                                +"<h2>"+v.fileTitle+"</h2>"
                                +"<p>"+v.fileContent+"</p>"
                                +"</div>"
                                +"<div class=\"shows\">"
                                +"<div class=\"play\" value="+v.path+">"+"</div>"
                                +"<img src=\"img/product0.jpg\" alt=\"\">"
                                +"</div>"
                                +"</div>"
                                + "</div>");
                 	   $('.play').on('click',function(){
                 	       var val=$(this).attr('value')
                 	       $('.openIframe').css('display','block');
                 	       $('.color').addClass('colorss')
                 	       $('.close').css('display','block');
                 	       $('iframe').attr('src',"http://47.93.227.28/OfficialWebsite/"+val);
                 	   })
             	   }
           
                })
            },
            error:function(data){
                 alert("0")
            }
        })

    }else {
    	$.ajax({
            type:"POST",
            url:"filecAction_filecWebList",
            dataType:"json",
            success: function(msg){
//               var data = eval("("+msg+")");
                $(msg).each(function(i,v){
             	   if(i%2==1){
             		   console.log(i)
             	  	   $('.color').append("<div class=\"product_list\">"
                                +"<div class=\"product_box\">"
                                +"<div class=\"list\">"
                                +"<span>"+v.id+"</span>"
                                +"<h2>"+v.fileTitle+"</h2>"
                                +"<p>"+v.fileContent+"</p>"
                                +"</div>"
                                +"<div class=\"shows\">"
                                +"<div class=\"play\" value="+v.path+">"+"</div>"
                                +"<img src=\"img/product0.jpg\" alt=\"\">"
                                +"</div>"
                                +"</div>"
                                + "</div>");
                 	   $('.play').on('click',function(){
                 	       var val=$(this).attr('value')
                 	       $('.openIframe').css('display','block');
                 	       $('.color').addClass('colorss')
                 	       $('.close').css('display','block');
                 	       $('iframe').attr('src',"http://47.93.227.28/OfficialWebsite/"+val);
                 	   })
             	   }
           
                })
            },
            error:function(data){
                 
            }
        })
	}
       
//    var iframe=$('iframe')
//   $('.play').on('click',function(value){
//      var val=$(this).attr('value')
//       //alert(val)
//       $('.openIframe').css('display','block');
//       $('.color').addClass('colorss')
//       $('.close').css('display','block');
//       //iframe.attr('src','unit3d/2/2.html');
////       iframe.attr('src',"unit3d/"+val+"/"+val+".html");
//       //alert("unit3d/"+val+"/"+val+".html")
//
//
//   })
    $('.color .close').on('click',function(){
            $('.color').removeClass('colorss')
            $('.close').css('display','none');
            $('.openIframe').css('display','none');
            //$('.product_list iframe').attr('src','img/product0.jpg')
            //$('.product_list1 iframe').attr('src','img/product1.jpg')
        })
})
