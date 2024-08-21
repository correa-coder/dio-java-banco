# DIO - Java Banco

## Descrição

Desafio de projeto que consiste implementar os pilares da orientação objeto em Java de forma prática em uma aplicação que simula um banco.

## Classes de domínio

- `/domain/Bank.java`: Factory para objetos do tipo `BankAccount`
- `/domain/BankAccount.java`: Classe base servindo de referência para `CheckingAccount` e `SavingsAccount`
- `/domain/CheckingAccount.java`: Classe representando uma conta corrente
- `/domain/SavingsAccount.java`: Classe representando uma conta poupança

## Enums

- `/enums/AccountType.java`: Representa o tipo de conta
- `/enums/Status.java`: Caracteres ✓ e ✗ para representar o sucesso ou fracasso de algumas operações

## Interfaces

- `/interfaces/IAccount.java`: Métodos base para serem implementados em `BankAccount`

## Models

- `/models/User.java`: Representa um usuário com nome e email

## App.java

Nesta classe há o método principal (main) que demonstra o uso das classes de domínio.
