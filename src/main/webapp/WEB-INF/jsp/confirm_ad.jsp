<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
<body onload="createBoxesForCategory(document.getElementById('txt-category').value)">


<div class="container-fluid">

    <div align="center" class="col-md-3"></div>
    <div class="col-md-6 panel custom-panel spaces-top">
        <h1>Confirm Advert Details</h1>
        <hr/>
        <br/>
        <br/>
        <form id="confirm-advert" action="save-advert" class="form-group" enctype="multipart/form-data" method="post"
              onsubmit="validatePostAdvertForm(); ">
            Ad Title:
            <br/>
            <label >${advert.getTitle()}</label>
            <input name="ad-title" type="hidden" value="${advert.getTitle()}"/>
            <br/>
            <br/>
            Ad Description:
            <br/>
            <label>${advert.getProduct().getDescription()}</label>
            <input name="ad-description" type="hidden" value="${advert.getProduct().getDescription()}"/>
            <br/>
            <br/>
            location:
            <br/>
            <label>${advert.getLocation().getCity()}, ${advert.getLocation().getSuburb()}</label>
            <input name="ad-location" type="hidden" value="${advert.getLocation().getCity()}, ${advert.getLocation().getSuburb()}"/>
            <br/>
            <br/>
            Price:
            <label name="ad-price"> ${advert.getPrice()}</label>
            <input name="ad-price" type="hidden" value="${advert.getPrice()}"/>
            <br/>
            <br/>
            Advert Type:
            <c:if test="${advert.isBuyOrSell() == true}">
                <label>Selling</label>
            </c:if>
            <c:if test="${advert.isBuyOrSell() == false}">
                <label>Wanted</label>
            </c:if>
            <input  name="bool-is-selling" type="hidden" value="${advert.getPrice()}"/>

            <br/>
            <br/>
            Category:
            <br/>
            We have placed your ad in: <label
                id="lbl-category"><b>${advert.getProduct().getCategory().getCategoryName()}</b></label>
            <input type="hidden" id="txt-category" name="category"
                   value="${advert.getProduct().getCategory().getCategoryName()}">
            <br/>
            If this category is not suitable, select one from the dropdown list below:
            <br/>
            <div class="row" style="margin-top: 20px; margin-bottom: 20px">
                <div class="col-md-3">
                    <select class="form-control" id="sel-category"
                            onchange="createBoxesForCategory(document.getElementById('sel-category').value)">
                        <option>Select Category</option>
                        <option>Books</option>
                        <option>Clothing</option>
                        <option>Shoes</option>
                        <option>Audio</option>
                        <option>Cellphone</option>
                        <option>Computer</option>
                        <option>Livestock</option>
                        <option>Vehicles</option>
                    </select>
                </div>
            </div>
            <div id="category-inputs">

            </div>
            <input type="submit" value="Confirm Ad" class="btn btn-success">

        </form>
    </div>
    <div align="center" class="col-md-3"></div>

</div>


<jsp:include page="footer.jsp"/>