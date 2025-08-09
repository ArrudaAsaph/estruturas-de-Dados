

public class Heap {
    private int tamanho;
    private No raiz;
    private No ultimoNo;
    
    public Heap (int elemento) {
        this.raiz = null;
        this.tamanho = 1;
        
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public No pai(No no) {
        return no.getPai();
    }

    public No heapOrder(No no) {
        if (no.getPai() == null) {
            return no;
        }

        if (no.getValor() >= no.getPai().getValor()) {
            return no;
        } 
        swap(no,no.getPai());
        return heapOrder(no);

    }

    public void swap(No no1, No no2) {
        int temp = no1.getValor();

        no1.setValor(no2.getValor());
        no2.setValor(temp);

    }

    public void inserir(int valor) {
        No novoNo = new No(null, valor);

        if (raiz == null) {
            raiz = novoNo;
            ultimoNo = novoNo;
            tamanho++;
        }

        
    }


    public boolean hasFilhoEsquerda(No no) {
        return no.getFilhoEsquerdo() != null;
    }

    public boolean hasFilhoDireiro(No no) {
        return no.getFilhoDireito() != null;
    }
    

    

    
}
