package br.edu.bancodigital.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

    public static List<Banco> listaBancos = new ArrayList<>();

    private String nome;
    private int codigo;
    private List<Conta> listaContas;

    public Banco(String nome, int codigo){
        setNome(nome);
        setCodigo(codigo);
        this.listaContas = new ArrayList<>();
    }

    public List<String> getListaContas() {
        List<String> numeroContas = listaContas.stream()
                .map(conta -> String.valueOf(conta.getNumeroConta()))
                .collect(Collectors.toList());
        return numeroContas;
    }

    public void setListaContas(Conta conta) {
        this.listaContas.add(conta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String exibirDadosBanco(){
        return "Banco: " + this.getNome() +
                "\nCódigo: " + this.getCodigo() +
                "\nNº das contas cadastradas neste banco: " + this.getListaContas();
    }

}