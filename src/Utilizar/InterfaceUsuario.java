package Utilizar;
import java.util.InputMismatchException;
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


    //LEITURA SEGURA: se o usuario digitar letras, pede de novo em vez de encerrar o programa
    private double lerDouble() {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("---DIGITE APENAS NÚMEROS---");
                sc.next();
            }
        }
    }
    private int lerInt() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("---DIGITE APENAS NÚMEROS INTEIROS---");
                sc.next();
            }
        }
    }

    //METODOS
    public double pedir_area_construida() {
        try {
            while (true) {
                System.out.println("---DIGITE O TAMANHO DA AREA CONSTRUIDA EM METROS");
                area_construida = lerDouble();
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
                tamanho_terreno = lerDouble();
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
            numero_de_vagas_garagem = lerInt();
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
                numero_andar = lerInt();
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
                tipo_de_terreno = lerInt();
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
                valor = lerDouble();
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
                prazo = lerInt();
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
                taxa_anual = lerDouble();
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