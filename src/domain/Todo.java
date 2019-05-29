package domain;

public class Todo {
    private String day;
    private String message;
    private String person;

    public Todo(String day, String message, String person){
        setDayOfTodo(day);
        setMessageOfTodo(message);
        setPersonOfTodo(person);
    }

    private void setDayOfTodo(String day) {
        if (day != null){
            this.day = day;
        }
    }

    private void setMessageOfTodo(String message) {
        if (message != null){
            this.message = message;
        }
    }

    private void setPersonOfTodo(String person) {
        if (person != null){
            this.person = person;
        }
    }

    public String getDayOfTodo(){
        return this.day;
    }

    public String getMessageOfTodo(){
        return this.message;
    }

    public String getPersonOfTodo(){
        return this.person;
    }
}
