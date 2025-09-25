public class ArvoreAVL {
    private No raiz;
    private int tamanho;


    public ArvoreAVL() {
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
        return (tamanho == 0);
    }

    public void inserir(int chave, Object elemento) {
        if (isEmpty()) {
            No novo_no = new No(chave, elemento);
            tamanho++;
            raiz = novo_no;
        } else {
            inserir_recu(raiz, chave, elemento);

        }
    }

    public No buscar(No atual, int chave) {
        
        if (atual == null) {
            return null;
        }
        if (chave == atual.getChave()) {
            return atual;
        } else if (chave < atual.getChave()) {
            return buscar(atual.getFilhoEsquerdo(), chave);
        } else {
            return buscar(atual.getFilhoDireito(), chave);
        }
    }
}