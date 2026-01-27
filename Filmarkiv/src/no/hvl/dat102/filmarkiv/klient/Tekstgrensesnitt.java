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
        in.nextLine();

        System.out.println("Produsent: ");
        String produsent = in.nextLine();

        System.out.println("Tittel: ");
        String tittel = in.nextLine();

        System.out.println("Lanserings ar: ");
        int utAr = in.nextInt();
        in.nextLine();

        Sjanger sjanger = null;

        while (sjanger == null) {
            System.out.print("Sjanger (");
            for (Sjanger sj : Sjanger.values()) {
                System.out.print(sj + " ");
            }
            System.out.println("): ");

            String s = in.nextLine();
            sjanger = Sjanger.finnSjanger(s);

            if (sjanger == null) {
                System.out.println("Ugyldig sjanger. Prøv igjen.");
            }
        }

        System.out.println("Utgiver: ");
        String utgiver = in.nextLine();

        return new Film(filmnr, produsent, tittel, utAr, sjanger, utgiver);
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] treff = arkiv.soekTittel(delstreng);

        for (Film film : treff) {
            System.out.println(film.toString());
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] treff = arkiv.soekProdusent(delstreng);

        for (Film film : treff) {
            System.out.println(film.toString());
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


