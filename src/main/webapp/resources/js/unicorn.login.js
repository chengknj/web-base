/**
 * Unicorn Admin Template
 * Diablo9983 -> diablo9983@gmail.com
**/
$(document).ready(function(){

    jQuery.browser={};(function(){jQuery.browser.msie=false; jQuery.browser.version=0;if(navigator.userAgent.match(/MSIE ([0-9]+)./)){ jQuery.browser.msie=true;jQuery.browser.version=RegExp.$1;}})();

	var login = $('#loginform');
	var recover = $('#recoverform');
	var speed = 400;

	$('#to-recover').click(function(){
		login.fadeTo(speed,0.01).css('z-index','100');
		recover.fadeTo(speed,1).css('z-index','200');
	});

	$('#to-login').click(function(){
		recover.fadeTo(speed,0.01).css('z-index','100');
		login.fadeTo(speed,1).css('z-index','200');
	});

    var version=window.navigator.userAgent.match(/MSIE\s\d+/);
    if(version != null){
        var vNumber=version[0].split(" ")[1];
        if(navigator.userAgent.toLowerCase() == true && vNumber!=undefined && vNumber < 10) {
            $('input[placeholder]').each(function(){
                var input = $(this);
                $(input).val(input.attr('placeholder'));
                $(input).focus(function(){
                    if (input.val() == input.attr('placeholder')) {
                        input.val('');
                    }
                });
                $(input).blur(function(){
                    if (input.val() == '' || input.val() == input.attr('placeholder')) {
                        input.val(input.attr('placeholder'));
                    }
                });
            });
        }
    }
});