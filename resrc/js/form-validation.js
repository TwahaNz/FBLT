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


function toggleProvinces() {
    if (document.getElementById('check-use-location').checked) {
        document.getElementById('sel-province').disabled = true;
        document.getElementById('sel-city').disabled = true;
        document.getElementById('txt-suburb').disabled = true;
    } else {
        document.getElementById('sel-province').disabled = false;
        document.getElementById('sel-city').disabled = false;
        document.getElementById('txt-suburb').disabled = false;
    }
}


function changeCategoryLabel() {
    var category = document.getElementById('txt-category');
    var categorySelector = document.getElementById('sel-category');
    category.value = categorySelector.value;
}
function createBoxesForCategory(category) {
    var categoryTextbox = document.getElementById('txt-category');
    categoryTextbox.value = category;

    function fillClothingSizes() {
        var sizes = ["",
            "Extra-Large",
            "Large",
            "Medium",
            "Small",
            "Extra-Small"];

        var clothingSizeSelector = document.getElementById('sel-clothing-size');
        clothingSizeSelector.options.length = 0;

        for (var i = 0; i < sizes.length; i++) {
            var opt = document.createElement('option');
            opt.innerHTML = sizes[i];
            opt.value = sizes[i];
            clothingSizeSelector.appendChild(opt);
        }
    }

    function fillClothingTypes() {

        var types = [""
            , "Armwear‎"
            , "Belts"
            , "Coats"
            , "Dresses‎"
            , "Footwear‎"
            , "Gowns‎"
            , "Headgear"
            , "Hosiery‎"
            , "Jackets‎"
            , "Neckwear"
            , "One-piece suits‎"
            , "Outerwear"
            , "Ponchos"
            , "Robes and cloaks‎"
            , "Royal attire"
            , "Saris‎"
            , "Shawls and wraps‎"
            , "Skirts"
            , "Sports clothing‎"
            , "Suits"
            , "Tops"
            , "Trousers and shorts‎"
            , "Undergarments"
            , "Wedding clothing‎"];

        var clothingSelector = document.getElementById('sel-clothing-type');
        clothingSelector.options.length = 0;
        types.sort();


        for (var i = 0; i < types.length; i++) {
            var opt = document.createElement('option');
            opt.innerHTML = types[i];
            opt.value = types[i];
            clothingSelector.appendChild(opt);
        }
    }

    function fillShoeSizes() {
        var shoeSizeSelector = document.getElementById('sel-shoes-size');
        shoeSizeSelector.options.length = 0;
        //create blank first option
        var opt = document.createElement('option');
        shoeSizeSelector.appendChild(opt);

        for (var i = 1; i < 13; i++) {
            var opt = document.createElement('option');
            opt.innerHTML = i;
            opt.value = i;
            shoeSizeSelector.appendChild(opt);
        }
    }

    function fillVehicleTypes(){
        var vehicleTypes = ["",
            "Car",
            "Sports Car",
            "SUV",
            "Bakkie",
            "Motorcycle",
            "Truck"];

        var vehicleTypeSelector = document.getElementById('sel-vehicles-type');
        vehicleTypeSelector.options.length = 0;

        for (var i = 0; i < vehicleTypes.length; i++) {
            var opt = document.createElement('option');
            opt.innerHTML = vehicleTypes[i];
            opt.value = vehicleTypes[i];
            vehicleTypeSelector.appendChild(opt);
        }
    }

    var categoryDiv = document.getElementById('category-inputs');


    if (category.trim() === "Livestock") {
        categoryDiv.setAttribute("class", "well");
        categoryDiv.innerHTML = "Optional Extra information about product:" +
            "<br/><br/>" +
            "Livestock Age: <br/><input id='txt-livestock-age' type='number' class='form-control'/><br/><br/>" +
            "Livestock Grade: <br/><input id='txt-livestock-grade' type='text' class='form-control'/><br/><br/>";


    }
    else if (category.trim() === "Cellphone") {
        categoryDiv.setAttribute("class", "well");
        categoryDiv.innerHTML = "Optional Extra information about product:" +
            "<br/><br/>" +
            "Make: <br/><input id='txt-cellphone-make' type='text' class='form-control'/><br/><br/>" +
            "Model: <br/><input id='txt-cellphone-model' type='text' class='form-control'/><br/><br/>";

    }
    else if (category.trim() === "Audio") {
        categoryDiv.setAttribute("class", "well");
        categoryDiv.innerHTML = "Optional Extra information about product:" +
            "<br/><br/>" +
            "Make: <br/><input id='txt-audio-make' type='text' class='form-control'/><br/><br/>" +
            "Model: <br/><input id='txt-audio-model' type='text' class='form-control'/><br/><br/>" +
            "Type (headphones/earphones/stereo hi-fi): <br/><input id='txt-audio-type' type='text' class='form-control'/><br/><br/>" +
            "Watts: <br/><input id='txt-audio-watts' type='text' class='form-control'/><br/><br/>";

    }
    else if (category.trim() === "Computer") {
        categoryDiv.setAttribute("class", "well");
        categoryDiv.innerHTML = "Optional Extra information about product:" +
            "<br/><br/>" +
            "Make: <br/><input id='txt-computer-make' type='text' class='form-control'/><br/><br/>" +
            "Model: <br/><input id='txt-computer-model' type='text' class='form-control'/><br/><br/>" +
            "Type (desktop/laptop/tablet): <br/><input id='txt-computer-type' type='text' class='form-control'/><br/><br/>" +
            "Size (Screen size if applicable): <br/><input id='txt-computer-size' type='text' class='form-control'/><br/><br/>";
    }
    else if (category.trim() === "Television") {
        categoryDiv.setAttribute("class", "well");
        categoryDiv.innerHTML = "Optional Extra information about product:" +
            "<br/><br/>" +
            "Make: <br/><input id='txt-television-make' type='text' class='form-control'/><br/><br/>" +
            "Model: <br/><input id='txt-television-model' type='text' class='form-control'/><br/><br/>" +
            "Type (desktop/laptop/tablet): <br/><input id='txt-television-type' type='text' class='form-control'/><br/><br/>" +
            "Size (Screen size if applicable): <br/><input id='txt-television-size' type='text' class='form-control'/><br/><br/>";

    }
    else if (category.trim() === "Clothes") {
        categoryDiv.setAttribute("class", "well");
        categoryDiv.innerHTML = "Optional Extra information about product:" +
            "<br/><br/>" +
            "Brand: <br/><input id='txt-clothing-brand' type='text' class='form-control'/><br/><br/>" +
            "Gender/Sex: <br/><select class='form-control' id='sel-clothing-gender'><option></option><option>Male</option><option>Female</option><option>Unisex</option></select><br/><br/>" +
            "Type: <br/><select class='form-control' id='sel-clothing-type'></select><br/><br/>" +
            "Age: <br/><select class='form-control' id='sel-clothing-age'><option></option><option>Adult</option><option>Teenager</option><option>Kids</option></select><br/><br/>" +
            "Size: <br/><select class='form-control' id='sel-clothing-size'></select><br/><br/>" +
            "Material: <br/><input id='txt-clothing-material' type='text' class='form-control'/><br/><br/>" +
            "Colour: <br/><input id='txt-clothing-colour' type='text' class='form-control'/><br/><br/>";

        fillClothingSizes();
        fillClothingTypes();
    } else if (category.trim() === "Shoes") {
        categoryDiv.setAttribute("class", "well");
        categoryDiv.innerHTML = "Optional Extra information about product:" +
            "<br/><br/>" +
            "Brand: <br/><input id='txt-shoes-brand' type='text' class='form-control'/><br/><br/>" +
            "Type: <br/><select class='form-control' id='sel-shoes-type'><option></option><option>Hi-Top</option><option>Low-Top</option><option>Boot</option><option>Sandal</option></select><br/><br/>" +
            "Size (UK): <br/><select class='form-control' id='sel-shoes-size'></select><br/><br/>" +
            "Colour: <br/><input id='txt-shoes-colour' type='text' class='form-control'/><br/><br/>";
        fillShoeSizes();
    } else if (category.trim() === "Books") {
        categoryDiv.setAttribute("class", "well");
        categoryDiv.innerHTML = "Optional Extra information about product:" +
            "<br/><br/>" +
            "Book Author: <br/><input id='txt-books-author' type='text' class='form-control'/><br/><br/>" +
            "Book Title: <br/><input type='text' class='form-control' id='txt-books-title'/><br/><br/>" +
            "ISBN: <br/><input id='txt-books-isbn' type='text' class='form-control'/><br/><br/>" +
            "Book Genre: <br/><input id='txt-books-genre' type='text' class='form-control'/><br/><br/>";
    }
    else if (category.trim() === "Vehicles") {
        categoryDiv.setAttribute("class", "well");
        categoryDiv.innerHTML = "Optional Extra information about product:" +
            "<br/><br/>" +
            "Type: <br/><select id='sel-vehicles-type' type='text' class='form-control'></select><br/><br/>" +
            "Make: <br/><input id='txt-vehicles-make' type='text' class='form-control'/><br/><br/>" +
            "Model: <br/><input id='txt-vehicles-model' type='text' class='form-control'/><br/><br/>" +
            "Year: <br/><input id='txt-vehicles-make' type='number' class='form-control'/><br/><br/>" +
            "Fuel Type: <br/><select class='form-control' id='sel-vehicles-fuel-type'><option></option><option>Diesel</option><option>Petrol</option></select><br/><br/>" +
            "Transmission: <br/><select class='form-control' id='sel-vehicle-transmission'><option></option><option>Manual</option><option>Automatic</option></select><br/><br/>";


        fillVehicleTypes();
    } else {
        categoryDiv.innerHTML = "";
        categoryDiv.setAttribute("class", "");
    }

}

