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
    
    public void enqueuePreferencia(Object novo_elemento) {
        No novoNo = new No(novo_elemento);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            No tempoNo = inicio;
            novoNo.setProximo(inicio);
            inicio = novoNo;
            
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
       tamanho--;
        return elememtoOut;
    }

    public Object first() throws ElemenVazia {
        if (isEmpty()) {
            throw new ElemenVazia("Fila Vazia");
        } else{
            return inicio.getElemento();
        }
    }

    public int size() {
        return tamanho;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Fila Vazia");
            return;
        } else {
            No tempoNo = inicio;
            int cont = 0;
            while (tempoNo.getProximo() != null) {
                System.out.print(String.format("%d° | %s -> ", cont,tempoNo.getElemento()));
                tempoNo = tempoNo.getProximo();
                cont++;
            }
            System.out.print(String.format("null-----Tamanho: %d\n",tamanho));
        }
    }
}
