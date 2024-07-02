package br.edu.bancodigital.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    private static int numero_conta = 0;
    public static List<Conta> listaContas = new ArrayList<>();

    private int agencia;
    private int numeroConta;
    private float saldo;
    private Cliente cliente;

    public Conta(Cliente cliente, int agencia){
        setCliente(cliente);
        setAgencia(agencia);
        setNumeroConta(++numero_conta);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String exibirDadosConta() {
        return "Titular: " + this.getCliente().getNome() +
                "\nAgência: " + this.getAgencia() +
                "\nNúmero conta: " + this.getNumeroConta() +
                "\nSaldo: R$ " + String.format("%.2f", this.getSaldo());
    }
}