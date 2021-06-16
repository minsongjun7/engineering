<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1>
	<tr><td>아이디</td><td>이름</td><td>연락처</td><td>성별</td><td>가입일</td></tr>
	<c:forEach items="${lists}" var="dto">
		<tr><td><a href="memberInfo?membId=${dto.membId}">${dto.membId}</a></td><td>${dto.membName}</td><td>${dto.membPhoneNumber}</td><td>${dto.membGender}</td>
			<td><fmt:formatDate value="${dto.membJoinDate}" type="date" pattern="yyyy-MM-dd"/></td></tr>
	</c:forEach>
</table>
</body>
</html>