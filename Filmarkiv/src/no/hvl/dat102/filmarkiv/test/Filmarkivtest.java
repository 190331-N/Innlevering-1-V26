package no.hvl.dat102.filmarkiv.test;

import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv;
import no.hvl.dat102.filmarkiv.impl.Sjanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class Filmarkivtest {

    private Filmarkiv arkiv;
    private Film f1;
    private Film f2;
    private Film f3;

    @BeforeEach
    void setUp(){
        arkiv = new Filmarkiv(2);

        f1 = new Film(1, "Peter Jackson", "Ringenes herre", 2001, Sjanger.FANTASY, "New Line");
        f2 = new Film(2, "James Cameron", "Titanic", 1997, Sjanger.DRAMA, "Fox");
        f3 = new Film(3, "Gore Verbinski", "Pirates", 2003, Sjanger.EVENTYR, "Disney");

        arkiv.leggTilFilm(f1);
        arkiv.leggTilFilm(f2);
        arkiv.leggTilFilm(f3);

    }

    @Test
    void testAntall(){
        assertEquals(3, arkiv.antall());
    }

    @Test
    void testFinnFilm(){
        Film funnet = arkiv.finnFilm(2);
        assertNotNull(funnet);
        assertEquals("Pirates", funnet.getTittel());
    }

    @Test
    void testSlettFilm() {
        assertTrue(arkiv.slettFilm(2));
        assertEquals(2, arkiv.antall());
        assertNull(arkiv.finnFilm(2));
    }

    @Test
    void testSlettIkkeEksisterendeFilm() {
        assertFalse(arkiv.slettFilm(99));
        assertEquals(3, arkiv.antall());
    }


    @Test
    void testSoekTittel() {
        Film[] treff = arkiv.soekTittel("ring");
        assertEquals(1, treff.length);
        assertEquals("Ringenes herre", treff[0].getTittel());
    }

    @Test
    void testSoekProdusent() {
        Film[] treff = arkiv.soekProdusent("Peter");
        assertEquals(1, treff.length);
        assertEquals("Peter Jackson", treff[0].getProdusent());
    }

    @Test
    void testAntallSjanger() {
        assertEquals(1, arkiv.antall(Sjanger.FANTASY));
        assertEquals(1, arkiv.antall(Sjanger.DRAMA));
        assertEquals(1, arkiv.antall(Sjanger.EVENTYR));
    }
}
