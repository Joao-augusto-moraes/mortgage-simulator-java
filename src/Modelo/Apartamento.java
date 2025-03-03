package Modelo;

public class Apartamento extends Financiamento {
    //atributos
    private int numero_de_vagas_garagem;
    private int numero_andar;

    //constructor
    public Apartamento (double valor_do_imovel, int prazo_financiamento_anos, double taxa_juros_anual, int numero_de_vagas_garagem, int numero_andar) {
        super(valor_do_imovel, prazo_financiamento_anos, taxa_juros_anual);
        this.numero_de_vagas_garagem = numero_de_vagas_garagem;
        this.numero_andar = numero_andar;
    }

    //metodos
    public double getNumero_de_vagas_garagem() {
        return this.numero_de_vagas_garagem;
    }
    public double getNumero_andar() {
        return this.numero_andar;
    }

    public double getCalcular_taxa_mensal() {
        return calcular_taxa_mensal();
    }

    public double calcular_pagamento_mensal() {
        return  (this.valorImovel * (1 + this.calcular_taxa_mensal() + Math.pow(this.prazo_meses(), 1)) / (1 + this.calcular_taxa_mensal()) + Math.pow(prazo_meses() - 1, 1));
    }
    public double calcular_taxa_mensal() {
        return (this.taxaJurosAnual / 12);
    }
    public int prazo_meses() {
        return (this.prazoFinanciamento * 12);
    }

    @Override
    public String toString() {
        return super.toString() + "," + " Qual andar: " + numero_andar + "," + " Numero de vagas: " + numero_de_vagas_garagem ;
    }
}