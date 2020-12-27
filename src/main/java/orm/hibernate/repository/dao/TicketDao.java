package orm.hibernate.repository.dao;

import orm.hibernate.repository.entity.Ticket;

public class TicketDao extends GenericDaoImpl<Ticket, Integer> {
    private static TicketDao instance;

    public static TicketDao getInstance() {
        if (instance == null) {
            synchronized (TicketDao.class) {
                if (instance == null) {
                    instance = new TicketDao();
                }
            }
        }
        return instance;
    }

    private TicketDao() {
    }
}
