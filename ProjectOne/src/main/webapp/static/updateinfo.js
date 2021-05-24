setInfo();

function setInfo(){
	let token = localStorage.getItem("token")
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOne/sgetinfo";
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
            let userInfo = xhr.getResponseHeader("userInfo");
			let jsonInfo = JSON.parse(userInfo);
			
			document.getElementById('firstName').placeholder=jsonInfo.first_name;
			document.getElementById('lastName').placeholder=jsonInfo.last_name;
			document.getElementById('email').placeholder=jsonInfo.email;

		} 
		else if (xhr.readyState == 4){
			alert("Failed to load your personal information!, please check your login status.");
		}
	}
	
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}

document.getElementById("update").addEventListener("click", updateInfo);


function updateInfo(){
    let firstName = document.getElementById("firstName").value;
	let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;

	let token = localStorage.getItem("token")
	
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOne/supdateInfo";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
            alert("You have successfully updated your personal information!");

		} 
		else if (xhr.readyState == 4){
			alert("Failed to updated your personal information!, please check your login status.");
		}
	}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	let requestBody = `firstName=${firstName}&lastName=${lastName}&email=${email}`;
	xhr.send(requestBody);
}

