package orm.hibernate.repository.dao;

import orm.hibernate.repository.entity.Flight;

public class FlightDao extends GenericDaoImpl<Flight, Integer> {
    private static FlightDao instance;

    public static FlightDao getInstance() {
        if (instance == null) {
            synchronized (FlightDao.class) {
                if (instance == null) {
                    instance = new FlightDao();
                }
            }
        }
        return instance;
    }

    private FlightDao() {
    }
}
