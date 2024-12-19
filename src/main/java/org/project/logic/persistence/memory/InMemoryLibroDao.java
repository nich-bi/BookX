package org.project.logic.persistence.memory;

import org.project.logic.model.Libro;
import org.project.logic.persistence.LibroDao;
import java.util.ArrayList;
import java.util.List;


public class InMemoryLibroDao extends InMemoryDao<String, Libro>  implements LibroDao {

    private static InMemoryLibroDao instance;

    public static InMemoryLibroDao getInstance() {
        if(instance == null) {
            instance = new InMemoryLibroDao();
        }
        return instance;
    }

    public String getKey(Libro libro) {
        return libro.getIsbn();
    }

    public Libro create(String isbn){
        return new Libro(isbn);
    }


}
