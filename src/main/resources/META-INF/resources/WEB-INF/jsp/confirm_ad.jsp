<jsp:include page="header.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<div class="container-fluid">

    <div align="center" class="col-md-3"></div>
    <div class="col-md-6 panel custom-panel spaces-top">
        <h1>Confirm Advert Details</h1>
        <hr/>
        <br/>
        <br/>
        <form id="confirm-advert" class="form-group" enctype="multipart/form-data" method="post"
              onsubmit="validatePostAdvertForm();">
            Ad Title:
            <br/>
            ${title}
            <br/>
            <br/>
            Ad Description:
            <br/>
            ${description}
            <br/>
            <br/>
            Location:
            <br/>
            ${location}
            <br/>
            <br/>
            Price:
            ${price}
            <br/>
            <br/>

            Category:
            <br/>
            We have placed your ad in: <b>${category}</b>
            <br/>
            If this category is not suitable, please select one from the dropdown list below:
            <br/>
            <div class="row" style="margin-top: 40px; margin-bottom: 40px">
                <div class="col-md-3">
                    <select class="form-control" id="sel-province" onchange="fillCity()">
                        <option>Select Category</option>
                        <option>Books</option>
                        <option>Clothing</option>
                        <option>Shoes</option>
                        <option>Audio</option>
                        <option>Cellphones</option>
                        <option>Computers</option>
                        <option>Electronics</option>
                        <option>Livestock</option>
                        <option>Vehicles</option>
                    </select>
                </div>
            </div>

            <input type="submit" value="Confirm Ad" class="btn btn-success">

        </form>
    </div>
    <div align="center" class="col-md-3"></div>

</div>


<jsp:include page="footer.jsp"/>