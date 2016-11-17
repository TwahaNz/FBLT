<jsp:include page="header.jsp"/>

<br />

<div style="background-color: lightgray; padding: 40px">
    <div align="center">
        <h1>Registration</h1>
        <h3>Made Easier Than Ever!</h3>
    </div>
</div>

<br />
<br />
<br />
<form action="register" method="post">
<div align="center" >
    <div align="center" class="middle-buttons panel custom-panel">
        <div id="registration" align="center" class="register-form">
            <p><input type='text' placeholder="Choose A Username" class="form-control custom-control" name='username' value=""/></p>
            <p><input type='text' placeholder="Valid Email" class="form-control custom-control" name='email' value=""/>
            </p>
            <input type='submit' name='submit' class="btn btn-info btn-lg register-button" value='Register'/>
        </div>
    </div>
</div>
</form>
<div style="margin-top: 360px"></div>

<jsp:include page="footer.jsp"/>
