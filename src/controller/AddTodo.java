package controller;

import domain.Todo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTodo extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Controller.setSendJson();
        String dayTodo = request.getParameter("todoDay");
        String messageTodo = request.getParameter("todoMessage");
        String personTodo = request.getParameter("todoPerson");
        Todo todo = new Todo(dayTodo, messageTodo, personTodo);
        getPersonService().addTodo(todo);
        response.setContentType("application/json");
        return this.toJSON(getPersonService().getTodos());
    }
}
