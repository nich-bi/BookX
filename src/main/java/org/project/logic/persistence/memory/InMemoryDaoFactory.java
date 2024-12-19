package org.project.logic.persistence.memory;

import org.project.logic.persistence.AnnuncioDao;
import org.project.logic.persistence.DaoFactory;

public class InMemoryDaoFactory extends DaoFactory {

    public InMemoryUserDao getUserDao() {
        return InMemoryUserDao.getInstance();
    }

    public AnnuncioDao getAnnuncioDao() {
        return InMemoryAnnuncioDao.getInstance();
    }

}
