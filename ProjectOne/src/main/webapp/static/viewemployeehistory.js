document.getElementById("approve").addEventListener("click", approveRequest);
document.getElementById("approve").addEventListener("click", rejectRequest);

function viewRequest(){
	let token = localStorage.getItem("token")
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOne/semployeehistory";
	let employeeID = document.getElementById("employeeID").value;
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			
            let requestList = xhr.getResponseHeader("requestList");
			let jsonList = JSON.parse(requestList);
			
			let content = document.getElementById("viewAllRequestById");
			content.innerHTML ='<th>Request ID</th><th>Amount</th><th>Submit Time</th><th>Resolved Time</th><th>Description</th><th>Employee ID</th><th>Resolver ID</th><th>Reimbursement Status</th><th>Reimbursement Type</th>';

			for(i = 0; i < jsonList.length; i++){
				let request = "<td>" + jsonList[i].reim_id + "</td><td>" + jsonList[i].amount + "</td><td>" + jsonList[i].submitDate + "</td><td>" + jsonList[i].resolveDate + "</td><td>" + jsonList[i].description + "</td><td>" + jsonList[i].user_id + "</td><td>" + jsonList[i].manager_id + "</td><td>" + jsonList[i].status + "</td><td>" + jsonList[i].type + "</td>";
				content.insertAdjacentHTML('beforeend', request);
			}
		} 
		else if (xhr.readyState == 4){
			alert("Failed to load request information!, please check your login status.");
		}
	}
	
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	xhr.setRequestHeader("employeeID",employeeID);
	xhr.send();
}