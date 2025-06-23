package arvoreAB;

import exception.noElemen;

public class ArvoreAB {
    private No raiz;
    private int tamanho;

    public ArvoreAB() {
        this.raiz = null;
        this.tamanho = 0;
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

    public No leftChild(No no) throws noElemen {
        if (isExternal(no)) {
            throw new noElemen("No não possui filhos");
        }
        return no.getFilhoEsquerdo();
    }

    public No rightChild(No no) throws noElemen {
        if (isExternal(no)) {
            throw new noElemen("No não possui filhos");
        }
        return no.getFilhoDireito();
    }

    public boolean hasLeft(No no) {
        return (no.getFilhoEsquerdo() != null);
    }
   
    public boolean hasRight(No no) {
        return (no.getFilhoDireito() != null);
    }

    

}
