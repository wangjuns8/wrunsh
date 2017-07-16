<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>miniERP登陆</title>
</head>

<c:set var="msUrl" value="${pageContext.request.contextPath}" />
<script src="${msUrl}/resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
function changeImg(){
	var imgSrc = $("#imgObj");
	var src = imgSrc.attr("src");
	imgSrc.attr("src", chgUrl(src));
}

//时间戳     
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳     
function chgUrl(url){     
  var timestamp = (new Date()).valueOf();
  return url + "?timestamp=" + timestamp;
}
//function isRightCode(){     
//  	var code = $("#veryCode").val();
//  	code = "c=" + code;   
//  	$.ajax({     
//   	   type:"POST",     
//   	   url:"/resultController/validateCode.html",     
//   	   data:code,     
//  	   success:callback
//  	});     
//}     
//function callback(data){     
//	//document.getElementById("info").html(data);
//  	$("#info").html(data);     
//} 
</script>

<body>
	<c:if test="${!empty error}">
		<font color="red"><c:out value="${error}"/></font>
	</c:if>
	
	<form action="<c:url value="/user/loginCheck.html"/>" method="post">
		用户名：
		<input type="text" name="userName">
		<br>
		密  码：
		<input type="password" name="password">
		<br>
		<input type="text" id="verifyCode" name="verifyCode" />
		<img id="imgObj" alt="" src="/verifyCode/getCode.html" onclick="changeImg()"/>		
		<br>
		<input type="submit" value="登录" />
		<input type="reset" value="重置" />
		
	</form>
</body>
</html>