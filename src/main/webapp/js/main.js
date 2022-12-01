//毫秒值转日期字符串
function msToString(ms) {
    var date = new Date(ms);
    var year = date.getFullYear();
    var month = date.getMonth();
    var d = date.getDate();
    if (month <= 9){
        month = "0" + month;
    }
    if (d <= 9){
        d = "0" + d;
    }

    return year + "-" + month + "-" + d;
}