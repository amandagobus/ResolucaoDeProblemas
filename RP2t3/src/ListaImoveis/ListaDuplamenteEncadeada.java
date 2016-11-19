/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaImoveis;

import Imovel.Imovel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

/**
 *
 * @author Amanda Gobus
 */
public class ListaDuplamenteEncadeada implements List {

    private No ultimo ;
    private No inicio ;
    private No aux;
    private int indice , size ;

    public ListaDuplamenteEncadeada() {
     this.ultimo = null;
     this.inicio = null;
     this.indice = 0;
     this.size = 0;
    }
    
    
    /**
     * Método que pega o último Imovel da lista e retorna ele
     *
     * @return imovel
     */
    public Imovel getLast() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {
            return ultimo.getImovel();
        }
    }

    /**
     * Método que adiciona um imovel na lista
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(Object e) {
        Imovel im = (Imovel) e;
        if (!this.isEmpty()) {
            aux = new No(indice, im, inicio, ultimo);
            this.ultimo.setProximo(aux);
            this.ultimo = aux;
            this.inicio.setAnterior(ultimo);
        } else {
            this.inicio = new No(indice, im, inicio, inicio);
            this.inicio.setAnterior(inicio);
            this.inicio.setProximo(inicio);
            this.ultimo = inicio;
        }

        this.indice++;
        this.size++;
        return true;
    }

    /**
     * Método que remove um imovel da lista
     *
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        Imovel im = (Imovel) o;
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {
            aux = this.inicio;
            while (aux != this.inicio) {
                Imovel i = (Imovel) aux.getImovel();
                if (i.getCodigo() == im.getCodigo()) {
                    break;
                }
                aux = aux.getProximo();
            }
            if (this.aux != this.inicio) {
                No anterior = aux.getAnterior();
                No proximo = aux.getProximo();
                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);
                this.size--;
                this.decrementarLista(proximo);
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.inicio == null;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object set(int i, Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int i, Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object remove(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que decrementa a Lista
     *
     * @param n
     */
    private void decrementarLista(No n) {
        if (this.size == 1) {
            this.ultimo = inicio;
        }
        this.indice--;
        No aux = n;
        while (aux != this.ultimo) {
            aux.decrementarIndice();
            aux = aux.getProximo();
        }
        aux.decrementarIndice();
    }

    /**
     * Método que incrementa a Lista
     *
     * @param n
     */
    private void incrementarLista(No n) {
        this.indice++;
        No aux = n;
        while (aux != this.ultimo) {
            aux.IncrementarIndice();
            aux = aux.getProximo();
        }
        aux.decrementarIndice();

    }

    public boolean existeImovel(Imovel im) {
        No aux1 = this.inicio;
        while (aux1 != this.ultimo) {
            Imovel i = (Imovel) aux1.getImovel();
            if (i.getCodigo() == im.getCodigo()) {
                return true;
            }
            aux1 = aux1.getProximo();
        }
        return false;
    }
}
