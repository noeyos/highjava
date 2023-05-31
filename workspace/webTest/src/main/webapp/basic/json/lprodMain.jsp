<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script>
$(function() {
	$('#lprodBtn').on('click', function() {
		$.ajax({
			url : "<%=request.getContextPath()%>/lprodListServlet.do",
			type: "post",
			success : function(data) {
				code = "<table border='1'>";
				code += "<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td></tr>";
				$.each(data, function(i, v) {
					code += "<tr><td>" + v.lprod_id + "</td>"
					code += "<td>" + v.lprod_gu + "</td>"
					code += "<td>" + v.lprod_nm + "</td></tr>"
				})
				code += "</table>";

				$('#result').html(code);
			},
			error: function(xhr) {
				alert("오류 : " + xhr.status);
			},
			dataType: "json"
		})
	})
})
</script>
</head>
<body>
<form>
	<input type="button" id="lprodBtn" value="Lprod자료 가져오기">
</form>
<h3>Lprod 자료 목록</h3>
<div id="result"></div>
</body>
</html>