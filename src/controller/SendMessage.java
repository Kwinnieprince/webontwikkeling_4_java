package controller;

import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMessage extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String senderId = request.getParameter("sender");
        String receiverId = request.getParameter("receiver");
        String messageString = request.getParameter("message");
        Message message = new Message();
        if (senderId != null && receiverId != null && messageString != null) {
            Person sender = getPersonService().getPersonWithSlashes(senderId);
            Person receiver = getPersonService().getPersonWithSlashes(receiverId);
            message = new Message(sender, receiver, messageString);
            getPersonService().sendMessage(sender, message);
        }
        Controller.setSendJson();
        return "{\"sender\":\"" + message.getSender().getUserId() + "\"," +
                "\"receiver\":\"" + message.getReceiver().getUserId() + "\"," +
                "\"message\":\"" + message.getMessage() + "\"}";
    }
}
