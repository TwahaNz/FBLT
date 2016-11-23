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
    var errors = "";
    var isValid = true;

    if (title.length < 10) {
        errors += "title is too short\n";
        isValid = false;
    }
    if (description.length > 10) {
        errors += "description too long\n";
        isValid = false;
    }

    if (!isValid) {
        alert(errors);
    }

    return isValid;

}