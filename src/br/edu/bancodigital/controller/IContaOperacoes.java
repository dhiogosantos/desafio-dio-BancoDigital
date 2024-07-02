package br.edu.bancodigital.controller;

import br.edu.bancodigital.model.Conta;

public interface IContaOperacoes {

    void sacar(float valor) throws ExceptionsConta;
    void depositar(float valor) throws ExceptionsConta;

}