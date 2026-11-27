package Modelo;

public class Terreno extends Financiamento {
    //atributos
    private int tipo_de_terreno;

    //constructor
    public Terreno (double valor_do_imovel, int prazo_financiamento_anos, double taxa_juros_anual, int tipo_de_terreno2) {
        super(valor_do_imovel, prazo_financiamento_anos, taxa_juros_anual);
        this.tipo_de_terreno = tipo_de_terreno2;
    }

    //metodos
    public int getTipo_de_terreno() {
        return this.tipo_de_terreno;
    }
    // Terreno tem acrescimo de 2% na parcela (risco maior de inadimplencia).
    // Usa 1.02 (double): a versao anterior usava 102 / 100, divisao inteira que resultava em 1.
    public double calcular_pagamento_mensal() {
        return super.calcular_pagamento_mensal() * 1.02;
    }

    @Override
    public String toString() {
        return super.toString() + "," + " Zona do terreno: " + tipo_de_terreno ;
    }
    
}