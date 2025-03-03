package Utilizar;
import java.util.Scanner;
public class InterfaceUsuario {
    //ATRIBUTOS
    Scanner sc = new Scanner(System.in);
    private double valor;
    private int prazo;
    private double taxa_anual;
    private double area_construida;
    private double tamanho_terreno;
    private int numero_de_vagas_garagem;
    private int numero_andar;
    private int tipo_de_terreno;


    //METODOS
    public double pedir_area_construida() {
        try {
            while (true) {
                System.out.println("---DIGITE O TAMANHO DA AREA CONSTRUIDA EM METROS");
                area_construida = sc.nextDouble();
                if (this.area_construida <= 0 ) {
                    System.out.println("---DIGITE UM VALOR MAIOR QUE 0:");
                } else {
                    return area_construida;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public double pedir_tamanho_terreno() {
        try {
            while (true) {
                System.out.println("---DIGITE O TAMANHO DO TERRENO EM METROS");
                tamanho_terreno = sc.nextDouble();
                if (this.tamanho_terreno <= 0 ) {
                    System.out.println("---DIGITE UM VALOR MAIOR QUE 0:");
                } else {
                    return tamanho_terreno;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public int pedir_numero_de_vagas_garagem() {
       try {
        while (true) {
            System.out.println("---DIGITE O A QUANTIDADES DE VAGA NO PREDIO");
            numero_de_vagas_garagem = sc.nextInt();
            if (this.numero_de_vagas_garagem <= 0 ) {
                System.out.println("---DIGITE UM VALOR MAIOR QUE 0:");
            } else {
                return numero_de_vagas_garagem;
            }
        }
       } catch (Exception e) {
        throw e;
       }
    }
    public int pedir_numero_andar() {
        try {
            while (true) {
                System.out.println("---DIGITE QUANTOS ANDARES TEM O PREDIO");
                numero_andar = sc.nextInt();
                if (this.numero_andar <= 0 ) {
                    System.out.println("---DIGITE UM VALOR MAIOR QUE 0:");
                } else {
                    return numero_andar;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public int pedir_tipo_terreno() {
        try {
            while (true) {
                System.out.println("---DIGITE O TIPO DO TERRENO, 1 PARA COMERCIAL E 2 PARA RESIDENCIAL:---");
                tipo_de_terreno = sc.nextInt();
                if (this.tipo_de_terreno > 2) {
                    System.out.println("---ESSE VALOR É INVÁLIDO---");
                } else if (this.tipo_de_terreno <= 0 ) {
                    System.out.println("---ESSE VALOR É INVALIDO---");
                } else {
                    return tipo_de_terreno;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public double pedir_valor_imovel() {
        try {
            while (true) {
                System.out.println ("---DIGITE O VALOR DO IMÓVEL:---");
                valor = sc.nextDouble();
                if (this.valor > 500000) {
                    System.out.println("---O VALOR DEVE SER MENOR QUE 500000---");
                } else if (this.valor <= 0) {
                    System.out.println("---O VALOR DEVE SER MAIOR QUE 0---");
                } else {
                    return valor;
                }
                }
        } catch (Exception e) {
            throw e;
        }
    }

    public int pedir_prazo_financ_anos() {
        try {
            while (true) {
                System.out.println ("---DIGITE O PRAZO DO FINANCIAMENTO EM ANOS:---");
                prazo = sc.nextInt();
                if (this.prazo >= 35) {
                    System.out.println("---O PRAZO DEVE SER MENOR QUE 35 ANOS---");
                } else if (this.prazo <= 0) {
                    System.out.println("---PRAZO EM ANOS INVÁLIDO---");
                } else {
                    return prazo;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public double pedir_taxa_juros_anual() {
        try {
            while (true) {
                System.out.println ("---DIGITE A TAXA DE JUROS ANUAL:---");
                taxa_anual = sc.nextDouble();
                if (this.taxa_anual > 12) {
                    System.out.println("---A TAXA DE JUROS ANUAL DEVE SER MENOR OU IGUAL A 12%---");
                } else if (this.taxa_anual <= 0) {
                    System.out.println("---A TAXA ANUAL DE JUROS DEVE SER MAIOR QUE 0---");
                } else {
                    return taxa_anual;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    }