package com.cinema.cinemacountry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Movie {
    private int id;
    private String title;
    //Map<Seans, Hall> durationMap;

    public Movie(String title) {
        this.title = title;
        //durationMap = new HashMap<>();
    }
}
