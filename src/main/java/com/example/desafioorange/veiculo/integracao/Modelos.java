package com.example.desafioorange.veiculo.integracao;

import java.util.List;

public class Modelos {

    private List<Modelo> modelos;

    public Modelos() {
    }

    public Modelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public static class Modelo {
        private String nome;
        private Integer codigo;

        public Modelo() {
        }

        public Modelo(String nome, Integer codigo) {
            this.nome = nome;
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getCodigo() {
            return codigo;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }


    }
}
