let xHRObjectFriends = new XMLHttpRequest();
let xHRObjectAdd = new XMLHttpRequest();
let userIds;


function getFriends() {
    setTimeout(null,1000);
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
                html = html + "<li style='padding-bottom: 10px' class='mouse' id='dialog" + serverResponse[i].userId + "' onclick='startChat(\""+serverResponse[i].userId+"\")'>" + serverResponse[i].userId + ": <b>" + serverResponse[i].status + "</b></li>"
            }
            document.getElementById("friends").innerHTML = html;
            setTimeout(getFriends, 10000);
        }
    }
    setTimeout(getFriends, 10000);
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
    let user;
    let receiver;
    $(document).ready(function () {
        let $li;
        let html;
        let htmlSendButton;
        for (let i = 0 ; i < userIds.length ; i++){
            // noinspection EqualityComparisonWithCoercionJS
            if (userIds[i].userId == userId){
                receiver = userIds[i].userId.toString();
                user = userIds[i].userId.toString();
                user = user.split("@");
                html = "<div> Message " + user[0] + "</div>";
                let user1 = user[1].split(".");
                user = user[0] + "\\@" + user1[0] + "\\." + user1[1];
                htmlSendButton = "<button type=\"submit\" class=\"btn\" style='\tbackground-color: #4CAF50;\n" +
                    "\tcolor: white;\n" +
                    "\tborder: none;\n" +
                    "\tcursor: pointer;\n" +
                    "\twidth: 100%;\n" +
                    "\tmargin-bottom:10px;\n" +
                    "\topacity: 0.8;' onclick='sendMessage()'>Send</button>";
                $li = $("#dialog" + user.toString());
                break;
            }
        }
        let chatwindow = "<div id='chatformtodel' class='form-container' style='\twidth: 300px;\n" +
            "\tpadding: 10px;\n" +
            "\tbackground-color: white;'>" +
            "<h1>Chat</h1><label for='msg'>" +
            "<b id='messagePerson'></b></label>" +
            "<div id='messages' style='min-height: 200px; background-color: #f1f1f1'> " +
            "<ul id='messagesUl'></l> </div> <textarea placeholder='Type message..' name='msg' id='msg' required style='\twidth: 100%;\n" +
            "\tmargin: 5px 0 22px 0;\n" +
            "\tborder: none;\n" +
            "\tbackground: #f1f1f1;\n" +
            "\tresize: none;'></textarea> " +
            "<input type='hidden' value='" + user + "' id='receiver'>" +
            "<input type='hidden' value='" + receiver + "' id='receiverWithoutSlash'>" +
            "<div id='sendButton'></div> " +
            "<button type='button' class='btn cancel' onclick='closeChat()' style='background-color: red; \tcolor: white;\n" +
            "\tborder: none;\n" +
            "\tcursor: pointer;\n" +
            "\twidth: 100%;\n" +
            "\tmargin-bottom:10px;\n" +
            "\topacity: 0.8;'>Close</button> " +
            "</div>";
        // $('#messagePerson').html(html);
        // document.getElementById("chatForm").innerHTML = chatwindow;
        $('#chatForm').empty();
        $('#chatForm').append(chatwindow);
        $('#messagePerson').append(html);
        $('#sendButton').append(htmlSendButton);
        $('#chatForm').css('display', 'flex');
        // document.getElementById("messagePerson").innerHTML = html;
        // document.getElementById("sendButton").innerHTML = htmlSendButton;
        // $('#sendButton').html(htmlSendButton);
        // document.getElementById("chatForm").style.display = "block";
    });
}

function getTodo() {
    setTimeout(null,1000);
    xHRObjectFriends.open("GET", "Controller?action=GetTodo");
    xHRObjectFriends.send();
    xHRObjectFriends.onreadystatechange = showDataOfTodo;
}

function addTodo() {
    let todoDay = document.getElementById("todoDay").value;
    let todoMessage = document.getElementById("todoMessage").value;
    let todoPerson = document.getElementById("todoPerson").value;
    let information = "todoDay=" + encodeURI(todoDay) + "&todoMessage=" + encodeURI(todoMessage) +  "&todoPerson=" + encodeURI(todoPerson);
    document.getElementById("todoDay").value = "";
    document.getElementById("todoMessage").value = "";
    document.getElementById("todoPerson").value = "";
    xHRObjectAdd.open("POST", "Controller?action=AddTodo");
    xHRObjectAdd.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xHRObjectAdd.send(information);
    getTodo();
    xHRObjectAdd.onreadystatechange = showDataOfTodo;
}

function showDataOfTodo() {
    if (xHRObjectFriends.readyState === 4) {
        if (xHRObjectFriends.status === 200) {
            let serverResponse = JSON.parse(xHRObjectFriends.responseText);
            userIds = serverResponse;
            let html = "";
            for (let i = 0; i < serverResponse.length; i++) {
                html = html + "<li>" + serverResponse[i].dayTodo + " - " + serverResponse[i].messageTodo + " - " + serverResponse[i].personTodo + "</li>"
            }
            document.getElementById("todoList").innerHTML = html;
            setTimeout(getTodo, 10000);
        }
    }
    setTimeout(getTodo, 10000);
}