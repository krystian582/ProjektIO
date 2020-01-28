<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap-material-design/4.1.2/dist/css/bootstrap-material-design.css" />
    <link rel="stylesheet" type="text/css"
          href="statics/css/main.css" />

</head>
<body>
<div class="card-header">

    <nav id="header" class="navbar navbar-expand bg-dark flex-column flex-md-row">
        <div class="navbar-nav-scroll">
            <ul class="nav nav-tabs bg-dark">

                <li class="nav-item">
                    <a class="nav-link ${param['pageName'] eq 'home' ?'active':''}"  href="/" >Strona główna</a>
                </li>
                <security:authorize access="hasRole('LEKARZ')">
                    <li class="nav-item">
                        <a class="nav-link ${param['pageName'] eq 'lekarz' ?'active':''}"  href="userList.html">Pacjenci</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${param['pageName'] eq 'lekarz' ?'active':''}"  href="terminarz.html">Terminarz</a>
                    </li>
                </security:authorize>
                <security:authorize access="hasRole('ZARZAD')">
                    <li class="nav-item">
                        <a class="nav-link ${param['pageName'] eq 'zarzad' ?'active':''}"  href="userList.html">Pacjenci</a>
                    </li>
                </security:authorize>
                <security:authorize access="hasRole('RECEPCJA')">
                    <li class="nav-item">
                        <a class="nav-link ${param['pageName'] eq 'recepcja' ?'active':''}"  href="userList.html">Pacjenci</a>
                    </li>
                </security:authorize>
                <security:authorize access="hasRole('USER')">
                    <li class="nav-item">
                        <a class="nav-link ${param['pageName'] eq 'user' ?'active':''}"  href="x.html">Strona Usera</a>
                    </li>
                </security:authorize>
                <security:authorize access="isAnonymous()">
                <li class="nav-item">
                    <a class="nav-link ${param['pageName'] eq 'registration' ?'active':''}"  href="/registrationForm.html">Rejestracja</a>
                </li>
                </security:authorize>

            </ul>
        </div>

        <ul class="nav-tabs navbar-nav ml-md-auto bg-dark">
            <security:authorize access="isAuthenticated()">
                <label style="color:yellow; margin-top: 20px;">
                    Witaj <security:authentication property="principal.username"/>!
                </label>
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="document.getElementById('logout').submit()">Wyloguj się</a>
                    <form action="/logout" id="logout" method="post" style="display: none;">
                        <security:csrfInput/>
                    </form>
                </li>
            </security:authorize>

            <security:authorize access="isAnonymous()">
                <li class="nav-item">
                    <a class="nav-link ${param['pageName'] eq 'logonForm' ?'active':''}" href="/login">Zaloguj się</a>
                </li>
            </security:authorize>
        </ul>

    </nav>

</div>
</body>
</html>


