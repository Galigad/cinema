package com.cinema.cinemacountry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTestSuite {
    @Test
    public void testDeleteAccount() {
        //Given
        User user = new User("Jan", "Nowak", "jan@nowak", "530 222 111", 1232);
        //When
        user.deleteAccount();
        //Then
        Assert.assertEquals(0, user.getPin());
        Assert.assertEquals("XXX", user.getFirstName());
    }

    @Test
    public void testCheckHistoryOfAllReservations() {
        //Given
        User user = new User("Jan", "Nowak", "jan@nowak", "530 222 111", 1232);
        Reservation reservation1 = new Reservation();
        Reservation reservation2 = new Reservation();
        Reservation reservation3 = new Reservation();

        user.createReservation(reservation1, true);
        user.createReservation(reservation2, true);
        user.createReservation(reservation3, true);

        //When
        List<Reservation> resultList = user.checkHistoryOfAllReservations();

        //Then
        Assert.assertEquals(3, resultList.size());
    }

    @Test
    public void testCheckActiveReservations() {
        //Given
        User user = new User("Jan", "Nowak", "jan@nowak", "530 222 111", 1232);
        Reservation reservation1 = new Reservation();
        Reservation reservation2 = new Reservation();
        Reservation reservation3 = new Reservation();

        user.createReservation(reservation1, true);
        user.createReservation(reservation2, false);
        user.createReservation(reservation3, false);

        //When
        List<Reservation> resultList = user.checkActiveReservations();

        //Then
        Assert.assertEquals(1, resultList.size());

    }

}
