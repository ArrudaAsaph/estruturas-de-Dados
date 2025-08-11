

public class Heap {
    private No ultimoNo;
    private No raiz;
    private int tamanho;

    public Heap() {
        this.raiz = null;
        this.ultimoNo = this.raiz;
        this.tamanho = 0;
    }

    public No root() {
        return this.raiz;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public No pai(No no) {
        return no.getPai();
    }

    public No filhoEsquerdo(No no) {
        return no.getFilhoEsquerdo();
    }

    public No filhoDireito(No no) {
        return no.getFilhoDireito();
    }

    public No irmaoDireito(No no) {
        No pai = no.getPai();
        return pai.getFilhoDireito();
    }

    public No ultimoNo() {
        return this.ultimoNo;
    }

    public void inserir(int key, Object elemento) {
        No novoNo = new No(elemento, key, null);

        if (isEmpty()) {
           
            raiz = novoNo;
            ultimoNo = raiz;
            tamanho++;
            return;
        }
        
        No ultimo = ultimoNo(this.ultimoNo);
        

        if (filhoEsquerdo(ultimo) == null) {
            novoNo.setPai(ultimo);
            ultimo.setFilhoEsquerdo(novoNo);
        } else {
            novoNo.setPai(ultimo);
            ultimo.setFilhoDireito(novoNo);
        }

        tamanho++;
        this.ultimoNo = novoNo;
        heapUp(ultimoNo);


    }


    private No ultimoNo(No no) {
        
        No pai = pai(no);
        No ultimo;
        
        // System.out.println("Pai -> " + pai.getElemento());
        while (pai != null && filhoDireito(pai) == no) {
            // System.out.println("Pai ->" + pai.getElemento() + "| Filho Direito ->" + no.getElemento());
            no = pai;
            pai = pai(no);
        }

        if (pai == null) {
            ultimo = descer(raiz);

        } else  {
            No irmao = irmaoDireito(no);
            if (irmao == null) {
                ultimo = pai;
            } else {
                ultimo = descer(irmao);
            }
        }

        return ultimo;

    }

    private No descer(No no) {
        
        while (no.getFilhoEsquerdo() != null) {
            no = no.getFilhoEsquerdo();
        }
        return no;
    }

    private void heapUp(No no) {
        
        if (no == raiz) {
            return;
        }
        No pai = pai(no);

        if (pai.getKey() > no.getKey()) {
            swap(no, pai);
            heapUp(pai);
        }
    }

    private void swap(No no1, No no2) {
        Object tempElemento = no1.getElemento();
        int tempKey = no1.getKey();

        no1.setElemento(no2.getElemento());
        no1.setKey(no2.getKey());

        no2.setElemento(tempElemento);
        no2.setKey(tempKey);
    }


}
