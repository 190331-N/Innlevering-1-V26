    package no.hvl.dat102.filmarkiv.klient;

    import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
    import no.hvl.dat102.filmarkiv.impl.Film;
    import no.hvl.dat102.filmarkiv.impl.Sjanger;
    import java.util.Scanner;


    public class Meny{

        private Tekstgrensesnitt tekst;
        private FilmarkivADT arkiv;

        public Meny(FilmarkivADT arkiv) {
            this.arkiv = arkiv;
            this.tekst = new Tekstgrensesnitt();
        }

        public void start() {
            leggInnTestdata();

            boolean fortsett = true;
            while (fortsett) {
                skrivMeny();
                int valg = tekst.lesInt("Velg: ");

                switch (valg) {
                    case 1:
                        Film film = tekst.lesFilm();
                        arkiv.leggTilFilm(film);
                        break;

                    case 3:
                        String delstreng = tekst.lesString("Delstreng i tittel: ");
                        Film[] treff = arkiv.finnFilmDelstrengITittel(delstreng);
                        tekst.skrivUtFilmer(treff);
                        break;

                    case 4:
                        arkiv.slettFilm(tekst.lesInt("Filmnr som skal slettes: "));
                        break;

                    case 0:
                        fortsett = false;
                        break;

                    default:
                        System.out.println("Ugyldig valg");
                }
            }
        }

        private void skrivMeny() {
            System.out.println();
            System.out.println("=== FILMARKIV ===");
            System.out.println("1: Legg til film");
            System.out.println("2: Skriv ut alle filmer");
            System.out.println("3: Søk på tittel");
            System.out.println("4: Slett film");
            System.out.println("0: Avslutt");
        }

        private void leggInnTestdata() {
            arkiv.leggTilFilm(new Film(1, "Nolan", "Inception", 2010, Sjanger.SCIFI));
            arkiv.leggTilFilm(new Film(2, "Wachowski", "The Matrix", 1999, Sjanger.SCIFI));
            arkiv.leggTilFilm(new Film(3, "Fincher", "Fight Club", 1999, Sjanger.DRAMA));
        }
    }


