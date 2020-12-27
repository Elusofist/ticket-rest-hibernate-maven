package orm.hibernate.repository.entity;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tic_id")
    private int ticketID;
    @Column(name = "owner")
    private String ownerName;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Flight.class)
    private Flight flight;

    public Ticket() {
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", ownerName='" + ownerName + '\'' +
                ", flightNo=" + flight +
                '}';
    }


    public static final class TicketBuilder {
        private String ownerName;
        private Flight flight;

        private TicketBuilder() {
        }

        public static TicketBuilder aTicket() {
            return new TicketBuilder();
        }

        public TicketBuilder withOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public TicketBuilder withFlight(Flight flight) {
            this.flight = flight;
            return this;
        }

        public Ticket build() {
            Ticket ticket = new Ticket();
            ticket.setOwnerName(ownerName);
            ticket.setFlight(flight);
            return ticket;
        }
    }
}
