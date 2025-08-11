package tabela_hash;

public class Tabela_hash {
    private No[] array;
    private int capacidade, tamanho;

    public Tabela_hash(int capacidade) {
        this.tamanho = 0;

        this.array = new No[capacidade];
    }

    private int hash(Object key) {
        if (key == null) return 0;

        return Math.abs(key.hashCode()) % capacidade;
    }

    public void inserir(Object key, Object elemento) {
        if (capacidade == )
    }
    
}