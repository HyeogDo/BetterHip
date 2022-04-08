<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="cakeListView.do?start=0&len=4">
	<% session.setAttribute("page", 1); %>
		<input type="submit" value="go">
	</form>
</body>
</html>