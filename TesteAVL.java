public class TesteAVL {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        // Inserindo alguns elementos
        arvore.inserir(50, "A");
        arvore.print();
        System.out.println("-------------------------------------------------------");
        arvore.inserir(70, "C");
        arvore.print();
        System.out.println("-------------------------------------------------------");
        arvore.inserir(20, "C");
        arvore.print();
        System.out.println("-------------------------------------------------------");
        arvore.inserir(80, "C");
        arvore.print();
        System.out.println("-------------------------------------------------------");
        arvore.inserir(10, "C");
        arvore.print();
        System.out.println("-------------------------------------------------------");
        arvore.inserir(8, "C");
        arvore.print();
        System.out.println("-------------------------------------------------------");
        arvore.inserir(75, "C");
        arvore.print();
        System.out.println("-------------------------------------------------------");
        
        

        // Impressão da árvore em ordem (esquerda -> raiz -> direita)
        System.out.println("Impressão em ordem:");
        arvore.print();
    }

    // Método auxiliar para impressão em ordem
    private static void imprimirInOrdem(No no) {
        if (no != null) {
            imprimirInOrdem(no.getFilhoEsquerdo());
            System.out.println("Chave: " + no.getChave() + " | Elemento: " + no.getElemento());
            imprimirInOrdem(no.getFilhoDireito());
        }
    }
}
