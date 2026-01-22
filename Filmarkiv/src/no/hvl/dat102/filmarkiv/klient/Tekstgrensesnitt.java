package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;
import java.util.Scanner;

public class Tekstgrensesnitt {

    Scanner in = new Scanner(System.in);

    public Film lesFilm() {
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
        System.out.println("FilmNr:        " + film.getFilmnr());
        System.out.println("Produsent:     " + film.getProdusent());
        System.out.println("Tittel:        " + film.getTittel());
        System.out.println("Lanserings år: " + film.getUtAr());
        System.out.println("Sjanger:       " + film.getSjanger());
        System.out.println("Utgiver:       " + film.getUtgiver());
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] treff = arkiv.soekTittel(delstreng);

        for (Film film : treff) {
            System.out.println(film);
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] treff = arkiv.soekProdusent(delstreng);

        for (Film film : treff) {
            System.out.println(film);
        }
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Statistikk over filmarkivet:");
        System.out.println("Totalt antall filmer: " + arkiv.antall());
        System.out.println();

        for (Sjanger s : Sjanger.values()) {
            System.out.println(s + ": " + arkiv.antall(s));
        }
    }
}


