package org.project.logic;

import org.project.logic.persistence.DaoFactory;
import org.project.logic.persistence.PersistenceProvider;
import org.project.logic.view.CliLogin;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Driver {

    public static void main(String[] args) throws IOException {

        setPersistenceProvider("in memory");

        CliLogin login = new CliLogin();
        login.loginMenu();
    }


    private static void setPersistenceProvider(String provider) {
        for (PersistenceProvider p : PersistenceProvider.values()) {
            if (p.getName().equals(provider)) {
                try {
                    DaoFactory.setInstance(p.getDaoFactoryClass().getConstructor().newInstance());
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException
                         | IllegalAccessException e) {
                    throw new IllegalStateException("Invalid Provider");
                }
                return;
            }
        }
    }
}