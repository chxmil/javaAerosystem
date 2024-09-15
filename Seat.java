package Air_plan;
public class Seat {
    protected String seatNumber;
    protected String planeID;
    protected boolean isAvailable;

    public void bookSeat() {
        this.isAvailable = false;
        System.out.println("Seat " + seatNumber + " has been booked.");
    }

    public void releaseSeat() {
        this.isAvailable = true;
        System.out.println("Seat " + seatNumber + " has been released.");
    }

}


