document.write("<script src='../../js/ajax-helper.js'></script>");
$('body').on('click','.m-top a',function(){
	    window.location.href= "../../page/orderInfo/" + $(this).prop("name")+'.jsp';
});
	
var orderData = {
	"items": []
}

var orderLogData = {
	"items": []
}

function listByStateCd(stateCd) {
	var json = {};
	if (stateCd == null || stateCd == "") {
		stateCd = "3040.160";
	}
	json["stateCd"] = stateCd;
	console.log("listByStateCd:stateCd=" + json["stateCd"]);
	jQuery.ajax({
		type: "GET",
		url: "../../bss/ord/page",
		xhrFields: {
			withCredentials: true
		},
		data: json,
		contentType: "application/x-www-form-urlencoded",
		dataType: "json",
		async: true,
		success: function (data) {
			if (data != null && data.status == "200") {
				sessionStorage.setItem("order", JSON.stringify(data.data));
				orderData.items = [];
				orderDataHandler(data.data);
			} else {
				console.log(data.msg);
			}
		},
		error: function (res) {
			console.log("ajax请求失败,res:" + res.toString());
		}
	});
}

function orderDataHandler(data) {
	var ordItems = data.items;
	for (var i in ordItems) {
		var desc = ordItems[i].cltsDesc;
		if(desc){
			ordItems[i]["descs"] = desc.split(";");
		}
		orderData.items.push(ordItems[i]);
	}
}

function cancelOrd() {
	var json = {};
	json["ordCd"] = sessionStorage.getItem("orderCd");;
	jQuery.ajax({
		type: "GET",
		url: "../../bss/ord/cancel",
		xhrFields: {
			withCredentials: true
		},
		data: json,
		contentType: "application/x-www-form-urlencoded",
		dataType: "json",
		async: true,
		success: function (data) {
			if (data != null && data.status == "200") {
				console.log("取消成功");
				openSuccess();
			} else {
				console.log(data.msg);
				openFail();
			}
		},
		error: function (res) {
			console.log("ajax请求失败,res:" + res.toString());
			openFail();
		}
	});
}

function deleteOrd(){
	var json = {};
	json["ordCd"] = sessionStorage.getItem("orderCd");
	console.log(json);
	var ajaxHelper = new AjaxHelper()
	ajaxHelper.get("../../bss/ord/delete",json,function(data){
		if (data != null && data.status == "200") {
				console.log("删除成功");
				openSuccess();
		} else {
				console.log(data.msg);
				openFail();
		}	
	},function(){
		openFail();
	});
}

function openListLgsInfo(thisObject){
	var json = {};
	json["ordCd"] = thisObject.getAttribute("name");
	console.log(json);
	var ajaxHelper = new AjaxHelper()
	ajaxHelper.get("../../bss/ordlog/listLgsInfo",json,function(data){
		if(data != null&& data.status=="200"){
			orderLogDataHandler(data.data);
			window.location.href='../../page/orderInfo/orderLgs.jsp?ordCd=' + json["ordCd"];
		}
        console.log("支付订单数据" + data);
	}); 
}

 var logS = new Array("3050.170","3050.190","3050.200","3050.202","3050.203","3050.207",
 "3050.210","3050.220");
function orderLogDataHandler(data) {
	var ordItems = {};
	if(data.items){
		ordItems = data.items;
	}
	sessionStorage.setItem("lgsInfo", JSON.stringify(ordItems));
}

function getInfoByOrdCd(ordCd){
	var result;
	for(var i in orderData.items){
		var info = orderData.items[i];
		if(info.cd == ordCd){
			result = info;
			break;
		} 
	}
	return result;
}

//打开立即支付页面
function openPayforNow(thisObject) {
//	var index = $('.m-item').index($(thisObject).parents('.m-item'));
//	console.log(index);
//	return;
	var ordCd = thisObject.getAttribute("name");
	var ordInfo = getInfoByOrdCd(ordCd);
	sessionStorage.setItem("ordInfo", JSON.stringify(ordInfo));
	window.location.href="../../page/orderInfo/orderPayFor_now.jsp";
}

