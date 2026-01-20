package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

import java.util.Arrays;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmarkiv;
    private int antall;

    public Filmarkiv(int storrelse){
        filmarkiv = new Film[storrelse];
        antall = 0;
    }


    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getFilmnr() == nr){
                return filmarkiv[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (filmarkiv.length >= antall){
            filmarkiv = Arrays.copyOf(filmarkiv, filmarkiv.length*2);
        }
        filmarkiv[antall] = nyFilm;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getFilmnr() == filmnr){
                filmarkiv[i] = filmarkiv[antall-1];
                filmarkiv[antall-1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] resultat = new Film[antall];
        int funnet = 0;

        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getTittel().contains(delstreng)){
                resultat[funnet] = filmarkiv[i];
                funnet++;
            }
        }
        return Arrays.copyOf(resultat, funnet);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] resultat = new Film[antall];
        int funnet = 0;

        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getProdusent().contains(delstreng)) {
                resultat[funnet] = filmarkiv[i];
                funnet++;
            }
        }
        return Arrays.copyOf(resultat, funnet);
    }
    @Override
    public int antall(Sjanger sjanger) {
        int mengde = 0;
        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getSjanger() == sjanger){
                mengde++;
            }
        }
        return mengde;
    }

    @Override
    public int antall() {
        return antall;
    }
}
