package dev.filipeabs.services;

import java.util.ArrayList;
import java.util.List;

import dev.filipeabs.dao.FirstDbDao;
import dev.filipeabs.dao.SecondDbDao;
import dev.filipeabs.models.ModelDb;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DbService {
    @Inject
    FirstDbDao firstDbDao;

    @Inject
    SecondDbDao secondDbDao;

    public List<?> listarTodos(String stringDb) {
        switch (stringDb) {
            case "first":
                return firstDbDao.listAll();
            case "second":
                return secondDbDao.listAll();
            default:
                throw new UnsupportedOperationException("Unsatisfied assing values for method 'listarTodos'");
        }
    }

    public List<?> migrarUmDbParaOutroDb(String umDb, String paraOutroDb) {
        if (umDb.isEmpty() || paraOutroDb.isEmpty() || umDb.equals(paraOutroDb)) {
            throw new UnsupportedOperationException("Unsatisfied assing values for method 'migrarUmDbParaOutroDb'");
        }

        ArrayList<?> lista = (ArrayList<?>) listarTodos(umDb);
        for (Object item : (ArrayList<?>) lista) {
            inserir(paraOutroDb, ((ModelDb) item).field);
        }
        return listarTodos(paraOutroDb);
    }

    public void inserir(String stringDb, String insertItem) {
        switch (stringDb) {
            case "first":
                firstDbDao.insert(insertItem);
                break;
            case "second":
                secondDbDao.insert(insertItem);
                break;
            default:
                throw new UnsupportedOperationException("Unsatisfied assing values for method 'inserir'");
        }

    }
}
