/**
 * 
 */

function validateRegister() {
	var form = document.forms["register"];
	var username = form["username"].value.trim();
	var password = form["password"].value.trim();
	var match_password = form["match_password"].value.trim();
	var address = form["address"].value.trim();
	var phoneNumber = form["phoneNumber"].value.trim();
	var error = document.querySelector(".modal-register .error");
	
	const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	if (username == "") {
    	error.innerHTML="Email cannot be blank";
    	return false;
    }
    
    if (!re.test(String(username).toLowerCase())) {
    	error.innerHTML="Email is invalid";
    	return false;
    }
    if (address == "") {
		error.innerHTML="Please fill in your address";
		return false;
	}
	if (phoneNumber == "") {
		error.innerHTML="Please fill in your phone number";
		return false;
	}
    if (password.length < 7 || password.length > 16) {
    	error.innerHTML="Password must between 8 - 16 characters";
    	return false;
    }

	if (password != match_password) {
		error.innerHTML="Password doesn't match, please check again";
		return false;
	}
	return true;
}
