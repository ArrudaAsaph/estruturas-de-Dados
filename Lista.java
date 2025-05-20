

public class Lista {
    private No inicio;
    private No fim;
    private int tamanho;

    public Lista() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    public Object first() throws ElemenVazia {
        if (isEmpty()) {
            throw new ElemenVazia("Fila Vazia");
        } else {
            return inicio.getElemento();
        }
    }

    public Object last() throws ElemenVazia {
        if (isEmpty()) {
            throw new ElemenVazia("Fila Vazia") 
        } else {
            return fim.getElemento();
        }
    }

    public Object before(No no) {
        return no.getAnterior();
    }

    public Object after(No no) {
        return no.getProximo();
    }

    public Object replaceElement(No no, Object novo_obj) {
        Object antigo = no.getElemento();
        no.setElemento(novo_obj);
        return antigo;
    }


    public void swapElement(No no1, No no2) {
        No temp = no1;

        no1.setElemento(no2.getElemento());
        no2.setElemento(temp.getElemento());
    }


    public void insertBefore(No no, Object novo_obj) {
        No novo_no = new No(novo_obj);
        // inicio <-> A(10) <-> B(11) <-> C(T) <-> Fim
        // insertBefore(B, 52)
        // inicio <-> A(10) <-> NovoNO(52) <-> B(11) <-> C(T) <-> Fim
        novo_no.setAnterior(no.getAnterior()); // NovoNO -> B.getAnterior() = A
        novo_no.setProximo(no); // NovoNO -> B
        // inicio <-> A(10) <- NovoNO(52) -> B(11) <-> C(T) <-> Fim
        //             ^-----------------------^    

        no.setAnterior(novo_no); // B.setAnterior(novoNO) 
        // inicio <-> A(10) <- NovoNO(52) <-> B(11) <-> C(T) <-> Fim
        //             |-----------------------^ 
        if (novo_no.getAnterior() == null) {
            inicio = novo_no;
        } else {
            novo_no.getAnterior().setProximo(novo_no);
            // inicio <-> A(10) <-> NovoNO(52) <-> B(11) <-> C(T) <-> Fim
        }
        tamanho++;


    }

    public void insertAfter(No no, Object novo_obj) {
        No novo_no = new No(novo_obj);
        // inicio <-> A(10) <-> B(11) <-> C(T) <-> Fim
        // insertAfter(B, 52)
        // inicio <-> A(10) <-> B(11) <-> NovoNO(52) <-> C(T) <-> Fim

        novo_no.setAnterior(no); // B <- NovoNO
        novo_no.setProximo(no.getProximo()); // NovoNO -> B.getProximo() = C
        // inicio <-> A(10) <-> B(11) <- NovoNO(52) -> C(T) <-> Fim
        //                       ^----------------------^
        no.setProximo(novo_no); // B -> NovoNO
        // inicio <-> A(10) <-> B(11) <-> NovoNO(52) -> C(T) <-> Fim
        //                       ^----------------------|

        if (novo_no.getProximo() == null) {
            fim = novo_no;
        } else {
            novo_no.getProximo().setAnterior(novo_no);
        // inicio <-> A(10) <-> B(11) <-> NovoNO(52) <-> C(T) <-> Fim

        }
        tamanho++;
    }
    

    public void insertFirst(Object novo_obj) {
        No novo_no = new No(novo_obj);

        if (inicio == null) {
            inicio = fim = novo_no;
        } else {
            novo_no.setProximo(inicio);
            novo_no.setAnterior(novo_no);
            inicio = novo_no;
        }
        tamanho++;
    }
}