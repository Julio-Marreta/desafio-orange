package com.example.desafioorange.veiculo.integracao;

public class Veiculo {

    private String nome;
    private String codigo;

    public Veiculo() {
    }

    public Veiculo(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
