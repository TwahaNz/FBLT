<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<c:forEach items="${adverts}" var="advert">
    ${advert.getProduct().getDescription()}
</c:forEach>--%>

<%--<% String path = request.getContextPath() + "/images/"; %>--%>
<% String path = "images/"; %>

<div class="container-fluid">
    <div class="row" style="margin-top: 40px; margin-bottom: 40px">
        <div align="center" class="col-md-3">
            <img src="s.png" class="img-responsive img-thumbnail" style="height:800px!important" width="85%"
                 height="800px"/>
        </div>
        <div class="col-md-6">
            <h3>Top Sellers</h3>
            <hr/>
            <br/>
            <div class="row">
                <c:forEach items="${advert_paths}" var="paths">

                    <c:set var="val" value="${paths}"/>
<%--
                    <h1>${val.split("\\\\")[2]}</h1>--%>

                    <div class="col-md-3">
                        <a href="item${val.split("\\\\")[2]}"><img src="${val}" class="img-responsive img-thumbnail"
                             style="height:200px!important" width="100%" height="200px"/></a>
                    </div>
                    <div class="col-md-3">
                        <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail"
                             style="height:200px!important" width="100%" height="200px"/>
                    </div>
                    <div class="col-md-3">
                        <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail"
                             style="height:200px!important" width="100%" height="200px"/>
                    </div>
                    <div class="col-md-3">
                        <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail"
                             style="height:200px!important" width="100%" height="200px"/>
                    </div>
                </c:forEach>
            </div>
            <h3>Top Selling Categories</h3>
            <hr/>
            <br/>
            <div class="row">
                <div class="col-md-3">
                    <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail" style="height:200px!important"
                         width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail" style="height:200px!important"
                         width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail" style="height:200px!important"
                         width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail" style="height:200px!important"
                         width="100%" height="200px"/>
                </div>
            </div>
            <h3>Frequently Searched</h3>
            <hr/>
            <br/>
            <div class="row">
                <div class="col-md-3">
                    <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail" style="height:200px!important"
                         width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail" style="height:200px!important"
                         width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail" style="height:200px!important"
                         width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail" style="height:200px!important"
                         width="100%" height="200px"/>
                </div>
            </div>
        </div>
        <div align="center" class="col-md-3">
            <img src="t.png" class="img-responsive img-thumbnail" style="height:800px!important" width="85%"
                 height="800px"/>
        </div>
    </div>
</div>