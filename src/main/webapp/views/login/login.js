/**
 * 登录js
 */
var login = function(){

    this.init = function(){
        /*$("#loginBtn").click(function(){
            var loginNo = $("#loginNo").val();
            var pwd = $("#password").val();
            if(!Com.strIsNotEmpty(loginNo)){
                lg.changeTips("Please Enter Username");
                return false;
            }
            if(!Com.strIsNotEmpty(pwd)){
                lg.changeTips("You Must Enter The Password");
                return false;
            }
            var reqObj = {};
            reqObj['url'] = '/login/login.json';
            reqObj['data'] = {};
            reqObj['data']['username'] = $("#loginNo").val();
            reqObj['data']['password'] = $("#password").val();
            var resObj = Com.Ajax.postRequest(reqObj);
            if(resObj.code = '0000' && resObj.data.success == true){
                window.location.href = '/views/index.html';
            }else{
                lg.changeTips("Incorrect Username or Password");
            }
        });*/
    };

    this.changeTips = function(str){
        $("#loginTip").text(str);
        $("#loginTip").css('color','red');
    }

};

var lg = new login();

$(document).ready(function(){
   lg.init();
});