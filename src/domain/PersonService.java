package domain;

import db.PersonRepository;
import db.PersonRepositoryStub;
import db.ToDoRepositoryStub;
import db.TodoRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();

	private TodoRepository todoRepository = new ToDoRepositoryStub();

	List<Integer>messageIds = new ArrayList<>();

	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public Person getPersonWithSlashes(String personId){
	    String[] personArr = personId.split("\\\\");
	    String person = "";
	    for (int i = 0; i < personArr.length; i++){
	        person += personArr[i];
        }
	    return getPerson(person);
    }

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	public void changeStatus(String status, Person person){
		person.setStatus(status);
		getPersonRepository().update(person);
	}

	public String getStatus(Person person){
		return getPersonRepository().get(person.getUserId()).getStatus();
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}

	public Message getLastMessageFromPerson(Person person, Person receiver){
		if (personRepository.get(person.getUserId()).getLastMessage() != null){
			System.out.println(receiver.getUserId() + " : receiver");
			System.out.println(person.getUserId() + " : sender");
			return  personRepository.get(person.getUserId()).getLastMessageOfPersonReceiver(receiver);
		}
		return new Message();
    }


	public void sendMessage(Person sender, Person receiver, Message message){
		personRepository.get(sender.getUserId()).sendMessage(message.getSender(), message.getReceiver(), message.getMessage());
//		personRepository.get(receiver.getUserId()).sendMessage(message.getSender(), message.getReceiver(), message.getMessage());
	}

    public List<Todo> getTodos() {
		return todoRepository.get();
    }

    public void addTodo(Todo todo){
		todoRepository.add(todo);
	}
}