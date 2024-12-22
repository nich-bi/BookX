package org.project.logic.control;

import org.project.logic.bean.AnnuncioBean;
import org.project.logic.model.Annuncio;
import org.project.logic.model.Libro;
import org.project.logic.model.Utente;
import org.project.logic.persistence.AnnuncioDao;
import org.project.logic.persistence.DaoFactory;
import org.project.logic.persistence.LibroDao;


public class VendiLibroController {

    AnnuncioDao ad;
    LibroDao ld;
    LoginController lc;

    public VendiLibroController() {
        ad = DaoFactory.getInstance().getAnnuncioDao();
        ld = DaoFactory.getInstance().getLibroDao();
        lc = LoginController.getInstance();
    }

    public void creaAnnuncio(AnnuncioBean ab) {

        Libro l = ld.create(ab.getIsbn());
        Annuncio a = ad.create(ab.getTitoloLibro());

        a.setPrice(ab.getPrezzo());
        l.setTitolo(ab.getTitoloLibro());
        l.setAutore(ab.getAutore());
        l.setCategoria(ab.getCategoria());
        l.setCondizioni(ab.getCondizioni());

        Utente venditore =  (Utente) lc.getCurrentUser();
        a.setVenditore(venditore);
        a.setLibro(l);

        // ad.store(a);
        // ld.store(l);

        ad.store1(a);
        ld.store1(l);

    }

}
