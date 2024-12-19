package org.project.logic.control;

import org.project.logic.bean.AnnuncioBean;
import org.project.logic.bean.LibroBean;
import org.project.logic.model.Annuncio;
import org.project.logic.model.Libro;
import org.project.logic.persistence.AnnuncioDao;
import org.project.logic.persistence.DaoFactory;
import org.project.logic.persistence.LibroDao;
import java.util.ArrayList;
import java.util.List;


public class CompraLibroController {

    public CompraLibroController() {
    }


    public List<Annuncio> cercaAnnuncio(AnnuncioBean ab) {
        AnnuncioDao dao = DaoFactory.getInstance().getAnnuncioDao();
        List<Annuncio> r = dao.loadAll();

        List<Annuncio> ricerca = new ArrayList<Annuncio>();
        for(Annuncio a : r){
            if (a.getLibro().getTitolo().equalsIgnoreCase(ab.getTitoloLibro())){
                ricerca.add(a);
            }
        }
        return ricerca;
    }



}
