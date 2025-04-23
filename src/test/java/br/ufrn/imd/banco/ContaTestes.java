package br.ufrn.imd.banco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ContaTestes {

    static Conta c1;
    static Conta c2;
    static Conta c3;
    static Conta c4;

    static double saldoC1;
    static double saldoC2;
    static double saldoC3;
    static double saldoC4;

    @BeforeAll
    static void setUp() {
        saldoC1 = 1000.0;
        saldoC2 = 2000.0;
        saldoC3 = 100.0;
        saldoC4 = 0.0;

        c1 = new Conta("1", saldoC1);
        c2 = new Conta("2", saldoC2);
        c3 = new Conta("3", saldoC3);
        c4 = new Conta("4", saldoC4);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 100.0, 200.0, 300.0, 400.0, 500.0})
    void deveTransferirCorretamente(double valor) throws OperacaoIlegalException {

        Assertions.assertDoesNotThrow(
                () -> c1.transferir(c2, valor)
        );

        Assertions.assertEquals(saldoC1 - valor, c1.getSaldo());
        Assertions.assertEquals(saldoC2 + valor, c2.getSaldo());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 100.0, 200.0, 300.0, 400.0, 500.0})
    void transferirDeveLancarOperacaoIlegalExceptionPorSaldoInsuficiente(double valor) throws OperacaoIlegalException {
        Assertions.assertThrows(
                OperacaoIlegalException.class,
                () -> c4.transferir(c3, valor)
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = { -100.0, -200.0, -300.0, -400.0, -500.0})
    void transferirDeveLancarOperacaoIlegalExceptionPorInputNegativo(double valor) throws OperacaoIlegalException {
        Assertions.assertThrows(
                OperacaoIlegalException.class,
                () -> c4.transferir(c3, valor)
        );
    }

}
