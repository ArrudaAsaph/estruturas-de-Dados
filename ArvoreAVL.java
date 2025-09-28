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
        //    atualizaPai(no, no.getPai());
            atualizarNo(no, tipo);

        //    while (no != null && FB(no.getPai()) != 0) {
        //         no = no.getPai();
        //         atualizaPai(no, no.getPai());
        //         // if (FB(no) > 1 && FB(no.getFilhoEsquerdo()) > 0) {
        //         //     System.out.println("Simples a direita\n");
        //         //     System.out.println(String.format("No = %d | FB(%d)\n", no.getChave(), FB(no)));
        //         //     System.out.println(String.format("FilhoEsquerdo = %d | FB(%d)", no.getFilhoEsquerdo().getChave(), FB(no.getFilhoEsquerdo())));

        //         //     print();
        //         //     System.out.println("-------------------------------------------------------");
        //         //     simplesDireita(no);
        //         //     print();
        //         //     System.out.println("-------------------------------------------------------");

        //         // }
        //         }
 
        }
    }

    private int FB(No no) {
        if (no == null) return 0;
        return no.getFator_balanceamento();
    }

    private void simplesDireita(No pai) {
        // System.out.print(String.format("SIMPLES DIREITA \n"));
        // System.out.print(String.format("Pai : %d | FB : %d \n",pai.getChave(), FB(pai)));
        // System.out.print(String.format("Filho : %d | FB : %d \n",pai.getFilhoEsquerdo().getChave(), FB(pai.getFilhoEsquerdo())));
        
        

        //                      AVO
        //                  PAI
        //      fEsquerdo
        // elemtno

        // AVO --(FilhoEsquerdo)--> Pai
        // PAI --(FilhoEsquerdo)--> fEsquerdo
        // Fesquerdo --(Pai)--> Pai

        // AVO --(FilhoEsquerdo)--> fEsquerdo
        // fEsquerdo --(FilhoDireito)--> Pai
        // PAI --(Pai)--> fEsquerdo
        if (pai == null) return;
        No avo;
        No filhoEsquerdo = pai.getFilhoEsquerdo();
        No aux = null;
        if (pai == raiz) {
            avo = null;
            raiz = filhoEsquerdo; // Novo Raiz
        } else {
            avo = pai.getPai();
            if (avo.getFilhoDireito() == pai) {
                avo.setFilhoDireito(filhoEsquerdo);
            } else {
                avo.setFilhoDireito(filhoEsquerdo);
            }

        }

        if (filhoEsquerdo.getFilhoDireito() != null) {
            aux = filhoEsquerdo.getFilhoDireito();
            aux.setPai(pai);
        } 

        filhoEsquerdo.setPai(avo);
        filhoEsquerdo.setFilhoDireito(pai);
        
        pai.setPai(filhoEsquerdo);
        
        pai.setFilhoEsquerdo(aux);

        int fb_pai = FB(pai) - 1 - Math.max(FB(filhoEsquerdo),0);

        int fb_filhoEsquerdo = FB(filhoEsquerdo) - 1 + Math.min(fb_pai,0);
        
        pai.setFator_balanceamento(fb_pai);
        filhoEsquerdo.setFator_balanceamento(fb_filhoEsquerdo);

    }


    private void simplesEsquerda(No pai) {
        // System.out.print(String.format("SIMPLES ESQUERDA \n"));
        // System.out.print(String.format("Pai : %d | FB : %d \n",pai.getChave(), FB(pai)));
        // System.out.print(String.format("Filho : %d | FB : %d \n",pai.getFilhoDireito().getChave(), FB(pai.getFilhoDireito())));

        if (pai == null) return;
        print();

        No avo;
        No aux = null;
        No filhoDireito = pai.getFilhoDireito();
        if (pai == raiz) {
            avo = null;
            raiz = filhoDireito; // Novo raiz
        } else {
            avo = pai.getPai();
            if (avo.getFilhoEsquerdo() == pai) {
                avo.setFilhoEsquerdo(filhoDireito);
            } else {
                avo.setFilhoDireito(filhoDireito);
            }
        }

        if (filhoDireito.getFilhoEsquerdo() != null) {
            aux = filhoDireito.getFilhoEsquerdo();
            aux.setPai(pai);
        }

        filhoDireito.setPai(avo);
        filhoDireito.setFilhoEsquerdo(pai);

        pai.setPai(filhoDireito);

        pai.setFilhoDireito(aux);

       
        
        int fb_pai = FB(pai) + 1 - Math.min(FB(filhoDireito), 0);
        int fb_filhoDireito = FB(filhoDireito) + 1 + Math.max(fb_pai,0);

        filhoDireito.setFator_balanceamento(fb_filhoDireito);

        pai.setFator_balanceamento(fb_pai);

        
       
    }
    private void atualizarNo(No no, boolean tipo) {
        if (raiz == no) return;
        if (tipo) {
            No pai = no.getPai();
            int fb_pai = pai.getFator_balanceamento();
            if (no == pai.getFilhoEsquerdo()) {
                pai.setFator_balanceamento(fb_pai + 1);
                
                if (FB(pai) > 1 && FB(pai.getFilhoEsquerdo()) > 0 ) {
                    simplesDireita(pai);
                } 
                if (FB(pai) > 1 && FB(pai.getFilhoEsquerdo()) < 0) {
                    simplesEsquerda(pai.getFilhoEsquerdo());
                    // System.out.println("Pai : " + pai.getChave() + "fEsquerdo : " + pai.getFilhoEsquerdo().getChave() +"f Direito : "+ pai.getFilhoDireito().getChave());
                    simplesDireita(pai);
                }
                
                if (FB(pai) == 0) return; // Condição de parada inserção


                atualizarNo(pai,tipo);
            } else {
                pai.setFator_balanceamento(fb_pai - 1);

                if (FB(pai) < -1 && FB(pai.getFilhoDireito()) < 0) {
                    simplesEsquerda(pai);
                }
                if (FB(pai) < -1 && FB(pai.getFilhoDireito()) > 0) {
                    simplesDireita(pai.getFilhoDireito());
                    simplesEsquerda(pai);
                }

                if (FB(pai) == 0) return;
                atualizarNo(pai, tipo);
            }
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
        int columns = tamanho * 2;
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

        System.out.println("-------------------------------------------------------");

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