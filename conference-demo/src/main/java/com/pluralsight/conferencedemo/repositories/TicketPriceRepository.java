package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.models.TicketPrice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TicketPriceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public TicketPrice create(TicketPrice tp) {
        entityManager.persist(tp);
        entityManager.flush();
        return tp;
    }

    public TicketPrice update(TicketPrice tp) {
        tp = entityManager.merge(tp);
        entityManager.flush();
        return tp;
    }

    public void delete(Long id) {
        entityManager.remove(find(id));
        entityManager.flush();
    }

    public TicketPrice find(Long id) {
        return entityManager.find(TicketPrice.class, id);
    }

    public List<TicketPrice> list() {
        return entityManager.createQuery("select t from TicketPrice t").getResultList();
    }
}
