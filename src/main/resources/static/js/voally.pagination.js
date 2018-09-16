var pagination = {
    url:'',
    elem:'pagination',
    version:'1.0',
    config: function(option){
        this.url = option.url || '',
        this.elem = option.elem || 'pagination'
    },
    load: function(option){
        this.config(option);
        var data = option.data;
        var page = data.paginationPage;
        var rows = data.paginationRows;
        var count = data.paginationPageCount;
        var nums = data.paginationPageNums;
        var paginationHtml = "";
        if(page>1){
            paginationHtml += "<li class=\"page-item page-prev\">\n" +
                "                                <a class=\"page-link\" href=\"javascript:go("+page+");\" tabindex=\"-1\">\n" +
                "                                    上一页\n" +
                "                                </a>\n" +
                "                            </li>";
        }else {
            paginationHtml += "<li class=\"page-item page-prev disabled\">\n" +
                "                                <a class=\"page-link\" href=\"javascript:go("+page+");\" tabindex=\"-1\">\n" +
                "                                    上一页\n" +
                "                                </a>\n" +
                "                            </li>";
        }
        for(var i=1,len=nums.length;i<=len;i++){
            if(page==i){
                paginationHtml += "<li class=\"page-item active\"><a class=\"page-link\" href=\"javascript:go("+page+")\">"+i+"</a></li>";
            }else {
                paginationHtml += "<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:go("+page+")\">"+i+"</a></li>";
            }
        }

        if(page<nums.length){
            paginationHtml += "<li class=\"page-item page-prev\">\n" +
                "                                <a class=\"page-link\" href=\"javascript:go("+page+");\" tabindex=\"+1\">\n" +
                "                                    下一页\n" +
                "                                </a>\n" +
                "                            </li>";
        }else {
            paginationHtml += "<li class=\"page-item page-prev disabled\">\n" +
                "                                <a class=\"page-link\" href=\"javascript:go("+page+");\" tabindex=\"+1\">\n" +
                "                                    下一页\n" +
                "                                </a>\n" +
                "                            </li>";
        }

        $(".pagination").prop("data-page",page);

        $(".pagination").html("");
        $(".pagination").append(paginationHtml);
    },
    go: function(page){
        var tabindex = Number($(this).attr("tabindex"));
        page = page + tabindex;
    }
}