package arvoreABB;

import arvoreAB.ArvoreAB;

import exception.noElemen;

public class ArvoreABB extends ArvoreAB{
    private No raiz;
    private int tamanho;

    public ArvoreABB() {
        this.raiz = null;
        this.tamanho = 0;
    }
    
    public boolean hasLeft(No atual) {
        return (atual.getFilhoEsquerdo() != null);
    }
    public boolean hasRight(No atual) {
        return (atual.getFilhoDireito() != null);
    }
    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void addRoot(int elemento) {
        if (raiz != null) {
            throw new noElemen("Raiz já existente");
        }
        No novo = new No(elemento, null);
        raiz = novo;
        tamanho++;
    }

    public void insert(int elemento) {
        if (isEmpty()) {
            addRoot(elemento);
        }
        else {
            insertRecu(raiz, elemento);
        }      
               
        
    }
   
    private void insertRecu(No atual, int elemento) {
        if (atual.getElemento() > elemento) {
            if (hasLeft(atual)){
                insertRecu(atual.getFilhoEsquerdo(), elemento);
            } else {
                No novo = new No(elemento, atual);
                atual.setFilhoEsquerdo(novo);
                tamanho++;
            }
        } else {
            if (hasRight(atual)) {
                insertRecu(atual.getFilhoDireito(), elemento);
            } else{
                No novo =  new No(elemento, atual);
                atual.setFilhoDireito(novo);
                tamanho++;
            }
        }

    }

    public No search (No atual, int elemento) {
        if (atual == null) {
            return null;
        }

        if (atual.getElemento() == elemento) {
            return atual.getPai();
        }

        if (atual.getElemento() > elemento) {
            if (hasLeft(atual)) {
                search(atual.getFilhoEsquerdo(), elemento);
            }
        }  else {
            if (hasRight(atual)) {
                search(atual.getFilhoDireito(), elemento);
            }
        }
    }
}
