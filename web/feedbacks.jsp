<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h3>Wat vond je van de projectweek?</h3>
    <ul id="feedback1"></ul>
    <label for="name1">naam <input type="text" id="name1"></label>
    <label for="feedback1text">feedback <input type="text" id="feedback1text"></label>
    <label for="feedback1nr">punten
        <select name="feedback1nr" id="feedback1nr">
            <c:forEach begin="1" end="10" var="nr">
                <option value="${nr}">${nr}</option>
            </c:forEach>
        </select>
    </label>
    <button onclick="send(1)">send</button>
</div>
<div>
    <h3>Wat ga je doen vandaag?</h3>
    <ul id="feedback2"></ul>
    <label for="name2">naam <input type="text" id="name2"></label>
    <label for="feedback2text">feedback <input type="text" id="feedback2text"></label>
    <label for="feedback2nr">punten
        <select name="feedback2nr" id="feedback2nr">
            <c:forEach begin="1" end="10" var="nr">
                <option value="${nr}">${nr}</option>
            </c:forEach>
        </select>
    </label>
    <button onclick="send(2)">send</button>
</div>
<div>
    <h3>Naar welke muziek ben je aan het luisteren?</h3>
    <ul id="feedback3"></ul>
    <label for="name3">naam <input type="text" id="name3"></label>
    <label for="feedback3text">feedback <input type="text" id="feedback3text"></label>
    <label for="feedback3nr">punten
        <select name="feedback3nr" id="feedback3nr">
            <c:forEach begin="1" end="10" var="nr">
                <option value="${nr}">${nr}</option>
            </c:forEach>
            </select>
        </label>
    <button onclick="send(3)">send</button>
</div>
<div>
    <h3>Wanneer is het vakantie?</h3>
    <ul id="feedback4"></ul>
    <label for="name4">naam <input type="text" id="name4"></label>
    <label for="feedback4text">feedback <input type="text" id="feedback4text"></label>
    <label for="feedback4nr">punten
        <select name="feedback4nr" id="feedback4nr">
            <c:forEach begin="1" end="10" var="nr">
                <option value="${nr}">${nr}</option>
            </c:forEach>
        </select>
    </label>
    <button onclick="send(4)">send</button>
</div>
<div>
    <h3>Wat vind je van de ucll?</h3>
    <ul id="feedback5"></ul>
    <label for="name5">naam <input type="text" id="name5"></label>
    <label for="feedback5text">feedback <input type="text" id="feedback5text"></label>
    <label for="feedback5nr">punten
        <select name="feedback5nr" id="feedback5nr">
            <c:forEach begin="1" end="10" var="nr">
                <option value="${nr}">${nr}</option>
            </c:forEach>
        </select>
    </label>
    <button onclick="send(5)">send</button>
</div>