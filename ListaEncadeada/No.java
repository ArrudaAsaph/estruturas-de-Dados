

public class No {
    private Object elemento;
    private No proximo;

    public No(Object elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }


    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public void setProximo(No novo_no) {
        this.proximo = novo_no;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public No getProximo() {
        return this.proximo;
    }
}