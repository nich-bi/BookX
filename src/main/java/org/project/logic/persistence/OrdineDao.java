package org.project.logic.persistence;

import org.project.logic.model.Ordine;

public interface OrdineDao extends Dao<String, Ordine> {

    Ordine create(String compratore);
}
