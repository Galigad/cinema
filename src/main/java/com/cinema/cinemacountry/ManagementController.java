package com.cinema.cinemacountry;

public class ManagementController {

    User user;
    Admin admin;
    //Repertory repertory;

    Admin createAdminAccount(String name, String surname, String mail, int phoneNumber, int pin) {
        Admin admin = new Admin(name, surname, mail, phoneNumber, pin);
        return admin;
    }

    User createUserAccount(String firstName, String lastName, String email, String phoneNum, int pin) {
        User user = new User(firstName, lastName, email, phoneNum, pin);
        return user;
    }
}
