package rubro_negro;

import java.util.Scanner;

public class TesteRubroNegro {
    public static void main(String[] args) {
        ArvoreRubroNegro arvoreRubroNegro = new ArvoreRubroNegro();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Árvore Rubro-Negra ===");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Inserir valor");
            System.out.println("2 - Remover valor");
            System.out.println("3 - Exibir árvore");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o valor para inserir: ");
                    int valorInserir = sc.nextInt();
                    arvoreRubroNegro.inserir(valorInserir);
                    System.out.println("✅ Valor " + valorInserir + " inserido!");
                    arvoreRubroNegro.print();
                }

                case 2 -> {
                    System.out.print("Digite o valor para remover: ");
                    int valorRemover = sc.nextInt();
                    arvoreRubroNegro.remover(valorRemover);
                    System.out.println("❌ Valor " + valorRemover + " removido!");
                    arvoreRubroNegro.print();
                }

                case 3 -> {
                    System.out.println("\n🌳 Estrutura atual da árvore:");
                    arvoreRubroNegro.print();
                }
                case 4 -> {
                    for (int i = 1; i <= 10; i++) {
                        arvoreRubroNegro.inserir(i);
                        arvoreRubroNegro.print();

                    }
                }

                case 0 -> {
                    System.out.println("\nEncerrando o programa...");
                    sc.close();
                    return;
                }

                default -> System.out.println("⚠️ Opção inválida! Tente novamente.");
            }

            System.out.println("----------------------------");
        }
    }
}
