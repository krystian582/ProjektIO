<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
    <c:param name="pageName" value="kartaZdrowiaForm"></c:param>
</c:import>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>KartaZdrowia From</title>
</head>
<body class="card">
<div id="main" class="container">

    <form:form modelAttribute="informacja">
    <div class="form-group">
        <label for="imie" class="bmd-label-floating">Imie:</label>
        <form:input path="imie" cssClass="form-control" cssErrorClass="form-control is-invalid" disabled="true"/>
        <form:errors path="imie" cssClass="error text-danger" element="div"/>
    </div>
        <div class="form-group">
            <label for="nazwisko" class="bmd-label-floating">Nazwisko:</label>
            <form:input path="nazwisko" cssClass="form-control" cssErrorClass="form-control is-invalid" disabled="true"/>
            <form:errors path="nazwisko" cssClass="error text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="pesel" class="bmd-label-floating">Pesel:</label>
            <form:input path="pesel" cssClass="form-control" cssErrorClass="form-control is-invalid" disabled="true"/>
            <form:errors path="pesel" cssClass="error text-danger" element="div"/>
        </div>
    </form:form>
    <form:form modelAttribute="kartaZdrowia">
    <div class="form-group">
        <label for="opis" class="bmd-label-floating">Opis:</label>
        <form:input path="opis" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
        <form:errors path="opis" cssClass="error text-danger" element="div"/>
    </div>
    <button type="submit" class="btn btn-success" >Wyślij</button>
    </form:form>

</body>
</html>

</div>

<jsp:include page="shared/footer.jsp"/>
