package org.project.logic.persistence.memory;

import org.project.logic.model.Annuncio;
import org.project.logic.model.Ordine;
import org.project.logic.persistence.OrdineDao;

public class InMemoryOrdineDao extends InMemoryDao<String, Ordine> implements OrdineDao {

    private static InMemoryOrdineDao instance;

    public static InMemoryOrdineDao getInstance() {
        if(instance == null) {
            instance = new InMemoryOrdineDao();
        }
        return instance;
    }


    public String getKey(Ordine o) {
        return o.getId();
    }


    public Ordine create(String id) {
        return new Ordine(id);
    }

}
