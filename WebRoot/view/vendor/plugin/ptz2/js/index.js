﻿/////////////////
//index 主页部分 登录，通讯控件，通用方法
////////////////
var log=new Log();

setInterval(function(){$("#nowTime").html(current)},10000);

//是否已登录
var isLogin=false;

//用户名
var username='';

//通讯控件
var userKey = window.parent.userKey;

//当前选中（显示）窗口---
var currWinNo=1;

/**
 * 每个窗口对应的摄像头信息—— 
 * 多分屏同时播放时，需要记住每个窗口对应的摄像头id
 * 格式为：【【id,name】，【id,name】,……】
 */
var winInfoArr=new Array();

//当前摄像头的id，name
var currCameraId,currCameraName;

//当前显示窗口数量
var winNum=1;

//是否全屏
var iffulldocument = false;

//记录当前摄像头历史视频列表
var hisVideoXmlArr;

//页面布局函数
$(window).resize(sizeContent);

var commonOcxObj = window.parent.commonOcxObj;


// 设备树列表
var xmlDeviceDoc = new ActiveXObject("Microsoft.XMLDOM");
var listGroup = new Object(); 
listGroup.add = function(key,value){this[key]=value} 
listGroup.get = function(key){return this[key]}

///页面初始化加载 2016-9-5 20:47:28
$(function(){

	//初始化实时视频播放工具栏
	initRealToolBar();

});

/**
 * 	//初始化实时视频播放工具栏
 */
function initRealToolBar(){
	var iconPath = "../../../img/yunnan/menu/ptz/";

	//PTZ操作
	$(".screenlink").mousedown(function(){
		var btnName = $(this).attr("btnName");
		$(this).find("img").attr("src",iconPath+btnName+".png");
	}).mouseup(function(){
		var btnName = $(this).attr("btnName");
	});

	$(".screenlink").hover(function(){
		var btnName = $(this).attr("btnName");
		$(this).find("img").attr("src",iconPath+btnName+".png");
	}, function(){
		var btnName = $(this).attr("btnName");
		$(this).find("img").attr("src",iconPath+btnName+".png");
	})

	$(".screenlink").each(function(){
		var btnName = $(this).attr("btnName");
		if($(this).find("img").length == 0){
			$(this).append("<img class='screenimg' src='" + iconPath+btnName+".png' />");
		}
	});

}


function sizeContent() {
	var newHeight,dh_h,operate_h,turnE_h,menu_h,turnE_menu_h,content_right_menu_h,content_right_menu_h_div,play_h;

	var footerHeight = 60;

	////info-bar  height
	var infoBarEl = $("#info-bar");
	var infoBarHeight = infoBarEl.is(":visible") ? infoBarEl.height() : 0;
	var leftWidth = $("#content-left").width() + 20;

    newHeight = $(this).height() - infoBarHeight - footerHeight;  //得到content的高度
	var newWidth = $(this).width() - leftWidth;          //得到content-right的宽度
	//$(".show_h").text("width:"+newWidth+"height:"+newHeight);

	$("#content").height(newHeight);        //设置content的高度
	$("#content-right").width(newWidth);	//设置content-right的宽度

	operate_h=$(".operate").outerHeight(true);	//得到ptz标题高度
	turnE_h=newHeight;			//导航栏第一部分的整体高度

	menu_h=$(".menuA").outerHeight(true);
	turnE_menu_h=turnE_h-0;				//导航栏第一部分的内容高度

	$("#turnE").height(turnE_h);
	$("#turnE .turn").height(turnE_menu_h+infoBarHeight-105);
	//$("#turnE .turn").text("width:"+"300,"+"height:"+turnE_menu_h);
	$("#realTimeTreeFrame").css("height",turnE_menu_h+infoBarHeight-105);
	
	//右侧区域 
	play_h=$("#play-about").outerHeight(true);    //得到content-right 底部按钮行的高度；
	play_h=148;    								// VOD控件的高度；
	content_right_menu_h=newHeight-menu_h;
	content_right_menu_h_div=newHeight-menu_h-play_h;	//得到content-right 主要内容的高度；
	//content_right_menu_w_div=newWidth;

	$("#content-right .turn").height(content_right_menu_h);
	$("#content-right .turn .show_h").height(content_right_menu_h_div);

	showLayout(winNum);

	//$("#content-right .turn .show_h").text("width:"+content_right_menu_w_div+","+"height:"+content_right_menu_h_div);   //右侧内容 测试高度值；
}

