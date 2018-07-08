package com.cinema.cinemacountry;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CinemaCountryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaCountryApplication.class, args);
        
        ApplicationContext context = new AnnotationConfigApplicationContext(ManagementController.class);
        ManagementController cinemaController = context.getBean(ManagementController.class);  //Choæ nie jest on Beanem?!
        boolean endProgram = false;
        Scanner sc= new Scanner(System.in);
        Admin admin=null;
        
        while(endProgram==false) {
        	System.out.println("Witam w programie Cinema Country. Czy stworzyæ administratora? (T,N)");
        	String userData = sc.nextLine();
        	if(userData=="T") {
        		boolean adminData = false;
        		while(adminData==false) {
        			admin = cinemaController.createAdminAccount();
        			System.out.println("Podaj Imiê: ");
        			String name = sc.nextLine();
        			
        			System.out.println("Podaj nazwiosko:");
        			String surname = sc.nextLine();
        			
        			System.out.println("Podaj nazwiosko:");
        			int phoneNumber= sc.nextInt();
        			sc.nextLine();
        			
        			System.out.println("Nr telefono ustawiono na: "+ name+". Teraz podaj nazwiosko:");
        			int adminPin = sc.nextInt();
        			
        			System.out.println("Dane Administratora: \n" +" Imiê: " +name+", nazwisko: " + surname +", nr telefonu: " + phoneNumber + '\n'+
        					"Jeœli dane sie zgadzaj¹ wpisz 'ok'"); 
        			userData=sc.nextLine();
        			if(userData=="ok") {
        				admin.setName(name);
        				admin.setSurname(surname);
        				admin.setPhoneNumber(phoneNumber);
        				admin.setPin(adminPin);
        				Admin.ID++;
        				adminData=true;
        			
        			} else adminData=false;
        			/*Nalezy jeszcze dodac obs³ugê wyj¹tków i ladniej bêdzie jak umo¿liwi siê korygowanie danych jeœli u¿ytkownik wprowadzi jakiœ b³¹d.
        			W celach testowych zamiast Scannera bêdzie wprowadzone FileReader - odczytuj¹cy po kolei dane testowe z pliku)*/
        		}
        	}
        }
    }
}
