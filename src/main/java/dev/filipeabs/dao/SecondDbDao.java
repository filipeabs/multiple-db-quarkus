package dev.filipeabs.dao;

import java.util.List;

import dev.filipeabs.models.ModelDb;
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

    public List<ModelDb> listAll() {
        String querySelectAll = "FROM ModelDb";
        return em.createQuery(querySelectAll, ModelDb.class)
                .getResultList();
    }

    @Transactional
    public void insert(String stringField) {
        ModelDb entityInsert = new ModelDb();
        entityInsert.field = stringField;
        em.persist(entityInsert);
    }
}