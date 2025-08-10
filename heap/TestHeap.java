public class TestHeap {
    public static void main(String[] args) {
        Heap heap = new Heap(); 
        for (int i = 0; i <= 15; i++) {
            System.out.println("Inserindo: " + i);
            heap.inserir(i);
            // heap.printHeap();
            System.out.println();
        }
    }
}
