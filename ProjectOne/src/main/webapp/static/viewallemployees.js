viewEmployees();

function viewEmployees(){
	let token = localStorage.getItem("token")
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOne/sallemployees";
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
            let employeeList = xhr.getResponseHeader("employeeList");
			let jsonList = JSON.parse(employeeList);
			
			let content = document.getElementById("employees");

			for(i = 0; i < jsonList.length; i++){
				let employee = "<td>" + jsonList[i].employee_id + "</td><td>" + jsonList[i].first_name + "</td><td>" + jsonList[i].last_name + "</td><td>" + jsonList[i].email + "</td>";
				content.insertAdjacentHTML('beforeend', employee);
			}
		} 
		else if (xhr.readyState == 4){
			alert("Failed to load employee information!, please check your login status.");
		}
	}
	
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}