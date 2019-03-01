let ws;
let feedback1 = document.getElementById("feedback1");

function open() {
    ws = new WebSocket("ws://localhost:8080/feedback")
}