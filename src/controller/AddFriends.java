package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFriends extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Controller.setSendJson();
        Person person = (Person) request.getSession().getAttribute("user");
        String friend = request.getParameter("friend");
        Person newFriend = new Person();
        newFriend.setStatus("Not available");
        newFriend.setUserId(friend);
        getPersonService().addPerson(newFriend);
        person.addFriend(newFriend);
        response.setContentType("application/json");
        return this.toJSON(getPersonService().getPersons());
    }
}