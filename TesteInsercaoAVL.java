public class TesteInsercaoAVL {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();

        System.out.println("=== Teste 1: Inserção crescente (gera rotações simples à esquerda) ===");
        for (int i = 10; i <= 50; i += 10) {
            avl.inserir(i, avl);
            avl.print();
        }

        System.out.println("\n=== Teste 2: Inserção decrescente (gera rotações simples à direita) ===");
        avl = new ArvoreAVL(); // nova árvore
        for (int i = 50; i >= 10; i -= 10) {
            avl.inserir(i, avl);
            avl.print();
        }

        System.out.println("\n=== Teste 3: Inserção para forçar rotação dupla esquerda-direita ===");
        avl = new ArvoreAVL();
        avl.inserir(30,"a");
        avl.inserir(10,"c");
        avl.inserir(20,"d"); // força rotação dupla (esq-dir)
        avl.print();

        System.out.println("\n=== Teste 4: Inserção para forçar rotação dupla direita-esquerda ===");
        avl = new ArvoreAVL();
        avl.inserir(10,"a");
        avl.inserir(30,"b");
        avl.inserir(20,"c"); // força rotação dupla (dir-esq)
        avl.print();

        System.out.println("\n=== Teste 5: Inserção aleatória ===");
        avl = new ArvoreAVL();
        int[] numeros = {40, 20, 60, 10, 30, 50, 70, 25, 27};
        for (int n : numeros) {
            avl.inserir(n,"a");
            avl.print();
        }
    }
}
