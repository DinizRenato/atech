package com.atech.teste.domain;

public class Ponto {
    
    private int linha;
    private int coluna;

    public Ponto(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha(){
        return this.linha;
    }

    public void setLinha(int linha){
        this.linha = linha;
    }

    public int getColuna(){
        return this.coluna;
    }

    public void setColuna(int coluna){
        this.coluna = coluna;
    }

    @Override
    public String toString() {
        return "Linha.: " + linha + " Coluna.: " + coluna;
    }

}
