package br.ufrn.imd.listas.exercicios02.questao03;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilmeTest {

    private Filme menorFilme, maiorFilme;

    @Test
    public void testFilmeConstructor() throws FilmeNaoValidoException {
        assertDoesNotThrow(() -> {
            Filme filme = new Filme("Inception", 148.0, "Christopher Nolan");
        });

        assertThrows(FilmeNaoValidoException.class, () -> {
           Filme filme2 = new Filme("", 148.0, "Nolan");
        });

        assertThrows(FilmeNaoValidoException.class, () -> {
            Filme filme3 = new Filme("Inception", 44, "Nolan");
        });

        assertThrows(FilmeNaoValidoException.class, () -> {
            Filme filme4 = new Filme("Inception", 148.0, "");
        });
    }

    @Test
    public void testMenorFilme() throws FilmeNaoValidoException {

        assertDoesNotThrow(() -> {
            menorFilme = new Filme("Inception", 148.0, "Christpoher Nolan");
            maiorFilme = new Filme("Lord Of The Rings: The Return of the King", 201.0, "Peter Jackson");
        });

        assertEquals(menorFilme,menorFilme.menorFilme(maiorFilme));
        assertEquals(menorFilme,maiorFilme.menorFilme(menorFilme));

        assertThrows(FilmeNaoValidoException.class, () -> {
            menorFilme.menorFilme(menorFilme);
        });
    }

    @Test
    public void testEhMesmoDiretor() throws FilmeNaoValidoException {

        Filme filme1, filme2, filme3;

        filme1 = assertDoesNotThrow(() -> new Filme("Lord Of The Rings: The Return Of The King", 201.0, "Peter Jackson"));
        filme2 = assertDoesNotThrow(() -> new Filme("Lord Of The Rings: The Fellowship Of The Ring", 178.0, "Peter Jackson"));
        filme3 = assertDoesNotThrow(() -> new Filme("Interestelar", 169.0, "Christopher Nolan"));

        assertThrows(FilmeNaoValidoException.class, () -> {
           filme1.ehMesmoDiretor(filme1);
        });

        assertTrue(filme1.ehMesmoDiretor(filme2));
        assertTrue(filme2.ehMesmoDiretor(filme1));

        assertFalse(filme1.ehMesmoDiretor(filme3));
        assertFalse(filme2.ehMesmoDiretor(filme3));
    }
}
