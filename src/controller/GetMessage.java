package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetMessage extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Controller.setSendJson();
        String userId = request.getParameter("userId");
        Person person = getPersonService().getPerson(userId);
        return this.toJSON(getPersonService().getLastMessageFromPerson(person));
    }
}
