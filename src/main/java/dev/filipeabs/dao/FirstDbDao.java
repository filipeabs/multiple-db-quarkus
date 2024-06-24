package dev.filipeabs.dao;

import java.util.List;

import dev.filipeabs.models.FirstDb;
import io.quarkus.hibernate.orm.PersistenceUnit;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RequestScoped
public class FirstDbDao {
    @Inject
    @PersistenceUnit("first")
    EntityManager em;

    public List<FirstDb> listAll() {
        String querySelectAll = "FROM FirstDb";
        return em.createQuery(querySelectAll, FirstDb.class)
                .getResultList();
    }

    @Transactional
    public void insert(String stringField) {
        FirstDb entityInsert = new FirstDb();
        entityInsert.field = stringField;
        em.persist(entityInsert);
    }
}