<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<body>
<div id="footer">
    <footer class="blockquote-footer">
        © 2020 IO - Kamil Pogorzelski / Krystian Koc / Patryk Koc
        <security:authorize access="isAuthenticated()">
            <security:authentication property="authorities" var="roleList"></security:authentication>
            <div>
                Twoje role to:
                <c:forEach items="${roleList}" var="role">
                    ${role},
                </c:forEach>
            </div>
        </security:authorize>
    </footer>
</div>
</body>
</html>
