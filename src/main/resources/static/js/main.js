Vue.prototype.showLoading = function(){
    console.log("加载数据ing...");
    swal({
        html: "<div class=\"line-scale-pulse-out\">\n" +
        "        <div></div>\n" +
        "        <div></div>\n" +
        "        <div></div>\n" +
        "        <div></div>\n" +
        "        <div></div>\n" +
        "      </div>",
        background:'transparent',
        showConfirmButton: false,
        allowEscapeKey: false,
        allowOutsideClick: false
    });
};

Vue.prototype.hideLoading = function () {
    console.log("加载数据完成...");
    swal.close();
};