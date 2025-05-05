package ListaExercicios.listaEncadeada;

public class FilaListaEncadeada {
    private No inicio;
    private No fim;

    public FilaListaEncadeada() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(Object novo_elemento) {
        No novo_no = new No();
        novo_no.setElemento(novo_elemento);
        novo_no.setProximo(null);

        if (isEmpty()) {
            inicio = novo_no;
        } else {
            fim.setProximo(novo_no);
        }
        fim = novo_no;
    }


}
