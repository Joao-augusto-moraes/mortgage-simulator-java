# Simulador de Financiamento Imobiliário (Java)

> 🎓 **Projeto acadêmico** · Análise e Desenvolvimento de Sistemas, PUCPR · 2025

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

## 🧮 Regras de cálculo

Todas as parcelas usam a **Tabela Price** (parcela fixa com juros compostos):

```
PMT = V × i / (1 − (1 + i)^−n)
V = valor do imóvel · i = taxa mensal · n = número de meses
```

| Tipo | Regra | Exemplo (R$ 300 mil, 30 anos, 10% a.a.) |
|---|---|---|
| Apartamento | Price pura | R$ 2.632,71 |
| Casa | Price + R$ 80 de seguro por parcela | R$ 2.712,71 |
| Terreno | Price + 2% (risco de inadimplência) | R$ 2.685,37 |

Se o usuário digitar letras no lugar de números, o sistema avisa e pede o valor de novo.

## 🔭 Próximos passos

- [ ] Criar testes com JUnit comparando com valores de referência
- [ ] Adicionar a opção de amortização SAC
- [ ] Padronizar nomes no estilo Java (camelCase e pacotes em minúsculas)
