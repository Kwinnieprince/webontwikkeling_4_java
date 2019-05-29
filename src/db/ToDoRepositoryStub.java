package db;

import domain.Todo;

import java.util.ArrayList;
import java.util.List;

public class ToDoRepositoryStub implements TodoRepository {

    private List<Todo> todolist = new ArrayList<Todo>();

    @Override
    public void add(Todo todo) {
        todolist.add(todo);
    }

    @Override
    public List<Todo> get() {
        return todolist;
    }
}
