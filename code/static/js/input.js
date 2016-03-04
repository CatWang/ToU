/**
 * 一个简单的material design 的文本框
 * by IwYvI
 * 2015.11.28
 */

;(function(window, document, undefined) {
	"use strict";
	var NAME = "mdtext";
	var mdtext = {};
	mdtext.init = function  () {
		var inputtext = document.getElementsByClassName("inputtext");
		for(var i = 0; i < inputtext.length; i++){
			var ele = inputtext[i].getElementsByTagName('input')[0];
			if(ele.value && !ele.className.match("typing")){
				ele.className += " typing";
			}
			inputtext[i].getElementsByTagName('input')[0].addEventListener("input",function (e) {
				var ele = e.target;
				if(ele.value){
					if(!ele.className.match("typing")){
						ele.className += " typing";
					}	
				}else{
					ele.className = ele.className.replace("typing","");
				}
			});
			inputtext[i].getElementsByTagName('input')[0].addEventListener("blur",function  (e) {
				var ele = e.target;
				if(ele.value && ele.className.match("error")){
					ele.className = ele.className.replace("error","");
				}
			});
			
		}
	}
	window[NAME] = mdtext;
})(window, document);