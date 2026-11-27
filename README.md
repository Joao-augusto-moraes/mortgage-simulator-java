# Simulador de Financiamento Imobiliário (Java)

Aplicação de console em Java que simula financiamentos de **casas, apartamentos e terrenos**, calculando parcela mensal e valor total pago. Projeto da disciplina de Fundamentos da Programação Orientada a Objetos (PUCPR).

## 🧱 Stack

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white&style=flat-square)

Java puro, sem dependências externas.

## ✨ O que o sistema faz

- Pede valor do imóvel, prazo e taxa de juros, com validação de faixa (imóvel até R$ 500 mil, prazo até 34 anos, juros até 12% ao ano)
- Cria uma lista de financiamentos com tipos diferentes de imóvel
- Mostra os valores formatados em reais
- Salva os financiamentos em arquivo de texto (`financiamentos.txt`) e em arquivo serializado (`financiamentos.ser`), e lê os dois de volta

## 🏗️ Conceitos de POO aplicados

```
           Financiamento (abstrata, Serializable)
          /             |              \
       Casa        Apartamento       Terreno
```

| Conceito | Onde aparece |
|---|---|
| Herança e classe abstrata | `Casa`, `Apartamento` e `Terreno` herdam de `Financiamento` |
| Polimorfismo | Cada tipo sobrescreve `calcular_pagamento_mensal()` |
| Exceção personalizada | `AcrescimoMaiorQuejurosException`, usada na regra da `Casa` |
| Encapsulamento | Atributos privados e protegidos com getters |
| Persistência | Escrita e leitura em texto e serialização de objetos |

## ▶️ Como rodar

```bash
javac -d out $(find src -name "*.java")
java -cp out Main.Main
```

## 📂 Estrutura

```
src/
├── Main/Main.java                  # Ponto de entrada
├── Modelo/                         # Financiamento, Casa, Apartamento, Terreno
└── Utilizar/                       # Entrada do usuário e exceção personalizada
```

## ⚠️ Limitações conhecidas

As fórmulas foram simplificadas para o exercício e **não refletem um financiamento real**:

- A parcela base aplica só um mês de juros, sem juros compostos. Num imóvel de R$ 300 mil em 30 anos a 10% ao ano, o sistema mostra cerca de R$ 1.000 por mês, enquanto a Tabela Price daria cerca de R$ 2.633
- A fórmula do `Apartamento` gera valores irreais (parcelas na casa dos milhões)
- No `Terreno`, o acréscimo de 2% não é aplicado, porque `102 / 100` é uma divisão inteira e resulta em 1
- Se o usuário digitar letras no lugar de números, o programa encerra com erro

## 🔭 Próximos passos

- [ ] Implementar a Tabela Price (ou SAC) e criar testes com JUnit comparando com valores de referência
- [ ] Tratar `InputMismatchException` na leitura do teclado
- [ ] Padronizar nomes no estilo Java (camelCase e pacotes em minúsculas)
