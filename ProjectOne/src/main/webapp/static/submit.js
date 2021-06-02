document.getElementById("submit").addEventListener("click", submitRequest);

function submitRequest(){
    let amount = document.getElementById("amount").value;
	let type = document.getElementById("type").value;
    let description = document.getElementById("description").value;
    let file = document.getElementById("file").value;
	let token = localStorage.getItem("token")

	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOne/ssubmit";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
            alert("You have successfully submited your reimbursement request!");

		} 
		else if (xhr.readyState == 4){
			alert("Failed to submit your reimbursement, please check your login status.");
		}
	}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	let requestBody = `amount=${amount}&type=${type}&description=${description}&file=${file}`;
	xhr.send(requestBody);
}
	

