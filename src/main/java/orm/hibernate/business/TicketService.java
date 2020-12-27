package orm.hibernate.business;

import orm.hibernate.repository.dao.TicketDao;
import orm.hibernate.repository.dao.exception.DatabaseException;
import orm.hibernate.repository.entity.Ticket;

import java.util.List;

public class TicketService {
    private static TicketDao ticketDao;
    private static TicketService instance;

    public static TicketService getInstance() {
        if (instance == null) {
            synchronized (TicketService.class) {
                if (instance == null) {
                    instance = new TicketService();
                }
            }
        }
        setTicketDao();
        return instance;
    }

    private TicketService() {
    }

    public TicketDao getTicketDao() {
        return ticketDao;
    }

    public static void setTicketDao() {
        ticketDao = TicketDao.getInstance();
    }

    public boolean addNewTicket(Ticket ticket) {
        return ticketDao.create(ticket);
    }

    public boolean cancelTicket(Ticket ticket) throws DatabaseException {
        return ticketDao.delete(ticket);
    }

    public boolean updateTicket(Ticket ticket) {
        return ticketDao.update(ticket);
    }

    public Ticket getTicket(Integer ticketId) {
        Ticket ticket = ticketDao.read(ticketId);
        System.out.println(ticket.toString());
        return ticketDao.read(ticketId);
    }

    public List<Ticket> getAllTickets() {
        return ticketDao.selectAll();
    }

    public boolean cancelAllTickets() {
        return ticketDao.deleteAll();
    }
}
