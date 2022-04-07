<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<script type="text/javascript">
function check_form(){

var form = document.regiform;
if(!form.agree_chk.checked){
form.agree_chk.focus();
alert("회원약관에 동의하셔야 다음단계로 이동합니다.");
return false;
  }

	location.href="payment.do";
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
 	<table style="table-layout: fixed;" border="1">
	 	<tr>
			<th colspan="2" width="300">
				<div style="display: block;overflow: hidden;">
					상품 정보
				</div>
			</th>
			<th width="100">
				<div style="display: block;overflow: hidden;">
					수량
				</div>
			</th>
			<th width="100">
				<div style="display: block;overflow: hidden;">
					주문금액
				</div>
			</th>
			<th width="100">
				<div style="display: block;overflow: hidden;">
					상태
				</div>
			</th>
		</tr>
		
<!-- 		첫번째 줄  끝     -->
		
		
		<!-- 두번째 줄 -->
		
		<c:forEach items="${paymentList }" var="dto_purchase_list">
		<tr>
			<td rowspan="5" width="100" height="200">
				<div style="display: block;overflow: hidden;">
					이미지
				</div>
			</td>
			<td height="40">
				<div style="display: block;overflow: hidden;">
					${dto_purchase_list.cake_name}
				</div>
			<td>
			<td rowspan="5" width="100" height="200">
				<div style="display: block;overflow: hidden;">
					${dto_purchase_list.purchase_quantity}
				</div>
			<td>
			<td rowspan="5" width="100" height="200">
				<div style="display: block;overflow: hidden;">
					${dto_purchase_list.purchase_price}
				</div>
			<td>
			<td rowspan="5" width="100" height="200">
				<div style="display: block;overflow: hidden;">
					방문수령
				</div>
			<td>
		</tr>
		<!-- 두번째 줄 끝 	-->
		
		
		
	<!-- 	세번째 줄 시작 -->
		
		
 		<tr>
			<td width="200" height="40">
				<div style="display: block;overflow: hidden;">
					맛: ${dto_purchase_list.customize_taste}
				</div>
			</td>
		</tr>	
		<!-- 네번째 줄 -->
		
		<tr>
			<td width="200" height="40">
				<div style="display: block;overflow: hidden;">
					사이즈: ${dto_purchase_list.customize_size}
				</div>
			</td>
		</tr>
		
		<!-- 다섯번째 줄 -->
		
		<tr>
			<td width="200" height="40">
				<div style="display: block;overflow: hidden;">
					크림 종류: ${dto_purchase_list.customize_cream_type}
				</div>
			</td>
		</tr>
		
		<!-- 여섯번째 줄 -->
		
		<tr>
			<td width="200" height="40">
				<div style="display: block;overflow: hidden;">
					크림 색상: ${dto_purchase_list.customize_cream_color}
				</div>
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
	
	
	


	<form name="regiform">
		<input type="checkbox" name="agree_chk" value="1">약관 동의
		<input type="button" onclick="check_form()" value="결제하기">

	</form>
</body>
</html>