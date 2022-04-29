package com.mes.util;

import org.hibernate.boot.model.naming.IllegalIdentifierException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory entityManagerFactory;

    static {
        if(entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("mesTest");
            } catch (IllegalStateException e) {
                e.printStackTrace();
                close();
            }
        }
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    public static void close(){
        try {
            entityManagerFactory.close();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.out.println("--> connection close error");
        }
    }
}
