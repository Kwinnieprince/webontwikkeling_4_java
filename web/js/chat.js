let xhr = new XMLHttpRequest();
let xHRStatus = new XMLHttpRequest();
let messageId = 0;

window.onload = function(){
    getStatus();
    getFriends();
    //getNewMessage(); TODO
};

function changeStatus() {
    let status = document.getElementById("state").value;
    let information = "status=" + encodeURI(status);
    document.getElementById("state").value = "";
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
    xhr.open("GET", "Controller?action=GetStatus");
    xhr.onreadystatechange = getData;
    xhr.send(null);
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

function closeChat() {
    let t = document.getElementById("chatformtodel");
    t.parentNode.removeChild(t);
    document.getElementById("chatForm").style.display(none);
}

let previousMessage;
function getNewMessage() {
    const userId = $('#userId').val();
    if (userId != null || userId != undefined){
        $.ajax({
            type: "GET",
            url: "Controller?action=GetMessage&userId=" + userId,
            dataType: "json",
            success: function (json){
                if (json.message != null){
                    if (previousMessage == null || previousMessage != json.message){
                        previousMessage = json.message;
                        if (json.sender == userId){
                            $('#messagesUl').append("<li style='text-align:right; list-style: none'>" + json.message + " </li>");
                        } else {
                            $('#messagesUl').append("<li style='text-align:left; list-style: none'>" + json.message + " </li>")
                        }
                    }
                }
                setTimeout(getNewMessage, 10000);
            },
            error: function () {
                console.log("error getting the message");
                setTimeout(getNewMessage, 10000);
            }
        })
    }
}

// function unslash(slashedString) {
//     let slashedstring = slashedString.split("\\");
//     let person = concat(slashedstring);
//     console.log(person);
//     return person;
// }

function sendMessage() {
    const message = $('#msg').val();
    const sender = $('#sender').val();
    const receiver = $('#receiver').val();
    $.post("Controller", {action: "SendMessage", message: message, sender: sender,  receiver: receiver});
    $('#msg').val("");
    getNewMessage();
}

document.getElementById("sendButton").addEventListener("click", function () {
    sendMessage();
});