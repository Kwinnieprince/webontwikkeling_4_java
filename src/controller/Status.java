package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Status extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        if (person != null){
            getPersonService().changeStatus(request.getParameter("status"), person);
            Controller.setSendJson();
            return toJSON(person.getStatus());
        }else {
            getPersonService().changeStatus(request.getParameter("status"), getPersonService().getPerson(request.getParameter("userId")));
            return toJSON( getPersonService().getPerson(request.getParameter("userId")).getStatus());
        }
    }

    private String toJSON (String status) {
        StringBuffer json = new StringBuffer();

        json.append("{ \"status\" : \"");
        json.append(status);
        json.append("\"}");

        return json.toString();
    }
}
