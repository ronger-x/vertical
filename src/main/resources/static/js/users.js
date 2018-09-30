Vue.component('users-table-component', {
    props: ['user'],
    template: '<tr>\n' +
    '                                        <td>\n' +
    '                                            <label class="custom-control custom-checkbox">\n' +
    '                                                <input type="checkbox" class="custom-control-input" name="users" v-bind:value="user.id">\n' +
    '                                                <div class="custom-control-label"></div>\n' +
    '                                            </label>\n' +
    '                                        </td>\n' +
    '                                        <td><span class="avatar d-block rounded" v-bind:style="\'background-image: url(\'+ user.userAvatarUrl +\')\'"></span></td>\n' +
    '                                        <td>{{ user.userName }}</td>\n' +
    '                                        <td class="d-none d-md-table-cell">{{ user.nickName }}</td>\n' +
    '                                        <td class="d-none d-md-table-cell">{{ user.userCreateTime }}</td>\n' +
    '                                        <td class="d-none d-md-table-cell">{{ loadUserStatus }}</td>\n' +
    '                                        <td>\n' +
    '                                            <a class="icon" href="javascript:void(0);"><i class="fe fe-edit"></i></a>\n' +
    '                                        </td>\n' +
    '                                    </tr>',
    computed: {
        loadUserStatus: function () {
            if(this.user.userStatus == 0){
                return "正常";
            }else if(this.user.userStatus == 1) {
                return "停用";
            }else {
                return "注销";
            }
        }
    }
});

Vue.component('users-pagination-component', {
    props: ['pagenum','pagination'],
    template: '<li class="page-item" v-if="pagenum == pagination.paginationPage"><a class="page-link active" href="javascript:void(0);" @click="go">{{ pagenum }}</a></li>' +
    '<li class="page-item" v-else><a class="page-link" href="javascript:void(0);" @click="go">{{ pagenum }}</a></li>',
    methods:{
        go:function (){
            var userName = $("#userName").val();
            var userStatus = $("#userStatus").val();
            var orderBy = $("#orderBy").val();
            getTags(this.pageNum, usersVm.pagination.paginationSize, userName, userStatus, orderBy);
        }
    }
});

var usersVm = new Vue({
    el:'#users-page',
    data:{
        users:[],
        pagination:{
            paginationPage: '1',
            paginationSize: '20'
        },
        order: 'desc'
    },
    methods:{
        updateOrder: function () {
            usersVm.users.reverse();
        },
        searchUsers: function (event) {
            var tagTitle = $("#userName").val();
            var tagStatus = $("#userStatus").val();
            getUsers(usersVm.pagination.paginationPage, usersVm.pagination.paginationSize, tagTitle, tagStatus, usersVm.order);
        }
    }
});

function getUsers(page, size, userName, userStatus, orderBy){
    usersVm.showLoading();
    $.get("/admin/getUsers",{page: page, size: size, userName:userName, userStatus: userStatus, orderBy: orderBy},function (data) {
        var users = data.data.data;
        var pagination = data.data.pagination;
        if(users){
            usersVm.users.shift();
        }
        for (var i in users){
            usersVm.users.push(users[i]);
        }
        // 更新分页信息
        usersVm.pagination = pagination;
        usersVm.hideLoading();
    })
}

usersVm.searchUsers();
