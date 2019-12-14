package pt.cuong.rest.ex.service;

import java.util.ArrayList;
import java.util.List;

import pt.cuong.rest.ex.model.Person;

public class PersonService {
	private static List<Person> persons = new ArrayList<Person>();
	private static long IDGeneration = 9;
	
	static {
		persons.add(new Person(1, "Cuong", "Phan", "Do Nhuan"));
		persons.add(new Person(2, "Su", "Tran", "Le Van Quoi"));
		persons.add(new Person(3, "Tri", "Nguyen", "Le Trong Tan"));
		persons.add(new Person(4, "Tri", "Vo", "Tay Thanh"));
		persons.add(new Person(5, "Khanh", "Hang", "Truong Chinh"));
		persons.add(new Person(6, "Khoi", "Tran", "Hoang Hoa Tham"));
		persons.add(new Person(7, "Chuong", "Nguyen", "Cong Hoa"));
		persons.add(new Person(8, "Ngan", "Nguyen", "Nguyen Thai Binh"));
	}
	
	public static List<Person> getPersons() {
		return persons;
	}
	
	public static void updatePerson(Person person) {
		Person personUpdated = persons.stream().filter(ps -> ps.getId() == person.getId()).findAny().get();
		personUpdated.setFirstName(person.getFirstName());
		personUpdated.setLastName(person.getLastName());
		personUpdated.setAddress(person.getAddress());
	}
	
	public static void createPerson(Person person) {
		person.setId(IDGeneration++);
		persons.add(person);
	}
	
	public static void deletePerson(long personID) {
		Person personDeleted = persons.stream().filter(ps -> ps.getId() == personID).findAny().get();
		persons.remove(personDeleted);
	}
}
