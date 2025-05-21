

public class Deque {

    private int capacidade, fim, inicio, fator_Crescimento;

    private Object deque[];

    public Deque(int fator_Crescimento) {
        this.capacidade = 1;
        this.inicio = this.fim = 0;
        this.fator_Crescimento = fator_Crescimento;

        if (fator_Crescimento <= 0) {
            this.fator_Crescimento = 0;
        }
        this.deque = new Object[capacidade];
    }

    public boolean isEmpty() {
        return inicio == fim;
    }

    public int size() {
        return (capacidade - inicio + fim) % capacidade;
    }

    

    public void enqueueFirst(Object novo_obj) {
        if (size() ==  capacidade - 1) {
            int nova_capacidade = capacidade;
            if (fator_Crescimento == 0) {
                nova_capacidade *= 2;
            } else {
                nova_capacidade += fator_Crescimento;
            }

            Object novo_deque[] = new Object[nova_capacidade];

            int novo_inicio = inicio;
            int comecar = 1;
            novo_deque[0] = novo_obj;
            

            for (int i = comecar; i < size(); i++ ) {
                novo_deque[i] = deque[novo_inicio];
                novo_inicio = (novo_inicio + 1) % capacidade;
            }
            fim = size();
            capacidade = nova_capacidade;
            inicio = 0;
            deque = novo_deque;
            return;
        }

        inicio = (inicio - 1 + capacidade) % capacidade;
        deque[inicio] = novo_obj;
    }

    public void enqueueLast(Object novo_obj) {
        if (size() ==  capacidade - 1) {
            int nova_capacidade = capacidade;
            if (fator_Crescimento == 0) {
                nova_capacidade *= 2;
            } else {
                nova_capacidade += fator_Crescimento;
            }

            Object novo_deque[] = new Object[nova_capacidade];

            int novo_inicio = inicio;

            for (int i = 0; i < size(); i++ ) {
                novo_deque[i] = deque[novo_inicio];
                novo_inicio = (novo_inicio + 1) % capacidade;
            }
            fim = size();
            capacidade = nova_capacidade;
            inicio = 0;
            deque = novo_deque;
            
        }
        deque[fim] = novo_obj;
        fim = (fim + 1) % capacidade;
    }

    public Object dequeueFirst() throws ElemVazia {
        if (isEmpty()) {
            throw new ElemVazia("Esta Vazio");
        }
        Object obj_out = deque[inicio];
        inicio = (inicio + 1) % capacidade;
        return obj_out;
    }

    public Object dequeueLast() throws ElemVazia{
        if (isEmpty()) {
            throw new ElemVazia("Esta vazio");
        }
        fim = (fim - 1 + capacidade) % capacidade;
        Object obj_out = deque[fim - 1];
        return obj_out;
    }
    
    public void desenhar() {
    System.out.println("Deque:");
    
    // Primeira linha: valores armazenados
    for (int i = 0; i < capacidade; i++) {
        String valor = deque[i] != null ? deque[i].toString() : " ";
        System.out.printf("%4s", valor);
    }
    System.out.println();

    // Segunda linha: índices
    for (int i = 0; i < capacidade; i++) {
        System.out.printf("%4d", i);
    }
    System.out.println();

    // Terceira linha: marcadores (i, f, i/f)
    for (int i = 0; i < capacidade; i++) {
        if (i == inicio && i == fim) {
            System.out.printf("%4s", "i/f");
        } else if (i == inicio) {
            System.out.printf("%4s", "i");
        } else if (i == fim) {
            System.out.printf("%4s", "f");
        } else {
            System.out.printf("    ");
        }
    }
    System.out.println("\n");
}

}





    
