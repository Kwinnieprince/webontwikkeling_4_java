<ul id="friends" style='margin-left: -40px'></ul>

<div style="display: flex;">
    <p>status:
        <div id="status" onload="getStatus();"></div>
    </p>
</div>
<p style="display: block">Change status: <input type="text" id="state"  name="status"> <button id="changestatus" onclick="changeStatus();"> change status </button></p>
<p style="display: block">add friends: <input type="text" id="add" name="addfriend"> <button id="addfriend" onclick="addFriends()"> add friend </button></p>
<input type="hidden" id="sender" value="${user.getUserIdEscaped()}">
<input type="hidden" id="userId" value="${user.getUserId()}">
<div class="chat-popup" id="chatForm" style="display:none;">
</div>
