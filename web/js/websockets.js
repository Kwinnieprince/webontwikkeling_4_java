let ws;
let chatsocket

function open() {
    ws = new WebSocket("ws://localhost:8080/web_war_exploded/feedback");

    ws.onopen = function (event) {
    };

    ws.onmessage = function (event) {
        writeResponse(event.data);
    };

    ws.onclose = function (event) {
        
    };
}

function send(id) {
    let feedbacks =  {};
    feedbacks.topicId = id;
    feedbacks.name = document.getElementById("name" + id).value;
    feedbacks.feedback = document.getElementById("feedback" + id + "text").value;
    feedbacks.rating = document.getElementById("feedback" + id + "nr").value;
    ws.send(JSON.stringify(feedbacks));
}

function close() {
    ws.close();
}

function writeResponse(text) {
    let result = JSON.parse(text);
    for (let i = 0; i < result.length; i++) {
        let commentsUL = document.getElementById("feedback" + result[i].topicId);
        commentsUL.innerHTML += "<li>" + result[i].name + " (" + result[i].rating + "/10) : " + result[i].feedback + "</li>"
    }
}
function openChat() {
    chatsocket = new WebSocket("ws://localhost:8080/web_war_exploded/ChatSocket");

    ws.onopen = function (event) {

    };

    ws.onmessage = function (event) {
        writeChat(event.data);
    };

    ws.onclose = function (event) {

    };
}

function sendMessage(userId) {
    console.log(userId);
    let sender = $('#hiddenName').val();
    let receiver = userId;
    let message = $('#msg').val();
    let messages = {};
    messages.sender = sender;
    messages.receiver = receiver;
    messages.message = message;
    chatsocket.send(JSON.stringify(messages));
}

function writeChat(message) {
    let result = JSON.parse(message);
    console.log(result);
    for (let i = 0; i < result.length; i++){
        let message = result[i].message;
        let sender = result[i].sender;
        let receiver = result[i].receiver;
        let inside;
        // noinspection EqualityComparisonWithCoercionJS
        if (sender == $('#hiddenName').val()){
            inside = "<div style='text-align: right'>" + message + "</div>";
        }else {
            inside = "<div style='text-align: left'>" + message + "</div>";
        }
        document.getElementById("messages").innerHTML = inside;
    }
}



open();
openChat();