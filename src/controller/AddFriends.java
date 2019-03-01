package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFriends extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Controller.setSendJson();
        String friend = request.getParameter("friend");
        Person newFriend = new Person();
        newFriend.setStatus("Not available");
        newFriend.setUserId(friend);
        getPersonService().addPerson(newFriend);
        return this.toJSON(getPersonService().getPersons());
    }
}