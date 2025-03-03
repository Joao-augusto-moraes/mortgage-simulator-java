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
    public double calcular_pagamento_mensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 100 / 12))* (102 / 100);
    }

    @Override
    public String toString() {
        return super.toString() + "," + " Zona do terreno: " + tipo_de_terreno ;
    }
    
}