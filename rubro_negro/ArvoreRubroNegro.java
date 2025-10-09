package rubro_negro;

public class ArvoreRubroNegro {
    private No raiz;

    private int tamanho;

    public ArvoreRubroNegro() {
        this.raiz = null;
        this.tamanho = 0;
    }


    public void inserir(int chave) {

        if (isEmpty()) {
            No novo_no = new No(null, chave);
            raiz = novo_no;
            mudarCor(novo_no);
            tamanho++;
        }
        else {
            tamanho++;
            No pai = buscar(raiz, chave);
            No novo_no = new No(pai, chave);

            if (chave >= pai.getChave()) {
                pai.setFilhoDireito(novo_no);
            } else {
                pai.setFilhoEsquerdo(novo_no);

            }


        }
        
    }

    public No buscar(No no, int chave) {
        
        imprimirNo(no);
        if (
            no.getFilhoDireito() == null || 
            no.getFilhoEsquerdo() == null )
            {

            return no;
        }

        if (chave == no.getChave()) {
            return no;
        }
        else if (chave > no.getChave()) {
            System.out.println("Chegeuei");
            return buscar(no.getFilhoDireito(), chave);
        } else {
            return buscar(no.getFilhoEsquerdo(), chave);
        } 


    }


    private void mudarCor(No no) {
        if (no == raiz) {
            no.setCor("preto");
        }
    }

    private String cor(No no) {
        return no.getCor();
    }
// ========================== METODOS GENERICOS ARVORE BINÁRIA ======================================
    private No pai(No no) {
        return no.getPai();
    }


// ========================== METODOS GENERICOS ARVORE BINÁRIA ======================================
    public boolean isEmpty() {
        return tamanho == 0;
    }

    public No raiz() {
        return raiz;
    }

    public boolean hasLeft(No atual) {
        return (atual.getFilhoEsquerdo() != null);
    }

    public boolean hasRight(No atual) {
        return (atual.getFilhoDireito() != null);
    }

    public int altura(No no) {
        if (no == null) return -1;
        int hEsq = altura(no.getFilhoEsquerdo());
        int hDir = altura(no.getFilhoDireito());
        return 1 + Math.max(hEsq, hDir);
    }

    public int profundidade(No no) {
        if (no == raiz) return 0;
        if (no == null) return -1;
        return 1 + this.profundidade(no.getPai());
    }
    
    private void inOrderPrint(No no, String[][] matrix, int[] atualColumn) {
        if (no == null) return;

        if (hasLeft(no))
            inOrderPrint(no.getFilhoEsquerdo(), matrix, atualColumn);

        int row = profundidade(no);
        int column = atualColumn[0]++;
        String corTexto = no.getCor().equalsIgnoreCase("vermelho") ? "\u001B[31m" : "\u001B[30m"; // vermelho ou preto
        String reset = "\u001B[0m"; // reseta a cor
        matrix[row][column] = String.format("%s%d%s[%s]", corTexto, no.getChave(), reset, no.getCor());


        if (hasRight(no))
            inOrderPrint(no.getFilhoDireito(), matrix, atualColumn);
    }

    public void print() {
        if (this.isEmpty())
            throw new RuntimeException("A árvore está vazia");

        int rows = this.altura(raiz) + 1;
        int columns = tamanho * 2;
        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = " ";

        int[] atualColumn = {0};
        this.inOrderPrint(this.raiz, matrix, atualColumn);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                System.out.print(String.format("%-10s", matrix[i][j]));
            System.out.println("\n");
        }

        System.out.println("-------------------------------------------------------");
    }

    public void imprimirNo(No no) {
        if (no == null) {
            System.out.println("Nó é null.");
            return;
        }

        No pai = no.getPai();
        No filhoEsq = no.getFilhoEsquerdo();
        No filhoDir = no.getFilhoDireito();

        System.out.println("==== Nó ====");
        System.out.println("Chave: " + no.getChave() + " | cor: " + cor(no));
        System.out.println("Pai: " + (pai != null ? pai.getChave() + " | cor: " + cor(pai) : "null"));
        System.out.println("Filho esquerdo: " + (filhoEsq != null ? filhoEsq.getChave() + " | cor: " + cor(filhoEsq) : "null"));
        System.out.println("Filho direito: " + (filhoDir != null ? filhoDir.getChave() + " | cor: " + cor(filhoDir) : "null"));
    System.out.println("============");
}
 // ========================== FIM -> METODOS GENERICOS ARVORE BINÁRIA ======================================
}
