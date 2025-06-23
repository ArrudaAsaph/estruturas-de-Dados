package arvoreAB;

import exception.noElemen;

public class TesteArvoreAB {
    public static void main(String[] args) {
        try {
            // Cria a árvore
            ArvoreAB arvore = new ArvoreAB();

            // Insere raiz
            arvore.insertRoot("A");

            // Insere filhos
            No noB = arvore.insertLeft(arvore.root(), "B");
            No noC = arvore.insertRight(arvore.root(), "C");
            No noD = arvore.insertLeft(noB, "D");
            No noE = arvore.insertRight(noB, "E");
            No noF = arvore.insertLeft(noC, "F");
            No noG = arvore.insertRight(noC, "G");

            // Estrutura da árvore:
            //          A
            //        /   \
            //       B     C
            //      / \   / \
            //     D   E F   G

            System.out.println("===== Travessia Pré-Ordem =====");
            arvore.preOrdem(arvore.root());

            System.out.println("\n===== Travessia In-Ordem =====");
            arvore.inOrder(arvore.root());

            System.out.println("\n===== Travessia Pós-Ordem =====");
            arvore.posOrdem(arvore.root());

            System.out.println("\n===== Teste de Altura =====");
            int altura = arvore.height(arvore.root());
            System.out.println("Altura da árvore: " + altura);

            System.out.println("\n===== Teste de Profundidade =====");
            System.out.println("Profundidade do nó A (raiz): " + arvore.depth(arvore.root()));
            System.out.println("Profundidade do nó B: " + arvore.depth(noB));
            System.out.println("Profundidade do nó E: " + arvore.depth(noE));

            System.out.println("\n===== Teste de Tamanho =====");
            System.out.println("Tamanho da árvore: " + arvore.size());

            System.out.println("\n===== Teste de Remoção =====");
            arvore.remove(noG);
            System.out.println("Removido nó G. Novo tamanho: " + arvore.size());
            System.out.println("Travessia pré-ordem após remoção:");
            arvore.preOrdem(arvore.root());

        } catch (noElemen e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
