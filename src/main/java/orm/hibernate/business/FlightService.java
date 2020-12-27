package orm.hibernate.business;

import orm.hibernate.repository.dao.FlightDao;
import orm.hibernate.repository.dao.exception.DatabaseException;
import orm.hibernate.repository.entity.Flight;

import java.util.List;

public class FlightService {
    private static FlightDao flightDao;
    private static FlightService instance;

    public static FlightService getInstance() {
        if (instance == null) {
            synchronized (FlightService.class) {
                if (instance == null) {
                    instance = new FlightService();
                }
            }
        }
        setFlightDao();
        return instance;
    }

    private FlightService() {
    }

    public FlightDao getFlightDao() {
        return flightDao;
    }

    public static void setFlightDao() {
        flightDao = FlightDao.getInstance();
    }

    public boolean addNewFlight(Flight flight) {
        return flightDao.create(flight);
    }

    public boolean cancelFlight(Flight flight) throws DatabaseException {
        return flightDao.delete(flight);
    }

    public boolean updateFlight(Flight flight) {
        return flightDao.update(flight);
    }

    public Flight getFlight(Integer flightNo) {
        return flightDao.read(flightNo);
    }

    public List<Flight> getAllFlights() {
        return flightDao.selectAll();
    }

    public boolean cancelAllFlights() {
        return flightDao.deleteAll();
    }
}
