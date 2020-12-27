package orm.hibernate.repository.dao;

import orm.hibernate.repository.entity.Location;

public class LocationDao extends GenericDaoImpl<Location, Integer> {
    private static LocationDao instance;

    public static LocationDao getInstance() {
        if (instance == null) {
            synchronized (LocationDao.class) {
                if (instance == null) {
                    instance = new LocationDao();
                }
            }
        }
        return instance;
    }

    private LocationDao() {
    }
}
