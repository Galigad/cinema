package com.cinema.cinemacountry;

import lombok.Getter;

@Getter

public class Hall {
    //private int id;
    private String hallName;
    private int capacity;

    public Hall(String hallName, int capacity) {
        this.hallName = hallName;
        this.capacity = capacity;
    }
}
