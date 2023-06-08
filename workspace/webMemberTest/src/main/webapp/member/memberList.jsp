<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.7.0.min.js"></script>
<script>
$(function(){
	$.ajax({
		url: '<%=request.getContextPath()%>/memberList.do',
		type:"post"
		success: function(res){
			code = `<table border=1>`;
			code += `<tr><td colspan="5"><input type="button" value="회원추가"></td></tr>`;
			code += `<tr><td>ID</td><td>비밀번호</td><td>이름</td><td>전화</td><td>주소</td></tr>`;
			$.each(res, function(i, v) {
				code += `<tr><td>${v.id}</td>`;
				code += `<td>${v.pass}</td>`;
				code += `<td>${v.name}</td>`;
				code += `<td>${v.tel}</td>`;
				code += `<td>${v.addr}</td></tr>`;
			})
			
			code += `</table>`;
			$('#result').html(code);
		},
		error: function(xhr){
			alert("오류 : " + xhr.status);			
		},
		dataType: 'json'
	})
})
</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/memberList.do" method="post">
	<h3>회원 목록 보기</h3>
	<div class=result></div>
</form>
</body>
</html>