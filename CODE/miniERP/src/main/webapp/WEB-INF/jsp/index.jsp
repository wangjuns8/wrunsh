<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title>miniERP首页</title>
<c:set var="msUrl" value="${pageContext.request.contextPath}" />
<script src="${msUrl}/resources/js/jquery-1.11.1.min.js"></script>

<script type="text/javascript">
</script>

</head>


<body>
<h2>Hello World!</h2>

${user.userName}, 你已成功登录miniERP。


<br>
	<c:if test="${!empty error}">
		<font color="red"><c:out value="${error}"/></font>
	</c:if>

<br>
	
	<form name="myform" action="<c:url value="/uploadFile/upload.html"/>" method="post" enctype="multipart/form-data">
       File:<br>
       <input type="file" name="myfile"><br>
       <br>
       <input type="submit" name="submit" value="Commit">
    </form>


</body>
</html>
