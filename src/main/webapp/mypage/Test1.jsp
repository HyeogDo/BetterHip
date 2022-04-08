<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 입력</title>
</head>
<body>

	<form action="userInfoDeleteView.do" method="post"> 
	
	아이디를 입력하세요. <br><br> 
	
	<table>
		<tr>
		<td>아이디 :</td> <td><input type="text" name="user_id" size="30"></td>
		</tr>
	</table>
	
	<br>
	
		<input type="submit" value="확인">  
	
	</form>


</body>
</html>