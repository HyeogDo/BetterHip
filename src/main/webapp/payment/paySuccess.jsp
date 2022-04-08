<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function goShopping() {
	location.href="cakeListview.do";
}
function payView() {
	location.href="purchaseList.do";
}
</script>
<body>
	<h1>결제 성공</h1>
	<input type="button" onclick="goShopping()" value="쇼핑하러가기">
	<input type="button" onclick="payView()" value="쇼핑 내역 확인">
</body>
</html>