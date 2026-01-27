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

            Scanner in = new Scanner(System.in);

            boolean fortsett = true;
            while (fortsett) {
                skrivMeny();
                int valg = in.nextInt();
                in.nextLine();

                switch (valg) {
                    case 1:
                        Film nyFilm = tekst.lesFilm();
                        arkiv.leggTilFilm(nyFilm);
                        break;

                    case 2:
                        System.out.print("Delstreng i tittel: ");
                        String tittelDelstreng = in.nextLine();
                        tekst.skrivUtFilmDelstrengITittel(arkiv, tittelDelstreng);
                        break;

                    case 3:
                        System.out.print("Delstreng i produsent: ");
                        String produsentDelstreg = in.nextLine();
                        tekst.skrivUtFilmProdusent(arkiv, produsentDelstreg);
                        break;

                    case 4:
                        tekst.skrivUtStatistikk(arkiv);
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
            System.out.println("2: Søk på tittel");
            System.out.println("3: Søk på produsent");
            System.out.println("4: Statistikk");
            System.out.println("0: Avslutt");
            System.out.println();
        }

        private void leggInnTestdata() {
            arkiv.leggTilFilm(new Film(1, "Peter Jackson", "Ringenes herre", 2001, Sjanger.FANTASY, "New Line Cinema"));
            arkiv.leggTilFilm(new Film(2, "James Cameron", "Titanic", 1997, Sjanger.DRAMA, "Fox"));
            arkiv.leggTilFilm(new Film(3, "Gore Verbinski", "Pirates", 2003, Sjanger.EVENTYR, "Disney"));
        }
    }



