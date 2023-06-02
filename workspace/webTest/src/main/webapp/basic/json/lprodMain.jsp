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
	
	// ajax를 사용하지 않기
	$("#lprodBtn2").on("click", function() {
		
		// 서블릿으로 요청을 하면 서블릿에서 DB의 자료를 가져오고
		// 가져온 자료를 view용 JSP문서로 forward방식으로 보낸다.
		// view용 JSP문서에서는 서블릿이 보낸 데이터를 받아서 화면에 출력한다.
		
		location.href = "<%=request.getContextPath()%>/lprodListServlet2.do";
		
		
	})
})
</script>
</head>
<body>
<form>
	<input type="button" id="lprodBtn" value="Lprod자료 가져오기">
	<input type="button" id="lprodBtn2" value="ajax 없이 Lprod자료 가져오기">
</form>
<h3>Lprod 자료 목록</h3>
<div id="result"></div>
</body>
</html>