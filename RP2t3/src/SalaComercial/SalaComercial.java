/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalaComercial;

import Imovel.Predio;

/**
 *
 * @author Arcano
 */
public class SalaComercial extends Predio {

    protected int numeroDeBanheiros;
    protected int numeroDaSala;

    /**
     * Metodo construtor da class SalaComercial
     * @param logradouro
     * @param numero
     * @param bairro
     * @param cidade
     * @param descricao
     * @param areaTotal
     * @param valor
     * @param nomeEdificio
     * @param andar
     * @param valorCondominio
     * @param numeroDeBanheiros
     * @param numeroDaSala
     */
    public SalaComercial(String logradouro, int numero, String bairro,
            String cidade, String descricao, double areaTotal, double valor,
            String nomeEdificio, int andar, double valorCondominio, int numeroDeBanheiros, int numeroDaSala) {

        super(logradouro, numero, bairro, cidade, descricao,
                areaTotal, valor, nomeEdificio, andar, valorCondominio);

        this.numeroDeBanheiros = numeroDeBanheiros;
        this.numeroDaSala = numeroDaSala;

    }

    /**
     * @return the numeroDeBanheiros
     */
    @Override
    public int getNumeroDeBanheiros() {
        return numeroDeBanheiros;
    }

    /**
     * @param numeroDeBanheiros the numeroDeBanheiros to set
     */
    @Override
    public void setNumeroDeBanheiros(int numeroDeBanheiros) {
        this.numeroDeBanheiros = numeroDeBanheiros;
    }

    /**
     * @return the numeroDaSala
     */
    @Override
    public int getNumeroDaSala() {
        return numeroDaSala;
    }

    /**
     * @param numeroDaSala the numeroDaSala to set
     */
    @Override
    public void setNumeroDaSala(int numeroDaSala) {
        this.numeroDaSala = numeroDaSala;
    }
    /**
     * ToString de Sala Comercial, diz ao objeto como se escrever como uma string
     * @return 
     */
    @Override
    public String toString() {
        String dados = super.toString();
        dados += "Número Da Sala: " + numeroDaSala + "\n";
        dados += "Número De Banheiros: " + numeroDeBanheiros + "\n";
        

        return dados;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toFileTitulo(){
    String dados= super.toFileTitulo();
    dados += "NÚMERO DA SALA, NÚMERO DE BNAHEIRO";
    
    return dados;
    }
    
    @Override
    public String toFile(){
    String dados = super.toFile();
    dados +=numeroDaSala+","+numeroDeBanheiros;
    return dados;
    }

}
