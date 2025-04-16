package br.ufrn.imd.parameterizedTesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static br.ufrn.imd.parameterizedTesting.CalculoImposto.calculaImpostoRenda;
import static org.junit.Assert.assertEquals;


/** Utilização de JUnit 4 para compreeensão da primeira versão
 * dos testes parametrizados
*/
 @RunWith(Parameterized.class)
public class CalculoImpostoTestes {

    @Parameter(1)
    public double salario;

    @Parameter(0)
    public double esperado;

    @Parameters
    public static Object[][] data() {
        
        double salario1 = 1100;         
        double salario2 = 4900;         
        double salario3 = 6000;
        double salario4 = 12000;
        
        
        return new Object[][] {
                {0, salario1},
                {0.1*salario2, salario2},
                {0.15*salario3,salario3},
                {0.2*salario4, salario4}
        };
    }

    @Test
    public void testCalculaImpostoRenda() {
        assertEquals(esperado, calculaImpostoRenda(salario), 0.0001f);
    }

}
