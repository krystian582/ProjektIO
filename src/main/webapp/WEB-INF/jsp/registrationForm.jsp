<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap-material-design/4.1.1/assets/css/docs.min.css" />
    <link rel="stylesheet" type="text/css"
          href="statics/css/main.css" />
</head>
<body class="card">
<c:import url="shared/header.jsp">
    <c:param name="pageName" value="registration"></c:param>
</c:import>
<div id="main" class="card-body container">

    <div class="row" style="margin-top:20px">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form:form modelAttribute="userCommand">

                <h3>Proszę, zarejestruj się</h3>
                <div class="form-group">
                    <form:errors path="*" cssClass="alert alert-danger" element="div">

                    </form:errors>
                </div>

                <div class="form-group">

                    <label for="pesel" class="bmd-label-floating">Pesel:</label>
                    <form:input path="pesel" cssClass="form-control"
                                cssErrorClass="form-control is-invalid"
                                required="true" autofocus="true" />
                </div>

                <div class="form-group">

                    <label for="imie" class="bmd-label-floating">Imie:</label>
                    <form:input path="imie" cssClass="form-control"
                                cssErrorClass="form-control is-invalid"
                                required="true" autofocus="true" />
                </div>

                <div class="form-group">

                    <label for="nazwisko" class="bmd-label-floating">Nazwisko:</label>
                    <form:input path="nazwisko" cssClass="form-control"
                                cssErrorClass="form-control is-invalid"
                                required="true" autofocus="true" />
                </div>

                <div class="form-group">

                    <label for="telefon" class="bmd-label-floating">Telefon:</label>
                    <form:input path="telefon" cssClass="form-control"
                                cssErrorClass="form-control is-invalid"
                                required="true" autofocus="true" />
                </div>

                <div class="form-group">

                    <label for="email" class="bmd-label-floating">Email:</label>
                    <form:input path="email" cssClass="form-control"
                                cssErrorClass="form-control is-invalid"
                                required="true" autofocus="true" />
                </div>

                <div class="form-group">

                    <label for="adres" class="bmd-label-floating">Adres:</label>
                    <form:input path="adres" cssClass="form-control"
                                cssErrorClass="form-control is-invalid"
                                required="true" autofocus="true" />
                </div>


                <div class="form-group">
                    <label for="password" class="bmd-label-floating">Hasło:</label>
                    <form:password path="password" cssClass="form-control"
                                   cssErrorClass="form-control is-invalid"
                                   required="true" />
                </div>

                <div class="form-group">
                    <label for="passwordConfirm" class="bmd-label-floating">Powtórz hasło:</label>
                    <form:password path="passwordConfirm" cssClass="form-control"
                                   cssErrorClass="form-control is-invalid"
                                   required="true"/>
                </div>

                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-success" value="Zarejestruj"/>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                    </div>
                </div>
            </form:form>
        </div>
    </div>

</div>
<jsp:include page="shared/footer.jsp"/>
</body>
</html>
