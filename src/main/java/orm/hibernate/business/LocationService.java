package orm.hibernate.business;

import orm.hibernate.repository.dao.LocationDao;
import orm.hibernate.repository.dao.exception.DatabaseException;
import orm.hibernate.repository.entity.Location;

import java.util.List;

public class LocationService {
    private static LocationDao locationDao;
    private static LocationService instance;

    public static LocationService getInstance() {
        if(instance == null) {
            synchronized (LocationService.class) {
                if (instance == null) {
                    instance = new LocationService();
                }
            }
        }
        setLocationDao();
        return instance;
    }

    private LocationService() {
    }

    public LocationDao getLocationDao() {
        return locationDao;
    }

    public static void setLocationDao() {
        locationDao = LocationDao.getInstance();
    }

    public boolean addNewLocation(Location location) {
        return locationDao.create(location);
    }

    public boolean cancelLocation(Location location) throws DatabaseException {
        return locationDao.delete(location);
    }

    public boolean updateLocation(Location location) {
        return locationDao.update(location);
    }

    public Location getLocation(Integer locationId) {
        return locationDao.read(locationId);
    }

    public List<Location> getAllLocations() {
        return locationDao.selectAll();
    }

    public boolean cancelAllLocations() { return locationDao.deleteAll(); }
}
