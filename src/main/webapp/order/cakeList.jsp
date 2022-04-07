<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//String user_id = session.getAttribute("USER_ID").toString();
	String user_id = "peterhd";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div align="center">
			<div align="center">
				<h1><b>레터링 케이크</b></h1>
				<h3>선물하고 싶은 메세지를 알려주세요. 다해줄게요.</h3>
			</div>
			<br>
			<div  style="position: absolute; left: 10%; right: 10%">
				<div align="left">
					<select>
						<option>인기 상품순</option>
						<option>최신 등록순</option>
					</select>
					<select>
						<option>4개씩 보기</option>
						<option>8개씩 보기</option>
					</select>
				</div>
				<div align="right">
					<input type="text" size="15" placeholder="제품명 검색"> <input type="button" name="btn_search" value="검색">
				</div>
				<div>
					<c:forEach items="${list}" var="dto">
						<table>
							<tr><td><img alt="1" src="${dto.cake_img }"></td></tr>
							<tr><td>${dto.cake_name }</td></tr>
							<tr><td>${dto.cake_saleprice }</td></tr>
						</table>
						<br>
					</c:forEach>
				</div>
			</div>
			
		</div>
	</body>
</html>