<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
<h2>Request연습 Form(숫자 입력은 정수형으로 입력하세요.)</h2>
<hr>
<form action="/webTest/requestTest02.do" method="get">
	<input type="text" name="num1" size="10">
	<select name="calc">
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
		<option value="%">%</option>
	</select>
	<input type="text" name="num2" size="10">
	<input type="submit" value="확인">
</form>
</body>
</html>