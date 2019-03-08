<ul id="friends"></ul>

<div style="display: flex;">
    <p> status: <div id="status" onload="getStatus();"></div></p>
</div>
<p style="display: flex">Change status: <input type="text" id="state"  name="status"> <button id="changestatus" onclick="changeStatus();"> change status </button></p>
<p style="display: flex">add friends: <input type="text" id="add" name="addfriend"> <button id="addfriend" onclick="addFriends()"> add friend </button></p>
