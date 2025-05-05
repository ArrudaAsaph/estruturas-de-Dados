package ListaExercicios.lista1;

public class Fila implements filaInterface {
    private Object[] fila;

    private int fator_crescimento, tamanho;
    private int inicio , fim;

    public Fila(int fator_crescimento) {
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 1;
        this.fator_crescimento = fator_crescimento;
        if ( fator_crescimento <= 0) {
            this.fator_crescimento = 0;
        }
        fila = new Object[tamanho];
    }


    public void enqueue(Object novo_elemento) {
        if (size() == tamanho- 1) {
            int novo_tamanho;
            if (fator_crescimento == 0) {
                novo_tamanho = tamanho * 2;
            } else {
                novo_tamanho = tamanho + fator_crescimento;
            }

            Object[] fila_temp = new Object[novo_tamanho];

            int novo_inicio = inicio;

            for (int nova_posicao = 0; nova_posicao < size(); nova_posicao++) {
                fila_temp[nova_posicao] = fila[novo_inicio];
                novo_inicio = (novo_inicio + 1) % tamanho;
        
            }
            fim = size();
            inicio = 0;
            tamanho = novo_tamanho;
            fila = fila_temp;

        }

        fila[fim] = novo_elemento;
        fim = (fim + 1) % tamanho;
    }

    public Object dequeue() throws EFilaVazia {
        if (isEmpty()) {
            throw new EFilaVazia ("A Fila está vazia");
        }
        Object proximo_fila = fila[inicio];
        inicio = (inicio + 1) % tamanho;
        return proximo_fila;
    }

    public boolean isEmpty() {
        return inicio == fim;
    }

    public int size() {
        return (tamanho - inicio + fim) % tamanho;
    }

    public Object first() {
        Object primeiro = fila[inicio];
        return primeiro;
    }

    public void printFila() {
        System.out.println("Fila (tamanho total: " + tamanho + ")");
        for (int i = 0; i < fila.length; i++) {
            System.out.print("[" + i + "]: ");
            if (fila[i] != null) {
                System.out.print(fila[i]);
            } else {
                System.out.print("null");
            }
            if (i == inicio) System.out.print(" <- início");
            if (i == fim) System.out.print(" <- fim");
            System.out.println();
        }
        System.out.println("Tamanho atual da fila (elementos): " + size());
        System.out.println("Está vazia? " + isEmpty());
        System.out.println("----------------------------------");
    }
    
    
}