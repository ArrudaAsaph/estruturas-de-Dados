public class ArvoreAVL {
    private No raiz;
    private int tamanho;


    public ArvoreAVL() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public boolean hasLeft(No atual) {
        return (atual.getFilhoEsquerdo() != null);
    }

    public boolean hasRight(No atual) {
        return (atual.getFilhoDireito() != null);
    }

    public boolean isEmpty() {
        return (tamanho == 0);
    }

    public void inserir(int chave, Object elemento) {
        if (isEmpty()) {
            No novo_no = new No(chave, elemento);
            tamanho++;
            raiz = novo_no;
        } else {
            No pai = insertRecu(raiz, chave);
            No novo_no = new No(chave, elemento);
            novo_no.setPai(pai);
            if (pai.getChave() > chave) {
                pai.setFilhoEsquerdo(novo_no);
            } else {
                pai.setFilhoDireito(novo_no);
            }
            tamanho++;
        }
    }

    private void atualizarFB(No no, boolean tipo) {
        if (tipo) {
            
            while (FB()) 
        }
    }

    private int FB(No no) {
        return no.getFator_balanceamento();
    }

     private No insertRecu(No atual, int chave) {
        if (atual.getChave() > chave) {
            if (hasLeft(atual)){
                insertRecu(atual.getFilhoEsquerdo(), chave);
            } else {
                return atual;
            }
        } else {
            if (hasRight(atual)) {
                insertRecu(atual.getFilhoDireito(), chave);
            } else{
                return atual;
            }
        }
        return null;
     }
 
}