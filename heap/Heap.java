

public class Heap {
    private int tamanho;
    private No raiz;
    private No ultimoNo;
    
    public Heap () {
        this.raiz = null;
        this.tamanho = 0;
        
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public No pai(No no) {
        return no.getPai();
    }

    public No heapOrder(No no) {
        if (no.getPai() == null) {
            return no;
        }

        if (no.getValor() >= no.getPai().getValor()) {
            return no;
        } 
        swap(no,no.getPai());
        return heapOrder(no);

    }

    public void swap(No no1, No no2) {
        int temp = no1.getValor();

        no1.setValor(no2.getValor());
        no2.setValor(temp);

    }

    public void inserir(int valor) {
        No novoNo = new No(null, valor);

        if (raiz == null) {
            raiz = novoNo;
            ultimoNo = novoNo;
            tamanho++;
            printHeapSide();
            return;
        }

        No novoUltimoNo = buscarProximo(ultimoNo);
        No novo = new No(novoUltimoNo, valor);

        if (novoUltimoNo.getFilhoEsquerdo() == null) {
            novoUltimoNo.setFilhoEsquerdo(novo);
            ultimoNo = novo;
            tamanho++;
            printHeapSide();
            return;
        } 
        novoUltimoNo.setFilhoDireito(novo);
        ultimoNo = novo;
        tamanho++;

        heapOrder(novo);
        printHeapSide();
        return;
        
    }


    public boolean hasFilhoEsquerda(No no) {
        return no.getFilhoEsquerdo() != null;
    }

    public boolean hasFilhoDireiro(No no) {
        return no.getFilhoDireito() != null;
    }
    
    public void printHeapSide() {
        printHeapSideRec(raiz, 0);
    }

    private void printHeapSideRec(No no, int nivel) {
        if (no == null) return;
        printHeapSideRec(no.getFilhoDireito(), nivel + 1);
        System.out.println("    ".repeat(nivel) + no.getValor());
        printHeapSideRec(no.getFilhoEsquerdo(), nivel + 1);
    }


    public No buscarUltimoNo(No no) {
        No pai = no.getPai(); 

        if (pai == null) { // O pai é o raiz? Sim -> Procuro o filho mais a esquerda
            return buscarProximo(raiz);
        }
        if (pai.getFilhoEsquerdo() == no) { // O no é o filho esquerdo?
            No irmao = pai.getFilhoDireito();

            if (irmao == null) { // Se o irmão for nulo ele é onde precisa ser adiconado
                return pai;
            }

            return buscarProximo(irmao); // Procuro o filho mais a esquerda do irmão
        }

        return buscarUltimoNo(pai); // Passo o pai até atender os casos base
    }

    private No buscarProximo(No no) {
        if (no.getFilhoEsquerdo() == null) {
            return no;
        }
        return buscarProximo(no.getFilhoEsquerdo());
    }

    

    
}
