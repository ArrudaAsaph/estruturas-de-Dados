public class PilhaEncadeada {
    private int tamanho;
    private No inicio;


    public PilhaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void push(Object novo_elemento) {
        No novo_no = new No(novo_elemento);

        novo_no.setProximo(inicio);
        inicio = novo_no;
        tamanho++;

    }

    public Object pop() throws ElemenVazia{
        if (isEmpty()) {
            throw new ElemenVazia("Pilha Vazia");
        } else {
            Object elemento_out = inicio.getElemento();
            inicio = inicio.getProximo();
            tamanho--;

            return elemento_out;
        }
        
    }

    public Object top() throws ElemenVazia{
        if (isEmpty()) {
            throw new ElemenVazia("Pilha Vazia");
        } else {
            System.out.println(String.format("Topo: %s ",inicio.getElemento()));
           return inicio.getElemento();

        }
    }
    public boolean isEmpty() {
        return tamanho == 0;
    }
    
    public int size() {
        return tamanho;
        
    }


    public void print() throws ElemenVazia{
        if (isEmpty()) {
            throw new ElemenVazia("Pilha Vazia");
        } 
        No tempNo = inicio;
        int cont = 0;
        while (tempNo != null) {
            System.out.println(String.format("Posi %d -> %s", cont, tempNo.getElemento()));
            tempNo = tempNo.getProximo();
            cont++;
        }
    }
}
