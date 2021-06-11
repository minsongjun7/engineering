<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="empModifyOk" method="post" name="frm">
<table border="1" width="500" align="center">
	<tr><td width="130">직원번호</td>
		<td width="370">
		</td></tr>
	<tr><td>아이디</td>
		<td>
		</td></tr>
	<tr><td>비밀번호</td>
		<td>
			<input type="password" name="empPw">
		</td></tr>
	<tr><td>이름</td>
		<td>
		</td></tr>
	<tr><td>부서명</td>
		<td>
			<input type="text" name="empDeptName">
		</td></tr>
	<tr><td>이메일</td>
		<td>
			<input type="text" name="empEmail">
		</td></tr>
	<tr><td>연락처</td>
		<td>
			<input type="text" name="empPhoneNumber" placeholder="010-1234-5678">
		</td></tr>
	<tr><td>입사일</td>
		<td>
			<input type="text" name="hireDate" placeholder="yyyy-MM-dd">
		</td></tr>
	<tr><td>급여</td>
		<td>
			<input type="text" name="salary">
		</td></tr>
	<tr><td colspan=2 align="center">
		<input type="submit" value="직원수정 완료">
		<input type="button" value="직원 삭제">
	</td></tr>
</table>
</form>
</body>
</html>