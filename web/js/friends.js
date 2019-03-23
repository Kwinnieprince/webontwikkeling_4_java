let xHRObjectFriends = new XMLHttpRequest();
let xHRObjectAdd = new XMLHttpRequest();
let userIds;


function getFriends() {
    xHRObjectFriends.open("GET", "Controller?action=GetFriends");
    xHRObjectFriends.send();
    xHRObjectFriends.onreadystatechange = showData;
}

function showData() {
    if (xHRObjectFriends.readyState === 4) {
        if (xHRObjectFriends.status === 200) {
            let serverResponse = JSON.parse(xHRObjectFriends.responseText);
            userIds = serverResponse;
            let html = "";
            for (let i = 0; i < serverResponse.length; i++) {
                html = html + "<li class='mouse' id='dialog" + serverResponse[i].userId + "' onclick='startChat(\""+serverResponse[i].userId+"\")'>" + serverResponse[i].userId + ": " + serverResponse[i].status + "</li>"
            }
            document.getElementById("friends").innerHTML = html;
            setTimeout(getFriends, 2000);
        }
    }
}

function addFriends() {
    let friend = document.getElementById("add").value;
    let information = "friend=" + encodeURI(friend);
    document.getElementById("add").value = "";
    xHRObjectAdd.open("POST", "Controller?action=AddFriends");
    xHRObjectAdd.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xHRObjectAdd.send(information);
    xHRObjectAdd.onreadystatechange = showData;
}

function startChat(userId) {
    $(document).ready(function () {
        let $li;
        for (let i = 0 ; i < userIds.length ; i++){
            // noinspection EqualityComparisonWithCoercionJS
            if (userIds[i].userId == userId){
                let user = userIds[i].userId.toString();
                user = user.split("@");
                let user1 = user[1].split(".");
                user = user[0] + "\\@" + user1[0] + "\\." + user1[1];
                console.log(user);
                $li = $("#dialog" + user.toString());
                break;
            }
        }
        // $("#chatForm").style.display = "block";
        document.getElementById("chatForm").style.display = "block";
    })
}