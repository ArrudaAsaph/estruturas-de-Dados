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
            fim = novNo.getProximo();
        }
    }
}
