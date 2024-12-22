package org.project.logic.control;

import org.project.logic.bean.AnnuncioBean;
import org.project.logic.model.Annuncio;
import org.project.logic.model.Utente;
import org.project.logic.persistence.AnnuncioDao;
import org.project.logic.persistence.DaoFactory;
import java.util.ArrayList;
import java.util.List;


public class CompraLibroController {

    AnnuncioDao dao;
    List<Annuncio> r;

    public CompraLibroController() {
        dao = DaoFactory.getInstance().getAnnuncioDao();
        r = dao.loadAll();
    }


    public List<Annuncio> cercaAnnuncio(AnnuncioBean ab) {

        List<Annuncio> ricerca = new ArrayList<>();
        for(Annuncio a : r){
            if (a.getLibro().getTitolo().equalsIgnoreCase(ab.getTitoloLibro())){
                ricerca.add(a);
            }
        }
        return ricerca;
    }


    /*
    public List<Annuncio> cercaAnnuncio(AnnuncioBean ab) {

        List<Annuncio> ricerca = new ArrayList<>();
        for(Annuncio a : r){
            Libro l = a.getLibro();

            if (l.getTitolo().equalsIgnoreCase(ab.getTitoloLibro()) &&
                    (!ab.getCategoria().isEmpty()) && (l.getCategoria().equalsIgnoreCase(ab.getCategoria())) &&
                    (!ab.getCondizioni().isEmpty()) && l.getCondizioni().equalsIgnoreCase(ab.getCondizioni()) &&
                    (!ab.getIsbn().isEmpty()) && l.getIsbn().equalsIgnoreCase(ab.getIsbn()) )
            {
                ricerca.add(a);
            }
        }
        return ricerca;
    }
     */


    public boolean compraLibro(Annuncio a, Utente c) {
        System.out.println("Hai scelto " + a.getLibro().getTitolo() + " venduto da " + c.getEmail());
        return true;
    }



}

