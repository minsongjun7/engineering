<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
아이디 : ${member.membId}<br/>
이름 : ${member.membName}<br/>
연락처 : ${member.membPhoneNumber}<br/>
생년월일 : ${member.membBirth}<br/>
성별 : ${member.membGender}<br/>
이메일 : ${member.membEmail}<br/>
우편번호 : ${member.postNumber}<br/>
주소 : ${member.membAddr}<br/>
상세주소 : ${member.detailAddr}<br/>
등록일 : <fmt:formatDate value="${member.membJoinDate}" type="date"
				pattern="yyyy-MM-dd"/><br/>
<a href="memberModify?membId=${member.membId}">수정</a>
</p>
</body>
</html>