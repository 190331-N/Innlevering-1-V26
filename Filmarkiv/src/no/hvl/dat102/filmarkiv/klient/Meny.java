package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;


public class Meny {

    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
        leggInnTestdata();

        boolean fortsett = true;
        while (fortsett) {
            skrivMeny();
            int valg = tekstgr.lesInt("Velg: ");

            switch (valg) {
                case 1:
                    lesFilm();
                    break;
                case 2:
                    skrivUtFilmDelstrengITittel();
                    break;
                case 3:
                    skrivUtFilmProdusent();
                    break;
                case 4:
                    skrivUtStatistikk;
                    break;
                default:
                    System.out.println("Ugyldig valg. Prøv igjen");
                    break;
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            int valg = tekstgr.lesInt("velg: ");
        }



// TODO
    }
}