function toggleFormElements() {

    var fieldset = document.getElementById("fieldset");

    if (fieldset.disabled === true)
        fieldset.disabled = false;
    else if (fieldset.disabled === false)
        fieldset.disabled = true;

}

function validateUpdateForm() {
    var newname = document.forms["update-profile"]["txt-newname"].value;
    var newcell = document.forms["update-profile"]["txt-newcell"].value;
    var newhandle = document.forms["update-profile"]["txt-newhandle"].value;
    var newsuburb = document.forms["update-profile"]["txt-suburb"].value;
    var newcity = document.forms["update-profile"]["txt-city"].value;


    var errors = "";
    var isValid = true;
    if (newname.trim().length == 0) {
            errors += "User Name Field is empty\n";
            isValid = false;
    }
    if (newhandle.length < 0) {
        errors += "User Name Field is empty\n";
        isValid = false;
    }
    if (isNaN(newcell)) {
            errors += "Only Numbers Allowed in User CellNumber TextBox\n";
            isValid = false;
        }
    if (newcell.charAt(0)!="0") {
        errors += "Cell Phone Number must Begin with 0\n";
        isValid = false;
    }
    if (newcell.length < 11&& newcell.length > 0) {
        errors += "Incorrect Length for CellNumber TextBox\n";
        isValid = false;
    }
    if (newhandle.trim().length == 0) {
        newhandle.value ="No Handle Available";
    }
    if (newhandle.trim().length > 0 && newhandle.charAt(0)!="@") {
        errors += "Invalid Telegram Handle @ sign missing\n";
        isValid = false;
    }
    if (newsuburb.trim().length == 0) {
        newhandle.value = "Suburb not supplied"
    }
    if (newcity.trim().length == 0) {
        newhandle.value = "City not supplied"
    }

    if (!isValid) {
            alert(errors);
    }
     return isValid;

}

function toggleRatingsForm(advertID){
    document.forms["ratingsForm"]["advertId"].value = advertID;
    return false;
}

function setRating(){
    if(document.getElementById("1").checked == true) {
        document.getElementById("rateNumber").value = "1";
    }
    if(document.getElementById("2").checked == true) {
        document.getElementById("rateNumber").value = "2";
    }
    if(document.getElementById("3").checked ==true) {
        document.getElementById("rateNumber").value = "3";
    }
    if(document.getElementById("4").checked == true) {
        document.getElementById("rateNumber").value = "4";
    }
}
