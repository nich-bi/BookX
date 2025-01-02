package org.project.logic.persistence;

import java.util.List;

public interface Dao<K, E> {
    E create(K id);
    E load(K id);
    void store(E entity);
    void delete(K id);
    boolean exists(K id);


    void store1(E entity);
    void delete1(E entity);
    List<E> loadAll();
    boolean exists1(K id);
}

