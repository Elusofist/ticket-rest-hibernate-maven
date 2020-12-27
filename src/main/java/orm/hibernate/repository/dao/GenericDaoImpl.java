package orm.hibernate.repository.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import orm.hibernate.repository.dao.exception.DatabaseException;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    private SessionFactory sf;
    private Class entityType;
    private String entityName;


    public GenericDaoImpl() {
        this.sf = DatabaseConnection.getSessionFactory();
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.entityType = (Class) pt.getActualTypeArguments()[0];
        this.entityName = entityType.getSimpleName();
    }

    @Override
    public boolean create(T t) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        boolean successfulCreate = session.contains(entityName, t);
        session.getTransaction().commit();
        session.close();
        return successfulCreate;
    }

    @Override
    public T read(PK id) {
        Session session = sf.openSession();
        session.beginTransaction();
        T t = (T) session.get(entityType, id);
        session.getTransaction().commit();
        session.close();
        return t;
    }

    @Override
    public boolean update(T t) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        boolean successfulUpdate = session.contains(entityName, t);
        session.getTransaction().commit();
        session.close();
        return successfulUpdate;
    }

    @Override
    public boolean delete(T t) throws DatabaseException {
        if (t == null) throw new DatabaseException("No such a field in database.");
        Session session = sf.openSession();
        session.beginTransaction();
        session.remove(t);
        boolean successfulDelete = !session.contains(entityName, t);
        session.getTransaction().commit();
        session.close();
        return successfulDelete;
    }

    @Override
    public List<T> selectAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from " + entityName);
        List list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public boolean deleteAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery("delete from " + entityName).executeUpdate();
        session.getTransaction().commit();
        session.close();
        return selectAll() == null
                || selectAll().size() == 0;
    }
}
