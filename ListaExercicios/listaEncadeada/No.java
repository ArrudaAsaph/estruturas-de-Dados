package ListaExercicios.listaEncadeada;

public class No {
    private Object elemento;
    private No proximo;


    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object novo_elemento) {
        elemento = novo_elemento;

    }

    public No getProximo() {
        return proximo;
    }
    public void setProximo(No novo_proximo) {
        proximo = novo_proximo;
    }
}
