<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
<style>
table, tr, td {
	border:1px solid blue;
	border-collapse: collapse;
}
td {
	padding:5px;
}
</style>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script>
$(function(){
	$("#btnList").on("click", function(){
		location.href="<%=request.getContextPath()%>/member/memberList.do";
	});
	
	$("#idCheck").on("click", function(){
		var memId = $("#mem_id").val();
		if(memId==""){
			alert("ID를 입력하세요");
			return;
		}
		
		$.ajax({
	    	 url : '<%=request.getContextPath()%>/member/memberIdCheck.do',
	    	 data : { "mem_id" : memId },
	    	 dataType : 'json',
	    	 success : function(result){
	    		 if(result=="OK"){
	    			 $("#idChkResult").html("사용 가능");
	    		 }else{
	    			 $("#idChkResult").html("사용 불가능");
	    		 }
	    	 },
	    	 error : function(xhr){
	    		 alert("status :" + xhr.status);
	    	 }
	     })
	});
	
	$("#memberForm").on("submit", function(){
		var idchk = $("#idChkResult").html();
		
		if(idchk!="사용 가능"){
			alert("ID 중복이거나 중복체크를 하지 않았습니다.");
			return false;
		}
		
		if($("#mem_pass").val()=="" || $("#mem_pass").val()!= $("#mem_pass2").val()){
			alert("비밀번호와 비밀번호 확인이 다릅니다.");
			return false;
		}
		return true;
	});
});
</script>
</head>
<body>
<h2>회원 정보 입력 폼</h2>
<form id="memberForm" method="post" enctype="multipart/form-data"
	action="<%=request.getContextPath()%>/member/memberInsert.do" >
<table border="1">
<tbody>
	<tr>
		<td>회원ID</td>
		<td>
			<input type="text" name="mem_id" id="mem_id">
			<input id="idCheck" type="button" value="중복확인"><br>
			<span id="idChkResult"></span>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="mem_pass" id="mem_pass"></td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td><input type="password" name="mem_pass2" id="mem_pass2"></td>
	</tr>	
	<tr>
		<td>회원이름</td>
		<td><input type="text" name="mem_name"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="mem_tel"></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><input type="text" name="mem_addr"></td>
	</tr>
	<tr>
		<td>프로필 사진</td>
		<td><input type="file" name="mem_photo"></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="submit" value="저장"> <input type="reset" value="취소">
			<input type="button" id="btnList" value="회원목록"></td>
	</tr>
</tbody>
</table>
</form>
</body>
</html>