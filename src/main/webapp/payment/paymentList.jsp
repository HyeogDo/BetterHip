<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
String user_id=request.getParameter("user_id");
%>



<html>
	<script type="text/javascript">
function check_form(){

var form = document.regiform;
if(!form.agree_chk.checked){
form.agree_chk.focus();
alert("약관에 동의하셔야 다음단계로 이동합니다.");
return false;
  }

	location.href="payment.do?user_id=<%=user_id%>";
}
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문하기</h1>
	<h3>주문상품</h3>
	
	<!-- 		첫번째 줄  시작     -->
 	<table border="1">
	 	<tr>
			<th colspan="2" width="200">
					상품 정보
			</th>
			<th width="100">
					수량
			</th>
			<th width="100">
					주문금액
			</th>
			<th width="100">
					상태
			</th>
		</tr>
		
<!-- 		첫번째 줄  끝     -->
		
		
		<!-- 두번째 줄 -->
		
		<c:forEach items="${paymentList }" var="dto_purchase_list">
		<tr>
			<td rowspan="5" height="200">
					이미지
			</td>
			<td height="40">
					${dto_purchase_list.cake_name}
			<td>
			<td rowspan="5" height="200">
					${dto_purchase_list.purchase_quantity}
			<td>
			<td rowspan="5" height="200">
					${dto_purchase_list.purchase_price}
			<td>
			<td rowspan="5" height="200">
					방문수령
			<td>
		</tr>
		<!-- 두번째 줄 끝 	-->
		
		
		
	<!-- 	세번째 줄 시작 -->
		
		
 		<tr>
			<td>
					맛: ${dto_purchase_list.customize_taste}
			</td>
		</tr>	
		<!-- 네번째 줄 -->
		
		<tr>
			<td>
					사이즈: ${dto_purchase_list.customize_size}
			</td>
		</tr>
		
		<!-- 다섯번째 줄 -->
		
		<tr>
			<td>
					크림 종류: ${dto_purchase_list.customize_cream_type}
			</td>
		</tr>
		
		<!-- 여섯번째 줄 -->
		
 		<tr>
			<td>
					크림 색상: ${dto_purchase_list.customize_cream_color}
			</td>
		</tr>
		</c:forEach>

	</table>
	
	<h3>주문자 정보</h3>
	-----------------------------------------------------------------------------
<table>
	<tr>
		<td>주문자 명</td>
		<td>${paymentUserList.user_name }</td>
	</tr>
	<tr>
		<td>휴대폰 번호</td>
		<td>${paymentUserList.user_phone }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${paymentUserList.user_email }</td>
	</tr>
	
</table>
	-----------------------------------------------------------------------------
	
	
	<h3>${total_price }</h3>
	<h3>총 주문금액</h3>
	
	
	

<!-- -------- 약관 동의 ------------- -->
	<form name="regiform">
		<input type="checkbox" name="agree_chk" value="1">약관 동의
		<input type="button" onclick="check_form()" value="결제하기">

	</form>
</body>
</html>