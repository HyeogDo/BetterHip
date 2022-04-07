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

	function onClick(){
		
	}


</script>

<body>
	<form action="cartOrder.do" method="get">
		<table>			
			<c:forEach var="item" items="${CartList}">
				<tr>
			
					<td><input type="checkbox" name="chk" value="${item.purchase_id}"></td>
					<td><c:out value = "${item.purchase_cake_name }"/></td>
				
				</tr>
				
				    
			</c:forEach>
		</table>
		<input type="submit" value="구매"> 
		
	</form>


</body>
</html>
