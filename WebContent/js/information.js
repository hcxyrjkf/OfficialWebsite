/**
 * Created by Administrator on 2017/7/18.
 */
$(function () {
//   导航栏
    $('.header_box span').on('mouseenter mouseleave', function () {
        $(this).find('ul').slideToggle()
    })
    //主营业务
    $('.con1').on("mouseenter mouseleave", function () {
        $(this).find('.con_box2').slideToggle()
    })

    //    面包屑下拉框
    $('.mianbaoxie').on('click', function () {
        $('.media ul').slideToggle();
    })
    $(".media ul li").on("click",function(){
        $(this).find("img").addClass("img_animate")
        $(this).find('div').slideToggle()
    })


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


})

