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
            mudarCor(novo_no,"preto");
            tamanho++;
        }
        else {
            tamanho++;
            No pai = buscar(raiz, chave);
            System.out.println("BUSCA ---- CHAVE" + chave);
            imprimirNo(pai);
            No novo_no = new No(pai, chave);

            if (chave >= pai.getChave()) {
                pai.setFilhoDireito(novo_no);
            } else {
                pai.setFilhoEsquerdo(novo_no);

            }

            balancearArvore(novo_no);

        }
        
    }

   

    private void balancearArvore(No atual) {

        // imprimirNo(atual);
        No pai = atual.getPai();
        
        if (pai == null || cor(pai) == "preto") {
            System.out.println("\n\nSAINDOOOO\n\n");
            return;
        }

        Parente parentes = pegarParentes(pai);

        No avo = parentes.getAvo();
        No tio = parentes.getTio();
        No sobrinhoPerto = parentes.getSobrinhoPerto();
        No sobrinhoLonge = parentes.getSobrinhoLonge();

// ========================== CASO 2 ======================================
        if (
            cor(pai) == "vermelho" &&
            cor(tio) == "vermelho" &&
            cor(avo) == "preto" ) {
            System.out.println("Cheguei -----> ANTES");
            print();
            imprimirNo(avo);
            imprimirNo(pai);
            imprimirNo(tio);
            mudarCor(pai, "preto");
            mudarCor(tio, "preto");
            mudarCor(avo, "vermelho");
            System.out.println("Cheguei -----> DEPOIS");

            imprimirNo(avo);
            imprimirNo(pai);
            imprimirNo(tio);

            balancearArvore(avo);
        }


    }

    private Parente pegarParentes(No pai) {
        Parente parentes = new Parente();
        // if (pai == raiz) {
        //     return parentes;
        // } else {
        //     No avo = pai.getPai();
        //     No tio;
        //     if (avo.getFilhoDireito() == pai) {
        //         tio = avo.getFilhoEsquerdo();
        //     } else {
        //         tio = avo.getFilhoDireito();
        //     }

        //     parentes.setAvo(avo);
        //     parentes.setTio(tio);
        //     return parentes;
        // }

        if (pai == raiz) {
            return parentes;
        } else {
            No avo = pai.getPai(); // Pegando vovo
            No tio;
            No sobrinhoPerto;
            No sobrinhoLonge;
            if ( avo.getFilhoDireito() == pai) {
                tio = avo.getFilhoEsquerdo();
                sobrinhoPerto = tio.getFilhoDireito();
                sobrinhoLonge = tio.getFilhoEsquerdo();
            } else {
                tio = avo.getFilhoDireito();
                sobrinhoPerto = tio.getFilhoEsquerdo();
                sobrinhoLonge = tio.getFilhoDireito();
            }

            parentes.setAvo(avo);
            parentes.setTio(tio);
            parentes.setSobrinhoLonge(sobrinhoLonge);
            parentes.setSobrinhoPerto(sobrinhoPerto);

            return parentes;

        }
        
    }


    private void mudarCor(No no, String cor) {
        if (no == null) return;

        if (no == raiz) {
            no.setCor("preto");
        } else {
            no.setCor(cor);
        }
    }

    private String cor(No no) {
        if (no == null) {
            return "preto";
        }
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
 
    public No buscar(No no, int chave) {
        
        // imprimirNo(no);
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


// ========================== FIM -> METODOS GENERICOS ARVORE BINÁRIA ======================================
}
