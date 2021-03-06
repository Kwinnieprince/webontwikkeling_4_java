package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        response.setContentType("application/json");
        return result;
    }

    private String toJSON(List<Person> friends){
        String json = "[";
        int i = 0;
        for (Person friend : friends){
            json += "{\"userId\":\"" + friend.getUserId() + "\"," +
                    "\"firstName\":\"" + friend.getFirstName() + "\"," +
                    "\"lastName\":\"" + friend.getLastName() + "\"," +
                    "\"status\":\"" + friend.getStatus() + "\"}";
            i++;
            if (friends.size() != i){
                json += ",";
            }
        }
        json += "]";
        return json;
    }
}
