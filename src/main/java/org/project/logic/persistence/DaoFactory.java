package org.project.logic.persistence;

public abstract class DaoFactory {
    private static DaoFactory instance = null;

    public static void setInstance(DaoFactory instance) {
        DaoFactory.instance = instance;
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public abstract UserDao getUserDao();
    // aggiungi altri Dao entity
}
