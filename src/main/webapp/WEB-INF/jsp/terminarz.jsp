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
    <title>Twój dzisiejszy terminarz</title>
</head>
<body class="card">
<div id="main">
    <H1>TERMINARZ</H1>

    <form:form id="searchForm" modelAttribute="searchCommand">
        <div class="row" >
            <div class="form-group col-md-4">
                <label for="data">Wyszukaj terminarz po dacie:</label>
                <form:input path="data" type="date" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="data" cssClass="error text-danger" element="div"/>
            </div>

            <div class="form-group col-md-8"></div>


            <div class="form-group col-md-2">
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Podaj date
                </button>
            </div>
        </div>
    </form:form>

    <c:if test="${empty terminarzList}">
        ${searchCommand.isEmpty() ? 'Lista pacjentów jest pusta':'Brak wyników wyszukiwania'}
    </c:if>

    <c:if test="${not empty terminarzList}">

         <table class="table table-striped">
            <thead>
            <tr>
                <th>Data</th>
                <th>Zabieg</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${terminarzList}" var="terminarz">
                <tr>
                    <td>${terminarz.wizyta.dataWizyty}</td>
                    <td>${terminarz.wizyta.usluga.nazwa}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
<jsp:include page="shared/footer.jsp"/>
