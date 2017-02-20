<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>login</title>

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
            type="text/javascript"></script>
    <link rel="stylesheet" href="<c:url value="/resource/css/login.css"/>">
    <link rel="stylesheet" href="<c:url value="/resource/css/styles.css"/>">

</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a href="<spring:url value="/"/>" class="navbar-brand">feedback page</a>
        </div>

    </div>
</nav>

<div class="main-content">
    <spring:url value="/login" var="loginUrl"/>

    <form class="form-login" method="post" action="${loginUrl}">
        <div class="form-log-in-with-email">
            <div class="form-white-background">
                <div class="form-title-row">
                    <h1>Log in </h1>
                </div>

                <div class="form-row">
                    <label>
                        <span>Email</span>
                        <input  name="email">
                    </label>
                </div>
                <div class="form-row">
                    <label>
                        <span>Name</span>
                        <input  name="name">
                    </label>
                </div>
                <div class="form-row">
                    <button type="submit">Log in</button>
                </div>
            </div>

        </div>
    </form>
</div>
</body>
</html>
