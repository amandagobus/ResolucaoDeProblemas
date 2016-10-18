/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terreno;

import Imovel.Imovel;

/**
 * Classe para objetos do tipo Terreno, onde serão contidos valores e métodos para o mesmo.
 * @author Julielen
 */
public class Terreno extends Imovel {

    private double dimensaoFrente;
    private double dimensaoLado;
    
    /**
     * Construtor Classe Terreno que estende atributos da classe Imovel
     * @param logradouro
     * @param numero
     * @param bairro
     * @param cidade
     * @param descricao
     * @param areaTotal
     * @param valor
     * @param dimensaoFrente
     * @param dimensaoLado 
     */

    public Terreno(String logradouro, int numero, String bairro, String cidade, String descricao, double areaTotal, double valor, double dimensaoFrente, double dimensaoLado) {
        super(logradouro, numero, bairro, cidade, descricao, areaTotal, valor);
        this.dimensaoFrente = dimensaoFrente;
        this.dimensaoLado = dimensaoLado;

    }

    /**
     * @return the dimensaoFrente
     */
    public double getDimensaoFrente() {
        return dimensaoFrente;
    }

    /**
     * @param dimensaoFrente the dimensaoFrente to set
     */
    public void setDimensaoFrente(double dimensaoFrente) {
        this.dimensaoFrente = dimensaoFrente;
    }

    /**
     * @return the dimensaoLado
     */
    public double getDimensaoLado() {
        return dimensaoLado;
    }

    /**
     * @param dimensaoLado the dimensaoLado to set
     */
    public void setDimensaoLado(double dimensaoLado) {
        this.dimensaoLado = dimensaoLado;
    }
     /**
     * ToString de Terreno, diz ao objeto como se escrever como uma string
     * @return 
     */
    @Override
    public String toString() {
        String dados = super.toString();
        dados += "Dimensão de Frente: " + dimensaoFrente + "\n";
        dados += "Dimensão de Lado: " + dimensaoLado + "\n";

        return dados;
    }

}
