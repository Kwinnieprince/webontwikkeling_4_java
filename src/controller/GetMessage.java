package controller;

import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetMessage extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Controller.setSendJson();
        String userId = request.getParameter("userId");
        Person person = getPersonService().getPerson(userId);
        return toJSON(person);
    }

    public String toJSON (Person person) {
        Message message = getPersonService().getLastMessageFromPerson(person);
        String json = "";
            json = "{\"sender\":\"" + message.getSender().getUserId() + "\"," +
                    "\"receiver\":\"" + message.getReceiver().getUserId() + "\"," +
                    "\"message\":\"" + message.getMessage() + "\"}";
        return json;
    }
}
