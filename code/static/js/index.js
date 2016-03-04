window.onload = function  () {
	
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

	document.getElementById('toolbar_btn').addEventListener("click",function  (e) {
		var toolbar = document.getElementById('main_toolbar');
		if(toolbar.className.match("toolbar_show")){
			toolbar.className = toolbar.className.replace("toolbar_show","");
		}else{
			toolbar.className += " toolbar_show";
		}
	});




if (document.getElementById("trig_modal")) {
	document.getElementById("trig_modal").onclick=function(){
		document.getElementById("modal").style.display='block';
		document.getElementById("modal-open").style.display='block';
		document.getElementById("modal-foot").style.display='block';		
	}

	document.getElementById("close_modal").onclick=function(){
		document.getElementById("modal").style.display='none';
		document.getElementById("modal-open").style.display='none';
		document.getElementById("modal-foot").style.display='none';
	}	


};

if (document.getElementById("_BCH")) {
	document.getElementById("_BCH").onclick=function(){
		document.location="index.html";
	}	
};

var _FCK = document.getElementsByClassName("_FCK");
for(var i = 0; i < _FCK.length; i++){
	_FCK[i].addEventListener("click",function  (e) {
		document.getElementById('modal_commit').getElementsByTagName('textarea')[0].setAttribute("placeholder","回复    QUOTE：" + e.target.parentNode.getElementsByTagName('span')[0].innerHTML);
	});
}
var submitBtn = document.getElementById('submitBtn');
	if(submitBtn){
		submitBtn.addEventListener("mouseup",function  (e) {
			document.getElementsByClassName("msgList")[0].innerHTML = "<li class='hand'><span>" + document.getElementById('modal-textarea').value + "</span><span class='_FCK'> 回复</span></li>" + document.getElementsByClassName("msgList")[0].innerHTML;
		});
	}
}