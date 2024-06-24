package dev.filipeabs.dao;

import java.util.List;

import dev.filipeabs.models.SecondDb;
import io.quarkus.hibernate.orm.PersistenceUnit;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RequestScoped
public class SecondDbDao {
    @Inject
    @PersistenceUnit("second")
    EntityManager em;

    public List<SecondDb> listAll() {
        String querySelectAll = "FROM SecondDb";
        return em.createQuery(querySelectAll, SecondDb.class)
                .getResultList();
    }

    @Transactional
    public void insert(String stringField) {
        SecondDb entityInsert = new SecondDb();
        entityInsert.field = stringField;
        em.persist(entityInsert);
    }
}