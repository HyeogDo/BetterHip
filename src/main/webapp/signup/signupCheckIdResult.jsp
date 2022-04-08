<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
</script>
<body>
	<%
		String result = session.getAttribute("RESULT").toString();
		if (result.equals("Possible")) {
			%>사용 가능한 아이디 입니다!!<%
		} else {
			%>사용 중인 아이디 입니다!!<%
		}
	%>
</body>
</html>