var xhr = new XMLHttpRequest();

function changeStatus() {
    var status = document.getElementById("state").value;
    var information = "status=" + encodeURI(status);
    xhr.open("POST", "Controller?action=Status", true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(information);
    xhr.onreadystatechange = getData;
}

function getData() {
    if (xhr.readyState == 4){
        if (xhr.status == 200){
            var serverResponse = JSON.parse(xhr.responseText);
            var statusXML = serverResponse.status;
            var div = document.getElementById("status");
            var p = div.childNodes[0];
            if (p == null){
                p = document.createElement("p");
                p.id = "statustext";
                var statustesxt = document.createTextNode(statusXML);
                p.appendChild(statustesxt);
                div.appendChild(p);
            }else{
                var statustesxt = document.createTextNode(statusXML);
                p.removeChild(p.childNodes[0]);
                p.appendChild(statustesxt);
            }
        }
    }

}