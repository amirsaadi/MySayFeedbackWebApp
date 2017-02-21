<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>topics</title>
    <link rel="stylesheet" href="<c:url value="/resource/css/styles.css"/>">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
            type="text/javascript"></script>
    <%--hides the comment submit form--%>
    <script>
        $(document).ready(function () {
            $(".comment-submit-form").hide();
        });
    </script>
    <%--extracts the clicked buttons’ id , comment submit form's id is assigned dynamically
by performing some string operations, correct form's id can be created
--%>
    <script>
        function showForm(clicked_id) {
            var v = clicked_id;
            var newStr = v.substring(1, v.length);
            var c = "#d";
            var formId = c.concat(newStr);
            $(formId).show(500);
        }
    </script>

<body>

<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a href="<spring:url value="/"/>" class="navbar-brand">feedback page</a>
        </div>
        <p class="wl"> welcome ${user.name} </p>
    </div>
</nav>

<div class="main-content">

    <div class="float-left-area">
        <div class="inner-left">
            <c:forEach items="${topics}" var="topic" varStatus="theCount">
                <div class="comment-and-topic">
                    <div class="topic-section">

                        <h1 class="topic-title">${topic.title}</h1>
                        <p class="topic-content">${topic.content}</p>
                        <div class="name-and-dat">
                            <p style="text-align: right;">${topic.user.email}
                                <span style="color: rgba(0,0,0,0.49)">${topic.date}</span>
                            </p>
                        </div>

                    </div>
                    <div class="comment-section">

                        <div>
                            <c:forEach items="${comments}" var="comment">
                                <c:if test="${topic.topicId==comment.commentOnTopic.topicId}">
                                    <p class="comment">${comment.mess} -
                                        <span style="color: #0059d0">${comment.user.name}</span>

                                        <span style="color: rgba(0,0,0,0.49)">${comment.date}</span>
                                      </p>
                                </c:if>
                            </c:forEach>
                        </div>

                        <spring:url value="/topic" var="loginUrl"/>
                        <form id="d${theCount.index}" class="comment-submit-form" method="post" action="${loginUrl}">
                            <div class="float-left-area-comment-form">
                                <input id="commentId" type="hidden" name="commentId" value="${topic.topicId}">
                                <div class="inner-left-comment-form">
                                    <textarea id="mess" name="mess" class="comment-text-area" title=""></textarea>
                                </div>

                            </div>
                            <div class="float-right-area-comment-form">
                                <div class="inner-right-comment-form">
                                    <button id="submitComment" name="submitComment" class="submit-comment-form-button">
                                        Add comment
                                    </button>
                                </div>
                            </div>
                            <div class="clear-floated"></div>
                        </form>
                        <button onclick="showForm(this.id)" class="comment-button" id="a${theCount.index}">add a
                            comment
                        </button>

                    </div>
                </div>
            </c:forEach>
            <spring:url value="/topic" var="topicUrl"/>
            <div class="topic-form">
                <form class="form-basic" method="post" action="${topicUrl}">

                    <div class="title-row">
                        <label>
                            <span>Title</span>
                            <input id="title" type="text" name="title">
                        </label>
                    </div>
                    <div class="content-row">
                        <label>

                            <textarea class="comment-text-area" id="content" name="content"></textarea>

                        </label>
                    </div>
                    <div class="form-row">
                        <button class="submit-comment-form-button" name="post" type="submit">Add A New Topic</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="float-right-area">

        <table id="tbl" class="tg" >
            <colgroup>
                <col style="width: 160px">
                <col style="width: 160px">
            </colgroup>
            <thead>
                <tr>
                    <th class="tg-gwd2">Topics</th>
                    <th class="tg-lqy6">Comments</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${topics}" var="topic">
                <tr>
                    <td class="tg-6k2t">${topic.title}</td>
                    <td class="tg-mb3i">${topic.comments.size()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>

</div>


</body>
</html>
