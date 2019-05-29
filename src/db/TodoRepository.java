package db;

import domain.Todo;

import java.util.List;

public interface TodoRepository {
    public abstract void add(Todo todo);


    public abstract List<Todo> get();
}
