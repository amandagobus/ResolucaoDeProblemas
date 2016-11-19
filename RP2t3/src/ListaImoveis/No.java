/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaImoveis;

import Imovel.Imovel;
/**
 *
 * @author Amanda Gobus
 */
public class No {
    private No proximo;
    private No anterior;
    private Imovel imovel;
    private int indice;

    /**
     * Construtor do No
     * @param indice
     * @param im
     * @param inicio
     * @param ultimo 
     */
   public No(int indice, Imovel im, No inicio, No ultimo) {
       this.indice=indice;
       this.imovel=imovel;
       this.anterior=anterior;
       this.proximo=proximo;
    }

    

/**
 * Método set do Imóvel
 * @param imovel 
 */
    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
/**
 * Método get do Imóvel
 * @return 
 */
    public Imovel getImovel() {
        return imovel;
    }
/**
 * 
 * @return 
 */
    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    public void decrementarIndice(){
        this.indice--;
    }
    public void IncrementarIndice(){
        this.indice++;
    }

    
}
