public class FilaEncadeada {
 
    
    private Object elemento;
    private int tamanho;
    private No inicio;
    private No fim;

    public FilaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;

    }

    public void enqueue(Object novo_elemento) {
        No novNo = new No(novo_elemento);

        if (inicio == null) {
            inicio = novNo;
            fim = novNo;
        } else {
            fim.setProximo(novNo);
            fim = novNo;
        }
        tamanho++;
    }
    public boolean isEmpty() {
        return inicio == null;
    }

    
    public Object dequeue() throws ElemenVazia {
        if (isEmpty()) {
            throw new ElemenVazia("Fila Vazia");
        }
       Object elememtoOut = inicio.getElemento();
       inicio = inicio.getProximo();
        return elememtoOut;
    }
}
