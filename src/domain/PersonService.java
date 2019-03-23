package domain;

import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();

	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
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

	public List<Message> getMessagesOfPerson(Person person){
		return personRepository.get(person.getUserId()).getMessages();
	}


	public void sendMessage(Person sender, Message message){
		personRepository.get(sender.getUserId()).sendMessage(message.getSender(), message.getReceiver(), message.getMessage());
	}

}
