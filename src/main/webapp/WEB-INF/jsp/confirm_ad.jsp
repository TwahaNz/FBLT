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
        <form id="confirm-advert" action="/" class="form-group" enctype="multipart/form-data" method="post"
              onsubmit="validatePostAdvertForm(<c:out value="${username}"/>); ">
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
            We have placed your ad in: <label id="lbl-category"><b>${category}</b></label>
            <input type="hidden" id="txt-category" value="${category}">
            <br/>
            If this category is not suitable, please select one from the dropdown list below:
            <br/>
            <div class="row" style="margin-top: 20px; margin-bottom: 20px">
                <div class="col-md-3">
                    <select class="form-control" id="sel-category" onchange="createBoxesForCategory(document.getElementById('sel-category').value)">
                        <option>Select Category</option>
                        <option>Books</option>
                        <option>Clothes</option>
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