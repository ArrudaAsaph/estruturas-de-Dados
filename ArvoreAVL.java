public class ArvoreAVL {

    private No raiz;
    private int tamanho;

    // Construtor
    public ArvoreAVL() {
        this.raiz = null;
        this.tamanho = 0;
    }

    // Métodos auxiliares
    public boolean hasLeft(No atual) {
        return (atual.getFilhoEsquerdo() != null);
    }

    public boolean hasRight(No atual) {
        return (atual.getFilhoDireito() != null);
    }

    public boolean isEmpty() {
        return (tamanho == 0);
    }

    public No raiz() {
        return raiz;
    }

    public int profundidade(No no) {
        if (no == raiz) return 0;
        if (no == null) return -1;
        return 1 + this.profundidade(no.getPai());
    }

    public int altura(No no) {
        if (no == null) return -1;
        int hEsq = altura(no.getFilhoEsquerdo());
        int hDir = altura(no.getFilhoDireito());
        return 1 + Math.max(hEsq, hDir);
    }

    // Inserção
    public void inserir(int chave, Object elemento) {
        if (isEmpty()) {
            No novo_no = new No(chave, elemento);
            raiz = novo_no;
            tamanho++;
        } else {
            No pai = insertRecu(raiz, chave); // encontra o pai para inserir
            No novo_no = new No(chave, elemento);
            novo_no.setPai(pai);
            tamanho++;

            if (pai.getChave() > chave) {
                pai.setFilhoEsquerdo(novo_no);
            } else {
                pai.setFilhoDireito(novo_no);
            }
            atualizarNo(novo_no, true, 0);
        }
    }

    private No insertRecu(No atual, int chave) {
        if (atual.getChave() > chave) {
            return hasLeft(atual) ? insertRecu(atual.getFilhoEsquerdo(), chave) : atual;
        } else {
            return hasRight(atual) ? insertRecu(atual.getFilhoDireito(), chave) : atual;
        }
    }

    // Remoção
    public No remover(int chave) {
        No atual = buscar(raiz, chave, 0);
        tamanho--;

        if (atual == raiz) {
            No raiz_retorno = raiz;
            raiz = null;
            return raiz_retorno;
        }

        No pai = atual.getPai();

        // Nó folha
        if (!hasLeft(atual) && !hasRight(atual)) {
            int filhoEsquerdo;
            if (pai.getFilhoEsquerdo() == atual) {
                pai.setFilhoEsquerdo(null);
                filhoEsquerdo = -1;
            } else {
                pai.setFilhoDireito(null);
                filhoEsquerdo = 1;
            }
            atual.setPai(null);
            atualizarNo(pai, false, filhoEsquerdo);
        }
        return atual;
    }

    private No sucessor(No no) {
        if (no.getFilhoEsquerdo() == null) return no;
        return sucessor(no.getFilhoEsquerdo());
    }

    // Busca
    public No buscar(No no, int chave, int qtd_busca) {
        if (no.getFilhoDireito() == null && no.getFilhoDireito() == null) return no; // base

        if (no.getChave() == chave) {
            System.out.println("Quantidade de interação : " + qtd_busca + "\n");
            return no;
        } else if (chave > no.getChave()) {
            System.out.println("\nChave atual : " + no.getChave());
            return buscar(no.getFilhoDireito(), chave, qtd_busca + 1);
        } else {
            return buscar(no.getFilhoEsquerdo(), chave, qtd_busca + 1);
        }
    }

    // Fator de balanceamento
    private int FB(No no) {
        return (no == null) ? 0 : no.getFator_balanceamento();
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
    System.out.println("Chave: " + no.getChave() + " | FB: " + FB(no));
    System.out.println("Pai: " + (pai != null ? pai.getChave() + " | FB: " + FB(pai) : "null"));
    System.out.println("Filho esquerdo: " + (filhoEsq != null ? filhoEsq.getChave() + " | FB: " + FB(filhoEsq) : "null"));
    System.out.println("Filho direito: " + (filhoDir != null ? filhoDir.getChave() + " | FB: " + FB(filhoDir) : "null"));
    System.out.println("============");
}



    // Rotações
    private No simplesDireita(No pai) {
        No avo;
        No filhoEsquerdo = pai.getFilhoEsquerdo();
        No aux = null;

        imprimirNo(pai);
        if (pai == raiz) {
            avo = null;
            raiz = filhoEsquerdo;
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

        int fb_pai = FB(pai) - 1 - Math.max(FB(filhoEsquerdo), 0);
        int fb_filhoEsquerdo = FB(filhoEsquerdo) - 1 + Math.min(fb_pai, 0);

        pai.setFator_balanceamento(fb_pai);
        filhoEsquerdo.setFator_balanceamento(fb_filhoEsquerdo);

        return filhoEsquerdo;
    }

    private No simplesEsquerda(No pai) {
        No avo;
        No aux = null;
        No filhoDireito = pai.getFilhoDireito();

        imprimirNo(pai);
        if (pai == raiz) {
            avo = null;
            raiz = filhoDireito;
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
        int fb_filhoDireito = FB(filhoDireito) + 1 + Math.max(fb_pai, 0);

        filhoDireito.setFator_balanceamento(fb_filhoDireito);
        pai.setFator_balanceamento(fb_pai);

        return filhoDireito;
    }

    // Atualização 
    private void atualizarNo(No no, boolean tipo, int filhoEsquerdo) {
        if (raiz == no) return;

        if (tipo) { // Inserção
            No pai = no.getPai();
            int fb_pai = pai.getFator_balanceamento();

            if (no == pai.getFilhoEsquerdo()) {
                pai.setFator_balanceamento(fb_pai + 1);

                if (FB(pai) > 1 && FB(pai.getFilhoEsquerdo()) > 0) {
                    simplesDireita(pai);
                }
                if (FB(pai) > 1 && FB(pai.getFilhoEsquerdo()) < 0) {
                    simplesEsquerda(pai.getFilhoEsquerdo());
                    simplesDireita(pai);
                }

                if (FB(pai) == 0) return;
                atualizarNo(pai, tipo, filhoEsquerdo);

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
                atualizarNo(pai, tipo, filhoEsquerdo);
            }
        } else { // Remoção
                        
            no.setFator_balanceamento(FB(no) + filhoEsquerdo);

            if (FB(no) < -1) {

                if (filhoEsquerdo == -1 && FB(no.getFilhoDireito()) < 0) {
                    System.out.print(String.format("************Cheguei ESQUERDO***************** "));
                    imprimirNo(no);
                    simplesEsquerda(no);
                        System.out.print(String.format("\n\n"));

                    no = no.getPai();
                        imprimirNo(no);
                    imprimirNo(no);
                   
                    if (no == no.getPai().getFilhoEsquerdo()) {
                        
                        filhoEsquerdo = -1;
                    } else {
                        filhoEsquerdo = 1;
                    }

                    if (FB(no.getPai()) != 0) return;
                    atualizarNo(no.getPai(), tipo, filhoEsquerdo);
                }
            } else {
                if (FB(no) > 1) {
                    System.out.print(String.format("************Direito***************** "));

                    if (filhoEsquerdo == 1 && FB(no.getFilhoEsquerdo()) > 0) {
                        imprimirNo(no);
                        simplesDireita(no);
                        no = no.getPai();
                        imprimirNo(no);

                        if (no == no.getPai().getFilhoEsquerdo()) {
                            filhoEsquerdo = -1;
                        } else {
                            filhoEsquerdo = 1;
                        }
                        
                        if (FB(no.getPai()) != 0) return;
                        atualizarNo(no.getPai(), tipo, filhoEsquerdo);
                    }
                }
            }
        }
    }

    // Impressão
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

    private void inOrderPrint(No no, String[][] matrix, int[] atualColumn) {
        if (no == null) return;

        if (hasLeft(no))
            inOrderPrint(no.getFilhoEsquerdo(), matrix, atualColumn);

        int row = profundidade(no);
        int column = atualColumn[0]++;
        matrix[row][column] = String.format("%d[%d]", no.getChave(), no.getFator_balanceamento());

        if (hasRight(no))
            inOrderPrint(no.getFilhoDireito(), matrix, atualColumn);
    }
}
