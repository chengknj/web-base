/**
 * 基础服务JS
 * @type {{}}
 */
var Com = {};

Com.strIsNotEmpty = function(str){
    return !!(str != null && str != undefined && str != '');
}

Com.Ajax = {};
Com.Ajax.postRequest =  function(obj){
    var responseObj = null;
    $.ajax({
        type : 'POST',
        url : obj['url'],
        async : false,
        cache : false,
        data : obj['data'],
        dataType : 'json',
        timeout : 60000,
        beforeSend : function(XMLHttpRequest){
            XMLHttpRequest.setRequestHeader("RequestType", "ajax");
        },
        success :function(data){
            responseObj = data;
        }
    });
    return responseObj;
};