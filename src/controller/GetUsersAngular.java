package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetUsersAngular extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Controller.setSendJson();
        return toJSON(getPersonService().getPersons());
    }

    public String toJSON(List<Person> persons){
        String json = "[";
        int i = 0;
        for (Person person : persons){
            json += "{\"userId\":\"" + person.getUserId() + "\"," +
                    "\"password\":\"" + person.getPassword() + "\"," +
                    "\"salt\":\"" + person.getSalt() + "\"," +
                    "\"firstName\":\"" + person.getFirstName() + "\"," +
                    "\"lastName\":\"" + person.getLastName() + "\"," +
                    "\"role\":\"" + person.getRole() + "\"," +
                    "\"status\":\"" + person.getStatus() + "\"}";
            i++;
            if (persons.size() != i){
                json += ",";
            }
        }
        json += "]";
        return json;
    }
}