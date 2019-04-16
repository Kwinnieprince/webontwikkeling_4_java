<ul id="friends" style='margin-left: -40px'></ul>

<div style="display: flex;">
    <p>status:
        <div id="status" onload="getStatus();"></div>
    </p>
</div>
<p style="display: block">Change status: <input type="text" id="state"  name="status"> <button id="changestatus" onclick="changeStatus();"> change status </button></p>
<p style="display: block">add friends: <input type="text" id="add" name="addfriend"> <button id="addfriend" onclick="addFriends()"> add friend </button></p>
<div class="chat-popup" id="chatForm" style="display:none;">
    <%--<div class="form-container"> <!-- TODO -->--%>
        <%--<h1>Chat</h1>--%>

        <%--<label for="msg"><b id="messagePerson"></b></label>--%>
        <%--<div id="messages" style="min-height: 200px; background-color: #f1f1f1">--%>
            <%--<ul id="messagesUl"></ul>--%>
        <%--</div>--%>
        <%--<textarea placeholder="Type message.." name="msg" id="msg" required></textarea>--%>
        <%--<input id="userIdHidden" type="hidden" value="${user.getUserIdEscaped()}">--%>
        <%--<input type="hidden" id="userId" value="${user.getUserId()}">--%>
        <%--<div id="receivingUser"></div>--%>
        <%--<div id="sendButton"></div>--%>
        <%--<button type="button" class="btn cancel" onclick="closeChat()">Close</button>--%>
    <%--</div>--%>
</div>
