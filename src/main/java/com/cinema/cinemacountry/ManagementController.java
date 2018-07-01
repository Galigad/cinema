package com.cinema.cinemacountry;

import org.springframework.beans.factory.annotation.Autowired;

public class ManagementController {

   private User user;
   private Admin admin;
   private Repertory repertory;

    Admin createAdminAccount() {
        return admin;
    }

    User createUserAccount() {
        return user;
    }
}
