package org.project.logic.Control;

public class CompraLibroController {

    String titoloLibro;
    String categoria ;
    String condizioni;
    int[] rangePrezzi;

    public CompraLibroController(String titoloLibro, String categoria, String condizioni, int[] rangePrezzi) {
        this.titoloLibro = titoloLibro;
        this.categoria = categoria;
        this.condizioni = condizioni;
        this.rangePrezzi = rangePrezzi;
    }


}