//立即支付
function payforNow() {
	var json = {};
	json["ordCd"] = vue.cd;
	jQuery.ajax({
		type: "GET",
		url: "../../bss/pay/ordPrePay",
		xhrFields: {
			withCredentials: true
		},
		data: json,
		contentType: "application/x-www-form-urlencoded",
		dataType: "json",
		async: true,
		success: function (data) {
			doBridgeReady(data);
		},
		error: function (res) {
			console.log("ajax请求失败,res:" + res.toString());
		}
	});
}

function doBridgeReady(data){
	if (typeof WeixinJSBridge == "undefined"){
		   if( document.addEventListener ){
		       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
		   }else if (document.attachEvent){
		       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
		       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		   }
		}else{
		   onBridgeReady(data);
		} 
}

function onBridgeReady(data) {
	WeixinJSBridge.invoke('getBrandWCPayRequest', {
		"appId" : data.appId, /* 微信支付，坑一 冒号是中文字符 */
		"appId" : data.appId, // 公众号名称，由商户传入
		"timeStamp" : data.timeStamp, // 时间戳，自1970年以来的秒数
		"nonceStr" : data.nonceStr, // 随机串
		"package" : data.package,
		"signType" : data.signType, // 微信签名方式：
		"paySign" : data.paySign
	// 微信签名
	}, function(res) {
		if (res.err_msg == "get_brand_wcpay_request:ok") {
			window.location.href = "../../bss/ip/openMyAccountInfo";
		} else {
			alert("支付失败，提示【" + res.err_msg + "】");
		}
	});
}


//找人代付
function openPayforProxy(thisObject) {
	window.location.href="../../page/orderInfo/orderPayFor_proxy.jsp";
	var ordCd = thisObject.getAttribute("name");
	var ordInfo = getInfoByOrdCd(ordCd);
	sessionStorage.setItem("ordInfo", JSON.stringify(ordInfo));
	return;
	
	var json = {};
	json["ordCd"] = thisObject.getAttribute("name");//.name;
	jQuery.ajax({
		type: "GET",
		url: "../../bss/ord/cancel",
		xhrFields: {
			withCredentials: true
		},
		data: json,
		contentType: "application/x-www-form-urlencoded",
		dataType: "json",
		async: true,
		success: function (data) {
			if (data != null && data.status == "200") {
				console.log("取消成功");
				listByStateCd("3040.150");
			} else {
				console.log(data.msg);
			}
		},
		error: function (res) {
			console.log("ajax请求失败,res:" + res.toString());
		}
	});
}

//打开评价
function openEval(thisObject) {
	var ordCd = thisObject.getAttribute("name");
	var ordInfo = getInfoByOrdCd(ordCd);
	sessionStorage.setItem("ordInfo", JSON.stringify(ordInfo));
	window.location.href="../../page/orderInfo/orderWaitEval_s.jsp";
}

//提交评价
function submitEval() {
	var ordInfo = JSON.parse(sessionStorage.getItem("ordInfo"));
	var json = {};
	json["ordCd"] = ordInfo.cd;
	json["dtl"] = $("#dtl").val();
	json["feel"] = $("#feel").attr("rel");
	json["speed"] = $("#speed").attr("rel");
	json["clear"] = $("#clear").attr("rel");
	json["atti"] = $("#atti").attr("rel");
	jQuery.ajax({
		type: "GET",
		url: "../../bss/ordEval/add",
		xhrFields: {
			withCredentials: true
		},
		data: json,
		contentType: "application/x-www-form-urlencoded",
		dataType: "json",
		async: true,
		success: function (data) {
			if (data != null && data.status == "200") {
				console.log("评价成功");
				window.location.href="../../weixin/orderInfo/myOrd";
			} else {
				console.log(data.msg);
			}
		},
		error: function (res) {
			console.log("ajax请求失败,res:" + res.toString());
		}
	});
}