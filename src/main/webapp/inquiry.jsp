<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="title">예약번호: (__)의 접종예약조회</div>
		<form name="frm" action="insert">
			<input type="hidden" id="GUBUN" value="insert">
			<div class="wrapper">
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
				<td>(데이터)</td>
				<td>(데이터)</td>
				<td>(데이터)</td>
				<td>(데이터)</td>
				<td>(데이터)</td>
				<td>(데이터)</td>
				<td>(데이터)</td>
				<td>(데이터)</td>
				<td>(데이터)</td>
				<td>(데이터)</td>
				</tr>
			</table>
			</div>
			<button class="btn btnstyle" type="button" onclick="location='search'">돌아가기</button>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>