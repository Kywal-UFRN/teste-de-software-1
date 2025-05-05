package br.ufrn.imd.listas.exercicios02.questao03;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilmeTest {

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
}
