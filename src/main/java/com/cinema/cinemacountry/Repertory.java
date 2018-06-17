package com.cinema.cinemacountry;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class Repertory {
    //
    List<Seans> seansList = new ArrayList<>();

    public void addSeans(Seans seans) {
        seansList.add(seans);
    }

    public void deleteSeans(Seans seans) {
        seansList.remove(seans);
    }

    public List<Seans> showSeansFrom(String hallName){
        return seansList.stream()
                .filter(seans -> seans.getHall().getHallName().equals(hallName))
                .collect(Collectors.toList());
    }

    public List<Seans> showSeansFilm(String filmTitle) {
        return seansList.stream()
                .filter(seans -> seans.getMovie().getTitle().equals(filmTitle))
                .collect(Collectors.toList());
    }

    public List<Seans> showFilmOfDay(LocalDateTime date) {
        return seansList.stream()
                .filter(seans -> seans.getDate().getMonth().equals(date.getMonth()))
                //
                //Filters of data
                //
                .collect(Collectors.toList());
    }

    public List<Seat> showAvaiableSeats() {
        Seans seansInList = seansList.get(1);
        // Dopisać wyszukiwanie odpowiedniego seansu z listy
        return seansInList.getSeats().stream()
                .filter(s -> s.isAvailable())
                .collect(Collectors.toList());
    }
}
