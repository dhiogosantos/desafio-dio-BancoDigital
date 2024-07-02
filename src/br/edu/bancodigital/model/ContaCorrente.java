package br.edu.bancodigital.model;

import br.edu.bancodigital.controller.ExceptionsConta;
import br.edu.bancodigital.controller.IContaOperacoes;

public class ContaCorrente extends Conta implements IContaOperacoes {


    public ContaCorrente(Cliente cliente, int agencia) {
        super(cliente, agencia);
    }

    @Override
    public void sacar(float valor) throws ExceptionsConta {
        if (valor > this.getSaldo())
            throw new ExceptionsConta("Saldo insuficiente.");

        this.setSaldo(this.getSaldo() - valor);
        System.out.println("\nSaque realizado com sucesso da conta corrente!");
    }

    @Override
    public void depositar(float valor) throws ExceptionsConta {
        if (valor <= 0)
            throw new ExceptionsConta("Valor de depósito inválido.");

        setSaldo(this.getSaldo() + valor);
        System.out.println("\nDepósito realizado com sucesso na conta corrente!");
    }

    @Override
    public String exibirDadosConta() {
        System.out.println("\n===== CONTA CORRENTE =====");
        return super.exibirDadosConta();
    }
}
