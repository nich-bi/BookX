package org.project.logic.model;

public class Acquisto {

    Annuncio annuncio;
    User compratore;

    public Acquisto(Annuncio annuncio, User compratore) {
        this.annuncio = annuncio;
        this.compratore = compratore;
    }

    public Annuncio getAnnuncio() {
        return annuncio;
    }

    public User getCompratore() {
        return compratore;
    }

    public void setAnnuncio(Annuncio annuncio) {
        this.annuncio = annuncio;
    }

    public void setCompratore(User compratore) {
        this.compratore = compratore;
    }

}
