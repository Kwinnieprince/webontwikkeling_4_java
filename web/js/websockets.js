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
    let feedback =  {};
    feedback.topicId = id;
    feedback.comment = document.getElementById("feedback" + id + "text").value;
    feedback.name = document.getElementById("name" + id).value;
    feedback.rating = document.getElementById("feedback" + id + "nr").value;
    console.log(feedback);
    ws.send(JSON.stringify(feedback));
}

function close() {
    ws.close();
}

function writeResponse(text) {
    let result = JSON.parse(text);
    for (let i = 0; i < result.length; i++) {
        let commentsUL = document.getElementById("feedback" + result[i].topicId);
        let commentLI = document.createElement('li');
        let commentTxt = document.createTextNode(result[i].name + " (" + result[i].rating + "/10) : " + result[i].comment);
        commentLI.appendChild(commentTxt);
        commentsUL.appendChild(commentLI);
    }
}

open();