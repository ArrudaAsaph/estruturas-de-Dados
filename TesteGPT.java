public class TesteGPT {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        System.out.println("=== Testes AVL (Inserções e Rotações) ===");

        // -------------------------------
        // Caso 1: Rotação simples à esquerda
        // Inserindo em ordem crescente: 10, 20, 30
        // Espera-se rotação simples à esquerda em 10
        // Resultado: raiz = 20
        // -------------------------------
        System.out.println("\n--- Caso 1: Rotação simples à esquerda ---");
        arvore.inserir(10, "A");
        arvore.print();
        arvore.inserir(20, "B");
        arvore.print();
        arvore.inserir(30, "C");
        arvore.print();

        // Resetando a árvore
        arvore = new ArvoreAVL();

        // -------------------------------
        // Caso 2: Rotação simples à direita
        // Inserindo em ordem decrescente: 30, 20, 10
        // Espera-se rotação simples à direita em 30
        // Resultado: raiz = 20
        // -------------------------------
        System.out.println("\n--- Caso 2: Rotação simples à direita ---");
        arvore.inserir(30, "A");
        arvore.print();
        arvore.inserir(20, "B");
        arvore.print();
        arvore.inserir(10, "C");
        arvore.print();

        // Resetando a árvore
        arvore = new ArvoreAVL();

        // -------------------------------
        // Caso 3: Rotação dupla à esquerda
        // Inserção: 10, 30, 20
        // Espera-se: dupla (esquerda em 30, depois direita em 10)
        // Resultado: raiz = 20
        // -------------------------------
        System.out.println("\n--- Caso 3: Rotação dupla à esquerda ---");
        arvore.inserir(10, "A");
        arvore.print();
        arvore.inserir(30, "B");
        arvore.print();
        arvore.inserir(20, "C");
        arvore.print();

        // Resetando a árvore
        arvore = new ArvoreAVL();

        // -------------------------------
        // Caso 4: Rotação dupla à direita
        // Inserção: 30, 10, 20
        // Espera-se: dupla (direita em 10, depois esquerda em 30)
        // Resultado: raiz = 20
        // -------------------------------
        System.out.println("\n--- Caso 4: Rotação dupla à direita ---");
        arvore.inserir(30, "A");
        arvore.print();
        arvore.inserir(10, "B");
        arvore.print();
        arvore.inserir(20, "C");
        arvore.print();
    }
}
