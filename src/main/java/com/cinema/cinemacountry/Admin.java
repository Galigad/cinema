package com.cinema.cinemacountry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("Singleton")
public class Admin {
    private int id=0;
    private String name;
    private String surname;
    private String mail;
    private int phoneNumber;
    private int pin;

    @Autowired
    RepertoryConfig repertoryConfig;
    
    private Admin () {
    }

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

}