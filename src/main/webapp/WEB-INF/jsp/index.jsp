<%@ page import="com.sun.org.apache.xpath.internal.SourceTree" %>
<%--
  Created by IntelliJ IDEA.
  User: maybra01
  Date: 10/6/2016
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>People Features!</title>
    <link href="../../css/custom.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top remove-margin-bottom">
    <div>
        <div align="center" class="navbar-header altered-menu">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.php">CSG International - My Favourite Features</a>
        </div>
    </div>
</nav>
<%for (int i = 0; i < 10; i++){%>
HELLOWORLD<br/>

<%}out.println("Your IP address is " + request.getRemoteAddr());%>
<%--<div class="container">
    <div class="jumbotron">
        <h1>Features</h1>
        <p>Anonymously Vote For Your Features. Go Ahead..</p>
    </div>
</div--%>

<div class="container-fluid altered-container spaces-bottom">
    <div align="center">
        <% response.setIntHeader("Refresh", 5); %>
        <table class="table table-bordered table-width">
            <tbody>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

            <c:if test="${not empty features}">
                <c:forEach var="feature" items="${features}">
                    <tr>
                        <td class="column-width column-width-vote-buttons">
                            <div align="center" class="votes-buttons">
                                <form method="POST" action="/upvote/${feature.id}">
                                    <button class="btn btn-success btn-lg glyphicon glyphicon-chevron-up"
                                            type="submit"></button>
                                </form>
                                <br class="spaces-bottom"/>
                                <form method="POST" action="/downvote/${feature.id}">
                                    <button class="btn btn-danger btn-lg glyphicon glyphicon-chevron-down"></button>
                                </form>
                            </div>
                        </td>
                        <td>
                            <div align="center" class="spaces-top"><h2 class="page-header spaces-top">
                                <a href="${feature.url}">${feature.id}</a>
                                - ${feature.name}</h2>
                            </div>
                        </td>
                        <div align="center" class="spaces-top">
                            <td class="column-width page-header">
                                <div align="center"><h1 class="spaces-top">Votes</h1></div>
                                <div align="center"><h1 class="fonts">${feature.vote}</h1></div>
                            </td>
                        </div>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
        <hr/>
    </div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
