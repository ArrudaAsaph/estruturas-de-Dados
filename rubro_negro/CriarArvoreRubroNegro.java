package rubro_negro;

public class CriarArvoreRubroNegro {
    public static void main(String[] args) {
        ArvoreRubroNegro arvoreRubroNegro = new ArvoreRubroNegro();

        int[] valores = {30, 13, 53, 8, 23, 43, 83, 63, 93, 96};

        System.out.println("=== Criando Árvore Rubro-Negra ===\n");

        for (int valor : valores) {
            System.out.println("Inserindo: " + valor);
            arvoreRubroNegro.inserir(valor);
            arvoreRubroNegro.print();
            System.out.println("-------------------------------------------------------\n");
        }

        System.out.println("\n=== Árvore final ===");
        arvoreRubroNegro.print();
    }
}
