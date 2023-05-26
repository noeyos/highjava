<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<style>
/* label {
    display: inline-block;
    width: 50px;
    margin-bottom: 5px;
}

#login {
	margin-top: 5px;
	margin-left: 80px;
} */

</style>


<%
// 쿠키 정보를 읽어서 처리한다
String cookieUserId = "";	// 쿠키값이 저장될 변수
String chk = "";

Cookie[] cookieArr = request.getCookies();	// 전체 쿠키 가져오기


for(Cookie cookie : cookieArr) {
	if("USERID".equals(cookie.getName())) {	// 원하는 쿠기 이름 찾기
		cookieUserId = cookie.getValue();	// 쿠키값을 구한다
		chk = cookie.getValue();
	} 
}
%>

<body>
<form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="get">
<table border="1" style="margin: 0 auto;">
	<tr>
		<td>ID : </td>
		<td><input type="text" id="userid" name="userid" value="<%= cookieUserId %>" placeholder="ID 입력하세요" size=15></td>
	</tr>
	<tr>
		<td>PASS : </td>
		<td><input type="password" id="pass" name ="pass" placeholder="PassWord 입력하세요" size=15></td>
	</tr>
	<tr>
		<td colspan="2"><input type="checkbox" name="chkid" value="check" <%=chk %> >ID 기억하기</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;"><input type="submit" id="login" name="login" value="Login"></td>
	</tr>
</table>
</form>
<!-- <div>
	<form action="%=request.getContextPath()%>/cookieLoginServlet.do" method="get">
		<label for="loginID">ID :</label>
		<input type="text" id="id" name="id" placeholder="ID 입력하세요" size=15><br>
		
		<label for="loginPASS">PASS :</label>
		<input type="password" id="pass" name ="pass" placeholder="PassWord 입력하세요" size=15><br>
		
		<input type="checkbox" id="save" name="save" value="save"> id 기억하기
		<br>
		
		
		<input type="submit" id="login" value="Login" >
	
	</form>
</div> -->
</body>
<script>


</script>
</html>