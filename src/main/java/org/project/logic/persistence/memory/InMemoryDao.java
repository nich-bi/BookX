package org.project.logic.persistence.memory;

import org.project.logic.persistence.Dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InMemoryDao<K, V> implements Dao<K, V> {



    private final Map<K, V> memory = new HashMap<>();

    protected void store(K key, V value) {
        memory.put(key, value);
    }

    @Override
    public void delete(K id) {
        memory.remove(id);
    }

    @Override
    public boolean exists(K id) {
        return memory.containsKey(id);
    }

    @Override
    public V load(K id) {
        return memory.get(id);
    }

    @Override
    public void store(V entity) {
        K key = getKey(entity);
        store(key, entity);
    }

    protected abstract K getKey(V value);




    // MEMORIA CON LISTE:
    private final List<V> mem = new ArrayList<>();

    public void store1(V value) {
        mem.add(value);
    }

    // @Override
    public void delete1(V value){
        mem.remove(value);
    }

    // @Override
    public boolean exists1(V value) {
        return mem.contains(value);
    }


    public List<V> loadAll() {
        return mem;
    }

}
