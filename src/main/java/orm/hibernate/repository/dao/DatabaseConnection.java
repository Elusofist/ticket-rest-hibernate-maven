package orm.hibernate.repository.dao;

import org.hibernate.boot.registry.StandardServiceRegistry;
import orm.hibernate.repository.entity.Flight;
import orm.hibernate.repository.entity.Location;
import orm.hibernate.repository.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DatabaseConnection {
    private static SessionFactory sessionFactory;

//    private static SessionFactory sf= new Configuration().configure().buildSessionFactory();
//    public static SessionFactory getSessionFactory(){
//        return sf;
//    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/ticket");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "Elif6440");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Ticket.class);
                configuration.addAnnotatedClass(Flight.class);
                configuration.addAnnotatedClass(Location.class);

                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}