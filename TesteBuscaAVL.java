public class TesteBuscaAVL {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        System.out.println("=== Teste de Inserção e Busca na AVL ===");

        for (int i = 1; i <= 10; i++) {
            arvore.inserir(i, "Elemento_" + i);
        }

        // Testando buscas
       System.out.println("\n--- BUSCA ---");
        No no = arvore.buscar(arvore.raiz(), 11, 0); 
        System.out.println(no.getChave());

    }   
}
