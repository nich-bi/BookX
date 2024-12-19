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

    /*
    // cerca libri per titolo dalla lista
    public List<Libro> load1(String titolo) {
        List<Libro> result = new ArrayList<>();
        for (Libro libro : mem) {
            if (libro.getTitolo().equalsIgnoreCase(titolo)) {
                result.add(libro);
            }
        }
        return result;
    }
    */

}
