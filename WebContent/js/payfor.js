
function  testValid() {
	var o = {"realName":1,"status":12};
	 jQuery.ajax({
	        type: "POST",
	        url: "test/testValid",
	        xhrFields:{
	            withCredentials:true
	        },
	        data: JSON.stringify(o),
	        contentType: "application/json",
	        dataType: "json",
	        async: false,
	        success:function (data) {
	            console.log(data);
	        },

	        error: function(res) {
	        	 console.log(res);
	        }
	    });
}

function  testValidate() {
	var o = {"pk":2,"age":12};
	 jQuery.ajax({
	        type: "GET",
	        url: "/test/testValidated",
	        xhrFields:{
	            withCredentials:true
	        },
	        data: JSON.stringify(o),
	        contentType: "application/json",
	        dataType: "json",
	        async: false,
	        success:function (data) {
	            console.log(data);
	        },

	        error: function(res) {
	        	 console.log(res);
	        }
	    });
}

function signFactory(){
	$("input[name='posttime']").attr("value",getNowFormatDate());//时间
	$("input[name='orderidinf']").attr("value",getOrderIdInf($("input[name='goodno']").val()));//订单号

	var id = $("input[name='id']").val();//商户id
	var app_id = $("input[name='appid']").val();//应用id
	var orderidinf = $("input[name='orderidinf']").val();//商户订单号
	var totalPrice = $("input[name='totalPrice']").val();
	var key = "26302da45636e837bff4aa1240c92660";//签名
	var source = id + app_id + orderidinf + totalPrice + key;
	var hash = hex_md5(source);
	$("input[name='sign']").attr("value",hash);//填充内容 
	
	console.log("source:" + source);
	console.log("hash:"+hash);//RZF206855RZF206029 2017032221001230.0126302da45636e837bff4aa1240c92660
}

//请求支付
function  requestPayFor() {
	signFactory();
    jQuery.ajax({
        type: "POST",
        url: "https://pretech.zitopay.com/service/api/controller/zitopay/topayByMc",
        data: $('#formid').serialize(),
        success:function (data) {
        	console.log(data);
        	var json = strToJson(data);
        	if(json.success == true){
        		alert("支付成功,跳转页面");
        	}
        	codeurl = decodeURI(json.codeurl);
        	qrodeQRCode(codeurl);
        	saveOrderInfo(json);
        },
        error: function(res) {
        	console.log(res);
            //alert(JSON.stringify(data));
            
        }
    });
}

function saveOrderInfo(json){
//	var o = {"appid":$("input[name='appid']").val(),"id":$("input[name='id']").val(),
//			"posttime":$("input[name='posttime']").val(),"orderidinf":json.orderidinf,
//			"goodsname":$("input[name='goodsname']").val(),"goodsdetail":$("input[name='goodsdetail']").val(),
//			"ordertitle":$("input[name='ordertitle']").val(),"totalPrice":$("input[name='totalPrice']").val(),
//			"orderId":json.orderId};
	
	var o = {"orderId":json.orderId};
	 jQuery.ajax({
	        type: "POST",
	        url: "../order/saveOrderInfo",
	        xhrFields:{
	            withCredentials:true
	        },
	        data: JSON.stringify(o),
	        contentType: "application/json",
	        dataType: "json",
	        async: false,
	        success:function (data) {
	            console.log(data);
	        },

	        error: function(res) {
	        	 console.log(res);
	        }
	    });
}

function qrodeQRCode(url){
	$("#code").qrcode({ 
	    render: "table", //table方式 
	    width: 200, //宽度 
	    height:200, //高度 
	    text: url //任意内容 
	}); 
}

//单笔查询
function  requestSingletonOrder(id,appid,posttime,sign,orderid) {
    jQuery.ajax({
        type: "POST",
        url: "https://pretech.zitopay.com/service/api/controller/zitopay/findOrder",
        data: {id:id,appid:appid,posttime:posttime,sign:sign,orderid:orderid},
        success:function (data) {
        	var json = strToJson(data);
        	alert(JSON.stringify(data));
        },
        error: function(res) {
            alert(JSON.stringify(data));
        }
    });
}

//多笔查询
function  requestMultiOrder(id,appid,getewayid,posttime,sign,starttime,endtime,page,pagesize,state) {
    jQuery.ajax({
        type: "POST",
        url: "https://pretech.zitopay.com/service/api/controller/zitopay/findOrder",
        data: {id:id,appid:appid,getewayid:getewayid,posttime:posttime,sign:sign,starttime:starttime,
        	endtime:endtime,page:page,pagesize:pagesize,state:state},
        success:function (data) {
        	var json = strToJson(data);
        	alert(JSON.stringify(data));
        },
        error: function(res) {
            alert(JSON.stringify(data));
        }
    });
}


//对表单或者网页中的数据进行检验
function toVaild(){
	return true;//测试用
     var val = document.getElementById("ff").value;
     alert(val);
     if(val == "可以提交"){
         alert("校验成功，之后进行提交");
        return true;
     }
     else{
         alert("校验失败，不进行提交");
         return false;
     }
}

function strToJson(str){ 
	var json = eval('(' + str + ')'); 
	return json; 
} 

//获得订单号
//goodsNum商品编号
function getOrderIdInf(goodsNum){
	goodsNum = "000001";//编号
	return getNowFormatDate() + goodsNum;//订单编号
}

//yyyyMMddhhmmssSSS
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "";
    var seperator2 = "";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
   
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var milliseconds = date.getMilliseconds();
    if(milliseconds <= 9){
    	milliseconds = "00" + milliseconds;
    }else if(milliseconds <= 99){
    	milliseconds = "0" + milliseconds;
    }
    var seconds = date.getSeconds();
    if(seconds < 9){
    	seconds = "0" + seconds;
    }
    var minutes = date.getMinutes();
    if(minutes < 9){
    	minutes = "0" + minutes;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + "" + date.getHours() + seperator2 + minutes
            + seperator2 + seconds + ""+ milliseconds;
    return currentdate;
}