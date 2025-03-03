//ALUNO JOÃO AUGUSTO MORAES SANTANA;
// FUNDAMENTOS DA PROGRAMAÇÃO ORIENTADA A OBJETOS
package Main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.Locale;
import Modelo.Apartamento;
import Modelo.Casa;
import Modelo.Financiamento;
import Modelo.Terreno;
import Utilizar.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //iniciamento da classe Main com as listas e os loops para iteração
    @SuppressWarnings("deprecation")
    public static void main (String[] args){

        Locale localeBR = new Locale("pt","BR");
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> Lista_de_Financiamentos = new ArrayList<Financiamento>();
        double valor_total_imoveis = 0;
        double valor_total_financiamentos_imoveis = 0;
        NumberFormat valor_Format = NumberFormat.getCurrencyInstance(localeBR);
    
    System.out.println("--- INICIANDO FINANCIAMENTOS ---");
        double valorimovel = interfaceUsuario.pedir_valor_imovel();
        int prazo_financ = interfaceUsuario.pedir_prazo_financ_anos();
        double taxajuros = interfaceUsuario.pedir_taxa_juros_anual();
        double area_construida = interfaceUsuario.pedir_area_construida();
        double tamanho_terreno = interfaceUsuario.pedir_tamanho_terreno();
        Lista_de_Financiamentos.add(new Casa(valorimovel, prazo_financ, taxajuros, area_construida, tamanho_terreno ));
        Lista_de_Financiamentos.add(new Casa(500000, 10, 10, 500, 700));
        Lista_de_Financiamentos.add(new Apartamento(400000, 12, 11, 23, 15 ));
        Lista_de_Financiamentos.add(new Apartamento(300000, 9, 10, 21, 12 ));
        Lista_de_Financiamentos.add(new Terreno(200000, 12, 11, 1 ));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("financiamentos.txt"))) {
            for (Financiamento financiamento : Lista_de_Financiamentos) {
                writer.write(financiamento.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("financiamentos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("financiamentos.ser"))) {
            oos.writeObject(Lista_de_Financiamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("financiamentos.ser"))) {
            ArrayList<Financiamento> deserializedFinanciamentos = (ArrayList<Financiamento>) ois.readObject();
            for (Financiamento financiamento : deserializedFinanciamentos) {
                System.out.println(financiamento);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        int i = 0;
        for (Financiamento f : Lista_de_Financiamentos) {
            System.out.println("---VALORES DO FINANCIAMENTO " + (i + 1) + ":---" + "\n" + 
            "---VALOR DO IMOVÉL--- R$ " + f.getValorImovel() + "\n" + 
            "---VALOR TOTAL DO IMOVÉL--- R$ " + f.calcular_total_pagamento());
            valor_total_imoveis += f.getValorImovel();
            valor_total_financiamentos_imoveis += f.calcular_total_pagamento();
            i++;
        }       

    System.out.println("---O VALOR TOTAL DOS IMOVEIS É:---  R$ " + valor_Format.format(valor_total_imoveis));
    System.out.println("---O VALOR TOTAL DO FINANCIAMENTO DOS IMOVEIS É:--- R$ " + valor_Format.format(valor_total_financiamentos_imoveis));
  }
}