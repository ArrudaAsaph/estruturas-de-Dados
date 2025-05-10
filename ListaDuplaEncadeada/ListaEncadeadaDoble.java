package ListaDuplaEncadeada;


public class ListaEncadeadaDoble {
    private int tamanho;
    private DobleNo inicio;
    private DobleNo fim;

    public ListaEncadeadaDoble() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }


    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public Object first() throws ElemenVazia {
        if (isEmpty()) {
            throw new ElemenVazia("Lista Vazia");
        } else{
            return inicio.getElemento();
        }
    }

    public Object last() throws ElemenVazia {
        if (isEmpty()) {
            throw new ElemenVazia("Lista Vazia");
        } else{
            return fim.getElemento();
        }
    }

    public Object before(DobleNo no) {
        return no.getAnterior();
    }

    public Object after(DobleNo no) {
        return no.getProximo();
    }

    public Object replaceElement(DobleNo no, Object novo_elemento) {
        Object antigo = no.getElemento();
        no.setElemento(novo_elemento);
        return antigo;
    }

    public void swapElements(DobleNo no1, DobleNo no2) {
        DobleNo temp = no1;

        no1.setElemento(no2.getElemento());
        no2.setElemento(temp.getElemento());
    }

    public void insertBefore(DobleNo no, Object novo_elemento) {
        DobleNo novo_no = new DobleNo(novo_elemento);

        novo_no.setProximo(no);
        novo_no.setAnterior(no.getAnterior());

        no.setAnterior(novo_no);
        if (novo_no.getAnterior() == null) {
            inicio = novo_no;
        } else {
            novo_no.getAnterior().setProximo(novo_no);
        }    
    }

    public void insertAfter(DobleNo no, Object novo_elemento) {
        DobleNo novo_no = new DobleNo(novo_elemento);

        novo_no.setAnterior(no);
        novo_no.setProximo(no.getProximo());

        no.setProximo(novo_no);

        if (novo_no.getProximo() == null) {
            fim = novo_no;
        } else {
            novo_no.getProximo().setAnterior(novo_no);
        }


    }

    public void insertFirst(Object novo_elemento) {
        DobleNo novo_no = new DobleNo(novo_elemento);
        if (inicio == null) {
            inicio = fim = novo_no;
        } else {
            novo_no.setProximo(inicio);
            inicio.setAnterior(novo_no);
            inicio = novo_no;
        }
    }

    public void insertLast(Object novo_elemento) {
        DobleNo novo_no = new DobleNo(novo_elemento);

        if (fim == null) {
            inicio = fim = novo_no;
        } else {
            fim.setProximo(novo_no);
            novo_no.setAnterior(fim);
            fim = novo_no;
        }
    }

    public Object remove(DobleNo elemento) {
        Object removido = elemento.getElemento();
    
        if (elemento == inicio && elemento == fim) {
            
            inicio = fim = null;
        } else if (elemento == inicio) {
            
            inicio = elemento.getProximo();
            inicio.setAnterior(null);
        } else if (elemento == fim) {
            fim = elemento.getAnterior();
            fim.setProximo(null);
        } else {
            elemento.getAnterior().setProximo(elemento.getProximo());
            elemento.getProximo().setAnterior(elemento.getAnterior());
        }
    
        return removido;
    }
    
}
