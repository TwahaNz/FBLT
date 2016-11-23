<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*,java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: maybra01
  Date: 10/6/2016
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>


<%--<c:set var="username" value="${username}"/>

<%
    session.setAttribute("user", (String) pageContext.getAttribute("username"));
%>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FBLT</title>
    <link href="../../css/custom.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>

<script>
    function isValidEmail() {
        var email = document.getElementById("email_code").value;

        if (email == "") {
            alert("Empty Email");
            return false;
        }

        return true;
    }
</script>

<nav class="navbar navbar-default navbar-static-top">
    <div class="navbar-header altered-menu">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index"><b>Why don't we have a Name Yet - We Make Online Shopping Easier!</b></a>
    </div>


    <div id="navbar" class="navbar-collapse collapse">

        <form id="postAdForm" action="post-advert" class="navbar-form navbar-right altered-menu"
              style="margin-right:20px;">

            <div class="form-group">
                <button type="submit" class="btn btn-primary spaces-right-header">Post Free Ad!</button>
            </div>
        </form>

        <c:choose>
            <c:when test="${username.length() > 0}">
                <form id="sign-out" action="sign-out-request" method="post"
                      class="navbar-form navbar-right altered-menu">
                    <b>Welcome!</b> ${username}
                    <button type="submit" class="btn btn-danger spaces-left glyphicon glyphicon-log-out
"></button>
                </form>
            </c:when>
            <c:otherwise>
                <div class="navbar-form navbar-right altered-menu"
                     style="padding-left: 5px!important; padding-right: 5px!important;">
                    <p><input type='text' placeholder="Valid Email" class="form-control custom-control spaces-right"
                              name='email'
                              value=""/>
                        <button type="button" class="btn btn-success glyphicon glyphicon-log-in
" data-toggle="modal" data-target="#myModal"></button>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

</nav>

<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog middle-buttons" style="margin-top: 15%">
        <div class="modal-content">
            <div class="modal-header">
                <div align="center"><h4 class="modal-title page-header"><b>Enter The Verification Code Sent To Your
                    Email</b></h4>
                    <form id="link" action="login-request" method="post" onsubmit="return isValidEmail()"
                          style="padding-left: 5px!important; padding-right: 5px!important;">
                        <p><input type='text' placeholder="Enter Verification Code"
                                  class="form-control custom-control spaces-right"
                                  name='email_code'
                                  value=''/>
                            <button type="submit" class="btn btn-success spaces-top glyphicon glyphicon-ok
" data-toggle="modal" data-target="#myModal">

                            </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<div align="center" class="row spaces-top">
    <div class="col-md-1 catagories" style="color: white; background-color: #f44336">
    </div>
    <div class="col-md-1 catagories" style="color: white; background-color: #e91e63">
        <a href="" class="link">Books</a>
    </div>
    <div class="col-md-1 catagories" style="color: white; background-color: #9c27b0">
        <a href="" class="link">Clothing</a>
    </div>
    <div class="col-md-1 catagories" style="color: white; background-color: #e91e63">
        <a href="" class="link"> Shoes</a>
    </div>
    <div class="col-md-1 catagories" style="color: white; background-color: #3f51b5">
        <a href="" class="link">Audio</a>
    </div>
    <div class="col-md-1 catagories" style="color: white; background-color: #2196f3">
        <a href="" class="link">Cellphones</a>
    </div>
    <div class="col-md-1 catagories" style="color: white; background-color: #ffeb3b">
        <a href="" class="link">Computers</a>
    </div>
    <div class="col-md-1 catagories" style="color: white; background-color: #e91e63;">
        <a href="" class="link"> TV and Video</a>
    </div>
    <div class="col-md-1 catagories" style="color: white; background-color: #00bcd4">
        <a href="" class="link"> Livestock</a>
    </div>
    <div class="col-md-1 catagories" style="color: white; background-color: #009688">
        <a href="" class="link"> Vehicles</a>
    </div>
    <div class="col-md-1 catagories" style="color: white; background-color: #f44336">
    </div>
    <div class="col-md-1 catagories" style="background-color: #e91e63">
    </div>
</div>

<div class="spaces-top">
    <div style="width: 100%">
        <input type="text" placeholder="Search By Title, Product ID, Or Keywords"
               class="form-control search-field custom-control"/>
        <button type="button" class="search-button inline"><span
                class="glyphicon glyphicon-search"></span></button>
    </div>
</div>

<div class="row">
    <div class="col-md-1" style="background-color: lightgray; padding-bottom: 50%">
        <br/>
        <div style="background-color: black; color: white; width: 145px"
             onclick="<%response.setHeader("Location", "home.jsp");%>"><span class="glyphicon glyphicon-home"></span>
            Home
        </div>
        <br/>
        <div style="background-color: black; color: white; width: 145px"><span
                class="glyphicon glyphicon-user"></span>
            Profile
        </div>
    </div>
    <div class="col-md-11">
