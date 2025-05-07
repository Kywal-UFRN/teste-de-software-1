package br.ufrn.imd.handsOn.tdd;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {

    private String owner;
    private double saldo;
    private double saldoInicial;
    private final List<Deposito> transacoes = new ArrayList<>();

    public ContaCorrente() {}

    public ContaCorrente(String owner) {
        this.owner = owner;
    }

    public ContaCorrente(double saldo) {
        this.saldoInicial = saldo;
        this.saldo = saldo;
    }

    public ContaCorrente(String owner, double saldo) {
        this.owner = owner;
        this.saldoInicial = saldo;
        this.saldo = saldo;
    }

    public void creditar(Deposito deposito) {
        this.saldo += deposito.valor();
        transacoes.add(deposito);
    }

    public String extrato() {
        String extrato =
                "Conta de " + owner + "\n" +
                "Saldo Inicial $" + (int) saldoInicial + "\n" +
                "Saldo Final $" + (int) saldo + "\n";

        StringBuilder extratoBuilder = new StringBuilder(extrato);

        if (transacoes.isEmpty())
            extratoBuilder
                    .append("Nenhuma transacao realizada\n");
        else {
            for (Deposito d: transacoes) {
                extratoBuilder
                        .append(d.getDate())
                        .append("\tDeposito\t")
                        .append("$")
                        .append((int) d.valor())
                        .append("\n");
            }
        }

        return extratoBuilder.toString();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double saldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
