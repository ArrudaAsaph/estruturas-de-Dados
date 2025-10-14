package rubro_negro;

import java.util.Scanner;

public class TesteRubroNegro {
    public static void main(String[] args) {
        ArvoreRubroNegro arvoreRubroNegro = new ArvoreRubroNegro();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Árvore Rubro-Negra ===");
        System.out.println("Digite números para inserir na árvore (0 para sair):");

        while (true) {
            System.out.print("Número: ");
            int valor = sc.nextInt();

            if (valor == 0) {
                break;
            }

            arvoreRubroNegro.inserir(valor);
            System.out.println("Valor " + valor + " inserido!\n");
            arvoreRubroNegro.print();
            System.out.println("----------------------------");
        }

        System.out.println("\nInserção finalizada!");
        System.out.println("Árvore final:");
        arvoreRubroNegro.print();

        sc.close();
    }
}
