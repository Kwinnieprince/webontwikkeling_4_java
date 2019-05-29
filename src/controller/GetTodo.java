package controller;

import domain.Todo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetTodo extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Controller.setSendJson();
        response.setContentType("application/json");

        return this.toJSON(getPersonService().getTodos());
    }

    private String toJSON(List<Todo> todolist){
        String json = "[";
        int i = 0;
        for (Todo todo : todolist){
            json += "{\"dayTodo\":\"" + todo.getDayOfTodo() + "\"," +
                    "\"messageTodo\":\"" + todo.getMessageOfTodo() + "\"," +
                    "\"personTodo\":\"" + todo.getPersonOfTodo() + "\"}";
            i++;
            if (todolist.size() != i){
                json += ",";
            }
        }
        json += "]";
        return json;
    }
}
