document.getElementById("aprrove").addEventListener("click", approveRequest);
document.getElementById("reject").addEventListener("click", rejectRequest);

function approveRequest(){
	let token = localStorage.getItem("token")
	let reimid = document.getElementById("reimID").value;
	console.log(reimid)
	let status = 1;

	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOne/srequest";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			
			let content = document.getElementById("text");
			alert("Successfully approved the reimbursement");
		} 
		else if (xhr.readyState == 4){
			alert("Failed to aprrove.");
		}
	}
	
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	xhr.setRequestHeader("reimID",reimID);
	xhr.setRequestHeader("status","1");
	let requestBody = `reimid=${reimid}&status=${status}`;
	xhr.send(requestBody);
}

function rejectRequest(){
	let token = localStorage.getItem("token")
	let reimid = document.getElementById("reimID").value;
	let status = 0;

	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOne/srequest";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			
			let content = document.getElementById("text");
			alert("Successfully rejected the reimbursement");
		} 
		else if (xhr.readyState == 4){
			alert("Failed to aprrove.");
		}
	}
	
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	xhr.setRequestHeader("reimID",reimID);
	xhr.setRequestHeader("status","1");
	let requestBody = `reimid=${reimid}&status=${status}`;
	xhr.send(requestBody);
	}