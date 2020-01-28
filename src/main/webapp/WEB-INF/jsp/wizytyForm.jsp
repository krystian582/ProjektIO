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
    <form:form modelAttribute="wizyta">

        <div class="form-group">
            <form:errors path="*" cssClass="alert alert-danger" element="div">

            </form:errors>
        </div>

        <div class="form-group">
            <label for="usluga.id" class="bmd-label-floating">Usługa:</label>
            <form:select path="usluga.id" cssClass="form-control" cssErrorClass="form-control is-invalid">
                <form:option value="-1" disabled="true">--wybierz usługę--</form:option>
                <form:options items="${uslugiWizytyForm}" itemLabel="nazwa" itemValue="id"/>
            </form:select>
            <form:errors path="usluga.id" cssClass="error text-danger" element="div"/>
        </div>

        <div class="form-group">
            <label for="dataWizyty" class="bmd-label-floating">Data wizyty:</label>
            <form:input path="dataWizyty" cssClass="form-control" type="date" cssErrorClass="form-control is-invalid"/>
            <form:errors path="dataWizyty" cssClass="error text-danger" element="div"/>
        </div>

        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-6">
                <input type="submit" class="btn btn-success" value="Zarezerwuj"/>
            </div>
            <div class="col-xs-6 col-sm-6 col-md-6">
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
<jsp:include page="shared/footer.jsp"/>
