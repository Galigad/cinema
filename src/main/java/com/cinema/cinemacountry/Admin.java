package com.cinema.cinemacountry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singielton")
public class Admin {
    public static int ID=0;
    private String name;
    private String surname;
    private String mail;
    private int phoneNumber;
    private int pin;

    @Autowired
    RepertoryConfig repertoryConfig;
    
    private Admin () {}

    public Admin (String name, String surname, String mail, int phoneNumber, int pin) {
        name=this.name;
        surname=this.surname;
        mail=this.mail;
        phoneNumber=this.phoneNumber;
        pin=this.pin;
    }


    public Hall createHall(String hallName, int capacity) { 
        return new Hall(name, capacity);
    }
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public RepertoryConfig getRepertoryConfig() {
		return repertoryConfig;
	}

	public void setRepertoryConfig(RepertoryConfig repertoryConfig) {
		this.repertoryConfig = repertoryConfig;
	}


	

}