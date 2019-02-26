<ul id="friends"></ul>

<div style="display: flex;">
    <p> status: <div id="status" onload="getStatus();"></div></p>
</div>
<p>Change status: <input type="text" id="state"  name="status" onchange="changeStatus();"> <button id="changestatus" onclick="changeStatus();"> change status </button></p>