//目前的ocx插件仅支持32位ie
function isie32(){
//	if($.browser.msie) { 
//		alert("请使用32位的IE浏览器!");
//	} 
	
	if(window.navigator.platform=='Win64'){
		alert("系统目前仅支持32位IE浏览器");
	}
}


/*$(function()
{	
	isie32();
	sizeContent();
	isLogin=false;
	
/!*----------------tab开始------------------------*!/
	function changeTab(lis, divs){
		lis.each(function(i){
			var els = $(this);
			els.click(function(){
				lis.removeClass();
				divs.stop().hide().animate({'opacity':0},0);
				$(this).addClass("libg");
				divs.eq(i).show().animate({'opacity':1},300);
			});
		});
	}
	var rrE = $("#turnE");
	changeTab(rrE.find(".menuA li"), rrE.find(".turn"));
	var con=$("#content-right");
	changeTab(con.find(".menuA li"), con.find(".turn"));
	/!*----------------tab结束--------------------------*!/
	
	//阻止连锁事件反映
	var liansuo=false;
	//有关联关系的两组按钮 ，一组中的一个按钮有点击事件，需要激活另外两个按钮的单击事件
	var linkedA=[['zb','shexiangjili','sshfli'],
	             ['db','jiansuoLi','sphfli']];
	
	//直播,点播，摄像机，检索，实时回放，视频回放 按钮的相互关联事件 ，
	$("#zb,#db,#shexiangjili,#jiansuoLi,#sshfli,#sphfli").click(function()
	{
		if(liansuo)
		{
			return ;
		}
		liansuo=true;
		var tmpLinkedArr=linkedA[0];
		var currAId=$(this).attr('id');
		if($.inArray(currAId,linkedA[0])<0)
		{
			tmpLinkedArr=linkedA[1];
		}
		for(var id in tmpLinkedArr)
		{
			if(currAId!=tmpLinkedArr[id])
			{
				$("#"+tmpLinkedArr[id]).trigger('click');
			}
		}
		liansuo=false;
	});
	
	/!*导航菜单结束*!/


		$('#nav-menu ul li a').click(
			function(){
				var n= $('#nav-menu ul li a').index(this)+1;
				$(this).addClass('active_'+n).parent().siblings().children().removeClass();
			}
			
		)
	/!*----------------------信息栏的显示和隐藏的单击事件-------------------------*!/
	
	var $log=$("#logdiv");
	var log_height=$log.height();  //日志的内容的高度；
	$(".info-bt").click(function()
	{
		if($log.is(":visible"))
		{
			//$("#info-bar").height(24);
			$("#logdiv").slideUp("fast");
			$("#info-bar").height("-="+log_height);
			
			//sizeContent();
			$("#content").animate({"height":"+="+log_height},"slow");
			$("#turnE").height("+="+log_height);
			$("#turnE .turn").height("+="+log_height);	
			$("#content-right .turn").height("+="+log_height);
			$("#content-right .turn .show_h").height("+="+log_height);
			//sizeContent();
			$(".info-bt a span").text("展开").css("background-position","-300px -200px");
		}
		else{
			$("#logdiv").slideDown("fast");
			$("#info-bar").height("+="+log_height);
			
			$("#content").animate({"height":"-="+log_height},"slow");
			$("#turnE").height("-="+log_height);
			$("#turnE .turn").height("-="+log_height);	
			$("#content-right .turn").height("-="+log_height);
			$("#content-right .turn .show_h").height("-="+log_height);
			$(".info-bt a span").text("收缩").css("background-position","-300px -250px");
		}
		showLayout(winNum);
	});	

		//菜单栏登录按钮事件
		$("#dl").click(function()
		{
			if(!window.isLogin)
			{
				//隐藏不能正常显示的含有active控件的容器
				hideActive(0);
				//显示登录窗口
				$("#logindiv").dialog("open");
				log.debug("登录");
				//读取已保存的登陆信息
				readLoginInfo();
			}else
			{
				if(window.confirm("确认要退出吗"))
				{
					logout();
				}
			}
		});
		
		//登陆弹出框设定
		$("#logindiv").dialog(
		{
			autoOpen : false,
			width : 290,
			height : 270,
			modal : true,
			bgiframe : true,
			title : "登录系统",
			overlay :
			{
				opacity : 0.8,
				background : "#ffffff"
			},
			close : function (event, ui)
			{
				//隐藏那些active控件
				hideActive(1);
				$("#loginlogspan").hide();
			}
		});
		
		$("#bz").click(function()
		{
			hideActive(0);
			//显示登录窗口
			$("#abotudiv").dialog("open");
		});
		
		//登陆弹出框设定
		$("#abotudiv").dialog(
		{
			autoOpen : false,
			width : 290,
			height : 270,
			modal : true,
			bgiframe : true,
			title : "关于视频综合管理应用平台",
			overlay :
			{
				opacity : 0.8,
				background : "#ffffff"
			},
			close : function (event, ui)
			{
				//隐藏那些active控件
				hideActive(1);
				$("#abotudiv").hide();
			}
		});
		
		
		

});*/

