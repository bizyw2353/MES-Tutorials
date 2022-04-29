package com.mes.dao;


import com.mes.dto.UserDto;
import com.mes.entity.User;
import com.mes.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    }

    public List<E> findWithNamedQuery(String queryName, Map<String, Object> parameter) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);

        System.out.println("query => "+query);
        Set<Map.Entry<String, Object>> setParameter = parameter.entrySet();

        for (Map.Entry<String, Object> entry : setParameter) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        List<E> result = query.getResultList();
        System.out.println("로그인유저정보 : "+result);
        System.out.println("getClass() : "+result.getClass());
        entityManager.close();

        return result;
    }
}
