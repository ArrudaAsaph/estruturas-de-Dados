package ListaExercicios.lista1;

public class q4 {
    public static void main(String[] args) {
        Fila fila = new Fila(0); 
        
        fila.enqueue(0);
        fila.enqueue(0);
        fila.enqueue(0);
        fila.enqueue(0);
        fila.dequeue();
        fila.dequeue();
        fila.dequeue();
        fila.dequeue();
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);
        fila.enqueue(6);

        fila.printFila();
        
        fila.reverse();
        fila.printFila();
    }
}
