package com.atech.teste.domain;

public class Linha {

    private Ponto inicio;
    private Ponto fim;


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
    @Override
    public String toString() {
        return "Linha..: " + inicio.getLinha() + " Inicio.: " + inicio.getColuna() + " Fim.: " + fim.getColuna() + " Distância.: " + this.getLargura();
    }
    
}
