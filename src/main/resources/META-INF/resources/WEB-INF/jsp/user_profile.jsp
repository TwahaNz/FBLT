<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="header.jsp"/>

<% String path = request.getContextPath() + "/images/"; %>
<%String value = "disabled";%>
<% int counter = 0;%>


</body>
<body onload="toggleFormElements()">

<div>
    <c:choose>
        <c:when test="${isValidBuyerEmail.length() == 5}">
            <script type="text/javascript">
                alert("Invalid email address:\nYou cannot rate yourself. \nYou can only rate an advert once. \nOnly a registered user can rate you.");
                /*toggleRatingsForm(${advertId});*/
            </script>
        </c:when>
        <c:when test="${isValidBuyerEmail.length() == 4}">
            <script type="text/javascript">
                alert("An email with rating request has been sent");
            </script>
        </c:when>
    </c:choose>
</div>

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
                    <p><b>Telegram Handle: </b><a data-toggle="tooltip" title="Click to Go To Telegram!"
                                                  href="http://www.telegram.me/${fn:substringAfter(user.getContactDetails().getTelegramHandle(),"@")}"><img
                            src="images/telegram.png" style="height:30px!important" width="30px"></a>
                    </p>
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


                <div>
                    <input type="button text center" value="Update Your Profile" onclick="toggleFormElements()"
                           class="btn btn-success">
                </div>

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


        </div>
    </div>

    <div class="row">

        <div class="col-md-6">

            <div class="container-fluid">

                <div class="col-md-6 panel custom-panel spaces-top modal-dialog">
                    <h1>${user.getName()}'s Adverts</h1>
                    <hr/>
                    <br/>

                    <c:forEach items="${adverts}" var="advert">
                        <%
                            counter++;
                        %>
                    </c:forEach>

                    <c:forEach items="${adverts}" var="advert">

                        <div class="col-md-3">

                            <a href="/item${advert.getId()}"><b>${advert.getTitle()}</b></a></div>
                        <div class="col-md-3"></div>
                        <div class="col-md-3">
                            <button class="btn btn-info" data-toggle="modal" data-target="#img"
                                    onClick="toggleRatingsForm( '${advert.getId()}' );">Request Rating
                            </button>
                        </div>
                        <div class="col-md-3">
                            <form id="delete-advert" action="user-delete-advert" class="form-group" method="post">

                                <input type="hidden" class="form-control" name="delete" id="delete-id"
                                       value="${advert.getId()}">

                                <input type="submit" value="Delete" class="btn btn-warning">

                            </form>
                        </div>

                    </c:forEach>

                </div>
                <div align="center" class="col-md-3"></div>
            </div>

        </div>

    </div>
        <% String post_js_path= request.getContextPath() + "/js/"; %>

    <script src="<%=post_js_path%>post_ad.js"></script>

    <div id="img" class="modal fade" role="dialog">
        <div class="modal-dialog middle-buttons" style="margin-top: 15%">
            <div class="modal-content">
                <div class="modal-header">
                    <form id="ratingsForm" action="validate-buyer-email" method="post">
                        <div align="center">
                            <div align="center" class="middle-buttons panel custom-panel">

                                <input type='hidden' class="form-control custom-control" name='advertId' id="advertId"
                                       value=""/>
                                <p>Please enter the buyers email address<input type='text'
                                                                               placeholder="Buyers Email address"
                                                                               class="form-control custom-control"
                                                                               name='email'
                                                                               value=""/>
                                </p>
                                <input type='submit' name='submit' class="btn btn-info btn-lg register-button"
                                       value='Send Rating Request'/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
<jsp:include page="footer.jsp"/>