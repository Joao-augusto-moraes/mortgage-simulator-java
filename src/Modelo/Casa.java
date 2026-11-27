package Modelo;

import Utilizar.AcrescimoMaiorQuejurosException;

public class Casa extends Financiamento {
    // atributos
    private double area_construida;
    private double tamanho_terreno;

    //constructor
    public Casa (double valor_do_imovel, int prazo_financiamento_anos, double taxa_juros_anual, double area_construida, double tamanho_terreno) {
        super(valor_do_imovel, prazo_financiamento_anos, taxa_juros_anual);
        this.area_construida = area_construida;
        this.tamanho_terreno = tamanho_terreno;
    }

    //metodos
    public double getArea_construida() {
        return this.area_construida;
    }
    public double getTamanho_terreno() {
        return this.tamanho_terreno;
    }

    public void acrescimoMaiorQueJuros(double valor_acrescimo, double valor_juros) throws AcrescimoMaiorQuejurosException {
        if (valor_acrescimo > valor_juros) {
            throw new AcrescimoMaiorQuejurosException ("---O VALOR DO JUROS É MENOR QUE DO ACRESCIMO---");
        }
    }

    // Casa paga um acrescimo fixo de R$ 80 por parcela (seguro obrigatorio).
    // Se o acrescimo for maior que os juros da primeira parcela, ele e limitado ao valor dos juros.
    public double calcular_pagamento_mensal() {
        double valor_acrescimo =  80;
        double valor_juros = this.valorImovel * this.taxa_mensal();
        try {
            acrescimoMaiorQueJuros (valor_acrescimo, valor_juros);
        } catch (AcrescimoMaiorQuejurosException excessao) {
            System.out.println("---ERRO: " + excessao.getMessage());
            valor_acrescimo = valor_juros;
        }
        return super.calcular_pagamento_mensal() + valor_acrescimo;
    }

    @Override
    public String toString() {
        return super.toString() + "," + " Area construida: " + area_construida + "," + " Area do terreno total: " + tamanho_terreno ;
    }
    
}