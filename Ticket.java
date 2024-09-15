package Air_plan;

public class Ticket {
    private String ticketID;
    private double price;
    private String seatNumber;
    private String gate;

    public Ticket(String ticketID, double price, String seatNumber, String gate) {
        this.ticketID = ticketID;
        this.price = price;
        this.seatNumber = seatNumber;
        this.gate = gate;
    }
    public String getTicketID() {
        return ticketID;
    }

    public double getPrice() {
        return price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getGate() {
        return gate;
    }

    public String toString(){
        return " Ticket:"+ticketID + "  Price:"+price+"  seat:"+seatNumber+"  Gate:"+gate;
    }
}

