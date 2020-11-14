/**
 * 
 */


function validateLogin() {
	
	var username = document.forms["login"]["username"].value.trim();
	var password = document.forms["login"]["password"].value.trim();
	var error = document.querySelector(".modal-login .error");
	const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	if (username == "" || password=="") {
		error.innerHTML = "Username or password cannot be blank";
    	return false;
    }
    
    if (!re.test(String(username).toLowerCase())) {
		error.innerHTML = "Email is invalid";
    	return false;
    } 
    
    if (password.length < 7 || password.length > 16) {
		error.innerHTML = "Password must be 8 - 16 characters";
		return false;
    }


	return true;
};

const close = document.getElementsByClassName("button-close");

for (let i=0; i < close.length; i++) {
	close[i].addEventListener("click", closeLoginForm);
}

function closeLoginForm() {
  var element = document.getElementById("myDIV");
  element.classList.toggle("mystyle");
};