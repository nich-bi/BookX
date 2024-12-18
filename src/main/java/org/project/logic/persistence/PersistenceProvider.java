package org.project.logic.persistence;

import org.project.logic.persistence.memory.InMemoryDaoFactory;

public enum PersistenceProvider {

    IN_MEMORY("in memory", InMemoryDaoFactory.class);

    private final String name;
    private final Class<? extends DaoFactory> daoFactoryClass;

    PersistenceProvider(String name, Class<? extends DaoFactory> daoFactoryClass) {
        this.name = name;
        this.daoFactoryClass = daoFactoryClass;
    }

    public String getName() {
        return name;
    }

    public Class<? extends DaoFactory> getDaoFactoryClass() {
        return daoFactoryClass;
    }

}
