<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="description" content="网站描述" />
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<!--<link rel="icon" type="image/png" href="./images/favicon.png">-->
<title>首页</title>
</head>
<body>
	<header>
		<a href="javascript:history.go(-1);"></a>我的订单
	</header>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<%-- <script src="${pageContext.request.contextPath}/js/orderInfo.js"></script> --%>
</body>
<script>
	$(document).ready(function() {
		listByStateCd();
	});

	function listByStateCd() {
		var json = {};
		json["mId"] = "2";
		json["idCard"] = "2";
		json["realName"] = "2";
		json["status"] = 2;
		jsonString = JSON.stringify(json);
		console.log("data:" + jsonString);
		jQuery.ajax({
			type : "POST",
			url : "http://localhost:8080/TestValidate/test/testValid",
			data : json,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(data) {
				console.log(data);
			},
			error : function(res) {
				console.log("ajax请求失败,res:" + res.toString());
			}
		});
	}
</script>
</html>