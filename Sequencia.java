

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

    public No first() {
        return inicio.getProximo();
    }

    public No after() {
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


    public No atRank(int indice) {
        if (indice < 0 || indice > tamanho) {
            throw new ElemenVazia("Indice fora");
        }
        else {
            if (indice <= (tamanho / 2)) {
                No temp = inicio;
                for (int i = 0; i <= indice; i++) {
                    temp = temp.getProximo();
                }
                
            } else {
                No temp = fim;
                for (int i = tamanho - 1; i > indice;i--) {
                    temp = temp.getAnterior();
                }
            }
            return temp;
        }
    }
    
    public void insertAtRank(int indice, Object elemento) {
        if (indice < 0 || indice > tamanho) {
            throw new ElemenVazia("Indice fora");
        }
        if (indice <= (tamanho / 2)) {
            No temp = inicio;
            for (int i = 0; i < indice; i++) {
                temp = temp.getProximo();
            }
            
        } else {
            No temp = fim;
            for (int i = 0; i < (tamanho - indice);)

        }
    }
}