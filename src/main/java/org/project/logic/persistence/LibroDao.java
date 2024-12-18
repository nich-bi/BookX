package org.project.logic.persistence;

import org.project.logic.Model.Annuncio;
import org.project.logic.Model.Libro;

public interface LibroDao extends Dao<String, Libro>{

    Libro create(int ISBN);
}
