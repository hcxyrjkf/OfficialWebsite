/**
 * Created by Administrator on 2017/7/13.
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
    //监听鼠标滚动，设置导航栏背景色
    $(window).scroll(function() {
        var s =$(window).scrollTop();
        if (s>=752) {//782是导航条离页面顶部的距离（px）
            $(".top-header").addClass("colors")
        }
        else{
            $('.top-header').removeClass('colors');
        }
    })

//    面包屑下拉框
    $('.mianbaoxie').on('click', function () {
        $('.media ul').slideToggle();
    })
    $(".media ul li").on("click",function(){
        $(this).find("img").addClass("img_animate")
        $(this).find('div').slideToggle()
    })

})
