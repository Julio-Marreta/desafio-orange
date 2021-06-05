package com.example.desafioorange.veiculo;

import com.example.desafioorange.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private String ano;
    private String valor;
    private String diaRotacao;
    private Boolean rotacaoAtiva = false;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    public Veiculo(){}

    public Veiculo(Long id, String marca, String modelo, String ano, String valor, String diaRotacao, Boolean rotacaoAtiva, Usuario usuario) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.diaRotacao = diaRotacao;
        this.rotacaoAtiva = rotacaoAtiva;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDiaRotacao() {
        return diaRotacao;
    }

    public void setDiaRotacao(String diaRotacao) {
        this.diaRotacao = diaRotacao;
    }

    public Boolean getRotacaoAtiva() {
        return rotacaoAtiva;
    }

    public void setRotacaoAtiva(Boolean rotacaoAtiva) {
        this.rotacaoAtiva = rotacaoAtiva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
