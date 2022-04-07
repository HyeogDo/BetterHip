<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	session = request.getSession();
	session.setAttribute("USER_ID", "hong");

%>

	<form action="cartList.do">
		<input type="submit" value="확인">
	
	
	</form>
</body>
</html>