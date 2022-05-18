package com.atech.teste.domain;

public class Retangulo {
    
    private Linha superior;
    private Linha inferior;

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
        return this.inferior.getFim().getLinha() - this.superior.getInicio().getLinha();
    }

    public int getArea(){
        return this.inferior.getLargura() * this.getAltura();
    }

    @Override
    public String toString() {
        return 
            "Altura.: " + this.getAltura() +
            " Area.: " + this.getArea() + 
            " LS.: " + this.superior.getInicio().getLinha() + " I: " + this.superior.getInicio().getColuna() + " F: " + this.superior.getFim().getColuna() + 
            " LI.: " + this.inferior.getInicio().getLinha() + " I: " + this.inferior.getInicio().getColuna() + " F: " + this.inferior.getFim().getColuna() + 
            "--------------------------------";
    }

    

}
