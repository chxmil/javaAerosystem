package Air_plan;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    String name;
    String id;
    boolean registered;
    String email;
    List<Ticket> tickets;  

    public Passenger(String name, String id, boolean registered, String email, List<Ticket> tickets) {
        this.name = name;
        this.id = id;
        this.registered = registered;
        this.email = email;
        this.tickets = tickets;
    }

    public List<String> browseEvents() {
        return new ArrayList<>();
    }

    public List<String> searchEvents(String keyword) {
        return new ArrayList<>();
    }

    public void purchaseTicket(Ticket ticket) {
        this.tickets.add(ticket);  // Add the ticket to the list
        System.out.println("Ticket purchased: " + ticket.getTicketID());
    }

    public void cancelTicket(Ticket ticket) {
        this.tickets.remove(ticket); 
        System.out.println("Ticket canceled: " + ticket.getTicketID());
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }

    public String getID(){
        return this.id;
    }

    @Override
    public boolean hasTicket(String ticketID) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketID().equals(ticketID)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Registered: " + registered + ", Email: " + email + ", Tickets: " + tickets;
    }
}
