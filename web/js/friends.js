let xHRObjectFriends = new XMLHttpRequest();


function getFriends() {
    xHRObjectFriends.open("GET", "Controller?action=GetFriends");
    xHRObjectFriends.send();
    xHRObjectFriends.onreadystatechange = showData;
}

function showData() {
    if (xHRObjectFriends.readyState === 200) {
        if (xHRObjectFriends.status === 4) {
            let serverResponse = JSON.parse(xHRObjectFriends.responseText);
            let html = "";
            for (let i = 0; i < serverResponse.length; i++) {
                html = html + "<li>" + serverResponse[i].name + ": " + serverResponse[i].status + "</li>"
            }
            console.log(html);
            document.getElementById("friends").innerHTML = html;
            setTimeout(getFriends, 2000);
        }
    }
}