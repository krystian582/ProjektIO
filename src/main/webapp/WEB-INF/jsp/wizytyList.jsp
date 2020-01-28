<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="shared/header.jsp">
    <jsp:param name="pageName" value="wizyty"/>
</jsp:include>
<html>
<head>
    <title>Wizyty</title>
</head>
<body class="card">
<div id="main">
    <H1>Twoje Wizyty</H1>


    <c:choose>
        <c:when test="${wizyty.isEmpty()}">
            Nie masz zaplanowanych wizyt.
        </c:when>
    </c:choose>

    <a class="btn btn-success" href="wizytyForm.html">Zerezerwuj wizyte</a>

    <c:if test="${not empty wizyty}">

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Data wizyty</th>
                <th>Usługa</th>
                <th>Cena</th>
                <th>Status</th>
                <th>Opcje</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${wizyty}" var="wizyta">
                <tr>
                    <td>${wizyta.dataWizyty}</td>
                    <td>${wizyta.usluga.nazwa}</td>
                    <td>${wizyta.usluga.cena} PLN</td>
                    <td>${wizyta.statusWizyty.nazwa}</td>
                    <c:choose>
                        <c:when test="${wizyta.statusWizyty.id==1}">
                            <td><a class="btn btn-danger" href="?did=${wizyta.id}">Anuluj</a></td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <security:authorize access="hasRole('RECEPCJA')">
                                    <a class="btn btn-danger" href="?did=${wizyta.id}">Anuluj</a>
                                </security:authorize>
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:set var="page" value="${wizyty}" scope="request"/>
        <c:set var="mainUrl" value="wizyty.html" scope="request"/>
    </c:if>
</div>
</body>
</html>
<jsp:include page="shared/footer.jsp"/>
