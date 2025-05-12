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
        return ultimo_Elemento - 1;
    }

    // public boolean isEmpty() {
    //     return tamanho
    // }

    public Object elementAtRank(int indice) throws ElemVazia{
        if (indice >= tamanho) {
            throw new ElemVazia("Indice inválido");
        } else {
            return vetor[indice];
        }
    } 
}
