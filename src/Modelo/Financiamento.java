package Modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    //atributos
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    //construtor
    public Financiamento (double valor_do_imovel, int prazo_financiamento_anos, double taxa_juros_anual) {
        this.valorImovel = valor_do_imovel;
        this.prazoFinanciamento = prazo_financiamento_anos;
        this.taxaJurosAnual = taxa_juros_anual;
    }

    public double getValorImovel() {
        return this.valorImovel;
    }
    public double getTaxa_anual() {
        return this.taxaJurosAnual;
    }

    //metodos
        public double calcular_pagamento_mensal() {
            return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 100 / 12)) + 80;
        }
    
    public double calcular_total_pagamento() {
        return this.calcular_pagamento_mensal() * this.prazoFinanciamento * 12;
    }

    @Override
    public String toString() {
        return "Valor do imovel: " + valorImovel + ","  + " Taxa de juros anual: " + taxaJurosAnual + "," + "Prazo do financiamento: " + prazoFinanciamento + "," +  " Pagamento mensal: " + calcular_pagamento_mensal() + "," +  " Pagamento total:  " + calcular_total_pagamento() ;
    }

}