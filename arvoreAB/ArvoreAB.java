package arvoreAB;

import exception.noElemen;

public class ArvoreAB {
    private No raiz;
    private int tamanho;

    public ArvoreAB() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public int size() {
        return tamanho;
    }

    public No root() {
        return raiz;
    }
    
    public boolean isExternal(No no) {
        return (no.getFilhoDireito() == null && no.getFilhoEsquerdo() == null);
    }

    public boolean isInternal(No no) {
        return (no.getFilhoDireito() != null || no.getFilhoEsquerdo() != null);
    }

    public boolean isRoot(No no) {
        return no == raiz;
    }

    public No leftChild(No no)  {
        if (isExternal(no)) {
            return null;

        }
        return no.getFilhoEsquerdo();
    }

    public No rightChild(No no)  {
        if (isExternal(no)) {
            return null;
        }
        return no.getFilhoDireito();
    }

    public boolean hasLeft(No no) {
        return (no.getFilhoEsquerdo() != null);
    }
   
    public boolean hasRight(No no) {
        return (no.getFilhoDireito() != null);
    }

    public void inOrder(No no) {
        if (hasLeft(no)) {
            inOrder(leftChild(no));
        }
        System.out.println(no.getElemento());
        if (hasRight(no)) {
            inOrder(rightChild(no));
        }
    }

    public int depth(No no) {
        if (no == raiz) {
            return 0;
        }
        return 1 + depth(no.getPai());
    }

    public int height(No no) {
        if (no == null) {
            return 0;
        }

        int alturaLeft = height(leftChild(no));
        int alturaRight = height(rightChild(no));

        return Math.max(alturaLeft, alturaRight) + 1;
    }

    public void insertRoot(Object elemento) throws noElemen {
        if (raiz != null) {
            throw new noElemen("Raíz já existente!");
        }
        No no = new No(elemento, null);
        raiz = no;
        tamanho++;
    }

    public No insertLeft(No pai, Object elemento) throws noElemen {
        if (hasLeft(pai)) {
            throw new noElemen("Filho esquerdo já existente!");
        }
        No no = new No(elemento, pai);
        pai.setFilhoEsquerdo(no);
        tamanho++;
        return no;
    }

    public No insertRight(No pai, Object elemento) throws noElemen {
        if (hasRight(pai)) {
            throw new noElemen("Filho direito já existente!");
        }
        No no = new No(elemento, pai);
        pai.setFilhoDireito(no);
        tamanho++;
        return no;
    }

    public void remove(No no) throws noElemen {
        if (hasLeft(no) || hasRight(no)) {
            throw new noElemen("Nó não pode ser removido pois possui filhos.");
        }

        No pai = no.getPai();

        if (pai != null) {
            if (pai.getFilhoEsquerdo() == no) {
                pai.setFilhoEsquerdo(null);
            } else if (pai.getFilhoDireito() == no) {
                pai.setFilhoDireito(null);
            }
        } else {
            raiz = null;
        }

        no.setPai(null);
        tamanho--;
    }

    public void preOrdem(No no) {
        System.out.println(no.getElemento());

        if (hasLeft(no)) {
            preOrdem(leftChild(no));
        }

        if (hasRight(no)) {
            preOrdem(rightChild(no));
        }

    }

    public void posOrdem(No no) {
        if (hasLeft(no)) {
            posOrdem(leftChild(no));
        }
        if (hasRight(no)) {
            posOrdem(rightChild(no));
        }
        System.out.println(no.getElemento());

    }

}
