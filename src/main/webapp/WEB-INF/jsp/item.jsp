<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="header.jsp"/>

<div class="container-fluid">
    <div class="row" style="margin-top: 40px; margin-bottom: 40px">
        <div align="center" class="col-md-3">
            <img src="images/ad1.png" class="img-responsive img-thumbnail" style="height:800px!important" width="85%" height="800px"/>
        </div>
        <div class="col-md-6">
            <h3 style="color: orange">${advert.getTitle()}</h3>
            <hr/>
            <br/>
            <div class="row">
                <div class="col-md-4">
                    <c:choose>
                        <c:when test="${size == 0}">
                            <img src="images/big_ad.png" class="img-responsive img-thumbnail"
                                 style="height:300px!important" width="300px"
                                 height="350px"/>
                        </c:when>
                        <c:otherwise>
                            <img src="${items.get(0)}" class="img-responsive img-thumbnail"
                                 style="height:300px!important" width="300px"
                                 height="350px" data-toggle="modal" data-target="#image"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-md-8">
                    <%--<h2>R${advert.getPrice()}</h2>--%>

                    <c:if test="${type == 'book'}">
                        <div style="background-color: lightgray">
                            <p> Book Author: ${book.getAuthor()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Book Title: ${book.getTitle()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> ISBN: ${book.getISBN()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Book Genre: ${book.getGenre()} </p>
                        </div>
                    </c:if>

                    <c:if test="${type == 'clothing'}">
                        <div style="background-color: lightgray">
                            <p> Brand: ${clothing.getBrand()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Gender/Sex: ${clothing.getGender()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Type: ${clothing.getClothingType()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Age: ${clothing.getAge()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Size: ${clothing.getSize()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Material: ${clothing.getMaterial()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Colour: ${clothing.getColor()} </p>
                        </div>
                    </c:if>
                    <c:if test="${type == 'livestock'}">
                        <div style="background-color: lightgray">
                            <p> Livestock Age: ${livestock.getAge()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Livestock Grade: ${liveStock.getGrade()} </p>
                        </div>
                    </c:if>
                    <c:if test="${type == 'vehicle'}">
                        <div style="background-color: lightgray">
                            <p> Type: ${vehicle.getVehicletype()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Make: ${vehicle.getMake()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Model: ${vehicle.getModel()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Year: ${vehicle.getYear()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Fuel Type: ${vehicle.getFuelType()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Transmission: ${vehicle.getTransmissionType()} </p>
                        </div>
                    </c:if>
                    <c:if test="${type == 'shoes'}">
                        <div style="background-color: lightgray">
                            <p> Brand: ${shoes.getBrand()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Type: ${shoes.getShoeType()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Size (UK): ${shoes.getSize()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Colour: ${shoes.getColor()} </p>
                        </div>
                    </c:if>
                    <c:if test="${type == 'television'}">
                        <div style="background-color: lightgray">
                            <p> Make: ${television.getMake()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Type (desktop/laptop/tablet): ${television.getType()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Size (Screen size if applicable): ${television.getSize()} </p>
                        </div>
                    </c:if>
                    <c:if test="${type == 'computer'}">
                        <div style="background-color: lightgray">
                            <p> Make: ${computer.getMake()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Type (desktop/laptop/tablet): ${computer.getType()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Size (Screen size if applicable): ${computer.getSize()} </p>
                        </div>
                    </c:if>
                    <c:if test="${type == 'audio'}">
                        <div style="background-color: lightgray">
                            <p> Make: ${audio.getMake()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Type (headphones/earphones/stereo hi-fi): ${audio.getType()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Model: ${audio.getModel()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Watts: (Screen size if applicable): ${audio.getWatts()} </p>
                        </div>
                    </c:if>
                    <c:if test="${type == 'cellphone'}">
                        <div style="background-color: lightgray">
                            <p> Make: ${cellphone.getMake()} </p>
                        </div>
                        <div style="background-color: lightgray">
                            <p> Model: ${cellphone.getModel()} </p>
                        </div>
                    </c:if>
                </div>

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
                    <div style="background-color: lightgray">
                        <p>Date Posted: ${advert.getDate()}</p>
                    </div>
                </div>

            </div>


            <h3>Contact Details</h3>
            <hr/>
            <br/>
            <div class="row">
                <div class="col-md-12">
                    <div style="background-color: lightgray">
                        <p>Email: ${advert.getUser().getContactDetails().getEmailAddress()}</p>
                    </div>
                    <div style="background-color: lightgray">
                        <p>Telegram Handle: <a
                                href="http://www.telegram.me/${fn:substringAfter(advert.getUser().getContactDetails().getTelegramHandle(),"@")}"><img
                                src="images/telegram.png" style="height:25px!important" width="25px"></a></p>

                    </div>
                </div>
            </div>
        </div>
        <div align="center" class="col-md-3">
            <img src="images/ad2.png" class="img-responsive img-thumbnail" style="height:800px!important" width="85%" height="800px"/>
        </div>
    </div>
</div>

<div id="image" class="modal fade" role="dialog">
    <div class="modal-dialog middle-buttons" style="margin-top: 15%">
        <div class="modal-content">
            <div class="modal-header">
                <c:forEach items="${items}" var="item">
                    <div align="center"><img src="${item}" class="img-responsive img-thumbnail zoom"
                                             style="height:300px!important" width="300px"
                                             height="350px" data-toggle="modal" data-target="#image"/>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>