package com.atech.teste.domain;

import java.util.List;

public class Linha {

    private Ponto inicio;
    private Ponto fim;

    private List<Ponto> pontos;

    public Linha(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public Linha(Ponto inicio, Ponto fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public Ponto getInicio() {
        return inicio;
    }

    public void setInicio(Ponto inicio) {
        this.inicio = inicio;
    }

    public Ponto getFim() {
        return fim;
    }

    public void setFim(Ponto fim) {
        this.fim = fim;
    }

    public int getLargura(){
        return this.getFim().getColuna() - this.getInicio().getColuna();
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        if (this.pontos.size() > 1){
            return "Largura.: " + pontos.size() + "linha.: " + pontos.get(0).getLinha() + " inicio.: " + pontos.get(0).getColuna() + " fim.: " + pontos.get(pontos.size()-1).getColuna();
        }
        return "Pontos insuficientes";
    }
    
}
