package com.cinema.cinemacountry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Configuration
@Scope("singielton")
public class Admin {
	private int id=0;
	private String name;
	private String surname;
	private String mail;
	private int phoneNumber;
	private int pin;
	
	public Admin (String name, String surname, String mail, int phoneNumber, int pin) {
		id=id+1;
		name=this.name;
		surname=this.surname;
		mail=this.mail;
		phoneNumber=this.phoneNumber;
		pin=this.pin;
	}

	@Bean
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

	@Bean
	public Hall createHall() {
		return new Hall;
	}
	
	public boolean deleteHall(Hall theHall) {
		return true;
	}

}
