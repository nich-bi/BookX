package org.project.logic.persistence;

import org.project.logic.model.Libro;

public interface LibroDao extends Dao<String, Libro>{

    Libro create(int ISBN);
}
