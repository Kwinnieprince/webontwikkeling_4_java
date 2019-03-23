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
                html = html + "<li id='dialog" + serverResponse[i].userId + "' onclick='startChat("+serverResponse[i].userId.toString()+")'>" + serverResponse[i].userId + ": " + serverResponse[i].status + "</li>"
            }
            document.getElementById("friends").innerHTML = html;
            //setTimeout(getFriends, 2000);
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
                $li = $("#dialog" +userIds[i].userId);//$("dialog" +userIds[i].userId);
                break;
            }
        }
        console.log("test");
        $li.on('click',function () {
            console.log("testie");
            $li.fadeOut(1000);
        })
    })
}