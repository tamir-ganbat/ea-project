package edu.mum.domain;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "session_id")
	private Session session;

	public Appointment() {
		super();
	}

	public Appointment(Person person, Session session) {
		super();
		this.person = person;
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
