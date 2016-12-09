<jsp:include page="header.jsp"/>

<% String path = request.getContextPath() + "/images/"; %>
<%String value = "disabled";%>
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

                <h3></h3>

                <input type="button" value="Edit" onclick="toggleFormElements()" class="btn btn-success">


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
                    <form id="post-advert" action="user-profile-update" class="form-group" method="post">

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
                            <input type="text" class="form-control" name="newcity" id="sel-city"
                                   value="${user.getLocation().getCity()}">

                        </div>
                        <div class="col-md-3">
                            Suburb:
                            <input type="text" class="form-control" id="txt-suburb"
                                   value="${user.getLocation().getSuburb()}" name="newsuburb"/>
                        </div>


                        <span id="error-location"></span>
                        <input id="txt-location" type="hidden" name="location"/>
                        <br/>

                        <input type="submit" value="Update" class="btn btn-success">

                    </form>
                </fieldset>
            </div>
            <div align="center" class="col-md-3"></div>
        </div>
    </div>
        <% String post_js_path= request.getContextPath() + "/js/"; %>

    <script src="<%=post_js_path%>post_ad.js"></script>


<jsp:include page="footer.jsp"/>