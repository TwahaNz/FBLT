<html>
<head><title>Bubby King</title></head>
<body>

<script>
    var myVar = setInterval(function () {
        myTimer()
    }, 100);

    //var timer = 1;

    function myTimer() {
        /*        timer--;
         if (timer < 1) {*/
        document.getElementById('redirect').click();
        /*        }*/
    }
</script>

<p>Redirecting...Or Click <a href="/index">Here</a> If You Are Not Redirected<p>
    <a id="redirect" href="/index"></a>

</body>
</html>
