<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String path = "images/"; %>

<div class="container-fluid">
    <div class="row" style="margin-top: 40px; margin-bottom: 40px">
        <div class="col-md-9">
            <% for (int i = 0; i < 4; i++) {%>
            <div class="row spaces-bottom">
                <div class="col-md-3">
                    <a href="<%=path%>big_ad.png"><img src="<%=path%>big_ad.png" class="img-responsive img-thumbnail"
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
            </div>
            <%}%>
        </div>
        <div align="center" class="col-md-3">
            <img src="<%=path%>ad2.png" class="img-responsive img-thumbnail" style="height:800px!important" width="85%"
                 height="800px"/>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