/**
 * 用户注销
 */
function logout()
{
	/*///////////////////////////////////////////////////////////////
	{
		log.debug("用户注销.");
		// 清除日志
		log.clear();
		//清空左侧摄像机列表区
		realTree.deleteChildItems(0);
		hisTree.deleteChildItems(0);
		videoTree.deleteChildItems(1);
	}

	$("#dl>span").text('登录');
	$(".welcome").hide();

	//左侧恢复到摄像头菜单区
	$('#shexiangjili').trigger('click');
	//右侧区域 变为首窗口单屏
	showLayout(1);
	isLogin=false;*/

	try{
		window.frames["realTimeTreeFrame"].logout();
		return 1;
	}catch(e){
		log.debug("error realtime" + e);
	}
}

//登陆事件
function login(userParam)
{
	var userName = null;
	var userPwd = null;
	var hostName = null;
	var hostPort = null;

	if(userParam){
		 userName=userParam.userName;
		 userPwd=userParam.userPwd;
		 hostName=userParam.hostName;
		 hostPort=userParam.hostPort;
	}else{
		 userName=$("#username").val();
		 userPwd=$("#password").val();
		 hostName=$("#ip").val();
		 hostPort=$("#port").val();
	}


	if (!loginValidate())
	{
		return;
	}
	else
	{
		//注册通讯控件
		if (!commonOcxObj)
		{
			log.error("无法获取调用通信控件!");
			$("#loginlogspan").text("无法获取调用通信控件!");
			$("#loginlogspan").show();
			return;
		}
		//通讯控件初始化
		userKey = commonOcxObj.Initialize(0);
		log.debug("hostName:" + hostName + "hostPort:" + hostPort);

		// 连接服务器成功
		var r = commonOcxObj.ConnectToServer(userKey, hostName, hostPort);
		if (r != 0)
		{
			log.error("连接服务器失败！请检查服务器地址和端口");
			$("#loginlogspan").text("连接服务器失败！请检查服务器地址和端口.");
			$("#loginlogspan").show();
			return;
		}
		$("#loginlogspan").hide();
		log.debug("连接服务器成功！正在登录..." + r);

		log.debug("userKey" + userKey + "userName:" + userName + "userPwd:" + userPwd);
		var retVal = window.parent.commonOcxObj.UserLogin(userKey, userName, userPwd);
		log.debug("登录成功"+retVal);

		//成功的话，关闭登陆框
		//hideActive(1);


		//$("#logindiv").dialog("close");
		return "OK";
	}
}

//addEvent(document.getElementById("commonOcx"),'SKDMessage',function (lMsgType, strContent)
//		{

//通讯控件事件绑定
//document.getElementById("commonOcx").addEventListener("OnSDKMessage", function (lMsgType, strContent)

/**
 * 登陆验证
 */
