package br.ufrn.imd.parameterizedTesting;

public class CalculoImposto {

    /**
     * Este método calcula o imposto a ser pago baseado no valor de uma dado salário.
     * Se  1201 <= salario <= 5000 deve pagar 10% de imposto
     * Se  5001 <= salario <= 10000 deve pagar 15% de imposto
     * Se  salario > 10000 deve pagar 20% de imposto
     * Se  salario < 1201 deve pagar 0% de imposto
     *
     * @param salario valor do salario
     */
    public static double calculaImpostoRenda(double salario) {
        //Declaração de Variáveis
        double imposto;
        double impostoTotal;
        String porcento;

        if (salario >= 1201 && salario <= 5000) {
            imposto = 1.1;
            porcento = "10%";
            impostoTotal = 0.1;
        } else if(salario >= 5001 && salario <= 10000){
            imposto = 1.15;
            porcento = "15%";
            impostoTotal = 0.15;
        } else{
            imposto = 1.2;
            porcento = "20%";
            impostoTotal = 0.2;
        }

        double resultado = salario*impostoTotal;

        //Saída de dados
        System.out.println("Valor em Dinheiro: R$" + resultado);

        return resultado;
    }
}
