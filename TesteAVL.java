import java.util.Scanner;

public class TesteAVL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreAVL arvore = new ArvoreAVL();
        int opcao;

        do {
            System.out.println("\n=== MENU ÁRVORE AVL ===");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("3 - Buscar");
            System.out.println("4 - Imprimir em ordem");
            System.out.println("5 - Teste Remoção");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a chave para adicionar: ");
                    int chaveAdd = sc.nextInt();
                    arvore.inserir(chaveAdd, "Elemento " + chaveAdd);
                    System.out.println("Inserido com sucesso!");
                    arvore.print();
                    break;

                case 2:
                    System.out.print("Digite a chave para remover: ");
                    int chaveRemover = sc.nextInt();
                    arvore.remover(chaveRemover);
                    System.out.println("Removido (se existia).");
                    arvore.print();
                    break;

                case 3:
                    System.out.print("Digite a chave para buscar: ");
                    int chaveBuscar = sc.nextInt();
                    var no = arvore.buscar(arvore.raiz(),chaveBuscar,0);
                    if (no != null) {
                        System.out.println("Encontrado: chave " + no.getChave() +
                                           " | elemento: " + no.getElemento());
                    } else {
                        System.out.println("Chave não encontrada!");
                    }
                    break;

                case 4:
                    arvore.print();
                    break;
                
                case 5:
                     for (int i = 10; i <= 80; i += 10) {
                        arvore.inserir(i,"A");
                        System.out.println("Inserido: " + i);
                    }
                    arvore.print();


                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
