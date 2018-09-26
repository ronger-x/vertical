Vue.prototype.showLoading = function(){
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
    setTimeout(function () {
        swal.close();
    },1000);
};