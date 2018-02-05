package edu.mum.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "session")
public class Session {

	@Id
	@GeneratedValue
	private int id;

	private Date date;
	private LocalDate startTime;
	private int duration;
	private int numberofsits;

	@OneToOne
	@JoinColumn(name = "location_id")
	private Location location;

	@OneToMany(mappedBy = "session")
	private List<Appointment> appointments;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	public Session() {
		super();
	}

	public Session(Date date, LocalDate startTime, int duration, Location location, Person person) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.duration = duration;
		this.location = location;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public int getNumberofsits() {
		return numberofsits;
	}

	public void setNumberofsits(int numberofsits) {
		this.numberofsits = numberofsits;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
