<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
</c:import>
<html>
<head>
    <title>Twoje Recepty</title>
</head>
<body class="card">
<div id="main">
    <H1>Twoje Recepty</H1>


    <c:choose>
        <c:when test="${receptaList.isEmpty()}">
            Lista recept jest pusta
        </c:when>
    </c:choose>

    <c:if test="${not empty receptaList}">

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Lek</th>
                <th>Data</th>
                <th>Dawkowanie</th>
                <th>Refundacja</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${receptaList}" var="recepta">
                <tr>
                    <td>${recepta.lek}</td>
                    <td>${recepta.creationDate}</td>
                    <td>${recepta.dawkowanie}</td>
                    <td>${recepta.refundacja.nazwa}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:set var="page" value="${receptaList}" scope="request"/>
        <c:set var="mainUrl" value="receptaList.html" scope="request"/>
    </c:if>
</div>
</body>
</html>
<jsp:include page="shared/footer.jsp"/>
