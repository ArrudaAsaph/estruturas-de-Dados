

// Methodos -> Size(); isEmpty()
// Methodos (vetor) -> insertAtRank(int rank, Object elemento); removeAtRank(int indice); replaceAtRank(int rank, Object elemento)

//Methodos (lista) -> first(); last(); before(No no); after(No no); replaceElement(No no, Object elemento); swapElement(No no1. No no2); insertBefore(No no, Object elemento); insertAfter(No no, Object elemento); insertFirst(Object elemento); insertLast(Object elemento), remove(No no);

//Methodos (Sequencia) -> atRank(int rank): return No no; rankOf(No no): return int indice
public class Sequencia {

    private No inicio;
    private No fim;
    private int tamanho;

    public Sequencia() {
        this.inicio = new No(null);
        this.fim = new No(null);
        this.tamanho = 0;
        inicio.setProximo(fim);
        fim.setAnterior(inicio);
    }

    public int size() {
        return tamanho;
    }

    public No first() {
        return inicio.getProximo();
    }

    public No lastr() {
        return fim.getAnterior();
    }

    public No before(No no) {
        return no.getAnterior();
    }

    public No after(No no) {
        return no.getProximo();
    }

    public void replaceAtRank(No no, Object elemento) {
        no.setElemento(elemento);
    }

    public void swapElement(No no1, No no2) {
        Object temp = no1.getElemento();

        no1.setElemento(no2.getElemento());
        no2.setElemento(temp);

    }

    public void insertBefore(No no, Object elemento) {
        No novNo = new No(elemento);

        novNo.setAnterior(no.getAnterior());
        novNo.setProximo(no);

        no.setAnterior(novNo);
        novNo.getAnterior().setProximo(novNo);
        tamanho++;

    }

    public void insertAfter(No no, Object elemento) {
        No novNo = new No(elemento);

        novNo.setAnterior(no);
        novNo.setProximo(no.getProximo());

        no.setProximo(novNo);
        novNo.getProximo().setAnterior(novNo);
        tamanho++;

    }

    public void insertFirst(Object elemento) {
        No novNo = new No(elemento);

        novNo.setAnterior(inicio);
        novNo.setProximo(inicio.getProximo());

        inicio.setProximo(novNo);
        
        novNo.getProximo().setAnterior(novNo);
        tamanho++;

    }

    public void insertLast(Object elemento) {
        No novNo = new No(elemento);

        novNo.setProximo(fim);
        novNo.setAnterior(fim.getAnterior());

        fim.setAnterior(novNo);

        novNo.getAnterior().setProximo(novNo);
        tamanho++;
    }

    public Object remove(No no) {
      

        no.getAnterior().setProximo(no.getProximo());

        no.getProximo().setAnterior(no.getAnterior());
        tamanho--;
        return no.getElemento();
    }


    public No atRank(int rank) throws ElemenVazia {
        if (rank < 0 || rank >= size()) {
            throw new ElemenVazia("Rank fora");
        } else{
            No temp;
            if (rank <= size() / 2) {
                temp = inicio.getProximo();
                for (int i = 0; i <= rank; i++) {
                    temp = temp.getProximo();
                }
            } else {
                temp = fim.getAnterior();
                for (int i = 0; i < size() - rank - 1; i++) {
                    temp = temp.getAnterior();
                }
            }

            return temp;
        }
    }
    
    public int rankOf(No no) {
        No temp = inicio.getProximo();
        int rank = 0;
        while (temp != no && temp != fim) {
            temp = temp.getProximo();
            rank++;
        }
        return rank;
    }

    public void insertAtRank(int rank, Object elemento) {
       No no_base = atRank(rank);

       insertBefore(no_base, elemento);
       

    }

    public Object elementAtRank(int rank) {
        No no = atRank(rank);

        return no.getElemento();
    }

    public Object replaceAtRank(int rank, Object elemento) {
        No no = atRank(rank);
        Object out = no.getElemento();
        no.setElemento(elemento);

        return out;
    }


    public void removeAtRank(int rank) {
        No no = atRank(rank);

        remove(no);
    }


}