function loginValidate(userParam)
{
	var userName = null;
	var userPwd = null;
	var hostName = null;
	var hostPort = null;

	if(userParam){
		userName=userParam.userName;
		userPwd=userParam.userPwd;
		hostName=userParam.hostName;
		hostPort=userParam.hostPort;
	}else{
		userName=$("#username").val();
		userPwd=$("#password").val();
		hostName=$("#ip").val();
		hostPort=$("#port").val();
	}

	//ip
	var ip = hostName;
	if (!ip)
	{
		return ("ip地址不能为空");
	}
	if (ip.match(/(d+).(d+).(d+).(d+)/g))
	{
		return alert("ip地址格式错误");
	}
	var parts = ip.split(".");
	for (var i = 0, l = parts.length; i < l; i++)
	{
		if (parseInt(parts[i]) > 255)
		{
			return ("ip地址不正确");
		}
	}

	//port
	var port = hostPort;
	if (!port)
	{
		return ("端口号不能为空");
	}
	else
	{
		if (isNaN(port) || parseInt(port) > 25535 || parseInt(port) < 0)
		{
			return ("端口号信息不正确");
		}
	}

	//用户名，密码
	username = userName;
	if (!username)
	{
		return ("用户名不能为空");
	}
	var password = userPwd;
	if (!password)
	{
		return ("密码不能为空");
	}
	saveLoginInfo(userParam);
	return true;
}

/**
 * 关闭/刷新页面时，强制注销，否则会造成帐号占用，无法使用
 */
window.onbeforeunload=function()
{
	if(isLogin)
	{
		window.onunload=function()
		{
			if(logout()==0)
			{
				//日志其实也看不到
				console.log("用户注销成功");
				log.debug("用户注销成功");
			}else
			{
				console.log("用户注销失败");	
				log.error("用户注销失败");
			}
		}
		event.returnValue="确认离开该页面，并注销当前登录用户吗？";
	}
};


/**
 * 返回摄像机组信息
 * @param content 摄像机组xml信息
 */
function returnGetCarmGroupList(content) {
	try{
		window.frames["realTimeTreeFrame"].treeObj.parseGroupXML(content);

		//获取摄像头组后接着获取摄像头
		//alert(userKey);
		//alert("window.parent.commonOcxObj" + window.parent.commonOcxObj);
		window.parent.commonOcxObj.GetCamera(window.parent.userKey);
	}catch(e){
		log.debug("error  returnGetCarmGroupList"+e);
	}

}

// 遍历并添加组信息
function addGroup(parentId, parentIdArray, groupIdArray, groupNameArray)
{
	for(var i=0;i<parentIdArray.length;i++)
	{
		if (parentIdArray[i]==parentId)
		{
			// 添加组信息
			inserOneGroup(parentId, groupIdArray[i], groupNameArray[i]);
			///////////////////////////////////////////////////////////////
			// 添加到xml中
			{
				// 创建xml元素
				var groupItem = xmlDeviceDoc.createElement("item");
				groupItem.setAttribute("text", groupNameArray[i]);
				groupItem.setAttribute("id", "G" + groupIdArray[i]);
				// 获取父元素
				var parentItem = listGroup.get(parentId);
				// 添加为父元素的子元素
				parentItem.appendChild(groupItem);
				
				// 添加到键值对列表中
				listGroup.add(groupIdArray[i], groupItem);
			}
			// 遍历并添加子组信息
			addGroup(groupIdArray[i], parentIdArray, groupIdArray, groupNameArray);
		}
	}
}

/**
 * 解析处理摄像机列表
 */
function returnGetCarmList(content)
{
	window.frames["realTimeTreeFrame"].addCameraXML(content);

	/*//console.info("content:" + content);
	var xmlDoc = getXMLDoc(content);
	var elements = xmlDoc.getElementsByTagName("CameraRes");
	for (var i = 0; i < elements.length; i++)
	{
		var groupId = elements[i].getElementsByTagName("ubiCameraGroupId")[0].firstChild.nodeValue;
		var id = elements[i].getElementsByTagName("ubiCameraId")[0].firstChild.nodeValue;
		var name = elements[i].getElementsByTagName("szName")[0].firstChild.nodeValue;
		//树列表添加摄像机信息
		insertOneCamera(groupId, id, name);
		{
			// 创建xml元素
			var cameraItem = xmlDeviceDoc.createElement("item");
			cameraItem.setAttribute("text", "[" + id + "]" + name);
			cameraItem.setAttribute("id", "C" + id);
			// 获取父元素
			var groupItem = listGroup.get(groupId);
			if(groupItem==null){
				console.info("groupId:" + groupId + " listGroup" +　listGroup);
				continue;
			}
			// 添加为父元素的子元素
			groupItem.appendChild(cameraItem);
		}
	}
	
	realTree.loadXMLString(xmlDeviceDoc.xml);
	hisTree.loadXMLString(xmlDeviceDoc.xml);*/
}

