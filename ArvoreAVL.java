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
            tamanho++;
            novo_no.setPai(pai);
            if (pai.getChave() > chave) {
                pai.setFilhoEsquerdo(novo_no);
                atualizarFB(novo_no, true);
            } else {
                pai.setFilhoDireito(novo_no);
                atualizarFB(novo_no, true);

            }
            
        }
    }

    private void atualizarFB(No no, boolean tipo) {
        if (tipo) {
           atualizaPai(no, no.getPai());


           while (no != null && FB(no.getPai()) != 0) {
                no = no.getPai();
                atualizaPai(no, no.getPai());
                // if (FB(no) > 1 && FB(no.getFilhoEsquerdo()) > 0) {
                //     System.out.println("Simples a direita\n");
                //     System.out.println(String.format("No = %d | FB(%d)\n", no.getChave(), FB(no)));
                //     System.out.println(String.format("FilhoEsquerdo = %d | FB(%d)", no.getFilhoEsquerdo().getChave(), FB(no.getFilhoEsquerdo())));

                //     print();
                //     System.out.println("-------------------------------------------------------");
                //     simplesDireita(no);
                //     print();
                //     System.out.println("-------------------------------------------------------");

                // }
                }
 
        }
    }

    private int FB(No no) {
        if (no == null) return 0;
        return no.getFator_balanceamento();
    }

    private void simplesDireita(No pai) {
        No avo = pai.getPai();

        No filhoEsquerdo = pai.getFilhoEsquerdo();
        No filhoDireito = pai.getFilhoDireito();
        
        filhoEsquerdo.setPai(avo);
        
        avo.setFilhoEsquerdo(filhoEsquerdo);
        
        pai.setPai(filhoEsquerdo);
        
        pai.setFilhoEsquerdo(filhoDireito);
                
        filhoEsquerdo.setFilhoDireito(pai);
        
        int fb_pai = FB(pai) - 1 - Math.max(FB(filhoEsquerdo), 0);
        int fb_filhoEsquerdo = FB(filhoEsquerdo) - 1 + Math.min(fb_pai,0);

        filhoEsquerdo.setFator_balanceamento(fb_filhoEsquerdo);
        pai.setFator_balanceamento(fb_pai);


        
        

    }

    

    private void atualizaPai(No no, No pai) {
        if (no == raiz ||no == null) return;
        if (pai.getFilhoEsquerdo() == no) {
            pai.setFator_balanceamento(pai.getFator_balanceamento() + 1);
        } else {
            pai.setFator_balanceamento(pai.getFator_balanceamento() -1 );
        }
    }

    public No raiz() {
        return raiz;
    }
 
     private No insertRecu(No atual, int chave) {
    if (atual.getChave() > chave) {
        if (hasLeft(atual)) {
            return insertRecu(atual.getFilhoEsquerdo(), chave); 
        } else {
            return atual;
        }
    } else {
        if (hasRight(atual)) {
            return insertRecu(atual.getFilhoDireito(), chave); 
        } else {
            return atual;
        }
    }
}

    public int altura(No no) {
        if (no == null) 
            return -1;

        int hEsq = altura(no.getFilhoEsquerdo());
        int hDir = altura(no.getFilhoDireito());

        return 1 + Math.max(hEsq, hDir);
    }


    public void print() {
        if (this.isEmpty()) 
            throw new RuntimeException("A árvore está vazia");

        int rows = this.altura(raiz) + 1; 
        int columns = tamanho;
        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = " ";
            }
        }

        int[] atualColumn = {0};
        this.inOrderPrint(this.raiz, matrix, atualColumn); 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(String.format("%-10s", matrix[i][j]));
            }
            System.out.println("\n");
        }
    }


    private void inOrderPrint(No no, String[][] matrix, int[] atualColumn) {
        if (no == null)
            return;

        if (hasLeft(no))
            inOrderPrint(no.getFilhoEsquerdo(), matrix, atualColumn);

        int row = profundidade(no); 
        int column = atualColumn[0]++;
        matrix[row][column] = String.format("%d[%d]", no.getChave(), no.getFator_balanceamento());

       
        if (hasRight(no))
            inOrderPrint(no.getFilhoDireito(), matrix, atualColumn);
    }

    public int profundidade(No no) {
        if (no == raiz) return 0;
        else
            return 1 + this.profundidade(no.getPai());
    }
}