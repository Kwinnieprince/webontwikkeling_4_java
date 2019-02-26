let xhr = new XMLHttpRequest();
let xHRStatus = new XMLHttpRequest();

window.onload = function(){
    getStatus();
    getFriends();
};

function changeStatus() {
    let status = document.getElementById("state").value;
    let information = "status=" + encodeURI(status);
    xhr.open("POST", "Controller?action=Status", true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(information);
    xhr.onreadystatechange = getData;
}

function getStatus() {
    // xhr.open("POST", "Controller?action=GetStatus");
    // xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    // xhr.send();
    // xhr.onreadystatechange = getData;
    xHRStatus.open("GET", "Controller?action=GetStatus");
    xHRStatus.onreadystatechange = getDataStatus;
    xHRStatus.send(null);
}

function getDataStatus() {
    if (xHRStatus.readyState === 4){
        if (xhr.status === 200){
            document.getElementById("status").innerText = xHRStatus.responseText;
        }
    }

}

function getData() {
    if (xhr.readyState === 4){
        if (xhr.status === 200){
            let serverResponse = JSON.parse(xhr.responseText);
            let statusXML = serverResponse.status;
            let div = document.getElementById("status");
            let p = div.childNodes[0];
            if (p == null){
                p = document.createElement("p");
                p.id = "statustext";
                let statustesxt = document.createTextNode(statusXML);
                p.appendChild(statustesxt);
                div.appendChild(p);
            }else{
                let statustesxt = document.createTextNode(statusXML);
                p.removeChild(p.childNodes[0]);
                p.appendChild(statustesxt);
            }
        }
    }
}