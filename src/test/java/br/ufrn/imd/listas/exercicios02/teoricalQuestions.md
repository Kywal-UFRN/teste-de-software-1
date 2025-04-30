# Questões teóricas da segunda lista de exercícios
> LISTA_DE_EXERCICIOS_JUnit.pdf

---
### Questão 16
- a) O `asserThrows` permite a realização de outras verificações além da verificação do lançamento de exceção, 
enquanto o `@Test(expected=...)` já aprova o teste após o lançamento da exceção esperada.

- b) Para uma exceção do tipo NullPointerException, implementamos da seguinte forma:
```java
package br.ufrn.imd.listas.exercicios02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class diffBetweenAssertThrowsAndExpected {

    // JUnit 5
    @org.junit.jupiter.api.Test
    public void shouldThrownNullPointerException() {
        String notTeste = "";

        assertThrows(NullPointerException.class, () -> {
            // Código que deve lançar a exceção
            String str = null;
            str.length(); // Isso lançará NullPointerException
        });

        assertEquals("teste", notTeste); // Esse assert falhará
    }

    // JUnit 4
    @org.junit.Test(expected = NullPointerException.class)
    public void shouldThrownNullPointerException2() {
        String notTeste = "";

        // Código que deve lançar a exceção
        String str = null;
        str.length(); // Isso lançará NullPointerException

        assertEquals("teste", notTeste); // Esse assert será ignorado
    }
}
```
Nesse caso, o primeiro teste, que usa `assertThrows`, 
falhará já que a variável teste é diferente da string "teste", enquanto o segundo teste passará.


- c) Testes unitários são benéficos pois auxiliam no processo de redução da quantidade de erros em um sistema
e auxiliam na manutenção futura do software, já que muitos casos de uso já estão sendo previamente verificados
por esses testes
---
### Questão 17

- Alternativa b
---
### Questão 18
- Alternativa c
---
### Questão 19
- Porque a permissão de leitura do buffer precisa ser finaliza/fechada independentemente de uma exceção
ser lançada. Se o `buffRead.close()` estiver fora do bloco try/catch e fora do finally e uma exceção for
lançada o processo será interrompido e a conexão com o buffer continuará aberta, o que pode resultar
em vulnerabilidades ou mal gerenciamento de memória.
---
### Questão 22
- Alternativa d
---
### Questão 25
- I -> Verdade
- II -> Falso: Não é na classe e sim no método.
- III -> Verdade
- IV -> Falso: É necessário instanciar o objeto como atributo da classe e 
inicializar-lo em um método anotado com @BeforeEach para que a variável seja inicializada
antes de cada teste e o contexto individual dos testes não seja corrompido.