</div>
</div>

<% String path= request.getContextPath() + "/js/"; %>

<div class="alert alert-info footer">
    <p>This website is protected by law and is copyrighted to the owners and all those that are involved</p>
</div>

<input type="hidden" id="no_cart" data-toggle="modal" data-target="#myModal3"/>
<div id="myModal3" class="modal fade" role="dialog">
    <div class="modal-dialog middle-buttons">
        <div class="modal-content">
            <div class="modal-header">
                <div align="center"><h4 class="modal-title page-header"><b>Empty Cart</b></h4>
                    <input type='button' class='btn btn-default' value='OK' data-dismiss='modal'/>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>

<script src="<%=path%>form-validation.js"></script>
<script src="<%=path%>Formvalidation.js"></script>
<script src="<%=path%>jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="<%=path%>vendor/jquery.min.js"><script>')</script>
<script src="<%=path%>tether.min.js"></script>
<script src="<%=path%>bootstrap.min.js"></script>
<script src="<%=path%>snow.js" type="text/javascript"></script>
<script src="<%=path%>index.js" type="text/javascript"></script>
<link href="<%=path%>index.css" rel="stylesheet" type="text/css">
<script>
    $(document).snow({ SnowImage: "<%=path%>snow.gif" });
</script>

</body>
</html>