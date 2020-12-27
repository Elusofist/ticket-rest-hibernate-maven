package orm.hibernate.repository.adaptor;

import orm.hibernate.business.FlightService;
import orm.hibernate.repository.dto.TicketDto;
import orm.hibernate.repository.entity.Ticket;

import static orm.hibernate.repository.entity.Ticket.TicketBuilder.aTicket;

public class TicketDtoAdaptor extends TicketDto {
    private static TicketDtoAdaptor instance;

    public static TicketDtoAdaptor getInstance() {
        if (instance == null) {
            synchronized (TicketDtoAdaptor.class) {
                if (instance == null) {
                    instance = new TicketDtoAdaptor();
                }
            }
        }
        return instance;
    }

    private TicketDtoAdaptor() {
    }

    public Ticket toTicket(TicketDto ticketDto) {
        return aTicket().withFlight(FlightService.getInstance()
                .getFlightDao().read(ticketDto.getFlightNo()))
                .withOwnerName(ticketDto.getOwner()).build();
    }
}
