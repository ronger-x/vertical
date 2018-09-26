var voallyTable = {
    url:'',
    method:'GET',
    elem:'voallyTable',
    columns:[],
    queryParams:{},
    config: function(option){
        this.url = option.url || '',
        this.method = option.method || 'GET',
        this.elem = option.elem || 'voallyTable',
        this.queryParams = option.queryParams || {};
        this.columns = option.columns || [];

        this.load(option.queryParams);
    },
    table: function(option){
        this.config(option);
    },
    load: function (data) {
        var that = this;
        var xhr;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xhr=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xhr=new ActiveXObject("Microsoft.XMLHTTP");
        }

        xhr.onreadystatechange=function(){

            if (xhr.readyState==4 && xhr.status==200)
            {
                var data = JSON.parse(xhr.responseText);
                var result = data.data;
                var flag = data.success;

                if(flag) {
                    var list = result.list;
                    var tableHtml = "<table class=\"table card-table table-vcenter\" id=\""+this.elem+"\">";
                    var theadHtml = "<thead><tr>";
                    var columns = that.columns;
                    for (var i=0,len=columns.length;i<len;i++){
                        var feature = columns[i].feature;
                        var image = columns[i].image;
                        if(feature){
                            theadHtml += "<th class='w-1'>"+columns[i].title+"</th>";
                        }else {
                            theadHtml += "<th class='d-none d-sm-table-cell'>"+columns[i].title+"</th>";
                        }
                    }
                    theadHtml += "</tr></thead>";

                    var tbodyHtml = "<tbody>";
                    for (var i = 0, len = list.length; i < len; i++) {
                        var obj = list[i];
                        console.log(obj);
                        console.log(obj['id']);
                        tbodyHtml += "<tr>\n";
                        for (var j=0,len1=columns.length;j<len1;j++){

                            var field = columns[j].field;
                            console.log(field);
                            var feature = columns[j].feature;
                            var value = obj[""+field+""];

                            if(field == 'ck'){
                                tbodyHtml += "<tr>\n" +
                                    "                                        <td>\n" +
                                    "                                            <label class=\"custom-control custom-checkbox\">\n" +
                                    "                                                <input type=\"checkbox\" class=\"custom-control-input\" name=\"userId\" value=\""+obj.id+"\">\n" +
                                    "                                                <div class=\"custom-control-label\"></div>\n" +
                                    "                                            </label>\n" +
                                    "                                        </td>\n";
                            }else {
                                if(feature){
                                    tbodyHtml += "<td>";
                                }else {
                                    tbodyHtml += "<td class=\"d-none d-md-table-cell\">";
                                }

                                if(image){
                                    tbodyHtml += "<span class=\"avatar d-block rounded\" style=\"background-image: url(\" + value + \")\"></span></td>\n";
                                }else {
                                    tbodyHtml += value + "</td>\n";
                                }
                            }
                        }

                        tbodyHtml += "</tbody>";
                    }



                    tableHtml += theadHtml + tbodyHtml + "</table>";

                    console.log(tableHtml);

                }


            }

        }

        xhr.open(this.method,this.url);
        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr.send(data);
    }
}

