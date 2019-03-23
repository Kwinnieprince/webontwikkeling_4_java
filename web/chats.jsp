<ul id="friends"></ul>

<div style="display: flex;">
    <p> status: <div id="status" onload="getStatus();"></div></p>
</div>
<p style="display: flex">Change status: <input type="text" id="state"  name="status"> <button id="changestatus" onclick="changeStatus();"> change status </button></p>
<p style="display: flex">add friends: <input type="text" id="add" name="addfriend"> <button id="addfriend" onclick="addFriends()"> add friend </button></p>
<div class="chat-popup" id="chatForm" style="display: none">
    <form action="#" class="form-container"> <!-- TODO -->
        <h1>Chat</h1>

        <label for="msg"><b>Message</b></label>
        <textarea placeholder="Type message.." name="msg" id="msg" required></textarea>

        <button type="submit" class="btn">Send</button>
        <button type="button" class="btn cancel" onclick="closeChat()">Close</button>
    </form>
</div>
