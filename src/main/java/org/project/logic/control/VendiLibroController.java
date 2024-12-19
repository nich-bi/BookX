package org.project.logic.control;

import org.project.logic.bean.AnnuncioBean;
import org.project.logic.model.Annuncio;
import org.project.logic.model.Utente;
import org.project.logic.persistence.AnnuncioDao;
import org.project.logic.persistence.DaoFactory;

public class VendiLibroController {


    public VendiLibroController() {
    }

    public void creaAnnuncio(AnnuncioBean ab) {

        AnnuncioDao ad = DaoFactory.getInstance().getAnnuncioDao();
        LoginController lc = LoginController.getInstance();

        Annuncio a = ad.create(ab.getTitoloLibro());
        a.setPrice(ab.getPrezzo());

        Utente venditore =  (Utente) lc.getCurrentUser();
        a.setVenditore(venditore);
    }


}
