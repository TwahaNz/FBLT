<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String path = "images/"; %>
http://localhost/posted_ads/brandonmaykie@gmail.com/58502c5b55efdb1004b9012e/0.jpg
http://localhost/list-adverts/posted_ads/brandonmaykie@gmail.com/58502c5b55efdb1004b9012e/0.jpg
<div class="container-fluid">
    <div class="row" style="margin-top: 40px; margin-bottom: 40px">
        <div class="col-md-9">
            <c:choose>
                <c:when test="${hasResults}">
                    <c:forEach items="${adverts}" var="advert">
                        <div class="row">
                            <div class="well" style="min-height: 190px">
                                <div class="col-md-3">
                                    <a href="item${advert.getId()}"> <img src="/${advert.getImagepaths().get(0)}"
                                                                          class="img-responsive img-thumbnail"
                                                                          style="height: 160px;" data-toggle="modal"
                                                                          data-target="#image"/></a>
                                </div>
                                <div class="col-md-6">
                                    <a href="/item${advert.getId()}"><u>${advert.getTitle()}</u></a>

                                    <p>${advert.getProduct().getDescription()}</p>
                                </div>
                                <div class="col-md-3">
                                    R${advert.getPrice()}
                                </div>

                            </div>
                        </div>


                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-danger text-align-center">
                        No adverts matched your search.
                        <br/>
                        Try another search.
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
        <div align="center" class="col-md-3">
            <img src="<%=path%>ad2.png" class="img-responsive img-thumbnail" style="height:800px!important" width="85%"
                 height="800px"/>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