/**
 * 播放历史视频回调事件
 * @param content
 */
function returnStartVod(content)
{
	var xmlDoc = getXMLDoc('<?xml version="1.0" encoding="UTF-8"?>' + content);
	
	var elements = xmlDoc.getElementsByTagName("RetStartVOD");
	sessionId = elements[0].getElementsByTagName("ubiSessionId")[0].firstChild.nodeValue;
	
	var es = xmlDoc.getElementsByTagName("ResultDest");
	//cId = es[0].getElementsByTagName("ubiCameraId")[0].firstChild.nodeValue;
	//monitorId = es[0].getElementsByTagName("ubiMonitorId")[0].firstChild.nodeValue;
	//videoFormat = es[0].getElementsByTagName("uiVideoFormat")[0].firstChild.nodeValue;
	//codecType = es[0].getElementsByTagName("uiCodecType")[0].firstChild.nodeValue;
	var destIp = es[0].getElementsByTagName("szDestIP")[0].firstChild.nodeValue;
	var destPort = es[0].getElementsByTagName("uiDestPort")[0].firstChild.nodeValue;
	
	// 调用  播放控件 StartVod
	startVod(destIp, destPort);
}


function hideToolInfo(){

	var infoBarE = $('#info-bar');
	if(infoBarE.is(":visible")){
		$("#toolId").removeClass("fa-angle-double-down");
		$("#toolId").addClass("fa-angle-double-up");
		infoBarE.hide();
	}else{
		$("#toolId").removeClass("fa-angle-double-up");
		$("#toolId").addClass("fa-angle-double-down");
		infoBarE.show();
	}

	sizeContent();
}


/**
 * 播放摄像头视频
 * @param cameraId 摄像机ID(去除前缀c后的id)
 */
function playCarmVideo(cameraId)
{
	try{
		//alert("cameraId"+cameraId + "currCameraId"+currCameraId+"userKey:"+window.parent.userKey);
		var versionId = 0; // 版本号
		var playType = 4; //1: UDP组播; 2: UDP单播; 3: TCP服务端; 4: TCP客户端
		var reviceIpAddr = ""; //接收端码流 若uiPlayType为TCP客户端，该值可忽略，填空
		var revicePort = 0; //若uiPlayType为TCP客户端，该值可忽略，填0
		var playStreamType = 0; //0: 自动分配码流; 1: 码流1; 2: 码流2;  3: 码流3
		commonOcxObj.startLive(window.parent.userKey, cameraId, currCameraId, versionId, playType, reviceIpAddr, revicePort, playStreamType);
	}catch(e){
		log.debug(" Camera error" + e);
	}
}

/**
 * 实时播放回调事件
 * @param content
 */
function returnStartLive(content)
{
	try{
		var xmlDoc = content;
		//var cameraId = 0;
		var wndId = 0;
		//var codeRate = 0;
		//var videoFormat = 0;
		//var codeType =0;
		//var fps = 0;
		//var resloution = 0;
		var playType = 0;
		var palyAddr = "";
		var playPort = 0;
		//var encAddr = "";
		var elements = xmlDoc.getElementsByTagName("RetStartLive");
		for (var i = 0; i < elements.length; i++)
		{
			// cameraId = elements[i].getElementsByTagName("ubiCameraId")[0].firstChild.nodeValue;
			wndId = elements[i].getElementsByTagName("ubiWndId")[0].firstChild.nodeValue;
			codeRate = elements[i].getElementsByTagName("uiCodecRate")[0].firstChild.nodeValue;
			videoFormat = elements[i].getElementsByTagName("uiVideoFormat")[0].firstChild.nodeValue;
			codeType = elements[i].getElementsByTagName("uiCodecType")[0].firstChild.nodeValue;
			fps = elements[i].getElementsByTagName("uiFPS")[0].firstChild.nodeValue;
			resloution = elements[i].getElementsByTagName("uiResloution")[0].firstChild.nodeValue;
			playType = elements[i].getElementsByTagName("uiPlayType")[0].firstChild.nodeValue;
			palyAddr = elements[i].getElementsByTagName("szPlayAddr")[0].firstChild.nodeValue;
			playPort = elements[i].getElementsByTagName("uiPlayPort")[0].firstChild.nodeValue;
			encAddr = elements[i].getElementsByTagName("szEncAddr")[0].firstChild.nodeValue;
		}
		// 调用实时播放页面播放方法
		startRealPlay(palyAddr, playPort, playType, wndId, window.parent.userKey);
	}catch (e){
		log.debug("Play Real " + e);
	}
}

