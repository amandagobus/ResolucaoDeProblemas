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

    public No(No proximo, No anterior, Imovel imovel, int indice) {
        this.proximo = proximo;
        this.anterior = anterior;
        this.imovel = imovel;
        this.indice = indice;
    }

    No(int indice, Imovel im, No inicio, No ultimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Imovel getImovel() {
        return imovel;
    }

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
