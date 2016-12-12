<html>
<head><title>Bubby King</title></head>
<body>

<script>
    var myVar = setInterval(function(){ myTimer() }, 1000);
    var timer = 2;

    function myTimer() {
        timer--;
        if (timer < 1) {
            document.getElementById('redirect').click();
        }
    }
</script>

<p>Please Wait...<p>
<a id="redirect" href="index"></a>

</body>
</html>