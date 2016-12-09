<jsp:include page="header.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
    $.get("http://ipinfo.io", function (response) {
        $("#lbl-current-location").html(response.city + ", " + response.region);

    }, "jsonp");
</script>

<div class="container-fluid">

    <div align="center" class="col-md-3"></div>
    <div class="col-md-6 panel custom-panel spaces-top modal-dialog">
        <h1>Post an Advert</h1>
        <hr/>
        <br/>
        <br/>
        <form id="post-advert" action="confirm-advert" class="form-group" enctype="multipart/form-data" method="post"
              onsubmit="return validatePostAdvertForm();">
            <label class="radio-inline"><input id="radio-sell" type="radio" name="optradio" checked="true">I want to
                sell</label>
            <label class="radio-inline"><input id="radio-buy" type="radio" name="optradio">I am looking for</label>
            <input type="hidden" id="is-selling" name="bool-is-selling">
            <br/>
            <br/>
            Ad Title:
            <input id="txt-title" type="text" class="form-control" name="title">
            <label id="error-title"></label>
            <br/>
            Ad Description:
            <textarea id="txt-description" name="description" class="form-control" rows="5"
                      id="advertDescription"></textarea>
            <span id="error-description"></span>
            <br/>
            Location:
            <br/>
            <label class="checkbox-inline"><input id="check-use-location" type="checkbox" onclick="toggleProvinces()">Use
                current Location:</label>
            <label id="lbl-current-location">{Location is suggested here}</label>
            <br/>
            <br/>

            <div class="row" style="margin-top: 20px; margin-bottom: 40px; text-align: left">
                <div>
                    Or Choose Location:
                </div>
                <div class="col-md-3">
                    <br/>
                    Province:
                    <select class="form-control" id="sel-province" onchange="fillCity()">
                        <option>Select Province</option>
                        <option>The Western Cape</option>
                        <option>The Eastern Cape</option>
                        <option>The Free State</option>
                        <option>Gauteng</option>
                        <option>KwaZulu-Natal</option>
                        <option>Limpopo</option>
                        <option>Mpumalanga</option>
                        <option>The Northern Cape</option>
                        <option>North West</option>
                    </select>
                </div>
                <div class="col-md-3">
                    <br/>
                    City:
                    <select class="form-control" id="sel-city">

                    </select>
                </div>
                <div class="col-md-3">
                    <br/>
                    Suburb:
                    <input type="text" class="form-control" id="txt-suburb"/>
                </div>

            </div>
            <span id="error-location"></span>
            <input id="txt-location" type="hidden" name="location"/>
            Price:
            <input id="txt-price" type="number" class="form-control" name="price">
            <span id="error-price"></span>
            <br/>
            Select images: <input id="upload-images" type="file" accept="image/*" name="img" multiple>
            <br/>
            <br/>

            <input type="submit" value="Confirm Ad" class="btn btn-success">

        </form>
    </div>
    <div align="center" class="col-md-3"></div>

</div>

<% String post_js_path = request.getContextPath() + "/js/"; %>

<script src="<%=post_js_path%>post_ad.js"></script>


<jsp:include page="footer.jsp"/>

