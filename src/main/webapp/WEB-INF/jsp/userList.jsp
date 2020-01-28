<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
    <c:param name="pageName" value="userList"></c:param>
</c:import>
<html>
<head>
    <title>Lista Pacjentów</title>
</head>
<body class="card">
<div id="main">
    <H1>LISTA PACJENTÓW</H1>

    <form:form id="searchForm" modelAttribute="searchCommand">
        <div class="row" >
            <div class="form-group col-md-4">
                <label for="pesel">Wyszukaj Pacjenta po Peselu:</label>
                <form:input path="pesel" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="pesel" cssClass="error text-danger" element="div"/>
            </div>

            <div class="form-group col-md-8"></div>

            <div class="form-group col-md-2">
                <a href="/userList.html?all" class="btn btn-success">
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

    <c:if test="${empty userListPage.content}">
        ${searchCommand.isEmpty() ? 'Lista pacjentów jest pusta':'Brak wyników wyszukiwania'}
    </c:if>

    <c:if test="${not empty userListPage.content}">

        <c:choose>
            <c:when test="${searchCommand.isEmpty()}">
                Lista zawiera ${userListPage.totalElements} pacjentów
            </c:when>
            <c:otherwise>
                Wynik wyszukiwania: ${userListPage.totalElements} pacjentów
            </c:otherwise>
        </c:choose>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Pesel</th>
                <th>Imie</th>
                <th>Nazwisko</th>
                <th>Adres</th>
                <th>Telefon</th>
                <security:authorize access="hasRole('LEKARZ')">
                    <th>Opcje</th>
                </security:authorize>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userListPage.content}" var="user">
                <tr>
                    <td>${user.pesel}</td>
                    <td>${user.imie}</td>
                    <td>${user.nazwisko}</td>
                    <td>${user.adres}</td>
                    <td>${user.telefon}</td>
                    <security:authorize access="hasRole('LEKARZ')">
                        <td>
                            <a class="btn btn-danger" href="receptaForm.html?idu=${user.id}">Recepta</a>
                            <a class="btn btn-success" href="kartaZdrowiaList.html?idu=${user.id}">Sprawdź Karte Zdrowia</a>
                            <a class="btn btn-success" href="kartaZdrowiaForm.html?idu=${user.id}">Dodaj Wpis Do Karty</a>
                        </td>
                    </security:authorize>
                    <security:authorize access="hasRole('RECEPCJA')">
                        <td>
                            <a class="btn btn-danger" href="wizytyList.html?id=${user.id}">Wizyty</a>
                        </td>
                    </security:authorize>
                    <security:authorize access="hasRole('ZARZAD')">
                        <td>
                            <a class="btn btn-danger" href="userLekarzForm.html?id=${user.id}">Mianuj Lekarzem</a>
                        </td>
                    </security:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:set var="page" value="${userListPage}" scope="request"/>
        <c:set var="mainUrl" value="userList.html" scope="request"/>
        <jsp:include page="shared/pagination.jsp"/>

    </c:if>
</div>
</body>
</html>
<jsp:include page="shared/footer.jsp"/>
