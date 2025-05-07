package ListaDuplaEncadeada;

public class DobleNo {
    private Object elemento;
    private DobleNo proximo;
    private DobleNo anterior;

    public DobleNo (Object elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public DobleNo getProximo() {
        return proximo;
    }

    public void setProximo(DobleNo proximo) {
        this.proximo = proximo;
    }

    public DobleNo getAnterior() {
        return anterior;
    }

    public void setAnterior(DobleNo anterior) {
        this.anterior = anterior;
    }
}
