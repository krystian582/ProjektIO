<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
    <%--<c:param name="pageName" value="kartaZdrowiaList"></c:param>--%>
</c:import>
<html>
<head>
    <title>Karta Zdrowia</title>
</head>
<body class="card">
<div id="main">
    <H1>Karta Zdrowia</H1>


    <c:choose>
        <c:when test="${kartaZdrowiaList.isEmpty()}">
            Karta zdrowia jest pusta
        </c:when>
    </c:choose>

    <c:if test="${not empty kartaZdrowiaList}">

        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Data</th>
                <th>Opis</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${kartaZdrowiaList}" var="kartazdrowia">
                <tr>
                    <td>${kartazdrowia.id}</td>
                    <td>${kartazdrowia.creationDate}</td>
                    <td>${kartazdrowia.opis}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:set var="page" value="${kartaZdrowiaList}" scope="request"/>
        <c:set var="mainUrl" value="kartaZdrowiaList.html" scope="request"/>
        <%--<jsp:include page="shared/pagination.jsp"/>--%>

    </c:if>
</div>
</body>
</html>
<jsp:include page="shared/footer.jsp"/>
