
<jsp:include page="header.jsp"/>

<% String path= request.getContextPath() + "/images/"; %>

<div class="container">
    <div class="row">
        <div class="col-sm-4 center-block">
            <h3>${user.getName()}'s Profile</h3>
            <img src="<%=path%>big_ad.png" class="img-circle" alt="Cinque Terre" width="304" height="236">
        </div>
        <div class="col-sm-4">
            <h3>User Information</h3>
            <p><b>Cell Number: </b>${user.getContactDetails().getCellPhoneNumber()}</p>
            <p><b>Email: </b>${user.getContactDetails().getEmailAddress()}</p>
            <p><b>Telegram Handle: </b>${user.getContactDetails().getTelegramHandle()}</p>

        </div>
        <div class="col-sm-4">
            <h3>Posted Adverts </h3>
            <p>Advert 1</p>
            <p>Advert 2</p>

        </div>

    </div>
</div>


<jsp:include page="footer.jsp"/>