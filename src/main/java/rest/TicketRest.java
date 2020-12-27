package rest;

import orm.hibernate.business.FlightService;
import orm.hibernate.business.TicketService;
import orm.hibernate.repository.dao.exception.DatabaseException;
import orm.hibernate.repository.entity.Ticket;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tickets")
public class TicketRest {
    TicketService ticketService = TicketService.getInstance();
    FlightService flightService = FlightService.getInstance();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket getTicketById(@PathParam("id") int id) {
        System.out.println("get ticket by id " + "id is: " + id);
        System.out.println(ticketService.getTicket(id));
        return ticketService.getTicket(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addNewTicket(String owner, int flightNo) {
//        Ticket ticket = new Ticket();
//        ticket.setOwnerName(owner);
//        ticket.setFlight(flightService.getFlight(flightNo));
//        if (ticketService.addNewTicket(ticket))
//            return Response.ok().build();
//        return Response.notModified().build();
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewFood(Ticket ticket) {
        if (ticketService.addNewTicket(ticket))
            return Response.ok().build();
        return Response.notModified().build();
    }

//    @PUT
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateTicket(@PathParam("id") int id, String owner, int flightNo) {
//        Ticket ticket = new Ticket();
//        ticket.setTicketID(id);
//        ticket.setOwnerName(owner);
//        ticket.setFlight(flightService.getFlight(flightNo));
//        if (ticketService.updateTicket(ticket))
//            return Response.ok().build();
//        return Response.notModified().build();
//    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTicket(@PathParam("id") int id, Ticket ticket) {
        if (ticketService.updateTicket(ticket))
            return Response.ok().build();
        return Response.notModified().build();
    }

    @DELETE
    public Response deleteAllTickets() {
        if (ticketService.cancelAllTickets())
            return Response.ok().build();
        return Response.notModified().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTicketById(@PathParam("id") int id) {
        try {
            if (ticketService.cancelTicket(ticketService.getTicket(id)))
                return Response.ok().build();
        } catch (DatabaseException e) {
            return Response.notModified().entity(e.getMessage()).build();
        }
        return Response.notModified().build();
    }
}