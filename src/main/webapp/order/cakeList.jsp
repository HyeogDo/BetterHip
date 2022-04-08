<%@page import="com.betterhip.dto.order.CakeListDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.betterhip.dao.order.CakeListDao"%>
<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//String user_id = session.getAttribute("USER_ID").toString();
	String user_id = "peterhd";
	
	//페이지 나누기
	
	String tempPage = request.getParameter("page");
	int cPage;
	//현재 페이지 정하기
	if (tempPage == null || tempPage.length() == 0) {
		cPage = 1;
	}
	try{
		cPage = Integer.parseInt(tempPage);
	} catch(NumberFormatException e) {
		cPage = 1;
	}
	
	// 페이지 묶음들 개수(3개면 [prev] 1 2 3 [next] 로 뜨고 next 클릭하면 [prev] 4 5 6 [next] 이런식으로 뜨게)
	int pageLength = 3;
	// 한 페이지에 담으려는 데이터 개수
	int len = 4;
	// 각 페이지의 데이터 시작점
	int start;
	// 현재 블록
	int currentBlock;
	// 시작 페이지 끝 페이지
	int startPage;
	int endPage;
	// 총 raw 수, 페이지 수
	int totalRows = Integer.parseInt(session.getAttribute("totalRows").toString());
	int totalPages = totalRows % len == 0 ? totalRows/len : (totalRows / len) + 1;
	// 총페이지수 예외처리
	if(totalPages == 0) {
		totalPages = 1;
	}
	if (cPage > totalPages) {
		cPage = 1;
	}
	// 각 페이지의 데이터 시작점
	start = (cPage - 1) * len;
	//현재 블록 설정
	currentBlock = cPage % pageLength == 0 ? cPage / pageLength : (cPage / pageLength) + 1;
	
	// 시작 페이지 끝 페이지 설정
	startPage = (currentBlock - 1) * pageLength + 1;
	endPage = startPage + pageLength - 1;
	
	// 총 페이지 숫자를 넘어가면 끝 페이지를 마지막 페이지 숫자로 지정
	if(endPage > totalPages) {
		endPage = totalPages;
	}
	
	
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
						<option>높은 가격순</option>
						<option>낮은 가격순</option>
						<option>인기 상품순</option>
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
						<table>
							<tr>
							<c:forEach items="${list}" var="dto" varStatus="status">
									
								<td><img src="data:cake_img/png;base64, ${dto.base64Image }" width = "200" height="200"><br>
								${dto.cake_name }<br>
								${dto.cake_saleprice }</td>
								<c:if test="${status.index % 4 == 3 }">
									</tr><tr>
								</c:if>
							</c:forEach>
						</table>
				</div>
				<% for (int i = 0; i < totalPages; i++) {
						start = len*i;
					%><a href="../main/cakeListView.do?start=<%=start %>"><%=i + 1 %></a> <%
					}	
				%>
				
			</div>
			
		</div>
	</body>
</html>