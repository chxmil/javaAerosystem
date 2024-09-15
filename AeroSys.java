package Air_plan;

import java.util.ArrayList;
import java.util.Scanner;

public class AeroSys {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Ticket> tickets1 = new ArrayList<>();
        ArrayList<Ticket> tickets2 = new ArrayList<>();
        ArrayList<Ticket> tickets3 = new ArrayList<>();
        ArrayList<Ticket> tickets4 = new ArrayList<>();
        ArrayList<Ticket> tickets5 = new ArrayList<>();
        Airplane plane1 = new Airplane("A001", 2, 5000, 900, 1000, 500, 500, 10);

        tickets1.add(new Ticket("011", 99.9, "E11", "Flight No.1"));
        tickets2.add(new Ticket("012", 99.9, "E12", "Flight No.1"));
        tickets3.add(new Ticket("013", 99.9, "E13", "Flight No.1"));
        tickets4.add(new Ticket("014", 99.9, "E14", "Flight No.1"));
        tickets5.add(new Ticket("015", 99.9, "E14", "Flight No.1"));

        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Captain("prof.dr.Charmil_Alee", "001", true, "charmil.alee2@oxford.com", 1000, tickets1)); 
        passengers.add(new Passenger("dr.Kot", "002", true, "dr.kot@walailak.com", tickets2));
        passengers.add(new Passenger("Aj.Mard", "003", true, "Aj.mard@walailak.com", tickets3));  
        passengers.add(new Passenger("prof.dr.Sombat", "004", true, "prof.dr.sombat@walailak.com", tickets4));  
        passengers.add(new Passenger("dr.Bigben", "005", true, "dr.bigben@walailak.com", tickets5));  

        plane1.addPassenger(passengers.get(0));  
        plane1.addPassenger(passengers.get(1)); 
        plane1.addPassenger(passengers.get(2));  

        char x;
        int n=0;
        String o;
        System.out.println("##################################");
        System.out.println("1.Find passenger");
        System.out.println("2.Show all passenger");
        System.out.println("3.chow all ticket");
        System.out.println("4.add plane #please wait for update Teacher T-T sorry");
        System.out.println("5.add passenger "); 
        System.out.println("6.Show all captains"); 
        System.out.println("7.Check if passenger has a ticket");
        System.out.println("8.Delete passenger"); 
        System.out.println("9.Check if the plane can fly");
        // System.out.println("----------------------------------");
        System.out.println("##################################");
        
        do {
            System.out.print("Enter your choise :");
            n=input.nextInt();
            System.out.println("*--------------------------------*");
            switch (n) {
                case 1:
                    System.out.print("Enter ticket ID: ");
                    o = input.next();
                    for (Passenger p : passengers) {
                        for (Ticket tic : p.getTickets()) {
                            if (o.equals(tic.getTicketID())) {
                                System.out.println(tic.toString());
                                System.out.println(p.toString());
                                break;
                            }
                        }
                    }
                    break;

                case 2:
                    for (Passenger p : passengers) {
                        System.out.println(p.toString());
                    }
                    break;

                case 3:
                    showAllTickets(passengers);
                    break;

                case 4:
                    System.out.println("Enter Plane Airbus or Boeing :");
                    System.out.println("#please wait for update Teacher T-T sorry");
                    o="sorry";
                    if(o.equalsIgnoreCase("airbus")){
    
                    }
                    if(o.equalsIgnoreCase("airbus")){
                        
                    }
                    break;

                case 5:
                    addPassenger(passengers, input);
                    break;

                case 6:
                    showAllCaptains(passengers);
                    break;

                case 7:
                    checkPassengerTicket(passengers, input);
                    break;

                case 8:
                    deletePassenger(passengers, input);
                    break;

                case 9:
                    if (plane1.canFly()) {
                        System.out.println("Plane " + plane1.planeID + " can fly.");
                    } else {
                        System.out.println("Plane " + plane1.planeID + " cannot fly because there is no captain on board.");
                    }
                    break;

                default:
                    System.out.println("plzz enter choise");
                    break;
            }
            System.out.println("_--------------------------------_");
            System.out.println("continue [y:n]");
            x = input.next().charAt(0);
           // input.nextLine(); 

        } while (x != 'n');

        input.close(); 

        
    }
    public static void addPassenger(ArrayList<Passenger> passengers, Scanner input) {
        System.out.println("Do you want to add a Captain or a Passenger? (Enter 'C' for Captain, 'P' for Passenger): ");
        char passengerType = input.next().charAt(0);

        System.out.print("Enter name: ");
        String name = input.next();

        System.out.print("Enter ID: ");
        String id = input.next();

        System.out.print("Is the passenger registered? (true/false): ");
        boolean registered = input.nextBoolean();

        System.out.print("Enter email: ");
        String email = input.next();

        ArrayList<Ticket> tickets = new ArrayList<>();  

        if (passengerType == 'C' || passengerType == 'c') {
            System.out.print("Enter years of experience: ");
            int experience = input.nextInt();

            Captain newCaptain = new Captain(name, id, registered, email, experience, tickets);
            passengers.add(newCaptain);  
            System.out.println("Captain added: " + newCaptain.toString());
        } else if (passengerType == 'P' || passengerType == 'p') {
            Passenger newPassenger = new Passenger(name, id, registered, email, tickets);
            passengers.add(newPassenger); 
            System.out.println("Passenger a4dded: " + newPassenger.toString());
        } else {
            System.out.println("Invalid input. Please enter 'C' for Captain or 'P' for Passenger.");
        }
    }

    public static void showAllTickets(ArrayList<Passenger> passengers) {
        for (Passenger passenger : passengers) {
            System.out.println("Passenger: " + passenger.name);
            for (Ticket ticket : passenger.getTickets()) {
                System.out.println(ticket.toString());
            }
            System.out.println("----------------------------------");
        }
    }

    public static void showAllCaptains(ArrayList<Passenger> passengers) {
        for (Passenger p : passengers) {
            if (p instanceof Captain) { 
                System.out.println(p.toString());
            }
        }
    }

    public static void checkPassengerTicket(ArrayList<Passenger> passengers, Scanner input) {
        System.out.print("Enter the passenger's ID: ");
        String passengerID = input.next();

        System.out.print("Enter the ticket ID to check: ");
        String ticketID = input.next();

        for (Passenger p : passengers) {
            if (p.id.equals(passengerID)) {
                if (p.hasTicket(ticketID)) {
                    System.out.println("Passenger " + p.name + " has the ticket: " + ticketID);
                } else {
                    System.out.println("Passenger " + p.name + " does not have the ticket: " + ticketID);
                }
                return;
            }
        }
        System.out.println("Passenger with ID " + passengerID + " not found.");
    }
    public static void deletePassenger(ArrayList<Passenger> passengers, Scanner input) {
        System.out.print("Enter the ID of the passenger to delete: ");
        String passengerID = input.next();

  
        boolean removed = false;
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).id.equals(passengerID)) {
                System.out.println("Passenger " + passengers.get(i).name + " has been deleted.");
                passengers.remove(i);  
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Passenger with ID " + passengerID + " not found.");
        }
    }
}
