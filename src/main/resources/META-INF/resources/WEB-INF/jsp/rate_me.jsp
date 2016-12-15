<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<form id="chooseRatingForm" action="" method="post" onSubmit="return false;">

    <div align="center">
        <div class="table-responsive">
            <table class="table table-bordered table-header-color">
                <tr>
                    <th class="custom-row-header row-font-size">
                        Description
                    </th>
                    <th class="custom-row-header row-font-size">
                        Category
                    </th>
                    <th class="custom-row-header row-font-size">
                        Price
                    </th>
                    <th class="custom-row-header row-font-size">
                        Request Rating
                    </th>
                </tr>
                <c:forEach items="${adverts}" var="item">
                    <tr>
                        <td>
                                ${item.getProduct().getDescription()}
                        </td>
                        <td>
                                ${item.getProduct().getCategory().getCategoryName()}
                        </td>
                        <td>
                                ${item.getPrice()}
                        </td>
                        <td>
                            <input type='submit' name='${item.getId()}' class="btn btn-info btn-lg register-button"
                                   value='Request Rating' onClick="toggleRatingsForm( '${item.getId()}' );"/>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>
</form>


<form id="ratingsForm" action="/validate-buyer-email" method="post">
    <div align="center">
        <div align="center" class="middle-buttons panel custom-panel">

            <input type='hidden' class="form-control custom-control" name='advertId' id="advertId"
                   value=""/>
            <p>Please enter the buyers email address<input type='text' placeholder="Buyers Email address"
                                                           class="form-control custom-control" name='email'
                                                           value=""/>
            </p>
            <input type='submit' name='submit' class="btn btn-info btn-lg register-button" value='Send Rating Request'/>

        </div>
    </div>
</form>


<c:choose>
    <c:when test="${isValidBuyerEmail.length() == 5}">
        <script type="text/javascript">
            alert("Invalid email address, only another registered user can rate you!");
        </script>
    </c:when>
    <c:when test="${isValidBuyerEmail.length() == 4}">
        <script type="text/javascript">
            alert("An email with rating request has been sent");
        </script>
    </c:when>
</c:choose>

<jsp:include page="footer.jsp"/>