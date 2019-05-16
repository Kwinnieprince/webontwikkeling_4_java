package controller;

import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetMessage extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Controller.setSendJson();
        String userId = request.getParameter("sender");
        String receiverString = request.getParameter("receiver");
        Person receiver = getPersonService().getPerson(receiverString);
        Person person = getPersonService().getPerson(userId);
        return toJSON(person, receiver);
    }

    public String toJSON (Person person, Person receiver) {
        Message message = getPersonService().getLastMessageFromPerson(person, receiver);
        String json = "";
            json = "{\"sender\":\"" + message.getSender().getUserId() + "\"," +
                    "\"receiver\":\"" + message.getReceiver().getUserId() + "\"," +
                    "\"message\":\"" + message.getMessage() + "\"}";
        return json;
    }
}
