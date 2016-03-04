/**
 * 一个简单的音乐控制器
 * by IwYvI
 * 2015.11.30
 */

;(function(window, document, undefined) {

  "use strict";

  var NAME = "musicController";
  var musicController = {
    audioElement: "",//audio标签元素
    isPlay: false,//是否在播放
    musicIndex: 0,//音乐编号索引
    musicList: [],//音乐列表
    option:{
      controllerElements:{
        play: 0,
        pause: 0,
        toggle: 0,
        next: 0,
        prev: 0,
        mute: 0,
      },//控制器
    },
  };

  musicController.init = function  (audio, option) {
      if(audio){
        if(typeof(audio) == "string"){
          if(audio.indexOf("#")!=-1){
            this.audioElement = document.querySelector(audio);
          }else{
            this.audioElement = document.getElementById(audio);
          }
        }else if(typeof(audio) == "object"){
          this.audioElement = audio;
        };
        if(this.audioElement == null || typeof(this.audioElement) == undefined){
          throw new Error("no element has been selected!");
        };
      }else{
        throw new Error("no element has been given!");
      };
      //获得audio元素
      this.audioElement.preload = "metadata";
      this.setOption(option);
      this.audioElement.addEventListener("ended",function  (e) {
        musicController.next();
      });
  };

  //修改option
  musicController.setOption = function  (opt) {
    for(var key in opt){
      if(typeof(this.option[key]) != undefined){
        if(typeof(this.option[key] == "object")){
          for(var key in opt){
            if(typeof(this.option[key]) != undefined){
              this.option[key] = opt[key];
            }
          }
        }else{
          this.option[key] = opt[key];
        }
      }
    }
    this.bind();
  };

  /**
   * 添加音乐
   * @param {Array || object} music 可以是对象或者包含对象的数组，要求对象中一定要有src，为音乐链接的string
   */
  musicController.addMusic = function  (music) {
    if(music instanceof Array){
      this.musicList = this.musicList.concat(music);
    }else if(typeof(music) == "object"){
      this.musicList.push(music);
    };
    if(!this.audioElement.src){
      this.audioElement.src = this.musicList[this.musicIndex].src;
    };
  };

  //播放
  musicController.play = function  () {
    if(this.musicList.length == 0){
      return;
    }
    this.audioElement.play();
    this.isPlay = true;
  };

  //暂停
  musicController.pause = function  () {
    this.audioElement.pause();
    this.isPlay = false;
  };

  musicController.toggle = function  () {
    if(this.isPlay){
      this.pause();
    }else{
      this.play();
    }
  }

  //下一曲
  musicController.next = function  () {
    if(this.musicList.length == 0){
      return;
    }
    if(this.musicIndex < this.musicList.length -1){
      this.musicIndex++;
    }else{
      this.musicIndex = 0;
    }
    this.audioElement.src = this.musicList[this.musicIndex].src;
    this.play();
  };

  //上一曲
  musicController.prev = function  () {
    if(this.musicList.length == 0){
      return;
    }
    if(this.musicIndex > 0){
      this.musicIndex--;
    }else{
      this.musicIndex = this.musicList.length-1;
    }
    this.audioElement.src = this.musicList[this.musicIndex].src;
    this.play();
  };

  //静音
  musicController.mute = function  () {
    this.audioElement.muted = !this.audioElement.muted;
  };

  //绑定（private）
  musicController.bind = function  () {
    for(var ele in this.option.controllerElements){
      if(this.option.controllerElements[ele] == 0){
        return;
      }else{
        if(navigator.userAgent.toLowerCase().indexOf("firefox")>=0){
          document.getElementById(this.option.controllerElements[ele]).addEventListener("mouseup",function  (e) {
            activeFunc(ele);
          });
        }else{
          document.getElementById(this.option.controllerElements[ele]).addEventListener("click",function  (e) {
            activeFunc(ele);
          });
        }
      }
    }
  };

  /**
   * 事件
   * @param  {string} func   方法名称
   */
  function activeFunc (func) {
    eval("musicController." + func + "();");
  };
  
  window[NAME] = musicController;
})(window, document);