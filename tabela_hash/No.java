package tabela_hash;

public class No {
    private Object key;
    private Object valor;

    public No(Object key, Object valor) {
        this.key = key;
        this.valor = valor;
    }
    public Object getKey() {
        return key;
    }
    public void setKey(Object key) {
        this.key = key;
    }
    public Object getValor() {
        return valor;
    }
    public void setValor(Object valor) {
        this.valor = valor;
    }
    
}
