package orm.hibernate.facade;

import orm.hibernate.business.FlightService;
import orm.hibernate.business.TicketService;
import orm.hibernate.business.exception.BusinessException;
import orm.hibernate.repository.dao.exception.DatabaseException;
import orm.hibernate.repository.dto.TicketDto;
import orm.hibernate.repository.entity.Ticket;

import static orm.hibernate.repository.entity.Ticket.TicketBuilder.aTicket;

public class TicketFacade {
    private static FlightService flightService;
    private static TicketService ticketService;
    private static TicketFacade instance;

    public static TicketFacade getInstance() {
        if (instance == null) {
            synchronized (TicketFacade.class) {
                if (instance == null) {
                    instance = new TicketFacade();
                }
            }
        }
        setFlightService();
        setTicketService();
        return instance;
    }

    private TicketFacade() {
    }

    public FlightService getFlightService() {
        return flightService;
    }

    public static void setFlightService() {
        flightService = FlightService.getInstance();
    }

    public TicketService getTicketService() {
        return ticketService;
    }

    public static void setTicketService() {
        ticketService = TicketService.getInstance();
    }

    public Ticket buy(TicketDto ticket) {
        Ticket ticket1 = aTicket()
                .withOwnerName(ticket.getOwner())
                .withFlight(getFlightService()
                        .getFlight(ticket.getFlightNo()))
                .build();
        getTicketService().addNewTicket(ticket1);
        return ticket1;
    }

    public Ticket show(Integer ticketId) throws BusinessException {
        if (ticketId != null) {
            return getTicketService().getTicket(ticketId);
        }
        throw new BusinessException("Buy First!");
    }

    public void cancel(Ticket ticket) throws BusinessException, DatabaseException {
        if (ticket != null) {
            getTicketService().cancelTicket(ticket);
        } else {
            throw new BusinessException("Buy first!");
        }
    }

    public Ticket change(TicketDto newTic, Ticket currentTic) throws BusinessException {
        if (currentTic != null) {
            if (newTic.getFlightNo() != null) {
                currentTic.setFlight(FlightService.getInstance()
                        .getFlight(newTic.getFlightNo()));
            }
            if (newTic.getOwner() != null) {
                currentTic.setOwnerName(newTic.getOwner());
            }
            getTicketService().updateTicket(aTicket()
                    .withFlight(getFlightService()
                            .getFlight(currentTic.getFlight().getFlightNo()))
                    .withOwnerName(currentTic.getOwnerName())
                    .build());
            return currentTic;
        } else throw new BusinessException("Buy First!");
    }
}
