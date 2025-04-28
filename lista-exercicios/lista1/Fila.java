

public class Fila implements filaInterface {
    private Object[] fila;

    private int fator_crescimento, tamanho;
    private int inicio , fim;

    public Fila(int fator_crescimento) {
        this.inicio = 0;
        this.fim = 1;
        this.tamanho = 1;
        this.fator_crescimento = fator_crescimento;
        if ( fator_crescimento <= 0) {
            this.fator_crescimento = 0;
        }
        fila = new Object[tamanho];
    }

    
    public void enqueue(Object novo_elemento) {
        
    }

    public boolean isEmpty() {
        
    }
}