package com.cinema.cinemacountry;

import java.time.LocalDateTime;

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

    private Repertory repertory;
    private Seans seans;

    public Admin (String name, String surname, String mail, int phoneNumber, int pin) {
        name=this.name;
        surname=this.surname;
        mail=this.mail;
        phoneNumber=this.phoneNumber;
        pin=this.pin;
    }

    @Bean
    public Movie createMovie(String title) {
        return new Movie(title);
    }

    public boolean deleteMovie(Movie theMovie) {
        if(theMovie!=null) {
            theMovie=null;
            return true;
        }else {
            System.out.println("Nie ma takiego filmu do wykasowania");
            return false;
        }
    }

    public boolean addMovie (Movie theMovie) { //nie ma do czego doda� filmu. Gdzie b�dzie trzymana lista film�w?
        return true;
    }

    public Seans createSeans(Movie movie, Hall hall, LocalDateTime date) { //wydaje mi si� jednak, �e Hall nie powinien by� w klasie Seans
        Seans seans = new Seans(movie,hall,date);
        return seans;
    }

    public boolean addSeans (Repertory repertory, Seans theSeans) { //jak w Hall b�dzie dodana List<Seans> to w tym miejsu b�dzie si� dodawa�o w kt�rej sali b�dzie seans
        repertory.seansList.add(theSeans);

        return true;
    }

    public boolean deleteSeans(Repertory repertory, Seans theSeans) {
        if(theSeans!=null&&repertory.seansList.contains(theSeans)) {
            repertory.seansList.remove(theSeans);
            System.out.println("Seans zosta usunity z Repertuaru");
            return true;
        }else {
            System.out.println("Tego seansu nie ma w Repertuarze.");
            return false;
        }
    }

    @Bean
    public Hall createHall(String hallName, int capacity) { //brakuje w klasie Hall p�l Seat [][] oraz List<Seans>
        return new Hall(name, capacity);
    }

}
