<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
    <c:param name="pageName" value="receptaList"></c:param>
</c:import>
<html>
<head>
    <title>Lista Towoich Recept</title>
</head>
<body class="card">
<div id="main">
    <H1>TWOJE RECEPTY</H1>

    <form:form id="searchForm" modelAttribute="searchCommand">
        <div class="row" >
            <div class="form-group col-md-4">
                <label for="pesel">:</label>
                <form:input path="pesel" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="pesel" cssClass="error text-danger" element="div"/>
            </div>

            <div class="form-group col-md-8"></div>

            <div class="form-group col-md-2">
                <a href="/receptaList.html?all" class="btn btn-success">
                    <span class="glyphicon glyphicon-refresh"></span> Pokaż wszystkich
                </a>
            </div>

            <div class="form-group col-md-2">
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Wyszukaj Pacjenta
                </button>
            </div>
        </div>
    </form:form>

    <c:if test="${empty receptaListPage.content}">
        ${searchCommand.isEmpty() ? 'Lista recept jest pusta':'Brak wyników wyszukiwania'}
    </c:if>

    <c:if test="${not empty receptaListPage.content}">

        <c:choose>
            <c:when test="${searchCommand.isEmpty()}">
                Lista zawiera ${receptaListPage.totalElements} recept
            </c:when>
            <c:otherwise>
                Wynik wyszukiwania: ${receptaListPage.totalElements} recept
            </c:otherwise>
        </c:choose>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Lek</th>
                <th>Dawkowanie</th>
                <th>Refundacja</th>
                    <%--<security:authorize access="hasRole('LEKARZ')">
                        <th>Opcje</th>
                    </security:authorize>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${receptaListPage.content}" var="recepta">
                    <tr>
                        <td>${recepta.id}</td>
                        <td>${recepta.lek}</td>
                        <td>${recepta.dawkowanie}</td>
                        <td>${recepta.refundacja.nazwa}</td>
                        <%--<security:authorize access="hasRole('LEKARZ')">
                            <td>
                                <a class="btn btn-danger" href="userReceptaForm.html?id=${user.pesel}">Recepta</a>
                                <a class="btn btn-success" href="userKartaZdrowiaList.html?id=${user.pesel}">Karta Zdrowia</a>
                            </td>
                        </security:authorize>
                        <security:authorize access="hasRole('RECEPCJA')">
                            <td>
                                <a class="btn btn-danger" href="userWizytaForm.html?id=${user.pesel}">Wizyty</a>
                            </td>
                        </security:authorize>
                        <security:authorize access="hasRole('ZARZAD')">
                            <td>
                                <a class="btn btn-danger" href="userLekarzForm.html?id=${user.pesel}">Mianuj Lekarzem</a>
                            </td>
                        </security:authorize>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:set var="page" value="${receptaListPage}" scope="request"/>
        <c:set var="mainUrl" value="receptaList.html" scope="request"/>
        <jsp:include page="shared/pagination.jsp"/>

    </c:if>
</div>
</body>
</html>
<jsp:include page="shared/footer.jsp"/>
