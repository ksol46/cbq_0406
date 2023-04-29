<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="script.js"></script>
</head>
<body>
	<%@ include file="topmenu.jsp"%>
	<section>
		<div class="title">백신접종예약</div>
		<form name="frm" action="insert">
			<input type="hidden" id="GUBUN" value="insert">
			<div class="wrapper">
				<table border="1">
					<tr>
						<th>접종예약번호</th>
						<td><input type="text" name="resvno" value=""><span>예)
								20210001</span></td>
					</tr>
					<tr>
						<th>주민번호</th>
						<td><input type="text" name="jumin" value=""><span>예)
								710101-1000001</span></td>
					</tr>
					<tr>
						<th>백신코드</th>
						<td><input type="text" name="vcode" value=""><span>예)
								V001 ~ V003</span></td>
					</tr>
					<tr>
						<th>병원코드</th>
						<td><input type="text" name="hospcode" value=""><span>예)
								H001</span></td>
					</tr>
					<tr>
						<th>예약일자</th>
						<td><input type="text" name="resvdate" value=""><span>예)
								20211231</span></td>
					</tr>
					<tr>
						<th>예약시간</th>
						<td><input type="text" name="resvtime" value=""><span>예)
								1230</span></td>
					</tr>
					<tr>
						<td colspan="2">
							<button class="btn" type="submit"
								onclick="fn_submit_res(); return false;">등록</button>
							<button class="btn" type="reset" onclick="fn_reset();">다시쓰기</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>