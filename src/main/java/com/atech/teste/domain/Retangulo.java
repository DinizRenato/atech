package com.atech.teste.domain;

import java.util.List;

public class Retangulo {
    
    private Linha superior;
    private Linha inferior;

    private List<Linha> linhas;

    public Retangulo(List<Linha> linhas) {
        this.linhas = linhas;
    }

    public Retangulo(Linha superior, Linha inferior) {
        this.superior = superior;
        this.inferior = inferior;
    }

    public Linha getSuperior() {
        return superior;
    }
    public void setSuperior(Linha superior) {
        this.superior = superior;
    }
    public Linha getInferior() {
        return inferior;
    }
    public void setInferior(Linha inferior) {
        this.inferior = inferior;
    }

    public int getAltura(){
        return this.linhas.size();
    }
    public int getLargura(){
        return this.linhas.get(0).getPontos().size();
    }

    public int getArea(){
        return this.getLargura() * this.getAltura();
    }

    public List<Linha> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<Linha> linhas) {
        this.linhas = linhas;
    }

    @Override
    public String toString() {
        return "Area = " + this.getArea();
    }
    
}
