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
            List<String> names = new ArrayList<>();
            List<String> statusses = new ArrayList<>();
            for (Person p : friends){
                names.add(p.getUserId());
                statusses.add(p.getStatus());
            }
            result = this.toJSON(names, statusses);
        }
        return result;
    }

    public String toJSON (List names, List statusses) {
        StringBuffer json = new StringBuffer();
        for(int i = 0; i < names.size(); i++){
            json.append("{ \"name\" : \"");
            json.append(names.get(i));
            json.append("\", \"status\" : \"");
            json.append(statusses.get(i));
            json.append("\"}");
        }
        return json.toString();
    }
}
