<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<main>
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if> <c:choose>
    <c:when test="${user!=null}">
        <p>Welcome ${user.getFirstName()}!</p>
        <form method="post" action="Controller?action=LogOut">
            <p>
                <input type="submit" id="logoutbutton" value="Log Out">
            </p>
        </form>
        <jsp:include page="chats.jsp"/>
    </c:when>
    <c:otherwise>
        <form method="post" action="Controller?action=LogIn">
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" value="jan@ucll.be">
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" value="t">
            </p>
            <p>
                <input type="submit" id="loginbutton" value="Log in">
            </p>
        </form>
        <br>
        <form method="post" action="Controller?action=AddUser">
            <p>
                <label for="newEmail">Your email</label>
                <input type="text" id="newEmail" name="email">
            </p>
            <p>
                <label for="firstName">First Name</label>
                <input type="text" name="firstName" id="firstName">
            </p>
            <p>
                <label for="lastName">Last Name</label>
                <input type="text" name="lastName" id="lastName">
            </p>
            <p>
                <label for="gender">Gender</label>
                <input type="radio" name="gender" id="gender" value="male">Male
                <input type="radio" name="gender" id="gender" value="female">Female
            </p>
            <p>
                <label for="newPassword">Password</label>
                <input type="password" name="password" id="newPassword">
            </p>
            <p>
                <label for="passwordRepeat">Repeat Password</label>
                <input type="password" id="passwordRepeat" name="passwordRepeat">
            </p>
            <p>
                <label for="age">Age</label>
                <select name="age" id="age">
                    <c:forEach begin="10" end="100" var="nr">
                        <option value="${nr}">${nr}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <input type="submit" value="Create account">
            </p>
        </form>
        <jsp:include page="feedbacks.jsp"/>
    </c:otherwise>
</c:choose>

</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
<script src="js/chat.js"></script>
<script src="js/friends.js"></script>
<script src="js/websockets.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.js"></script>
</html>