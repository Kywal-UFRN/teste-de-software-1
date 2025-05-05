package br.ufrn.imd.listas.exercicios02.questao16;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Questao16_DiffBetweenAssertThrowsAndExpected {

    // JUnit 5
    @org.junit.jupiter.api.Test
    public void shouldThrownNullPointerException() {
        String notTeste = "";

        assertThrows(NullPointerException.class, () -> {
            // Código que deve lançar a exceção
            String str = null;
            str.length(); // Isso lançará NullPointerException
        });

        assertEquals("teste", notTeste);
    }

    // JUnit 4
    @org.junit.Test(expected = NullPointerException.class)
    public void shouldThrownNullPointerException2() {
        String notTeste = "";

        // Código que deve lançar a exceção
        String str = null;
        str.length(); // Isso lançará NullPointerException

        assertEquals("teste", notTeste);
    }
}
