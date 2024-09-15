
package Air_plan;

import java.util.List;

public class Captain extends Passenger {
    protected int exp;  
    public Captain(String name, String id, boolean registered, String email, int exp, List<Ticket> tickets) {
        super(name, id, registered, email, tickets);
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Captain: " + name + ", ID: " + id + ", Registered: " + registered + ", Email: " + email + ", Experience: " + exp + " flight hours";
    }
}
