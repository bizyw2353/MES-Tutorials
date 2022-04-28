package com.mes.dao;


import com.mes.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpaDao<E> {
    EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

    public E create(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        return entity;
    }

    public E find(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        E entity = entityManager.find(type, id);
        if (entity == null) {
            return null;
        }
        entityManager.close();
        return entity;

    }

    protected E update(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        return entity;
    }

    protected void delete(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Object reference = entityManager.getReference(type, id);
            entityManager.remove(reference);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    public List<E> findWithNamedQuery(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        List<E> result = query.getResultList();
        return result;
     /*   try {
            Query query = entityManager.createNamedQuery(queryName);
            List<E> result = query.getResultList();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.close();
        }
        entityManager.close();
        return null;
*/
    }
}
