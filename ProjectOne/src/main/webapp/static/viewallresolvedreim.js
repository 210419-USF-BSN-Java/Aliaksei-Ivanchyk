viewallResolved();

function viewallResolved(){
	let token = localStorage.getItem("token")
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOne/sviewallresolvedreim";
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status < 300){
			
            let list = xhr.getResponseHeader("pList");
			let jsonList = JSON.parse(list);			
			let content = document.getElementById("reimsTable");
			
			for(i = 0; i < jsonList.length; i++){
				let request = "<td>" + jsonList[i].reim_id + "</td><td>" + jsonList[i].amount + "</td><td>" + jsonList[i].submitDate + "</td><td>" + jsonList[i].resolveDate + "</td><td>" + jsonList[i].description + "</td><td>" + jsonList[i].type + "</td><td>" + jsonList[i].status + "</td><td>" + jsonList[i].manager_id + "</td>";
				content.insertAdjacentHTML('beforeend', request);
			}
		} 
		else if (xhr.readyState == 4){
			alert("Failed to load your pending reimbursement!, please check your login status.");
		}
	}
	
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}