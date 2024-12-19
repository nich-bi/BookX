package org.project.logic.persistence;

import org.project.logic.model.Annuncio;

public interface AnnuncioDao extends Dao<String, Annuncio>{

    Annuncio create(String id);
}
