package controller;

import domain.Person;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUser extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String destination = "index.jsp";
        Person person = new Person();
        String firstName = request.getParameter("firstName");
        String lastName =request.getParameter("lastName");
        String email =request.getParameter("email");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");
        String age = request.getParameter("age");
        if (!email.isEmpty() && !gender.isEmpty() && !password.isEmpty() && !passwordRepeat.isEmpty() && !age.isEmpty()){
            if (password.equals(passwordRepeat)){
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setUserId(email);
                person.setPassword(password);
                person.setHashedPassword(password);
                person.setRole(Role.LID);
                person.setStatus("Offline");
                getPersonService().addPerson(person);
            }else {
                throw new IllegalArgumentException("Passwords do not match");
            }
        }else {
            throw new IllegalArgumentException("Empty field");
        }
        return destination;
    }
}
