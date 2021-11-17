$(function () {


   // alert("hhh");
    //访问后台，获取销售量最高的4本图书条列表
    recomProduct();
    //访问后台，获取图书类型
    getType();
    //访问后台，获取新书上架列表
    newProduct();
    //访问后台，获取猜你喜欢图书列表
    likedProduct();

    //获取动态广告
    getCarousel();


    $("#like_button").click(function (){
        alert("like");
        likedProduct();
    })

});

function  getCarousel(){
    //定义访问后台，获取推荐图书列表
    var carouselUrl = '/frontend/header.do';
    $.getJSON(carouselUrl, function (data) {

        if (data.success) {
            var headerList =data.headList;
            var swiperHtml = '';

            $.map(headerList,function (item,index){
                if (index==1){
                    swiperHtml+='<div class="item active">\n' +
                        '                <img class="first-slide" src="'+item.img+'" alt="First slide">\n' +
                        '            </div>';
                }
                else{
                swiperHtml+='<div class="item">\n' +
                    '                <img class="first-slide" src="'+item.img+ '" alt="First slide">\n' +
                    '            </div>';
                }

            });
            $("#carousel-1").html(swiperHtml);
        }
    });
}

/**
 * 获取推荐图书列表
 */
function recomProduct(){
    //定义访问后台，获取推荐图书列表
    var recomUrl = '/frontend/recom.do';
    $.getJSON(recomUrl, function (data) {
        if (data.success) {
            //获取后台传递过来的图书列表
            var recomList = data.recomList;
            // recomList=$(recomList);
            //  alert(recomList);
            var swiperHtml = '';
            //遍历图书列表，
            $.map(recomList, function (item, index) {
                swiperHtml += ' <div class="col-sm-4 col-md-3">\n' +
                    '                    <div class="thumbnail">\n' +
                    '                        <a href="#"><img src="' + item.bookImage + '" class="img-responsive img-thumbnail" alt="..."\n' +
                    '                                         style="height: 150px;width:150px;"/></a>\n' +
                    '                        <div class="caption">\n' +
                    '                            <h5 class="book_title"><a href="#">' + item.bookName + '</a></h5>\n' +
                    '                            <p class="book_intro">\n' + item.bookIntroduction +
                    '                                 </p>\n' +
                    '                            <p><span class="search_now_price">¥' + item.discount + '</span><span class="search_pre_price">¥' + item.price + '</span>\n' +
                    '                            </p>\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                </div>\n';
            });
            //将图书列表赋值给前端HTML控件
            $('#recom_product').html(swiperHtml);
        }
    });
}
/**
 * 获取推荐图书类型列表
 */
function getType(){
    var typeUrl='/frontend/gettype.do';
    $.getJSON(typeUrl, function (data) {
        if (data.success) {
            // 加载图书类别
            var typeList=data.typeList;
            swiperHtml = ' <a href="#" class="list-group-item active" style="background-color:#3c763d;">\n' +
                '                图书分类\n' +
                '            </a>\n';
            typeList.map(function (item,index){
                swiperHtml+='<a href="#" class="list-group-item" booktypeid="'+item.bookTypeID+'">'+item.bookTypeName+'</a>\n';
            });
            $("#productTypeList").html(swiperHtml);
        }

    });
}

/**
 * 猜你喜欢
 */
function likedProduct(){
    var likedUrl = '/frontend/like.do';
    $.getJSON(likedUrl, function (data) {
        if (data.success) {

//加载猜你喜欢
            var likedList=data.likedList;
            swiperHtml = '';
            likedList.map(function (item,index){
                swiperHtml +='<div class="col-sm-3 col-md-2">\n' +
                    '                <div class="thumbnail">\n' +
                    '                    <a href="#"><img src="'+ item.bookImage+'" class="img-responsive img-thumbnail " alt="..."\n' +
                    '                                     style="width:150px;height:150px;"/></a>\n' +
                    '                    <div class="caption">\n' +
                    '                        <h5  class="book_title"><a href="#">'+item.bookName+'</a></h5>\n' +
                    '                        <p ><span class="search_now_price">¥' + item.discount + '</span><span class="search_pre_price">¥' + item.price + '</span></p>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </div>\n';

            });

            $("#likedBooksList").html(swiperHtml);
        }
    });

}

/**
 * 新书上架
 */
function newProduct(){
    var newUrl = '/frontend/newbook.do';
    $.getJSON(newUrl, function (data) {
        if (data.success) {
            //加载新书上架
            var newItemList=data.newItemList;
            swiperHtml = '';
            newItemList.map(function (item,index){
                swiperHtml +='<div class="col-sm-3 col-md-2">\n' +
                    '                <div class="thumbnail">\n' +
                    '                    <a href="#"><img src="'+ item.bookImage+'" class="img-responsive img-thumbnail " alt="..."\n' +
                    '                                     style="width:150px;height:150px;"/></a>\n' +
                    '                    <div class="caption">\n' +
                    '                        <h5  class="book_title"><a href="#">'+item.bookName+'</a></h5>\n' +
                    '                        <p ><span class="search_now_price">¥' + item.discount + '</span><span class="search_pre_price">¥' + item.price + '</span></p>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </div>\n';

            });

            $("#newBooksShelves").html(swiperHtml);
        }
    });
}
