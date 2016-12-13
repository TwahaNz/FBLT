<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>

<div class="container-fluid">
    <div class="row" style="margin-top: 40px; margin-bottom: 40px">
        <div align="center" class="col-md-3">
            <img src="" class="img-responsive img-thumbnail" style="height:800px!important" width="85%" height="800px"/>
        </div>
        <div class="col-md-6">
            <h3 style="color: orange">Item Title</h3>
            <hr/>
            <br/>
            <div class="row">
                <div class="col-md-3">
                    <c:choose>
                        <c:when test="${size == 0}">
                            <img src="images/big_ad.png" class="img-responsive img-thumbnail" style="height:300px!important" width="300px"
                                 height="350px"/>
                        </c:when>
                        <c:otherwise>
                            <img src="${items.get(0)}" class="img-responsive img-thumbnail" style="height:300px!important" width="300px"
                                 height="350px" data-toggle="modal" data-target="#image"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-md-4">
                    <span class="alert alert-info glyphicon glyphicon-info-sign">Click Image To ZOOM</span>
                    <h2>R${advert.getPrice()}</h2>
                </div>
                <div class="col-md-2">

                </div>
                <div class="col-md-4"></div>
            </div>
            <h3>Item Description</h3>
            <hr/>
            <br/>
            <div class="row">
                <div class="col-md-12">
                    ${advert.getProduct().getDescription()}
                </div>
            </div>
            <h3>Item Details</h3>
            <hr/>
            <br/>
            <div class="row">
                <div class="col-md-12">
                    <div style="background-color: lightgray">
                        <p>Category: ${advert.getProduct().getCategory().getCategoryName()}</p>
                    </div>
                    <div style="background-color: lightgray">
                        <p>Description: ${advert.getProduct().getDescription()}</p>
                    </div>
                    <div style="background-color: lightgray">
                        <c:if test="${advert.isBuyOrSell() == false}">
                            <p>Seller: ${advert.getUser().getName()}</p>
                        </c:if>
                        <c:if test="${advert.isBuyOrSell() == true}">
                            <p>Buyer: ${advert.getUser().getName()}</p>
                        </c:if>
                    </div>
                    <div style="background-color: lightgray">
                        <p>Price: ${advert.getPrice()}</p>
                    </div>
                    <div style="background-color: lightgray">
                        <p>City: ${advert.getLocation().getCity()}</p>
                    </div>
                    <div style="background-color: lightgray">
                        <p>Suburb: ${advert.getLocation().getSuburb()}</p>
                    </div>
                </div>
            </div>
        </div>
        <div align="center" class="col-md-3">
            <img class="img-responsive img-thumbnail" style="height:800px!important" width="85%" height="800px"/>
        </div>
    </div>
</div>

<div id="image" class="modal fade" role="dialog">
    <div class="modal-dialog middle-buttons" style="margin-top: 15%">
        <div class="modal-content">
            <div class="modal-header">
                <c:forEach items="${items}" var="item">
                    <div align="center"><img src="${item}" class="img-responsive img-thumbnail zoom" style="height:300px!important" width="300px"
                                             height="350px" data-toggle="modal" data-target="#image"/>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>