package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml")
            .build();
    private static final Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();
    private static final SessionFactory sessionfactory = meta.getSessionFactoryBuilder().build();
    public static SessionFactory getSessionfactory(){
        return sessionfactory;
    }

}
