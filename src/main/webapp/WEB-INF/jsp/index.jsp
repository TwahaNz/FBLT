<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<jsp:include page="pages/header.jsp"/>

<div style="margin-top: 55px!important;"></div>

<div align="center" class="row spaces-top">
    <div class="col-md-1" style="color: white; background-color: #f44336">
    </div>
    <div class="col-md-1" style="color: white; background-color: #e91e63">
        Catagory Name
    </div>
    <div class="col-md-1" style="color: white; background-color: #9c27b0">
        Catagory Name
    </div>
    <div class="col-md-1" style="color: white; background-color: #e91e63">
        Catagory Name
    </div>
    <div class="col-md-1" style="color: white; background-color: #3f51b5">
        Catagory Name
    </div>
    <div class="col-md-1" style="color: white; background-color: #2196f3">
        Catagory Name
    </div>
    <div class="col-md-1" style="color: white; background-color: #ffeb3b">
        Catagory Name
    </div>
    <div class="col-md-1" style="color: white; background-color: #e91e63">
        Catagory Name
    </div>
    <div class="col-md-1" style="color: white; background-color: #00bcd4">
        Catagory Name
    </div>
    <div class="col-md-1" style="color: white; background-color: #009688">
        Catagory Name
    </div>
    <div class="col-md-1" style="color: white; background-color: #e91e63">
        Catagory Name
    </div>
    <div class="col-md-1" style="background-color: #e91e63">
    </div>
</div>

<div class="spaces-top">
    <div>
        <input type="text" class="form-control search-field custom-control"/>
        <button type="button"><span class="glyphicon glyphicon-search"></span></button>
    </div>
</div>



<div class="row" style="margin-top: 40px; margin-bottom: 40px">
    <div align="center" class="col-md-1">
    </div>
    <div align="center" class="col-md-2">
        <img src="<c:url value="images/big_ad.png"/>" width="100%" height="815"/>
    </div>
    <div class="col-md-5">
        <h3>Some Event</h3>
        <hr/>
        <br />
        <div class="row">
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
        </div>
        <h3>Some Event</h3>
        <hr/>
        <br />
        <div class="row">
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
        </div>
        <h3>Some Event</h3>
        <hr/>
        <br />
        <div class="row">
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
            <div class="col-md-3">
                <img src="<c:url value="images/big_ad.png"/>" width="100%" height="200px"/>
            </div>
        </div>
    </div>
    <div align="center" class="col-md-2">
        <img src="images/big_ad.png" width="100%" height="815"/>
    </div>
    <div align="center" class="col-md-1">
    </div>
</div>

<jsp:include page="pages/footer.jsp"/>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
