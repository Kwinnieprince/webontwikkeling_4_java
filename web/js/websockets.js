let ws;

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
open();