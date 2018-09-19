Vue.component('articles-component',{
    props: ['article'],
    template:'<div class="col-lg-12">\n' +
    '                                <div class="card">\n' +
    '                                    <div class="card-body d-flex flex-column">\n' +
    '                                        <h4><a v-bind:href="article.articlePermalink">{{ article.articleTitle }}</a></h4>\n' +
    '                                        <div class="text-muted article-summary-md" >{{ article.articleSummary }} \n' +
    '                                        </div>\n' +
    '                                        <div class="d-flex align-items-center pt-5 mt-auto">\n' +
    '                                            <div class="avatar avatar-md mr-3"\n' +
    '                                                 v-bind:style="\'background-image: url(\'+ article.thinker.userAvatarUrl +\')\'">\n' +
    '                                            </div>\n' +
    '                                            <div>\n' +
    '                                                <a v-bind:href="article.thinker.userUrl" class="text-default">{{ article.thinker.nickName }}</a>\n' +
    '                                                <small class="d-block text-muted" >{{ article.timeAgo }}</small>\n' +
    '                                            </div>\n' +
    '                                            <div class="ml-auto text-muted">\n' +
    '                                                <a href="javascript:void(0)" class="icon d-none d-md-inline-block ml-3"><i\n' +
    '                                                        class="fe fe-heart mr-1"></i></a>\n' +
    '                                            </div>\n' +
    '                                        </div>\n' +
    '                                    </div>\n' +
    '                                </div>\n' +
    '                            </div>'
});

var vm = new Vue({
    el:'#articles-content',
    data:{
        articles:[],
        pagination:{
            paginationPage: '1',
            paginationSize: '20'
        }
    }
});

function getArticles(page,size){
    $.get("/getArticles",{page: page, size: size},function (data) {
        var articles = data.data.data;
        var pagination = data.data.pagination;
        for (var i in articles){
            vm.articles.push(articles[i]);
        }
        // 更新分页信息
        vm.pagination = pagination;
    })
}

$(function () {
    getArticles(vm.pagination.paginationPage,vm.pagination.paginationSize);
});

//jquery 监听页面滚动至页面底部
$(window).scroll(function(){
    var scrollTop = $(this).scrollTop();
    var scrollHeight = $(document).height();
    var windowHeight = $(this).height();
    if(scrollTop + windowHeight == scrollHeight){
        if(vm.pagination.nextPage && vm.pagination.nextPage >0){
            getArticles(vm.pagination.nextPage,vm.pagination.paginationSize);
        }
    }
});