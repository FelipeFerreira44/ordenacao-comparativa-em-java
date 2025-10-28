# ordenacao-comparativa-em-java

### PONTIFÍCIA UNIVERSIDADE CATÓLICA DO PARANÁ

**Matéria:** Resolução de Problemas Estruturados em Computação  
**Curso:** Ciência da Computação  
**Professor:** Andrey Cabral Meira  

**Nome do Estudante:** Felipe Willian Barros Ferreira  
**Nome no GitHub:** FelipeFerreira44  

---

## 📋 Descrição do Projeto

Este projeto tem como objetivo **implementar e comparar o desempenho de 6 algoritmos de ordenação** em Java, analisando seu comportamento em diferentes cenários de dados. Os algoritmos foram testados com vetores específicos para avaliar eficiência em termos de **comparações, trocas e iterações**.

O trabalho implementa os algoritmos solicitados sem utilizar funções prontas de ordenação, seguindo integralmente os requisitos do enunciado.

---

## 🎯 Algoritmos Implementados

| Algoritmo | Tipo | Característica Principal |
|-----------|------|-------------------------|
| **Comb Sort** | Melhoria do Bubble Sort | Usa gap decrescente com fator 1.3 |
| **Gnome Sort** | Simples | "Algoritmo do gnomo" - compara elementos adjacentes |
| **Bucket Sort** | Distribuição | Divide em baldes e ordena individualmente |
| **Bubble Sort c/ Flag** | Comparação | Otimizado com flag de parada |
| **Selection Sort** | Seleção | Menor número de trocas |
| **Cocktail Sort** | Bidirecional | Bubble Sort que vai e volta |

---

## 📊 Vetores de Teste

### Vetor 1 - Elementos Aleatórios
```java
{12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28}

---

### Vetor 2 - Elementos Quase Ordenados
```java
{5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32}


### Vetor 3 - Elementos em Ordem Decrescente
```java
{99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6}
