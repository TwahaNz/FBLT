<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${adverts}" var="advert">
    ${advert.getProduct().getDescription()}
</c:forEach>

<div class="container-fluid">
    <div class="row" style="margin-top: 40px; margin-bottom: 40px">
        <div align="center" class="col-md-3">
            <img class="img-responsive img-thumbnail" style="height:800px!important"  width="85%" height="800px"/>
        </div>
        <div class="col-md-6">
            <h3>Some Event</h3>
            <hr/>
            <br/>
            <div class="row">
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
            </div>
            <h3>Some Other Event</h3>
            <hr/>
            <br/>
            <div class="row">
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
            </div>
            <h3>Some Other Other Event</h3>
            <hr/>
            <br/>
            <div class="row">
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
                <div class="col-md-3">
                    <img class="img-responsive img-thumbnail" style="height:200px!important"  width="100%" height="200px"/>
                </div>
            </div>
        </div>
        <div align="center" class="col-md-3">
            <img class="img-responsive img-thumbnail" style="height:800px!important" width="85%" height="800px"/>
        </div>
    </div>
</div>