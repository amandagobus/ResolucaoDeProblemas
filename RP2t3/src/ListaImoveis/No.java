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

    
}
