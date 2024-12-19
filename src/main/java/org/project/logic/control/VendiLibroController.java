package org.project.logic.control;

import org.project.logic.bean.AnnuncioBean;
import org.project.logic.model.Annuncio;
import org.project.logic.model.Libro;
import org.project.logic.model.Utente;
import org.project.logic.persistence.AnnuncioDao;
import org.project.logic.persistence.DaoFactory;
import org.project.logic.persistence.LibroDao;


public class VendiLibroController {

    public VendiLibroController() {
    }

    public void creaAnnuncio(AnnuncioBean ab) {

        AnnuncioDao ad = DaoFactory.getInstance().getAnnuncioDao();
        LibroDao ld = DaoFactory.getInstance().getLibroDao();
        LoginController lc = LoginController.getInstance();

        Libro l = ld.create(ab.getIsbn());
        Annuncio a = ad.create(ab.getTitoloLibro());

        a.setPrice(ab.getPrezzo());
        l.setTitolo(ab.getTitoloLibro());
        l.setAutore(ab.getAutore());
        l.setCategoria(ab.getCategoria());

        Utente venditore =  (Utente) lc.getCurrentUser();
        a.setVenditore(venditore);

        ad.store(a);
        ld.store(l);
    }

}
