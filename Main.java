public class Main {
    public static void main(String[] args) {
        Heap heapArvore = new Heap();

        heapArvore.inserir(1, "1");
        heapArvore.inserir(2, "2");
        heapArvore.inserir(3, "3");
        heapArvore.inserir(0, "0");

        System.out.println("\nHeap:");
        imprimirHeap(heapArvore.root(), 0);
    }

    private static void imprimirHeap(No no, int nivel) {
        if (no == null) return;

   
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(no.getKey() + " (" + no.getElemento() + ")");

        
        imprimirHeap(no.getFilhoEsquerdo(), nivel + 1);
        imprimirHeap(no.getFilhoDireito(), nivel + 1);
    }
}