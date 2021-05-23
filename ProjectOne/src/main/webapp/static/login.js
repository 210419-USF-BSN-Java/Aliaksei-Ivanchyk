console.log("hgh")
let token = localStorage.getItem("token");
console.log(token)
isLogedIn();

function isLogedIn(){
	if(token != null){
		let tokenArray = token.split(":");
		if(tokenArray[2] == 1){
		
			window.location.href="http://localhost:8080/ProjectOne/employee"
		
		} else if(tokenArray[2] == 2) {
			window.location.href="http://localhost:8080/ProjectOne/manager"
		}
	}
}

document.getElementById("loginB").addEventListener("click", Login);


function Login(e){
	e.preventDefault();
	let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOne/slogin";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status < 300){
			let auth = xhr.getResponseHeader("Authorization");
			localStorage.setItem("token", auth);
			token = localStorage.getItem("token");
			isLogedIn();
		} 
		else if (xhr.readyState == 4){
			document.getElementById("message").innerHTML='Incorrect credentials!';
		}
	}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `username=${user}&password=${pass}`;
	xhr.send(requestBody);
}

