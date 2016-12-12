<jsp:include page="header.jsp"/>

<br/>

<div style="background-color: lightgray; padding: 40px">
    <div align="center">
        <h1>Rate your experience buying from a user</h1>
    </div>
</div>

<br/>
<br/>
<br/>
<form id="rateUser" action="rate-user" method="post" onsubmit="setRating();">
    <div align="center">
        <div align="center" class="middle-buttons panel custom-panel">

                <input type='hidden'  value="${advert.getId()}" name='advertId' />
                <input type='hidden'  value="${userSellerId}" name='userSellerId' />
                <input type='hidden'  value="${userBuyerId}" name='userBuyerId' />
                <input type='hidden'  value="" name='rateNumber' id="rateNumber"/>

                <p> Description <input type='text' disabled value="${advert.getProduct().getDescription()}"/> </p>
                <p> Price: R <input type='text' disabled value="${advert.getPrice()}"/> </p>

                <div align="left">
                    <p>Rate your experience, 4 being perfect:</p>
                    <input id='1' name='rate' type='radio' checked onclick="setRating();"/><b> * </b> <br />
                    <input id='2' name='rate' type='radio' onclick="setRating();"/><b> * * </b><br />
                    <input id='3' name='rate' type='radio' onclick="setRating();"/><b> * * * </b><br />
                    <input id='4' name='rate' type='radio' onclick="setRating();"/><b> * * * * </b><br />
                    <br />
                </div>
                <p>Leave a quick review:</p>
                <textarea cols='30' name='commentText' rows='5'></textarea><br />
                <br />

                <input type='submit' name='submit' class="btn btn-info btn-lg register-button" value='Rate User' />
        </div>
    </div>
</form>
<div style="margin-top: 360px"></div>

<jsp:include page="footer.jsp"/>
