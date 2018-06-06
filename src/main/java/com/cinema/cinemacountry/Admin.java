package com.cinema.cinemacountry;

import org.springframework.stereotype.Component;

@Component
public class Admin {
	private int id;
	private String name;
	private String surname;
	private String mail;
	private int phoneNumber;
	private int pin;
	
	public Admin (String name, String surname, String mail, int phoneNumber) {
		id=id+1;
		name=this.name;
		surname=this.surname;
		mail=this.mail;
		phoneNumber=this.phoneNumber;
	}
	
	public Movie createMovie() {
		return new Movie();
	}
	
	public boolean deleteMovie(Movie theMovie) {
		return true;
	}
	
	public boolean addMovie (Movie theMovie) {
		return true;
	}
	
	public boolean addSeans (Seans theSeans) {
		return true;
	}
	
	public boolean deleteSeans(Seans theSeans) {
		return true;
	}

	public Hall create Hall() {
		return new Hall;
	}
	
	public boolean deleteHall(Hall theHall) {
		return true;
	}

}
