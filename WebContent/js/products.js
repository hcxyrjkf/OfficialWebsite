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

    //    闈㈠寘灞戜笅鎷夋
    $('.mianbaoxie').on('click', function () {
        $('.media ul').slideToggle();
    })
    $(".media ul li").on("click",function(){
        $(this).find("img").addClass("img_animate")
        $(this).find('div').slideToggle()
    })


    //椤圭洰灞曠ず
    //var iframe=$('iframe')
    //$('.play').on('click',function(){
    //    //for( var i=0;i<iframe.length;i++){
    //    //   iframe.attr('src', 'img/product'+i+'.jpg');
    //    //}
    //    $('.color').addClass('colorss')
    //    $('.close').css('display','block');
    //    $(this).next().addClass('big')
    //    $('.big').attr('src','unit3d/11111.html');
    //    //$(this).next().attr('src','unit3d/333/333.html');
    //})
    //
    //$('.color .close').on('click',function(){
    //    $('.color').removeClass('colorss')
    //    $('.close').css('display','none');
    //    iframe.removeClass('big')
    //    $('.product_list iframe').attr('src','img/product0.jpg')
    //    $('.product_list1 iframe').attr('src','img/product1.jpg')
    //
    //
    //})

    
       $.ajax({
           type:"POST",
           url:"filecAction_filecWebList",
           dataType:"json",
           success: function(msg){
//              var data = eval("("+msg+")");
               $(msg).each(function(i,v){
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
            	       $('iframe').attr('src',"http://localhost:8080/webTest/"+val);
            	   })
//            	   var a="unit3d\\"+v.id+"\\"+v.id+".html";
//                   $('iframe').attr('src',a);
//                   $("span").text(v).appendTo(".product_list .list");
//                   $('h2').html( v.id).appendTo(".product_list .list");
               })
           },
           error:function(data){
                alert("0")
           }
       })
       
       
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
