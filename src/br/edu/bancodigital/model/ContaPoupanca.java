package br.edu.bancodigital.model;

import br.edu.bancodigital.controller.ExceptionsConta;
import br.edu.bancodigital.controller.IContaOperacoes;

public class ContaPoupanca extends Conta implements IContaOperacoes {

    public ContaPoupanca(Cliente cliente, int agencia) {
        super(cliente, agencia);
    }

    @Override
    public void sacar(float valor) throws ExceptionsConta {
        if (valor > this.getSaldo())
            throw new ExceptionsConta("Saldo insuficiente.");

        this.setSaldo(this.getSaldo() - valor);
        System.out.println("\nSaque realizado com sucesso da conta poupança!");
    }

    @Override
    public void depositar(float valor) throws ExceptionsConta {
        if (valor <= 0)
            throw new ExceptionsConta("Valor de depósito inválido.");

        setSaldo(this.getSaldo() + valor);
        System.out.println("\nDepósito realizado com sucesso da conta poupança!");
    }

    @Override
    public String exibirDadosConta() {
        System.out.println("\n===== CONTA POUPANÇA =====");
        return super.exibirDadosConta();
    }
}
