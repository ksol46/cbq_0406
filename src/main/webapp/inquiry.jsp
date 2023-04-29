<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DTO.Reservation" %>
<%
request.setCharacterEncoding("utf-8");
String resvno = (String) request.getAttribute("resvno");
Reservation res = (Reservation) request.getAttribute("res");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@ include file="topmenu.jsp" %>
	<section>
	<% if (res == null) { %> 
	<div class="title">접종예약정보가 존재하지 않습니다!</div>
	<% } else { %>
	<div class="title">예약번호: <%=resvno%> 의 접종예약조회</div>
	<% } %>
			<div class="wrapper">
			<% if (res != null) { %>
			<table border="1">
				<tr>
				<th>이름</th>
				<th>주민번호</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>예약일자</th>
				<th>예약시간</th>
				<th>병원명</th>
				<th>대표전화</th>
				<th>병원주소</th>
				<th>백신종류</th>
				</tr>
				<tr>
				<td><%=res.getPname() %></td>
				<td><%=res.getJumin() %></td>
				<td><%=res.getGender() %></td>
				<td><%=res.getTel()%></td>
				<td><%=res.getResvdate() %></td>
				<td><%=res.getResvtime()%></td>
				<td><%=res.getHospname() %></td>
				<td><%=res.getTel() %></td>
				<td><%=res.getHospaddr() %></td>
				<td><%=res.getVtype() %></td>
				</tr>
			</table>
			<%} %>
			</div>
			<button class="btn btnstyle" type="button" onclick="location='search'">돌아가기</button>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>