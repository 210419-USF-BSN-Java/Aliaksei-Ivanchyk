document.getElementById("logout").addEventListener("click", logOut);

function logOut(){

    localStorage.removeItem("token");

    window.location.href="http://localhost:8080/ProjectOne/index.html";

}