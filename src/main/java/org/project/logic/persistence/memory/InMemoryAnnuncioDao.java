package org.project.logic.persistence.memory;

import org.project.logic.Model.Annuncio;
import org.project.logic.persistence.AnnuncioDao;

public class InMemoryAnnuncioDao extends InMemoryDao<String, Annuncio>  implements AnnuncioDao {

    private static InMemoryAnnuncioDao instance;

    public static InMemoryAnnuncioDao getInstance() {
        if(instance == null) {
            instance = new InMemoryAnnuncioDao();
        }
        return instance;
    }

    public String getKey(Annuncio annuncio) {
        return annuncio.getId();
    }

    public Annuncio create(String id){
        return new Annuncio(id);
    }
}
