document.getElementById("check").addEventListener("click", viewRequest);

function approveRequest(){
	let token = localStorage.getItem("token")
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOne/srequest";
	let reimID = document.getElementById("reimID").value;
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			
			let content = document.getElementById("text");
			content.insertAdjacentHTML('');
		} 
		else if (xhr.readyState == 4){
			alert("Failed to aprrove.");
		}
	}
	
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	xhr.setRequestHeader("reimID",reimID);
	xhr.setRequestHeader("status","1");
	xhr.send();
}