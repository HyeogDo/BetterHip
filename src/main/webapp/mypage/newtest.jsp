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

request.setCharacterEncoding("utf-8");
String user_id = request.getParameter("user_id");
session = request.getSession();
session.setAttribute("LoginId", user_id);
out.print(session.getAttribute("LoginId"));

%>


<form action="userInfoModifyView.do">

	<input type="submit" value="확">
</form>

</body>
</html>