/**
 * 解析一路摄像机历史视频记录
 */
function returnGetCamHisVideo(content)
{
	hisVideoXmlArr = new Array();
	var xmlDoc = getXMLDoc(content);
	var elements = xmlDoc.getElementsByTagName("RetGetHistory");
	var cameraId = elements[0].getElementsByTagName("ubiCameraId")[0].firstChild.nodeValue;
	var historys = xmlDoc.getElementsByTagName("sHistoryInfo");
	var videoArr = xmlDoc.getElementsByTagName("array");
	if (!videoArr || (videoArr.length > 0))
	{
		hisVideoXmlArr[0] = ["C" + cameraId, historys.length, videoArr[0].xml];
	}
	var startTime = 0;
	var endTime = 0;
	for (var i = 0; i < historys.length; i++)
	{
		startTime = historys[i].getElementsByTagName("tStartTime")[0].firstChild.nodeValue;
		endTime = historys[i].getElementsByTagName("tEndTime")[0].firstChild.nodeValue;
		codecType = historys[i].getElementsByTagName("uiCodecType")[0].firstChild.nodeValue;
		videoFormat = historys[i].getElementsByTagName("uiVideoFormat")[0].firstChild.nodeValue;
		// 输出 展示  时间要X1000，返回的是秒，不是毫秒
		insertOneHistoryVideo(cameraId, cameraId + "摄像机", startTime * 1000, endTime * 1000);
		hisVideoXmlArr[hisVideoXmlArr.length] = [cameraId + "_" + (startTime * 1000) + "_" + (endTime * 1000), 1, "<array>" + historys[i].xml + "</array>"];
		log.debug(historys[i].xml);
	}
	//(long lCamIndex, LPCTSTR strCamName, LPCTSTR strCamId, LPCTSTR strHisData, long lRecCount)
	//	top.mainPage.timeLineObj.SetCamHisInfo(1,currcameraName, cameraId,,	historys.length);
}




/**
 * 有弹出框是需要隐藏  active控件，否则布局会乱掉
 * @param show
 */
function hideActive(show) 
{
	var tmpobj = $("#content-right");
	if (show) {
		tmpobj.show();
	} else {
		tmpobj.hide();
	}

}

/**
 * 从本地存储中读取上次保存的地址，用户名，密码
 */
function readLoginInfo()
{
	//如果不为空则设置，否则为页面默认值
	if(localStorage.ip)
	{
		$("#ip").val(localStorage.ip)
		$("#port").val(localStorage.port);
		$("#username").val(localStorage.name);
		$("#password").val(localStorage.password);
	}
}

/**
 * 存储登陆信息
 */
function saveLoginInfo()
{
	//如果不为空则设置，否则为页面默认值
	localStorage.ip=$("#ip").val()
	localStorage.port=$("#port").val();
	localStorage.name=$("#username").val();
	localStorage.password=$("#password").val();
}

function ocxOnloadErr()
{
	console.log("通讯控件加载错误!");
	alert("通讯控件加载错误!");
}

function current(){
	var d=new Date(),str='';
	str +=d.getFullYear()+'年'; //获取当前年份
	str +=d.getMonth()+1+'月'; //获取当前月份（0——11）
	str +=d.getDate()+'日'; 
	str +=" "+d.getHours();
	str +=":"+d.getMinutes();
	return str;
}
