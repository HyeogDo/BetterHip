<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>

</head>

<!--회원 탈퇴 컨펌 alert -->
<script type="text/javascript">

	function del() {
		if(confirm("정말로 탈퇴하시겠습니까?")) {
			location.href = "userInfoDelete.do";
		}		
	}
</script>


<!--회원 탈퇴 메인-->
<body>
	<div style="position: absolute; left: 40%">
	
		<form action="#" name="userInfoDeleteView" method="post">
		
			<table>
				<tr>
					<td align="center" colspan="2">BETTER HIP</td>
				</tr>
				<tr>
					<td align="center" colspan="2">회원 탈퇴</td>
				</tr>
			
				<tr>
					<td>아이디</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_id" size="41" value="${userInfo.user_id }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>이메일</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_email" size="41" value="${userInfo.user_email }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>휴대폰 번호</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="user_phone" size="30" value="${userInfo.user_phone }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>주소</td>
				</tr>
				<tr>
					<td>
						<input type="text" id="sample6_postcode" name="user_postcode" size="20" value= "${userInfo.user_postcode } " readonly="readonly"><br>
						<input type="text" id="sample6_address" size="41" name="user_address" value= "${userInfo.user_address } " readonly="readonly"><br>
						<input type="text" id="sample6_detailAddress" size="41" name="user_address_detail" value= "${userInfo.user_address_detail } " readonly="readonly">
					</td>
					</tr>
			
			</table>
		
		<!-- 회원 탈퇴 button  -->
			<input type="button" value="회원 탈퇴" onclick="del()">
	
		</form>
	
	</div>

	
</body>
</html>