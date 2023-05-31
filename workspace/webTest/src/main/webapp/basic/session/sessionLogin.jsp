<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
// JSP문서에서는 세션객체는 'session' 이라는 이름으로 이미 저장되어 있다.


// 로그인 성공했을 때 저장한 세션 가져오기
String userid = (String)session.getAttribute("userID");

%>

<%
if(userid==null) {	// 로그인이 안 되었을 때
	

%>

<form action="<%=request.getContextPath()%>/sessionLogin.do" method="post">
<table border="1" style="margin: 0 auto;">
	<tr>
		<td>ID : </td>
		<td><input type="text" name="id" placeholder="아이디를 입력하세요"></td>

	</tr>
	<tr>
		<td>PASS:</td>
		<td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
		<input type=submit value="Login" id="login">
		</td>
	</tr>
</table>
</form>
<%
} else {
%>

	<h3><%=userid%>님 반값습니다.</h3>
	<a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>

<%
}
%>
</body>
</html>