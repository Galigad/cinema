package com.cinema.cinemacountry;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RepertoryTestSuite {
    private Repertory repertuar;

    @Before
    public void init() {
        //Given
        repertuar = new Repertory();
        Movie movie1 = new Movie("Titanic");
        Hall hall1 = new Hall("Warszawa", 40);
        LocalDateTime data1 = LocalDateTime.of(2018,1,10,18,0);
        Seans seans1 = new Seans(movie1, hall1, data1);

        Movie movie2 = new Movie("Film");
        Hall hall2 = new Hall("Wroclaw", 40);
        LocalDateTime data2 = LocalDateTime.of(2018,1,10,20,0);
        Seans seans2 = new Seans(movie2, hall2, data2);

        Movie movie3 = new Movie("Dramat");
        Hall hall3 = new Hall("Warszawa", 40);
        LocalDateTime data3 = LocalDateTime.of(2018,2,10,22,0);
        Seans seans3 = new Seans(movie3, hall3, data3);

        //When
        repertuar.addSeans(seans1);
        repertuar.addSeans(seans2);
        repertuar.addSeans(seans3);
    }

    @Test
    public void testAddSeans() {
        //Given
        Movie movie = new Movie("Test1");
        Hall hall = new Hall("Warszawa", 40);
        LocalDateTime data = LocalDateTime.of(2018,1,10,18,0);

        //When
        repertuar.addSeans(new Seans(movie, hall, data));

        //Then
        Assert.assertEquals(4, repertuar.getSeansList().size());
    }

    @Test
    public void testDeleteSeans() {
        //Given
        Movie movie = new Movie("Test1");
        Hall hall = new Hall("Warszawa", 40);
        LocalDateTime data = LocalDateTime.of(2018,1,10,18,0);
        Seans seans = new Seans(movie, hall, data);
        //When
        repertuar.addSeans(seans);
        repertuar.deleteSeans(seans);

        //Then
        Assert.assertEquals(3, repertuar.getSeansList().size());
    }

    @Test
    public void testShowSeansFrom() {
        Assert.assertEquals(3, repertuar.getSeansList().size());
        Assert.assertEquals(2, repertuar.showSeansFrom("Warszawa").size());
        Assert.assertEquals(1, repertuar.showSeansFrom("Wroclaw").size());
    }

    @Test
    public void testShowSeansFilm() {
        Assert.assertEquals(1, repertuar.showSeansFilm("Titanic").size());
    }

    @Test
    public void testShowFilmOfDay() {
        LocalDateTime data = LocalDateTime.of(2018,1,10,18,0);
        Assert.assertEquals(2, repertuar.showFilmOfDay(data).size());
    }

    @Test
    public void testShowAvaiableSeats() {
        List<Seat> seats = repertuar.showAvaiableSeats();

        //Then
        Assert.assertEquals(40, seats.size());
    }

}
