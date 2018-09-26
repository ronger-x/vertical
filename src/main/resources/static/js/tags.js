Vue.component('tags-table-component', {
    props: ['tag'],
    template: '<tr>\n' +
    '                                        <td>\n' +
    '                                            <label class="custom-control custom-checkbox">\n' +
    '                                                <input type="checkbox" class="custom-control-input" name="tags" v-bind:value="tag.id">\n' +
    '                                                <div class="custom-control-label"></div>\n' +
    '                                            </label>\n' +
    '                                        </td>\n' +
    '                                        <td><span class="avatar d-block rounded" v-bind:style="\'background-image: url(\'+ tag.tagIconPath +\')\'"></span></td>\n' +
    '                                        <td>{{ tag.tagTitle }}</td>\n' +
    '                                        <td class="d-none d-md-table-cell">{{ tag.tagURI }}</td>\n' +
    '                                        <td class="d-none d-md-table-cell">{{ loadTagStatus }}</td>\n' +
    '                                        <td>\n' +
    '                                            <a class="icon" href="javascript:void(0);"><i class="fe fe-edit"></i></a>\n' +
    '                                        </td>\n' +
    '                                    </tr>',
    computed: {
        loadTagStatus: function () {
            if(this.tag.tagStatus == 0){
                return "正常";
            }else {
                return "停用";
            }
        }
    }
});

Vue.component('tags-pagination-component', {
    props: ['pagenum','pagination'],
    template: '<li class="page-item" v-if="pagenum == pagination.paginationPage"><a class="page-link active" href="javascript:void(0);" v-on:click="go">{{ pagenum }}</a></li>' +
    '<li class="page-item" v-else><a class="page-link" href="javascript:void(0);" v-on:click="go">{{ pagenum }}</a></li>',
    methods:{
        go:function (){
            var tagTitle = $("#tagTitle").val();
            var tagStatus = $("#tagStatus").val();
            var orderBy = $("#orderBy").val();
            getTags(this.pageNum, tagsVm.pagination.paginationSize, tagTitle, tagStatus, orderBy);
        }
    }
});

var tagsVm = new Vue({
    el:'#tags-page',
    data:{
        tags:[],
        pagination:{
            paginationPage: '1',
            paginationSize: '20'
        },
        order: 'desc'
    },
    methods:{
        updateOrder: function () {
            tagsVm.tags.reverse();
        },
        searchTags: function (event) {
            var tagTitle = $("#tagTitle").val();
            var tagStatus = $("#tagStatus").val();
            getTags(tagsVm.pagination.paginationPage, tagsVm.pagination.paginationSize, tagTitle, tagStatus, tagsVm.order);
        }
    }
});

function getTags(page, size, tagTitle, tagStatus, orderBy){
    tagsVm.showLoading();
    $.get("/admin/getTags",{page: page, size: size, tagTitle:tagTitle, tagStatus: tagStatus, orderBy: orderBy},function (data) {
        var tags = data.data.data;
        var pagination = data.data.pagination;
        if(tags){
            tagsVm.tags.shift();
        }
        for (var i in tags){
            tagsVm.tags.push(tags[i]);
        }
        // 更新分页信息
        tagsVm.pagination = pagination;
        tagsVm.hideLoading();
    })
}

tagsVm.searchTags();