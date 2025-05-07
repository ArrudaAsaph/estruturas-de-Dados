public class ListaEncadeada {
    private No inicio;  

    public ListaEncadeada() {
        this.inicio = null;
    }

    public void adicionarElemento(Object novo_elemento) {
        No novo_no = new No(novo_elemento);
        if (inicio == null) {
            inicio = novo_no;
        } else {
            No temporario = inicio;
            while (temporario.getProximo() != null) {
                temporario = temporario.getProximo();
            }
            temporario.setProximo(novo_no);
        }
    }

    public void exibirElementos() {
        No tempNo = inicio;

        if (tempNo == null) {
            System.out.println("Lista Vazia");
            return;
        }

        while (tempNo != null) {
            System.out.print(tempNo.getElemento() + " -> ");
            tempNo = tempNo.getProximo();
        }

        System.out.println("null");
    }
}
