package com.cinema.cinemacountry;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class Reservation {
    private long id;
    private LocalDate dateOfCreatedReservation;
    private Movie movie;
    private boolean isRealised;

    public Reservation(long id, LocalDate dateOfCreatedReservation, boolean isRealised) {
        this.id = id;
        this.dateOfCreatedReservation = dateOfCreatedReservation;
        this.isRealised = isRealised;
    }
}
