<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<% String path = request.getContextPath() + "/images/"; %>
<%String value = "disabled";%>
<% int counter = 0;%>
</body>
<body onload="toggleFormElements()">

<div class="row">

    <div class="col-md-6">

        <div class="container-fluid">

            <div class="col-md-6 panel custom-panel spaces-top modal-dialog">
                <h1>${user.getName()}'s Profile</h1>
                <hr/>
                <div>
                    <h3>Contact Information</h3>
                    <p><b>Cell Number: </b>${user.getContactDetails().getCellPhoneNumber()}</p>
                    <p><b>Email: </b>${user.getContactDetails().getEmailAddress()}</p>
                    <p><b>Telegram Handle: </b>${user.getContactDetails().getTelegramHandle()}</p>
                </div>
                <div>
                    <h3>Location</h3>
                    <p><b>City: </b>${user.getLocation().getCity()}</p>
                    <p><b>Suburb: </b>${user.getLocation().getSuburb()}</p>
                </div>
                <div>
                    <h3>Ranking</h3>
                    <p>${user. getRating()}</p>
                </div>


                <input type="button text center" value="Update Your Profile" onclick="toggleFormElements()"
                       class="btn btn-success">
                <br/>
                <br/>


            </div>
            <div align="center" class="col-md-3"></div>
        </div>
    </div>

    <div class="col-md-6">

        <div class="container-fluid">
            <div align="center" class="col-md-3"></div>
            <div class="col-md-6 panel custom-panel spaces-top modal-dialog">
                <h1>Update Your Profile</h1>
                <hr/>
                <br/>

                <fieldset id="fieldset">
                    <form id="update-profile" action="user-profile-update" class="form-group" method="post"
                          onsubmit="return validateUpdateForm();">

                        User Name:
                        <input id="txt-newname" type="text" class="form-control" name="newname"
                               value="${user.getName()}">
                        <label id="error-newname"></label>
                        <br/>
                        User CellNumber:
                        <input id="txt-newcell" type="text" class="form-control" name="newcell"
                               value="${user.getContactDetails().getCellPhoneNumber()}">
                        <label id="error-newcell"></label>
                        <br/>
                        Telegram Handle:
                        <input id="txt-newhandle" type="text" class="form-control" name="newhandle"
                               value="${user.getContactDetails().getTelegramHandle()}">
                        <label id="error-newhandle"></label>
                        <br/>

                        <div class="col-md-3">
                            City:
                            <input type="text" class="form-control" name="newcity" id="txt-city"
                                   value="${user.getLocation().getCity()}">
                            <label id="error-newcity"></label>

                        </div>
                        <div class="col-md-3">
                            Suburb:
                            <input type="text" class="form-control" id="txt-suburb"
                                   value="${user.getLocation().getSuburb()}" name="newsuburb"/>
                            <label id="error-newsuburb"></label>
                        </div>


                        <span id="error-location"></span>

                        <br/>

                        <input type="submit" value="Submit" class="btn btn-success">

                    </form>
                </fieldset>
            </div>
            <div align="center" class="col-md-3"></div>

            <%-- ferins mess --%>
            <form id="profile" action="rate-me" method="post" class="navbar-form"
                  style="margin-right:15px;">
                <div class="form-group">
                    <button type="submit" class="btn btn-info btn-lg" name="Rate me">Request Rating</button>
                </div>
            </form>
            <%-- ferins end --%>

        </div>
    </div>
    <div class="row">

        <div class="col-md-6">

            <div class="container-fluid">

                <div class="col-md-6 panel custom-panel spaces-top modal-dialog">
                    <h1>${user.getName()}'s Adverts</h1>
                    <hr/>

                    <c:forEach items="${adverts}" var="advert">
                        <%
                            counter++;
                        %>
                    </c:forEach>

                    <c:forEach items="${adverts}" var="advert">
                        <p>Advert:
                            <a href="item${advert.getId()}"><b>${advert.getTitle()}</b></a>
                        </p>
                    </c:forEach>

                </div>
                <div align="center" class="col-md-3"></div>
            </div>

        </div>

    </div>
        <% String post_js_path= request.getContextPath() + "/js/"; %>

    <script src="<%=post_js_path%>post_ad.js"></script>


<jsp:include page="footer.jsp"/>