package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmarkiv;
    private int antall;

    public Filmarkiv(int storrelse){
        filmarkiv = new Film[storrelse];
        antall = 0;
    }


    @Override
    public Film finnFilm(int nr) {
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {

    }

    @Override
    public boolean slettFilm(int filmnr) {
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        return new Film[0];
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        return new Film[0];
    }

    @Override
    public int antall(Sjanger sjanger) {
        return 0;
    }

    @Override
    public int antall() {
        return 0;
    }
}
