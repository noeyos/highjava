<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
$(function () {
	
	// 문자열 처리
	$("#strBtn").on("click", function () {
		
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=string",
				  // "이름(parameter)=값&이름=값", {"이름1": 값1, "이름2": 값2}
			success : function(data) {
				$("#result").html(data);
			},
			error: function(xhr) {
				alert("오류 : " + xhr.status);
			},
			dataType: "json"	// 응답 데이터의 데이터 타입 지정
		
		})
	
	})
	
	// ---------------------------------------------------------------------------
	
	// 배열 처리
	$("#arrayBtn").on("click", function () {
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=array",
			success: function (data) {
				// data = [10, 20, 30, 40, 50, 60]
				let htmlCode = "";
				$.each(data, function(i, v){
					htmlCode += i + "번째 자료 : " + v + "<br>";
				})
				
				$('#result').html(htmlCode);
			},
			error: function(xhr) {
				alert("오류 : " + xhr.status);
			},
			dataType: "json"	
		})
	})
		
	// ---------------------------------------------------------------------------
	
	// 객체 처리
	$("#objBtn").on("click", function () {
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=obj",
			success: function (data) {
				// data = {"num":1,"name":"홍길동"}
				let htmlCode = "";
				htmlCode += "번호 : " + data.num + "<br>";
				htmlCode += "이름 : " + data.name + "<br>";
				
				$('#result').html(htmlCode);
				
				
			},
			error: function(xhr) {
				alert("오류 : " + xhr.status);
			},
			dataType: "json"	
		})
	})
	
	// ---------------------------------------------------------------------------
	
	// 객체 처리
	$("#listBtn").on("click", function () {
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=list",
			success: function (data) {
				// data = [{"num":100,"name":"이순신"},
				//		   {"num":200,"name":"강감찬"},
				//  	   {"num":300,"name":"이몽룡"}]
				let htmlCode = "";
				$.each(data, function(i, v){
					htmlCode += i + "번째 자료<br>";
					htmlCode += "번호 : " + v.num +"<br>";
					htmlCode += "이름 : " + v.name + "<hr>";
				})
				$('#result').html(htmlCode);
			},
			error: function(xhr) {
				alert("오류 : " + xhr.status);
			},
			dataType: "json"
		})
	})
			
	// ---------------------------------------------------------------------------

	// Map데이터 처리
	$("#mapBtn").on("click", function () {
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONDataTest.do",
			type : "post",
			data : "choice=map",
			success: function (data) {
/* 				// data = {"name":"성춘향","tel":"010-1234-5678","addr":"대전시 중구 오류동"}
				let htmlCode = "이름 : " + data.name + "<br>";
				htmlCode += "전화 : " + data.tel + "<br>";
				htmlCode += "주소 : " + data.addr + "<br>";
					
				$('#result').html(htmlCode);    */
				
				let htmlCode = "";
				$.each(data, function(i, v) {	// map데이터일 땐 => key, v => value 값 들어감
					htmlCode += i + " : " + v + "<br>";
				})
				$('#result').html(htmlCode);
			},
			error: function(xhr) {
				alert("오류 : " + xhr.status);
			},
			dataType: "json"
		})
	})
})

</script>
<body>
<h2>Ajax를 이용한 예제</h2>
<form action="">
	<input type="button" id="strBtn" value="문자열">
	<input type="button" id="arrayBtn" value="배열">
	<input type="button" id="objBtn" value="객체">
	<input type="button" id="listBtn" value="리스트">
	<input type="button" id="mapBtn" value="Map객체">
</form>
<br><hr color="#E4E4E4"><br>
<h3>응답 결과 출력</h3>
<div id="result"></div>


</body>
</html>