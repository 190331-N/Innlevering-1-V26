    package no.hvl.dat102.filmarkiv.klient;

    import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
    import no.hvl.dat102.filmarkiv.impl.Film;
    import no.hvl.dat102.filmarkiv.impl.Sjanger;


    public class Meny {

        private Tekstgrensesnitt tekstgr;
        private FilmarkivADT filmarkiv;

        public Meny(FilmarkivADT filmarkiv) {
            tekstgr = new Tekstgrensesnitt();
            this.filmarkiv = filmarkiv;
        }

        public void start() {
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
            }

            void skrivMeny() {
                System.out.println();
                System.out.println("====== FILMARKIV MENY ======");
                System.out.println("1) Legg til film");
                System.out.println("2) Skriv ut alle filmer");
                System.out.println("3) Søk i tittel (delstreng)");
                System.out.println("4) Søk på produsent");
                System.out.println("5) Slett film (filmnr)");
                System.out.println("0) Avslutt");
                System.out.println("============================");
            }
            private void lesfilm(){
                System.out.println("\n--- Legg til film ---");
                Film film = tekstgr.lesFilm();
                filmarkiv.leggTilFilm(film);
                System.out.println("Film lagt til.");
            }

            private void sokPaTittelDelstreng(){
                System.out.println("\n--- Søk i tittel (delstreng) ---");
                String delstreng = tekstgr.lesString("Skriv delstreng: ");
                Film[] treff = filmarkiv.finnFilmDelstrengITittel(delstreng);

                if (treff == null || treff.length == 0) {
                    System.out.println("Ingen treff.");
                    return;
                }
                System.out.println("Treff:");
                for (Film f : treff) {
                    if (f != null) {
                        tekstgr.skrivUtFilm(f);
                        System.out.println();
                    }
                }
            }
            private void sokPaProdusent () {
                System.out.println("\n--- Søk på produsent ---");
                String produsent = tekstgr.lesString("Skriv produsent: ");
                Film[] treff = filmarkiv.finnFilmerProdusent(produsent);

                if (treff == null || treff.length == 0) {
                    System.out.println("Ingen treff.");
                    return;
                }
                System.out.println("Treff:");
                for (Film f : treff) {
                    if (f != null) {
                        tekstgr.skrivUtFilm(f);
                        System.out.println();

                    }
                }
            }
        }
    }


