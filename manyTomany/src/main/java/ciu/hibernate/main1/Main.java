package ciu.hibernate.main1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ciu.hibernate.Curso;
import ciu.hibernate.Estudiante;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Estudiante.class);
        configuration.addAnnotatedClass(Curso.class); 
        
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Curso curso1 = new Curso(001, "funcional");
        Curso curso2 = new Curso(002, "concurrencia");
        
        Estudiante estudiante1 = new Estudiante(100, "Pepe", curso1);
        Estudiante estudiante2 = new Estudiante(101, "Pepita", curso2);
        
        
        session.save(curso1);
        session.save(curso2);
        
        session.save(estudiante1);
        session.save(estudiante2);
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
