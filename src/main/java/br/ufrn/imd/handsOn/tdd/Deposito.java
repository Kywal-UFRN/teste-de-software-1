package br.ufrn.imd.handsOn.tdd;

public class Deposito {

    private String date;
    private double valor;

    public Deposito(String date, double valor) {
        this.date = date;
        this.valor = valor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }

    public double valor() {
        return valor;
    }
}
