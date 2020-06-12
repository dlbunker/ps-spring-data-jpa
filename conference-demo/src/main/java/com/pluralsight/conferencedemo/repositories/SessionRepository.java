package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Session create(Session session) {
        entityManager.persist(session);
        entityManager.flush();
        return session;
    }

    public Session update(Session session) {
        session = entityManager.merge(session);
        entityManager.flush();
        return session;
    }

    public void delete(Long id) {
        entityManager.remove(find(id));
        entityManager.flush();
    }

    public Session find(Long id) {
        return entityManager.find(Session.class, id);
    }

    public List<Session> list() {
        return entityManager.createQuery("select s from Session s").getResultList();
    }

    public List<Session> getSessionsThatHaveName(String name) {
        List<Session> ses = entityManager
                .createQuery("select s from Session s where s.sessionName like :name")
                .setParameter("name", "%" + name + "%").getResultList();
        return ses;
    }
}
