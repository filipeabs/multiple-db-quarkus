package dev.filipeabs.services;

import dev.filipeabs.dao.FirstDbDao;
import dev.filipeabs.dao.SecondDbDao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DbService {
    @Inject
    FirstDbDao firstDbDao;

    @Inject
    SecondDbDao secondDbDao;

    public Object listarTodos(String stringDb) {
        switch (stringDb) {
            case "first":
                return firstDbDao.listAll();
            case "second":
                return secondDbDao.listAll();
            default:
                throw new UnsupportedOperationException("Unsatisfied assing values for method 'listarTodos'");
        }
    }

    public Object migrarUmDbParaOutroDb(String umDb, String paraOutroDb) {
        // TODO Auto-generated method stuU
        if (umDb.isEmpty() || paraOutroDb.isEmpty() || umDb.equals(paraOutroDb)) {
            throw new UnsupportedOperationException("Unsatisfied assing values for method 'migrarUmDbParaOutroDb'");
        }

        throw new UnsupportedOperationException("Unimplemented method 'migrarUmDbParaOutroDb'");
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
