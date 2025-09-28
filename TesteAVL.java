import java.util.Scanner;

public class TesteAVL {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Árvore AVL Interativa ===");
        System.out.println("Digite um número para inserir ou 'sair' para encerrar:");

        while (true) {
            System.out.print(">> ");
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando...");
                break;
            }

            try {
                int chave = Integer.parseInt(entrada);
                arvore.inserir(chave, "Elemento " + chave);
                arvore.print();
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número ou 'sair'.");
            }
        }

        sc.close();
    }

    // Método auxiliar para impressão em ordem (se quiser usar)
    private static void imprimirInOrdem(No no) {
        if (no != null) {
            imprimirInOrdem(no.getFilhoEsquerdo());
            System.out.println("Chave: " + no.getChave() + " | Elemento: " + no.getElemento());
            imprimirInOrdem(no.getFilhoDireito());
        }
    }
}
