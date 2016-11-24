function isValidRegistratioForm() {
    var email = document.forms["registerForm"]["email"].value;
    var username = document.forms["registerForm"]["username"].value;

    var errors = "";
    var isValid = true;

    var emailReg = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);


    if (email == "" || !emailReg.test(email)) {
        errors += "Invalid email address\n"
        isValid = false;
    }

    if (username == "") {
        errors += "Invalid email username\n"
        isValid = false;
    }

    if (!isValid)
        alert(errors);

    return isValid;
}

function validatePostAdvertForm() {
    var description = document.forms["post-advert"]["txt-description"].value;
    var title = document.forms["post-advert"]["txt-title"].value;
    var price = document.forms["post-advert"]["txt-price"].value;
    var provinceSelector = document.forms["post-advert"]["sel-province"].value;
    var citySelector = document.forms["post-advert"]["sel-city"].value;
    var suburb = document.forms["post-advert"]["txt-suburb"].value;

    var errors = "";
    var isValid = true;

    if (document.forms["post-advert"]["check-use-location"].checked) {

        if (suburb == "") {
            document.forms["post-advert"]["txt-location"].value =
                document.getElementById("lbl-current-location").innerHTML;
        } else {
            document.forms["post-advert"]["txt-location"].value = suburb + "," +
                document.getElementById("lbl-current-location").innerHTML
        }
    } else {

        if (citySelector == "") {
            errors += "You must specify a location, or use your current location\n";
            isValid = false;
        } else {
            if (suburb == "") {
                document.forms["post-advert"]["txt-location"].value = citySelector + "," + provinceSelector;
            } else {
                document.forms["post-advert"]["txt-location"].value = suburb + "," + citySelector + "," + provinceSelector;
            }
        }

    }

    if (document.forms["post-advert"]["radio-sell"].checked) {
        document.forms["post-advert"]["bool-is-selling"].value = "true";
    }
    else {
        document.forms["post-advert"]["bool-is-selling"].value = "false";
    }

    if (title.length < 10) {
        errors += "Title is Too Short (Minimum 10 Characters)\n";
        isValid = false;
    }

    if (description.length > 200 || description.length < 20) {
        errors += "Description Must Be Between 20 and 200 Characters Long\n";
        isValid = false;
    }

    if (isNaN(price)) {
        errors += "Only Numbers Allowed in Price TextBox\n";
        isValid = false;
    }

    if (!isValid) {
        alert(errors);
    }

    return isValid;

}
