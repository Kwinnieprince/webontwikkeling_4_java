package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class GetFriends extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Controller.setSendJson();
        Person user = (Person) request.getSession().getAttribute("user");
        String result = "";
        if (user != null){
            List<Person> friends = user.getFriends();
            result = this.toJSON(friends);
        }
        return result;
    }
}
