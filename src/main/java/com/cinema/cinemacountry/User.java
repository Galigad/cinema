package com.cinema.cinemacountry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

/*kaja*/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id; //generated value
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;// maybe better than int when somebody will type f.e. +48 555 222 333?
    private int pin;
    Map<Reservation, Boolean> reservationMap;

    public User(String firstName, String lastName, String email, String phoneNum, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.pin = pin;
        reservationMap = new HashMap<>();
    }

    public boolean login() {//czy funkcja login nie powinna być udostępniona z menagera?
        return true;//temp
    }

    public boolean deleteAccount() {
        this.firstName = "XXX";
        this.lastName = "XXX";
        this.email = "XXX";
        this.phoneNum = "0000";
        this.pin = 0;
        reservationMap = new HashMap<>();
        return true;
    }

    public Reservation createReservation(Reservation reservation, boolean realised) {//default false?
        //find some way to actualize realised reservations
        //jaki ma sens mapa skoro reservation juz ma przypisany true/false?
        //
        realised = reservation.isRealised();
        reservationMap.put(reservation, realised);
        return reservation;
    }

    public List<Reservation> checkHistoryOfAllReservations() {
        List<Reservation> allReservations = new ArrayList<>();
        for (Map.Entry<Reservation, Boolean> entry : reservationMap.entrySet()) {
            allReservations.add(entry.getKey());
        }
        return allReservations;
    }

    public List<Reservation> checkActiveReservations() {//those having false
        List<Reservation> activeReservations = new ArrayList<>();
        for (Map.Entry<Reservation, Boolean> entry : reservationMap.entrySet()) {
            if (entry.getValue().equals(false)) {
                System.out.println("value: " + entry.getValue());
                activeReservations.add(entry.getKey());
            }
        }
        return activeReservations;
    }

    public boolean cancelReservation(long reservationId) {
        Reservation keyReservation = null;
        boolean succeed = false;
        for (Map.Entry<Reservation, Boolean> reservation : reservationMap.entrySet()) {
            long id = reservation.getKey().getId();
            if (id == reservationId) {
                keyReservation = reservation.getKey();
            }
        }

        Optional<Reservation> resultReservation = Optional.ofNullable(keyReservation);
        if (resultReservation.isPresent()) {
            reservationMap.remove(keyReservation);
            System.out.println("Your reservation has been succesfully canceled");
            succeed = true;
        }
        return succeed;
    }

    public boolean logOut() {
        return true;//temp
    }
}
