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
		<div class="title">병원별 접종건수 통계</div>
			<div class="wrapper">
			<table border="1">
				<tr>
				<th>병원코드</th>
				<th>병원명</th>
				<th>접종건수</th>
				</tr>
				<tr>
				<td>(데이터)</td>
				<td>(데이터)</td>
				<td>(데이터)</td>
				</tr>
				<tr>
				<th></th>
				<th>총 누계</th>
				<th></th>
				</tr>
			</table>
			</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>