<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<form id="registerForm" action="register" method="post" onsubmit="">
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
                        <input type='submit' name='${item.getId()}' class="btn btn-info btn-lg register-button" value='Request Rating'/>
                    </td>
                </tr>
            </c:forEach>
            </table>
        </div>
    </div>
</form>

<jsp:include page="footer.jsp"/>