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
		<div class="title">접종예약정보가 존재하지 않습니다!</div>
		<button class="btn btnstyle" type="button" onclick="location='search'">돌아가기</button>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>