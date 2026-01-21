package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;
import java.util.Scanner;

public class Tekstgrensesnitt {

    Scanner in = new Scanner(System.in);

    public Film lesFilm(){
        System.out.println("Filmnr: ");
        int filmnr = in.nextInt();

        System.out.println("Produsent: ");
        String produsent = in.nextLine();

        System.out.println("Tittel: ");
        String tittel = in.nextLine();

        System.out.println("Lanserings ar: ");
        int utAr = in.nextInt();

        System.out.println("Sjanger: ");
        String s = in.nextLine();
        Sjanger sjanger = Sjanger.valueOf(s);

        System.out.println("Utgiver: ");
        String utgiver = in.nextLine();

        return new Film(filmnr, produsent, tittel, utAr, sjanger, utgiver);
    }

    public void skrivUtFilm(Film film) {
// TODO
    }
    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
// TODO
    }
    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
// TODO
    }
    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
// TODO
    }
// osv ... andre metoder
}

