package org.project.logic.persistence;

public interface Dao<K, E> {
    E create(K id);
    E load(K id);
    void store(E entity);
    void delete(K id);
    boolean exists(K id);
}

