public class TesteFilaEncadeada {
    public static void main(String[] args) {
        FilaEncadeada filaEncadeada = new FilaEncadeada();

        filaEncadeada.print();
        filaEncadeada.enqueue(1);
        filaEncadeada.enqueue(2);
        filaEncadeada.enqueue(3);
        filaEncadeada.enqueue(4);
        
        filaEncadeada.print();
        
        filaEncadeada.enqueuePreferencia("EU");
        filaEncadeada.print();
        filaEncadeada.dequeue();
        filaEncadeada.print();
        
    }
}
