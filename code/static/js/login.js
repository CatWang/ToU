window.onload = function  () {
	mdbtn.init();
	mdtext.init();
	musicController.init("musicaudio",{controllerElements:{toggle:"musiccontroller"}});
	musicController.addMusic(
	[
		{
			name: '秋水江湖',
			src: 'http://sc1.111ttt.com/2015/1/02/18/95181958046.mp3',
		},
		{
			name: '午后柠檬树下的阳光',
			src: 'http://sc1.111ttt.com/2015/1/02/18/95181958046.mp3',
		},
	]);

	if(navigator.userAgent.toLowerCase().indexOf("firefox")>=0){
		document.getElementById('musiccontroller').addEventListener("mouseup",function  (e) {
			if(musicController.isPlay){
				document.getElementById('musiccontroller').getElementsByTagName('img')[0].src = "static/img/turn_on.png";
			}else{
				document.getElementById('musiccontroller').getElementsByTagName('img')[0].src = "static/img/turn_off.png";
			}		
		});
	}else{
		document.getElementById('musiccontroller').addEventListener("click",function  (e) {
			if(musicController.isPlay){
				document.getElementById('musiccontroller').getElementsByTagName('img')[0].src = "static/img/turn_on.png";
			}else{
				document.getElementById('musiccontroller').getElementsByTagName('img')[0].src = "static/img/turn_off.png";
			}		
		});
	}
	
	document.getElementById('newaccount').addEventListener("click",function  (e) {
		e.preventDefault();
		changePage("signup");
	});
	document.getElementById('hasaccount').addEventListener("click",function  (e) {
		e.preventDefault();
		changePage("login");
	});
	if(navigator.userAgent.toLowerCase().indexOf("firefox")>=0){
		document.getElementById('loginbtn').addEventListener("mouseup",function  (e) {
		e.preventDefault();
		loginEvent();
		});
		document.getElementById('signupbtn').addEventListener("mouseup", function  (e) {
			e.preventDefault();
			signupEvent();
		});
	}
	document.getElementById('loginbtn').addEventListener("click",function  (e) {
		e.preventDefault();
		loginEvent();
	});
	document.getElementById('signupbtn').addEventListener("click", function  (e) {
		e.preventDefault();
		signupEvent();
	});
	document.getElementById('username').addEventListener("keydown",function  (e) {
		if(e.keyCode==13) {
			document.getElementById('password').focus();
		}
	});
	document.getElementById('password').addEventListener("keydown",function  (e) {
		if(e.keyCode==13) {
			e.target.blur();
			document.getElementById('loginbtn').click();
		}
	});
	window.onresize = function  () {
		if(document.body.dataset.page != "login"){
			changePage("signup");
		}
	}
	changePage("login");
}
function changePage (page) {
	var nextPage = page;
	if(nextPage.match("login")){
		document.getElementById('loginwrap').style.marginTop = 0;
		var signupinputs = document.getElementById('signupwrap').getElementsByTagName('input');
		for (var i = signupinputs.length - 1; i >= 0; i--) {
			signupinputs[i].disabled = "disabled";
		};
		var logininputs = document.getElementById('loginwrap').getElementsByTagName('input');
		for (var i = logininputs.length - 1; i >= 0; i--) {
			logininputs[i].disabled = "";
		};
	}else{
		document.getElementById('loginwrap').style.marginTop = "-" + document.body.clientHeight + "px"; 
		var signupinputs = document.getElementById('signupwrap').getElementsByTagName('input');
		for (var i = signupinputs.length - 1; i >= 0; i--) {
			signupinputs[i].disabled = "";
		};
		var logininputs = document.getElementById('loginwrap').getElementsByTagName('input');
		for (var i = logininputs.length - 1; i >= 0; i--) {
			logininputs[i].disabled = "disabled";
		};
	}
	document.body.dataset.page = nextPage;
}

//这里模拟ajax获取数据可能会有的延迟
var timer;

function loginEvent () {
	var loginbtn = document.getElementById('loginbtn');
	if(!loginbtn.className.match("loading")){
		loginbtn.className += " loading";
	}
	var username = document.getElementById('username');
	var password = document.getElementById('password');
	var error = false;
	if(!password.value){
		if(!password.className.match("error")){
			password.parentNode.getElementsByTagName('span')[0].innerHTML = "请输入密码";
			password.className += " error";
		}
		password.focus();
		error = true;
	}
	if(!username.value){
		if(!username.className.match("error")){
			username.parentNode.getElementsByTagName('span')[0].innerHTML = "请输入用户名";
			username.className += " error";
		}
		username.focus();
		error = true;
	}
	if(error){
		loginbtn.className = loginbtn.className.replace("loading","");
		return;
	}else{
		clearTimeout(timer);
		timer = setTimeout(function  () {
			window.location.href="index.html";
		},2000);
	}
}
function signupEvent () {
	var signupbtn = document.getElementById('signupbtn');
	if(!signupbtn.className.match("loading")){
		signupbtn.className += " loading";
	}
	var newusername = document.getElementById('newusername');
	var newpassword = document.getElementById('newpassword');
	var newpassword2 = document.getElementById('newpassword2');
	var newnickname = document.getElementById('newnickname');
	var error = false;
	if(!newnickname.value){
		if(!newnickname.className.match("error")){
			newnickname.parentNode.getElementsByTagName('span')[0].innerHTML = "请输入昵称";
			newnickname.className += " error";
		}
		newnickname.focus();
		error = true;
	}
	if(!newpassword.value){
		if(!newpassword.className.match("error")){
			newpassword.parentNode.getElementsByTagName('span')[0].innerHTML = "请输入密码";
			newpassword.className += " error";
		}
		newpassword.focus();
		error = true;
	}else{
		if(!newpassword2.value || newpassword2.value != newpassword.value){
			if(!newpassword2.className.match("error")){
				newpassword2.parentNode.getElementsByTagName('span')[0].innerHTML = "两次密码不一致";
				newpassword2.className += " error";
			}
			newpassword2.value = "";
			newpassword2.focus();
			error = true;
		}
	}
	if(!newusername.value){
		if(!newusername.className.match("error")){
			password.parentNode.getElementsByTagName('span')[0].innerHTML = "请输入用户名";
			newusername.className += " error";
		}
		newusername.focus();
		error = true;
	}
	if(error){
		signupbtn.className = signupbtn.className.replace("loading","");
		return;
	}else{
		//提交
		clearTimeout(timer);
		setTimeout(function  () {
			window.location.href="index.html";
		},2000);
		
	}
}