package com.musicmanagerssoftware.util;

import com.musicmanagerssoftware.base.*;

import com.musicmanagerssoftware.base.account.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Clase con utilidades de Hibernate
 * @author Alejandro Roda
 * @version 1.0
 * @since 12/11/2020
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    /**
     * Constructor
     */
    public HibernateUtil() {

    }

    /**
     * Crea la factoría de sesiones.
     */
    public static void buildSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Artista.class);
        configuration.addAnnotatedClass(Grupo.class);
        configuration.addAnnotatedClass(Cancion.class);
        configuration.addAnnotatedClass(Disco.class);
        configuration.addAnnotatedClass(Concierto.class);
        configuration.addAnnotatedClass(Gira.class);
        configuration.addAnnotatedClass(Sala.class);
        configuration.addAnnotatedClass(Reunion.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * Crea la factoría de sesiones de usuarios.
     */
    public static void buildSessionFactoryUser() {

        Configuration configuration = new Configuration();
        configuration.configure("hibernateUser.cfg.xml");

        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * Abre una nueva sesión
     */
    public static void openSession() {

        session = sessionFactory.openSession();
    }

    /**
     * Devuelve la sesión actual
     * @return
     */
    public static Session getCurrentSession() {

        if ((session == null) || (!session.isOpen()))
            openSession();

        return session;
    }

    /**
     * Cierra la sesión.
     */
    public static void closeSessionFactory() {

        if (session != null)
            session.close();

        if (sessionFactory != null)
            sessionFactory.close();
    }
}
