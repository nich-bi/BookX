package org.project.logic.control;

import org.project.logic.bean.AnnuncioBean;
import org.project.logic.model.Annuncio;
import org.project.logic.model.Libro;
import org.project.logic.model.Ordine;
import org.project.logic.model.Utente;
import org.project.logic.persistence.AnnuncioDao;
import org.project.logic.persistence.DaoFactory;
import org.project.logic.persistence.OrdineDao;
import org.project.logic.view.Printer;
import java.util.ArrayList;
import java.util.List;


public class CompraLibroController {

    AnnuncioDao ad;
    OrdineDao od;
    List<Annuncio> annunci;


    public CompraLibroController() {
        ad = DaoFactory.getInstance().getAnnuncioDao();
        od = DaoFactory.getInstance().getOrdineDao();
        annunci = ad.loadAll();  // TODO nel metodo?
    }


    public List<Annuncio> cercaAnnuncio(AnnuncioBean ab) {

        List<Annuncio> ricerca = new ArrayList<>();
        for(Annuncio a : annunci){
            if (a.getLibro().getTitolo().equalsIgnoreCase(ab.getTitoloLibro())){
                ricerca.add(a);
            }
        }
        return ricerca;
    }


    public List<Annuncio> cercaAnnuncioFiltered(AnnuncioBean ab) {

        List<Annuncio> ricerca = new ArrayList<>();

        for(Annuncio a : annunci){
            Libro l = a.getLibro();

            if ( (l.getTitolo().equalsIgnoreCase(ab.getTitoloLibro())) &&
                    (l.getCategoria().isEmpty() || l.getCategoria().equals(ab.getCategoria())) &&
                    (l.getCondizioni().isEmpty() || l.getCondizioni().equals(ab.getCondizioni()))
                    && (a.getPrice() >= ab.getRangePrezzo()[0] && a.getPrice() <= ab.getRangePrezzo()[1]))
            {

                    ricerca.add(a);
            }
        }
        return ricerca;
    }




    // TODO usare AnnuncioBean
    public boolean compraLibro(Annuncio a, Utente c) {
        Printer.printMsg("Hai scelto " + a.getLibro().getTitolo() + " venduto da " + c.getEmail());

        Ordine o = od.create(c.getEmail());
        o.setAnnuncio(a);

        // TODO elimina annuncio dalla lista degli annunci
        ad.delete1(a);
        Printer.printMsgln("Annuncio eliminato dalla lista");
        return true;
    }


    public List<Annuncio> listOrdiniUtente(Utente u) {
        Printer.printMsgln("");


        // TODO ritorna lista ordini di uno specifico utente
        return annunci;
    }


}

