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
            mudarCor(novo_no, "preto");
            tamanho++;
        } else {
            No pai = buscar(raiz, chave);
            if (pai.getChave() == chave) {
                System.out.println("Não é permito adicionar dois valores iguais");
            } else {
                tamanho++;
                // System.out.println("BUSCA ---- CHAVE " + chave);
                // imprimirNo(pai);
                No novo_no = new No(pai, chave);

                if (chave >= pai.getChave()) {
                    pai.setFilhoDireito(novo_no);
                } else {
                    pai.setFilhoEsquerdo(novo_no);

                }

                balancearArvore(novo_no);

            }

        }

    }

    public void remover(int chave) {
        if (isEmpty()) {
            System.out.println("Não é possivel remover, árvore vazia");
        } else {
            No no_removido = buscar(raiz, chave);
            //System.out.println("NO ACHADO REMOÇÃO");
            //imprimirNo(no_removido);

            if (no_removido.getChave() != chave) {
                System.out.println("No não existente");
            } else {
                tamanho--;
                No no_sucessor;

                if (no_removido.getFilhoDireito() != null) {
                    no_sucessor = sucessor(no_removido.getFilhoDireito());
                } else if (no_removido.getFilhoEsquerdo() != null) {
                    no_sucessor = no_removido.getFilhoEsquerdo();
                }
                else {
                    if (no_removido == raiz) {
                        raiz = null;
                        return;
                    }
                    no_sucessor = no_removido;
                }
                removerNos(no_removido, no_sucessor);
            }
        }
    }

    private void balancearArvore(No atual) {

        // imprimirNo(atual);
        No pai = atual.getPai();

        if (pai == null || cor(pai) == "preto") {
           // System.out.println("\n\nSAINDOOOO\n\n");
            return;
        }

        Parente parentes = pegarParentes(pai);

        No avo = parentes.getAvo();
        No tio = parentes.getTio();
        No sobrinhoPerto = parentes.getSobrinhoPerto();
        No sobrinhoLonge = parentes.getSobrinhoLonge();

        // ========================== CASO 2 ======================================
        if (cor(pai) == "vermelho" &&
                cor(tio) == "vermelho" &&
                cor(avo) == "preto") {
           // System.out.println("Cheguei -----> ANTES");
            //print();
            // imprimirNo(avo);
            // imprimirNo(pai);
            // imprimirNo(tio);
            mudarCor(pai, "preto");
            mudarCor(tio, "preto");
            mudarCor(avo, "vermelho");
            //System.out.println("Cheguei -----> DEPOIS");

            // imprimirNo(avo);
            // imprimirNo(pai);
            // imprimirNo(tio);

            balancearArvore(avo);
        }
        // ========================== CASO 3 ======================================
        if (cor(pai) == "vermelho" &&
                cor(tio) == "preto" &&
                cor(avo) == "preto") {

            //print();
            // ========================== simples Esquerda ==========================
            if (isFilhoDireito(pai) && isFilhoDireito(atual)) {
                Parente parente = simplesEsquerda(pai);
                pai = parente.getPai();
                avo = parente.getAvo();

                // mudar a cor
                mudarCor(pai, "preto");
                mudarCor(avo, "vermelho");
            }
            // ========================== Dupla Esquerda ==========================
            else if (isFilhoDireito(pai) && !isFilhoDireito(atual)) {
                Parente parente = simplesDireita(atual);

                parente = simplesEsquerda(parente.getPai());

                pai = parente.getPai();
                avo = parente.getAvo();

                // mudar a cor
                mudarCor(pai, "preto");
                mudarCor(avo, "vermelho");
            }
            // ========================== Simples Direita ==========================
            else if (!isFilhoDireito(pai) && !isFilhoDireito(atual)) {
                Parente parente = simplesDireita(pai);

                pai = parente.getPai();
                avo = parente.getAvo();
                // mudar a cor
                mudarCor(pai, "preto");
                mudarCor(avo, "vermelho");
            }
            // ========================== Dupla Direita ==========================
            else if (!isFilhoDireito(pai) && isFilhoDireito(atual)) {
                Parente parente = simplesEsquerda(atual);

                parente = simplesDireita(parente.getPai());
                pai = parente.getPai();
                avo = parente.getAvo();
                // mudar a cor
                mudarCor(pai, "preto");
                mudarCor(avo, "vermelho");
            }

        }

    }

    private void removerNos(No removido, No sucessor) {
       // System.out.println("Removido");
        ///imprimirNo(removido);
       // System.out.println("Sucessor");
        imprimirNo(sucessor);
        if (cor(removido) == "vermelho" && cor(sucessor) == "vermelho") {
            trocarNos(removido, sucessor);
            removeNo(removido);
            return;
        }
        
        if (cor(removido) == "preto" && cor(sucessor) == "vermelho") {
            trocarNos(removido, sucessor);
            mudarCor(sucessor, "preto");
            removeNo(removido);
            return;
        }

        
        //System.out.println("Removido");
        //imprimirNo(removido);
        //System.out.println("Sucessor");
       // imprimirNo(sucessor);
        balancearArvoreRemocao(sucessor);
        trocarNos(removido, sucessor);
        //print();
        removeNo(removido);
    }

    private void balancearArvoreRemocao(No sucessor) {

        if (sucessor == raiz) {
            return;
        }

        Parente parentes = pegarParentes(sucessor);
        No tio = parentes.getTio();
        No sobrinhoLonge = parentes.getSobrinhoLonge();
        No sobrinhoPerto = parentes.getSobrinhoPerto();
        No avo = parentes.getAvo();

       // System.out.println("=============================");
       // System.out.println("============ Avo ============");
       // imprimirNo(avo);
       // System.out.println("============ Sucessor ============");
      //  imprimirNo(sucessor);
       // System.out.println("============ Irmao ============");
      //  imprimirNo(tio);
      //  System.out.println("============ Sobrinho Perto ============");
      //  imprimirNo(sobrinhoPerto);
      //  System.out.println("============ Sobrinho Longe ============");
      //  imprimirNo(sobrinhoLonge);
       // 
     //   System.out.println("=============================");

        // Caso 1
        if (cor(tio) == "vermelho") {
            remocaoCaso1(avo, tio);
        }

        // Caso 4
        if (cor(sobrinhoLonge) == "vermelho") {
            remocaoCaso4(avo, tio, sobrinhoLonge);
            return;
        }
        // Caso 3
        if (cor(sobrinhoPerto) == "vermelho") {
            remocaoCaso3(tio, sobrinhoPerto);
            //print();
            parentes = pegarParentes(sucessor);
            tio = parentes.getTio();
            sobrinhoLonge = parentes.getSobrinhoLonge();
            sobrinhoPerto = parentes.getSobrinhoPerto();
            avo = parentes.getAvo();

            remocaoCaso4(avo, tio, sobrinhoLonge);
            return;
        }

        // Caso 2b
        if (cor(avo) == "vermelho") {
            System.out.println("Chegueiiii");
            mudarCor(avo, "preto");
            mudarCor(tio, "vermelho");
            return;
        }
        else {
            mudarCor(tio, "vermelho");
            balancearArvoreRemocao(avo);
        }

        
    }

    private void remocaoCaso1(No pai, No tio) {
        if (isFilhoDireito(tio)) {
            simplesEsquerda(tio);
        } else {
            simplesDireita(tio);
        }

        mudarCor(pai, "vermelho");
        mudarCor(tio, "preto");
    }

    private void remocaoCaso4(No pai, No tio, No sobrinhoLonge) {
        if (isFilhoDireito(tio)) {
            simplesEsquerda(tio);
        } else {
            simplesDireita(tio);
        }

        tio.setCor(cor(pai));
        mudarCor(pai, "preto");
        mudarCor(sobrinhoLonge, "preto");

    }

    private void remocaoCaso3(No tio, No sobrinhoPerto) {
        if (isFilhoDireito(sobrinhoPerto)) {
            simplesEsquerda(sobrinhoPerto);
        } else {
            simplesDireita(sobrinhoPerto);
        }

        mudarCor(tio, "vermelho");
        mudarCor(sobrinhoPerto, "preto");
    }

    private Parente simplesEsquerda(No pai) {
        Parente parentes = new Parente();
        No avo = pai.getPai();
        No filhoEsquerdo = pai.getFilhoEsquerdo();

        No bisavo = avo.getPai();
        if (avo == raiz) {
            raiz = pai;
        }

        if (bisavo != null) {
            if (isFilhoDireito(avo)) {
                bisavo.setFilhoDireito(pai);
            } else {
                bisavo.setFilhoEsquerdo(pai);
            }
        }

        pai.setPai(bisavo);

        pai.setFilhoEsquerdo(avo);

        avo.setPai(pai);

        avo.setFilhoDireito(filhoEsquerdo);

        parentes.setPai(pai);
        parentes.setAvo(avo);

        return parentes;
    }

    private Parente simplesDireita(No pai) {
        Parente parentes = new Parente();
        No avo = pai.getPai();
        No filhoDireito = pai.getFilhoDireito();

        No bisavo = avo.getPai();
        if (avo == raiz) {
            raiz = pai;
        }
        if (bisavo != null) {
            if (isFilhoDireito(avo)) {
                bisavo.setFilhoDireito(pai);
            } else {
                bisavo.setFilhoEsquerdo(pai);
            }
        }
        pai.setPai(bisavo);

        pai.setFilhoDireito(avo);

        avo.setPai(pai);

        avo.setFilhoEsquerdo(filhoDireito);

        parentes.setPai(pai);
        parentes.setAvo(avo);

        return parentes;

    }

    private Parente pegarParentes(No pai) {
        Parente parentes = new Parente();

        if (pai == raiz) {
            return parentes;
        } else {

            No avo = pai.getPai(); // Pegando vovo
            No tio;
            No sobrinhoPerto;
            No sobrinhoLonge;
            if (avo.getFilhoDireito() == pai) {
                tio = avo.getFilhoEsquerdo();
                if (tio == null) {
                    sobrinhoLonge = null;
                    sobrinhoPerto = null;
                } else {
                    sobrinhoPerto = tio.getFilhoDireito();
                    sobrinhoLonge = tio.getFilhoEsquerdo();
                }

            } else {
                tio = avo.getFilhoDireito();
                if (tio == null) {
                    sobrinhoLonge = null;
                    sobrinhoPerto = null;
                } else {
                    sobrinhoPerto = tio.getFilhoEsquerdo();
                    sobrinhoLonge = tio.getFilhoDireito();
                }

            }

            parentes.setAvo(avo);
            parentes.setTio(tio);
            parentes.setSobrinhoLonge(sobrinhoLonge);
            parentes.setSobrinhoPerto(sobrinhoPerto);

            return parentes;

        }

    }

    private void mudarCor(No no, String cor) {
        if (no == null)
            return;

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

    // ========================== METODOS GENERICOS ARVORE BINÁRIA
    // ======================================
    private No pai(No no) {
        return no.getPai();
    }

    private boolean isFilhoDireito(No no) {
        return no.getPai().getFilhoDireito() == no;
    }

    private No sucessor(No no) {
        if (no.getFilhoEsquerdo() == null)
            return no;

        return sucessor(no.getFilhoEsquerdo());
    }

    private void trocarNos(No no1, No no2) {

        No paiNo1 = no1.getPai();
        No paiNo2 = no2.getPai();

        if (no1 == raiz) {
            raiz = no2;
        } else {
            if (paiNo1 != null) {
                if (isFilhoDireito(no1)) {
                    paiNo1.setFilhoDireito(no2);
                } else {
                    paiNo1.setFilhoEsquerdo(no2);
                }
            }
        }
        boolean no2FilhoDireito = isFilhoDireito(no2);
        no2.setPai(paiNo1);

        boolean no2FilhoDireitoNo1 = no2 == no1.getFilhoDireito();
        boolean no2FilhoEsquerdoNo1 = no2 == no1.getFilhoEsquerdo();

        No filhoDireitoNo1 = no1.getFilhoDireito();
        No filhoEsquerdoNo1 = no1.getFilhoEsquerdo();
        No filhoDireitoNo2 = no2.getFilhoDireito();
        No filhoEsquerdoNo2 = no2.getFilhoEsquerdo();

        // No2 é o filho direito do no1
        if (no2FilhoDireitoNo1) {
            no2.setFilhoDireito(no1);
            no2.setFilhoEsquerdo(filhoEsquerdoNo1);
            
            if (filhoEsquerdoNo1 != null) {
                filhoEsquerdoNo1.setPai(no2);
            }
            
            no1.setPai(no2);
            no1.setFilhoDireito(filhoDireitoNo2);
            no1.setFilhoEsquerdo(filhoEsquerdoNo2);
            
            if (filhoDireitoNo2 != null) {
                filhoDireitoNo2.setPai(no1);
            }
            if (filhoEsquerdoNo2 != null) {
                filhoEsquerdoNo2.setPai(no1);
            }
        } 
        // No2 é o filho esquerdo do no1
        else if (no2FilhoEsquerdoNo1) {
            no2.setFilhoEsquerdo(no1);
            no2.setFilhoDireito(filhoDireitoNo1);
            
            if (filhoDireitoNo1 != null) {
                filhoDireitoNo1.setPai(no2);
            }
            
            no1.setPai(no2);
            no1.setFilhoDireito(filhoDireitoNo2);
            no1.setFilhoEsquerdo(filhoEsquerdoNo2);
            
            if (filhoDireitoNo2 != null) {
                filhoDireitoNo2.setPai(no1);
            }
            if (filhoEsquerdoNo2 != null) {
                filhoEsquerdoNo2.setPai(no1);
            }
        } 

        else {
            // Atualiza pai do no2
            if (paiNo2 != null) {
                if (no2FilhoDireito) {
                    paiNo2.setFilhoDireito(no1);
                } else {
                    paiNo2.setFilhoEsquerdo(no1);
                }
            }
            no1.setPai(paiNo2);

    
            no1.setFilhoEsquerdo(filhoEsquerdoNo2);
            no1.setFilhoDireito(filhoDireitoNo2);
            
            if (filhoEsquerdoNo2 != null) {
                filhoEsquerdoNo2.setPai(no1);
            }
            if (filhoDireitoNo2 != null) {
                filhoDireitoNo2.setPai(no1);
            }

    
            no2.setFilhoEsquerdo(filhoEsquerdoNo1);
            no2.setFilhoDireito(filhoDireitoNo1);
            
            if (filhoEsquerdoNo1 != null) {
                filhoEsquerdoNo1.setPai(no2);
            }
            if (filhoDireitoNo1 != null) {
                filhoDireitoNo1.setPai(no2);
            }
        }
    }
    
    private void removeNo(No no) {
        if (no == raiz) {
            raiz = null;
        } else {
            No pai = no.getPai();
            No filho = no.getFilhoDireito();
            if (isFilhoDireito(no)) {
                pai.setFilhoDireito(filho);
            } else {
                pai.setFilhoEsquerdo(filho);
            }

            if (filho != null) {
                filho.setPai(pai);
            }

            no.setPai(null);
        }

    }

    // ========================== METODOS GENERICOS ARVORE BINÁRIA
    // ======================================
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
        if (no == null)
            return -1;
        int hEsq = altura(no.getFilhoEsquerdo());
        int hDir = altura(no.getFilhoDireito());
        return 1 + Math.max(hEsq, hDir);
    }

    public int profundidade(No no) {
        if (no == raiz)
            return 0;
        if (no == null)
            return -1;
        return 1 + this.profundidade(no.getPai());
    }

    private void inOrderPrint(No no, String[][] matrix, int[] atualColumn) {
        if (no == null)
            return;

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

    // public void print() {
    // if (this.isEmpty())
    // throw new RuntimeException("A árvore está vazia");

    // int rows = this.altura(raiz) + 1;
    // int columns = tamanho * 2;
    // String[][] matrix = new String[rows][columns];

    // for (int i = 0; i < rows; i++)
    // for (int j = 0; j < columns; j++)
    // matrix[i][j] = " ";

    // int[] atualColumn = {0};
    // this.inOrderPrint(this.raiz, matrix, atualColumn);

    // for (int i = 0; i < rows; i++) {
    // for (int j = 0; j < columns; j++)
    // System.out.print(String.format("%-10s", matrix[i][j]));
    // System.out.println("\n");
    // }

    // System.out.println("-------------------------------------------------------");
    // }

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
        System.out.println(
                "Filho esquerdo: " + (filhoEsq != null ? filhoEsq.getChave() + " | cor: " + cor(filhoEsq) : "null"));
        System.out.println(
                "Filho direito: " + (filhoDir != null ? filhoDir.getChave() + " | cor: " + cor(filhoDir) : "null"));
        System.out.println("============");
    }

    public No buscar(No no, int chave) {

        // System.out.println("No que foi passado");
        // imprimirNo(no);
        if (no == null)
            return null;

        if (chave == no.getChave()) {
            return no;
        }

        if ((chave < no.getChave() && no.getFilhoEsquerdo() == null) ||
                (chave > no.getChave() && no.getFilhoDireito() == null)) {
            return no;
        }

        else if (chave > no.getChave()) {
           // System.out.println("Chegeuei");
            return buscar(no.getFilhoDireito(), chave);
        } else {
            return buscar(no.getFilhoEsquerdo(), chave);
        }

    }

    public void print() {
        if (this.isEmpty()) {
            System.out.println("Árvore vazia");
            return;
        }

        int altura = this.altura(raiz);
        int largura = (int) Math.pow(2, altura + 1) * 3;
        String[][] matrix = new String[altura * 2 + 1][largura];

        // Inicializar matriz com espaços
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = " ";
            }
        }

        preencherMatrix(raiz, matrix, 0, largura / 2, largura / 4);

        // Imprimir matriz
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ÁRVORE RUBRO-NEGRO (Altura: " + altura + ", Tamanho: " + tamanho + ")");
        System.out.println("=".repeat(60));

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder linha = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                linha.append(matrix[i][j]);
            }
            System.out.println(linha.toString().replaceAll("\\s+$", "")); // Remove espaços finais
        }
        System.out.println("=".repeat(60));

        // Estatísticas
        System.out.println("Raiz: " + raiz.getChave() + "[" + raiz.getCor() + "]");
        System.out.println("Altura negra: " + calcularAlturaNegra(raiz));
        System.out.println("=".repeat(60));
    }

    private void preencherMatrix(No no, String[][] matrix, int linha, int coluna, int offset) {
        if (no == null)
            return;

        // Cor do nó
        String cor = no.getCor();
        String corTexto = cor.equals("vermelho") ? "\u001B[31m" : "\u001B[30m";
        String reset = "\u001B[0m";

        // Formatar nó
        String noStr = String.format("%s%d%s", corTexto, no.getChave(), reset);
        matrix[linha][coluna] = noStr;

        // Conectores para filhos
        if (hasLeft(no)) {
            matrix[linha + 1][coluna - offset / 2] = "/";
            preencherMatrix(no.getFilhoEsquerdo(), matrix, linha + 2, coluna - offset, offset / 2);
        }

        if (hasRight(no)) {
            matrix[linha + 1][coluna + offset / 2] = "\\";
            preencherMatrix(no.getFilhoDireito(), matrix, linha + 2, coluna + offset, offset / 2);
        }
    }

    private int calcularAlturaNegra(No no) {
        if (no == null)
            return 0;
        int alturaEsq = calcularAlturaNegra(no.getFilhoEsquerdo());
        int alturaDir = calcularAlturaNegra(no.getFilhoDireito());
        int incremento = no.getCor().equals("preto") ? 1 : 0;
        return Math.max(alturaEsq, alturaDir) + incremento;
    }

    // ========================== FIM -> METODOS GENERICOS ARVORE BINÁRIA
    // ======================================
}
