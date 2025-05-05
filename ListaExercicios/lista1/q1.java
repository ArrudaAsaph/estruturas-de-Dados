package ListaExercicios.lista1;


// Descreva o estado da fila (inicialmente vazia) após cada uma das operações a seguir: (R-4.2)
// enqueue(5), enqueue(3), dequeue(), enqueue(2), enqueue(8), dequeue(), dequeue(),
// enqueue(9), enqueue(1), dequeue(), enqueue(7), enqueue(6), dequeue(), dequeue(),
// enqueue(4), enqueue (7), dequeue().

// 5 , 3 , -> 5
// 3 , 2 , 8  -> 3 
// 2 , 8 -> 2
// 8 , 9 , 1 -> 8 
// 9 , 1 , 7 , 6 -> 9
// 1 , 7 , 6 -> 1
// 7 , 6 -> 7
// 6 , 4 , 7 -> 6 
// 4 , 7 

public class q1 {
    public static void main(String[] args) {
        Fila fila = new Fila(0); 

        System.out.println("Inicialmente vazia:");
        fila.printFila();

        fila.enqueue(5);
        System.out.println("Após enqueue(5):");
        fila.printFila();

        fila.enqueue(3);
        System.out.println("Após enqueue(3):");
        fila.printFila();

        fila.dequeue();
        System.out.println("Após dequeue():");
        fila.printFila();

        fila.enqueue(2);
        System.out.println("Após enqueue(2):");
        fila.printFila();

        fila.enqueue(8);
        System.out.println("Após enqueue(8):");
        fila.printFila();

        fila.dequeue();
        System.out.println("Após dequeue():");
        fila.printFila();

        fila.dequeue();
        System.out.println("Após dequeue():");
        fila.printFila();

        fila.enqueue(9);
        System.out.println("Após enqueue(9):");
        fila.printFila();

        fila.enqueue(1);
        System.out.println("Após enqueue(1):");
        fila.printFila();

        fila.dequeue();
        System.out.println("Após dequeue():");
        fila.printFila();

        fila.enqueue(7);
        System.out.println("Após enqueue(7):");
        fila.printFila();

        fila.enqueue(6);
        System.out.println("Após enqueue(6):");
        fila.printFila();

        fila.dequeue();
        System.out.println("Após dequeue():");
        fila.printFila();

        fila.dequeue();
        System.out.println("Após dequeue():");
        fila.printFila();

        fila.enqueue(4);
        System.out.println("Após enqueue(4):");
        fila.printFila();

        fila.enqueue(7);
        System.out.println("Após enqueue(7):");
        fila.printFila();

        fila.dequeue();
        System.out.println("Após dequeue():");
        fila.printFila();
    }
}
