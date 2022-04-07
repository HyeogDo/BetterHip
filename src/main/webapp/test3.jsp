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

	String[] p_id = request.getParameterValues("test");
	for(int i=0; i < p_id.length; i++) {
		out.print(p_id[i]);
	}


%>
</body>
</html>