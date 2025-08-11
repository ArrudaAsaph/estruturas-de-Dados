import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Heap heapArvore = new Heap();

        heapArvore.inserir(1, "1");
        heapArvore.inserir(2, "2");
        heapArvore.inserir(3, "3");
        heapArvore.inserir(0, "0");

        heapArvore.inserir(4, "4");
        heapArvore.inserir(5, "5");
        heapArvore.inserir(6, "6");
        heapArvore.inserir(7, "7");
        heapArvore.inserir(8, "8");
        heapArvore.inserir(9, "9");
        heapArvore.inserir(10, "10");
        heapArvore.inserir(11, "11");
        heapArvore.inserir(12, "12");
        heapArvore.inserir(13, "13");
        heapArvore.inserir(14, "14");
        heapArvore.inserir(15, "15");
        heapArvore.removerUltimo();
        heapArvore.removerUltimo();
        heapArvore.removerRaiz();

        imprimirPorNivel(heapArvore.root(), heapArvore);
    }

    private static void imprimirPorNivel(No raiz, Heap heap) {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            int nivelSize = fila.size();

            for (int i = 0; i < nivelSize; i++) {
                No atual = fila.poll();

                System.out.print(atual.getKey() + " ");

                if (atual.getFilhoEsquerdo() != null)
                    fila.add(atual.getFilhoEsquerdo());

                if (atual.getFilhoDireito() != null)
                    fila.add(atual.getFilhoDireito());
            }
            System.out.println("-> ultimo No:" + heap.ultimoNo().getElemento()); // Quebra de linha após cada nível
        }
    }
}
