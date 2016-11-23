<jsp:include page="header.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="container-fluid">
    <div class="dropdown">
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li><a href="#">HTML</a></li>
            <li><a href="#">CSS</a></li>
            <li><a href="#">JavaScript</a></li>
        </ul>
    </div>


    <div align="center" class="col-md-3"></div>
    <div class="col-md-6">
        <form class="form-group">
            <br/>
            Ad Title:
            <input type="text" class="form-control">
            <br/>
            Ad Description:
            <textarea class="form-control" rows="5" id="advertDescription"></textarea>
            <br/>
            Select images: <input type="file" name="img" multiple>
            <br/>
        </form>
    </div>
    <div align="center" class="col-md-3"></div>

</div>
<jsp:include page="footer.jsp"/>