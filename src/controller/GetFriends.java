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
    //[{"userId":"bib@ucll.be","firstName":"Bib","lastName":"Liothekaris","role":"BIB","status":"offline","friends":[],"lastMessage":null,"userIdEscaped":"bib\\@ucll\\.be"},{"userId":"an@ucll.be","password":"c779c24592c454cf12b37c4e637616d095fa0ea4","salt":"14d199fe15d546888e3d82e320e9d77d4616077c","firstName":"An","lastName":"Cornelissen","role":"LID","status":"gone","friends":[],"lastMessage":null,"userIdEscaped":"an\\@ucll\\.be"}]
    //[{"userId":"bib@ucll.be","firstName":"Bib","lastName":"Liothekaris","status":"offline"},{"userId":"an@ucll.be","firstName":"An","lastName":"Cornelissen","userIdEscaped":"an\@ucll\.be","status":"gone"}]
}
