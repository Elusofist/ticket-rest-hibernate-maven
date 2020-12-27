package orm.hibernate.controller;

import orm.hibernate.business.FlightService;
import orm.hibernate.business.LocationService;
import orm.hibernate.business.TicketService;
import orm.hibernate.repository.entity.Flight;
import orm.hibernate.repository.entity.Location;
import orm.hibernate.repository.entity.Ticket;

import java.util.Date;

import static orm.hibernate.repository.entity.Flight.FlightBuilder.aFlight;
import static orm.hibernate.repository.entity.Location.LocationBuilder.aLocation;
import static orm.hibernate.repository.entity.Ticket.TicketBuilder.aTicket;

public class Main {
    public static void main(String[] args) {
        LocationService locationService = LocationService.getInstance();
        FlightService flightService = FlightService.getInstance();
        TicketService ticketService = TicketService.getInstance();

        Location tehran = aLocation()
                .withCityName("Tehran")
                .withX(100)
                .withY(205)
                .build();
        locationService.addNewLocation(tehran);

        Location tabriz = aLocation()
                .withCityName("Tabriz")
                .withX(50)
                .withY(400)
                .build();
        locationService.addNewLocation(tabriz);

        Location isfahan = aLocation()
                .withCityName("Isfahan")
                .withX(105)
                .withY(100)
                .build();
        locationService.addNewLocation(isfahan);

        Location uremia = aLocation()
                .withCityName("Uremia")
                .withX(40)
                .withY(400)
                .build();
        locationService.addNewLocation(uremia);

        Location shiraz = aLocation()
                .withCityName("Shiraz")
                .withX(70)
                .withY(50)
                .build();
        locationService.addNewLocation(shiraz);

        Location mashhad = aLocation()
                .withCityName("Mashhad")
                .withY(200)
                .withY(300)
                .build();
        locationService.addNewLocation(mashhad);

        Location yazd = aLocation()
                .withCityName("Yazd")
                .withX(120)
                .withY(100)
                .build();
        locationService.addNewLocation(yazd);

        Location khoozestan = aLocation()
                .withCityName("Khoozestan")
                .withX(60)
                .withY(30)
                .build();
        locationService.addNewLocation(khoozestan);

        Flight flight1 = aFlight()
                .withSource(tehran)
                .withDestination(tabriz)
                .withFlightDate(new Date(1399, 9, 29))
                .build();
        flightService.addNewFlight(flight1);

        Flight flight2 = aFlight()
                .withSource(tehran)
                .withDestination(uremia)
                .withFlightDate(new Date(1399, 9, 25))
                .build();
        flightService.addNewFlight(flight2);

        Flight flight3 = aFlight()
                .withSource(tabriz)
                .withDestination(mashhad)
                .withFlightDate(new Date(1399, 9, 15))
                .build();
        flightService.addNewFlight(flight3);

        Flight flight4 = aFlight()
                .withSource(isfahan)
                .withDestination(khoozestan)
                .withFlightDate(new Date(1399, 9, 20))
                .build();
        flightService.addNewFlight(flight4);

        Flight flight5 = aFlight()
                .withSource(yazd)
                .withDestination(shiraz)
                .withFlightDate(new Date(1399, 10, 1))
                .build();
        flightService.addNewFlight(flight5);

        Ticket niktaTic = aTicket()
                .withOwnerName("Nikta")
                .withFlight(flight2)
                .build();
        ticketService.addNewTicket(niktaTic);

        Ticket shabiTic = aTicket()
                .withOwnerName("Shabi")
                .withFlight(flight3)
                .build();
        ticketService.addNewTicket(shabiTic);

        Ticket negarinTic = aTicket()
                .withOwnerName("Negarin")
                .withFlight(flight1)
                .build();
        ticketService.addNewTicket(negarinTic);

        Ticket yaqubTic = aTicket()
                .withOwnerName("Yaqub")
                .withFlight(flight2)
                .build();
        ticketService.addNewTicket(yaqubTic);

        Ticket baharTic = aTicket()
                .withOwnerName("Bahar")
                .withFlight(flight4)
                .build();
        ticketService.addNewTicket(baharTic);

        Ticket kooranTic = aTicket()
                .withOwnerName("Kooran")
                .withFlight(flight4)
                .build();
        ticketService.addNewTicket(kooranTic);

        Ticket tavakTic = aTicket()
                .withOwnerName("Tavak")
                .withFlight(flight5)
                .build();
        ticketService.addNewTicket(tavakTic);

        Ticket zahraTic = aTicket()
                .withOwnerName("Zahra")
                .withFlight(flight5)
                .build();
        ticketService.addNewTicket(zahraTic);
    }
}
