$(function(){
    var totalCounts=101;

    var recomURL="/frontend/recomproduct.do";
    var countURL="/frontend/prodCount.do";
    $.getJSON(countURL,function (result){
        if (result.success){
            alert(result.recordCount);
            totalCounts=result.recordCount;
            $("#pagination").jqPaginator({
                totalCounts: totalCounts,
                pageSize:4,
                visiblePages: 10,
                currentPage: 1,
                first: '<li class="first"><a href="javascript:void(0);">首页<\/a><\/li>',
                prev: '<li class="prev"><a href="javascript:void(0);">上一页<\/a><\/li>',
                next: '<li class="next"><a href="javascript:void(0);">下一页<\/a><\/li>',
                last: '<li class="last"><a href="javascript:void(0);">末页<\/a><\/li>',
                page: '<li class="page"><a href="javascript:void(0);">{{page}}<\/a><\/li>',
                onPageChange: function(curPage) {
                    $("#text").html(curPage);
                    pageInfo(curPage);
                }
            });
        }
    });

    function pageInfo(curPage){
        alert(curPage);
        $.getJSON(recomURL,{pageIndex:curPage,pageSize:4},function(result){

            if (result.success){
                var swiperHtml="";
                var productList=result.productList;

                productList.map(function(item,index){
                    var date=item.bookPublishTime;
                    var odate=new Date(date);
                    var fullYear=odate.getFullYear();
                    var month=odate.getMonth()+1;
                    var bookPublishTime=fullYear +'年'+month +'月';
                    swiperHtml+='<li class="row recom-1" style="margin-top:5px;margin-bottom:5px;display:block;height:242px;background-color:#f8f8f8">\n' +
                        '<div class="col-md-3"  style="line-height:242px;">\n' +
                        '\t\t\t<a href="'+item.bookImage+'" target="_blank" alt="点击看大图" class="img-thumbnail"><img src="'+item.bookImage+'" class="imgBook"/></a>\n' +
                        '</div>\n' +
                        '<div class="col-md-9" style="">\t\n' +
                        '           <div class="row">\t\t\n' +
                        '\t\t\t<ul>\n' +
                        '\t\t\t   <li><span style="font-weight:bold;font-size:14px;line-height:24px;">'+item.bookName+'</span></li>\n' +
                        '\t\t\t   <li><span class="search_now_price">¥'+item.discount+'</span><span class="search_pre_price">¥'+item.price+'</span></li>\n' +
                        '   \n' +
                        '\t\t\t   <li><span style="color:blue">'+item.bookAuthor+'</span><span style="color:blue">/'+item.publishDomain.publishingName+'</span>\n' +
                        '\t\t\t   <span style="color:blue">/'+bookPublishTime+'</span></li>\n' +
                        '\t\t\t   <li>ISBN：<span style="color:blue">'+item.bookIsbn+'</span></li>\n' +
                        '\t\t\t   <li>所属分类：<span style="color:blue">'+item.productTypeDomain.bookTypeName+'</span></li>\n' +
                        '\t\t\t   <li>\t\t<p style="height:60px;overflow:hidden">'+item.bookIntroduction+'</p>\n' +
                        '               </li>\n' +
                        '\t\t\t</ul>\n' +
                        '\t\t\t</div>\n' +
                        '\t\t\t<div class="row" style="">\n' +
                        '\t\t\t\t<button type="button" class="btn btn-primary">收藏</button>\n' +
                        '\t\t\t\t<button type="button" class="btn btn-success">加入购物车</button>\n' +
                        '\t\t\t\t<button type="button" class="btn btn-danger">一键购买</button>\n' +
                        '\t\t\t </div>\n' +
                        '</div>\n' +
                        '</li>';
                });

                alert(swiperHtml);
                $('#content-body').html(swiperHtml);
            }

        });
    }


})