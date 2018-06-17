package com.cinema.cinemacountry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Reservation createReservation(Reservation reservation, boolean realised) {
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

    public List<Reservation> checkActiveReservations() {//those having true
        List<Reservation> activeReservations = new ArrayList<>();
        for (Map.Entry<Reservation, Boolean> entry : reservationMap.entrySet()) {
            if (entry.getValue().equals(true)) {
                activeReservations.add(entry.getKey());
            }
        }
        return activeReservations;
    }

    public boolean cancelReservation(long reservationId) {
        return false;//temporary
    }

    public boolean logOut() {
        return true;//temp
    }
}
