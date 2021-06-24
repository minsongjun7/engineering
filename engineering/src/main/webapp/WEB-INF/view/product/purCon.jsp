<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800" border="1">
	<tr><th>주문일자/결제번호</th><th colspan="2">상품명/주문번호</th><th>주문상태</th></tr>
<c:forEach items="${list}" var="dto">	
	<tr><td>${dto.purDate}/${dto.payNo}</td>
		<td rowspan="2"><img width="100" src="../product/upload/${dto.prodImage.split(',')[0]}"/></td>
		<td rowspan="2">${dto.prodName}/${dto.purNo}</td>
		<td rowspan="2"><c:if test="${dto.payNo == null}"><a href="paymentOk?purNo=${dto.purNo}&payPrice=${dto.purTotal}">주문하기</a></c:if>
						<c:if test="${dto.payNo != null }">주문완료<br/>
							<c:if test="${dto.reviewContent == null}">
								<a href="goodsReview?purNo=${dto.purNo}&prodNo=${dto.prodNo}&prodName=${dto.prodName}">리뷰쓰기</a></c:if>
							<c:if test="${dto.reviewContent != null}">
								<a href="goodsReviewUpdate?purNo=${dto.purNo}&prodNo=${dto.prodNo}&prodName=${dto.prodName}">리뷰수정</a></c:if>
						</c:if>
		</td>
	</tr>
	<tr><td>결제금액 : ${dto.purTotal}</td></tr>
</c:forEach>
</table>
</body>
</html>