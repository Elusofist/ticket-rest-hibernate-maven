package orm.hibernate.repository.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_no")
    private int flightNo;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Location.class)
    private Location source;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Location.class)
    private Location destination;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "flight_date")
    private Date flightDate;
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Ticket> tickets;

    public Flight() {
        tickets = new HashSet<>();
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNo=" + flightNo +
                ", source=" + source +
                ", destination=" + destination +
                ", flightDate=" + flightDate +
                '}';
    }


    public static final class FlightBuilder {
        private Location source;
        private Location destination;
        private Date flightDate;

        private FlightBuilder() {
        }

        public static FlightBuilder aFlight() {
            return new FlightBuilder();
        }

        public FlightBuilder withSource(Location source) {
            this.source = source;
            return this;
        }

        public FlightBuilder withDestination(Location destination) {
            this.destination = destination;
            return this;
        }

        public FlightBuilder withFlightDate(Date flightDate) {
            this.flightDate = flightDate;
            return this;
        }

        public Flight build() {
            Flight flight = new Flight();
            flight.setSource(source);
            flight.setDestination(destination);
            flight.setFlightDate(flightDate);
            return flight;
        }
    }
}