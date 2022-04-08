<%@page import="javax.swing.RepaintManager"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxConnection.CapabilitiesGetOrBuilder"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

	function cartOrder() {
		document.list.action ="../BetterHip/paymentList.do"
		document.list.submit()
		

	}
	
	function cartDelete() {
		document.list.action="cartDelete.do"
		document.list.submit()
		
	
	}


</script>

<body>
	<form name="list" method="get">
		<table>			
			<c:forEach var="item" items="${CartList}">
				<tr>
			        
					<td><input type="checkbox" name="chk" value="${item.purchase_id}"></td>
					<td><c:out value = "${item.purchase_cake_name }"/></td>
				
				</tr>
				
				    
			</c:forEach>
		</table>
		<input type="button" onclick="cartOrder()" value="구매">
		<input type="button" onclick="cartDelete()" value="삭제">
		
	</form>


</body>
</html>
