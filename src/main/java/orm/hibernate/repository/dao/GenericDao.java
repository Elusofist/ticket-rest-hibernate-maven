package orm.hibernate.repository.dao;

import orm.hibernate.repository.dao.exception.DatabaseException;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
    boolean create(T t);

    T read(PK id);

    boolean update(T t);

    boolean delete(T t) throws DatabaseException;

    List<T> selectAll();

    boolean deleteAll();
}
