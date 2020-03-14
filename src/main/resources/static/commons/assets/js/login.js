$(function(){
	getCode();  //获取验证码
	$("#LAY-user-get-vercode").click(function(){
		getCode();
	});
})
//获取验证码
var codeKey = null;
function getCode(){
	
	if(codeKey==null){
		codeKey = guid();
	}
	$("#LAY-user-get-vercode").attr("src","image/captcha?codeKey="+codeKey+"&n="+Math.random());
}
//生成uuid
function guid() {
    function S4() {
       return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+"-"+S4()+"-"+S4()+"-"+S4()+"-"+S4()+S4()+S4());
}

//提交
layui.form.on('submit(LAY-user-login-submit)', function(obj) {
	obj.field.verkey = codeKey;
	layer.load(1);
	$.post("loginAction_login.action ", obj.field, function(data) {
		if (data.code == 200) {
			layer.msg(data.msg,{icon: 1});
			localStorage.setItem("user", JSON.stringify(data.user));
			setTimeout(function() {
				location.replace("index.jsp");
			}, 1000);
		} else {
			layer.closeAll('loading');
			layer.msg(data.msg,{icon: 2});
		}
	}, "json");
});