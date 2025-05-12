package Vetor;

public class Vetor implements VetorInterfece {
    private Object[] vetor;
    private int fator_Crescimento, tamanho;
    private int ultimo_Elemento;

    public Vetor( int fator_Crescimento) {
        this.tamanho = 1;
        this.fator_Crescimento = fator_Crescimento;
        if (fator_Crescimento <= 0) {
            this.fator_Crescimento = 0;
        }

        this.ultimo_Elemento = 0;

        vetor = new Object[tamanho];
    }

    public int size() {
        return tamanho;
    }

    public int tamanhoUsado() {
        return ultimo_Elemento;
    }

    public boolean isEmpty() {
        return ultimo_Elemento == 0;
    }

    public Object elementAtRank(int indice) throws ElemVazia{
        if (indice >= ultimo_Elemento || indice < 0) {
            throw new ElemVazia("Indice inválido");
        } else {
            return vetor[indice];
        }
    } 

    public Object replaceAtRank(int indice, Object novo_elemento) throws ElemVazia{
        if (indice >= ultimo_Elemento || indice < 0) {
            throw new ElemVazia("Indice inválido");
        } else {
            Object elemento_out = vetor[indice];
            vetor[indice] = novo_elemento;
            return elemento_out;
        }
    }
    
    public void insertAtRank(int indice, Object novo_elemento) throws ElemVazia{
        if (indice > ultimo_Elemento || indice < 0)  {
            throw new ElemVazia("Indice inválido");
        } else {
            if (ultimo_Elemento == tamanho) {
                tamanho += fator_Crescimento;
                if (fator_Crescimento == 0)  {
                    tamanho *= 2;
                }

                Object vetor_temp[] = new Object[tamanho];
                for (int i = 0; i < ultimo_Elemento; i++) {
                    vetor_temp[i] = vetor[i];
                }
                vetor = vetor_temp;
            }
            for (int i = ultimo_Elemento; i > indice; i--) {
                vetor[i] = vetor[i-1];
            } 
            vetor[indice] = novo_elemento;
            ultimo_Elemento++;
        }
    }

    public Object removeAtRank(int indice) throws ElemVazia {
        if (indice >= ultimo_Elemento || indice < 0) {
        throw new ElemVazia("Indice inválido");
    } else {
        Object elemento_out = vetor[indice];
        for (int i = indice; i < ultimo_Elemento; i++) {
            vetor[i] = vetor[i + 1];
        } 
        vetor[ultimo_Elemento - 1] = null;
        ultimo_Elemento--;

        return elemento_out;
    
        }
    }

    public void printar() {
        if (isEmpty()) {
            System.out.println("Vetor Vazio");
        } else{
            int contador = 0;

            while (contador < ultimo_Elemento) {
                System.out.print(String.format("[ %s ] -> ", vetor[contador]));
                contador++;
            }
        }
    }
}
