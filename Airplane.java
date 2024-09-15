package Air_plan;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
    protected String planeID;
    protected int seat;    
    protected int litre;
    protected int maxSpeed;
    protected int destination;
    protected int origin;
    protected int distant;
    protected int fuelRate;

    private List<Passenger> passengers; 

    public Airplane(String planeID, int seat, int litre, int maxSpeed, int destination, int origin, int distant, int fuelRate) {
        this.planeID = planeID;
        this.seat = seat;
        this.litre = litre;
        this.maxSpeed = maxSpeed;
        this.destination = destination;
        this.origin = origin;
        this.distant = distant;
        this.fuelRate = fuelRate;
        this.passengers = new ArrayList<>();  
    }


    public boolean checkAvailability() {
        return passengers.size() < seat;  
    }

    public List<Seat> listAvailableSeats() {

        return new ArrayList<>();
    }

    public int oilCal() {
        return distant * fuelRate;
    }

    public boolean addPassenger(Passenger passenger) {
        if (checkAvailability()) {
            passengers.add(passenger);  
            System.out.println("Passenger " + passenger.name + " added to plane " + planeID);
            return true;
        } else {
            System.out.println("No available seats on plane " + planeID);
            return false;
        }
    }

    // public boolean canFly() {
    //     for (Passenger passenger : passengers) {
    //         if (passenger instanceof Captain) {
    //             return true; 
    //         }
    //     }
    //     return false;  
    // }
    public boolean canFly() {
        for (Passenger p : passengers) {
                if(p.getID().equals("001")){
                    return true; 
                }
                System.out.println("Has no cap");
        } 
        System.out.println("Has no cap1");
        return false; 
    }
    


    public List<Passenger> getPassengers() {
        return passengers;
    }

    public String getPlaneID() {
        return planeID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getLitre() {
        return litre;
    }

    public void setLitre(int litre) {
        this.litre = litre;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDistant() {
        return distant;
    }

    public void setDistant(int distant) {
        this.distant = distant;
    }

    public int getFuelRate() {
        return fuelRate;
    }

    public void setFuelRate(int fuelRate) {
        this.fuelRate = fuelRate;
    }
}
