<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
    <c:param name="pageName" value="receptaForm"></c:param>
</c:import>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Recepta From</title>
</head>
<body class="card">
<div id="main" class="container">

    <form:form modelAttribute="recepta">
    <div class="form-group">
        <label for="lek" class="bmd-label-floating">Lek:</label>
        <form:input path="lek" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
        <form:errors path="lek" cssClass="error text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="dawkowanie" class="bmd-label-floating">Dawkowanie:</label>
         <form:input path="dawkowanie" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
         <form:errors path="dawkowanie" cssClass="error text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="refundacja.id" class="bmd-label-floating">Typ Refundacji:</label>
        <form:select path="refundacja.id" cssClass="form-control" cssErrorClass="form-control is-invalid">
            <form:options items="${refundacjaList}" itemLabel="nazwa" itemValue="id"/>
        </form:select>
        <form:errors path="refundacja.id" cssClass="error text-danger" element="div"/>
    </div>
    <button type="submit" class="btn btn-success" >Wyślij</button>
    </form:form>

</body>
</html>

</div>

<jsp:include page="shared/footer.jsp"/>
