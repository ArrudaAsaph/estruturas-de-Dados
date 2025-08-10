package heapArray;

import java.util.Optional;

public class Entry {
    private Object key;
    private Object value;


    
    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    public Object getKey() {
        return key;
    }
    public void setKey(Object key) {
        this.key = key;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }

    public Optional<Integer> compare(Entry a, Entry b) {
    try {
        Comparable<Object> keyA = (Comparable<Object>) a.getKey();
        Comparable<Object> keyB = (Comparable<Object>) b.getKey();
        
        return Optional.of(keyA.compareTo(keyB)); // retorna -1, 0 ou 1
    } catch (Exception e) {
        return Optional.empty(); // caso não consiga comparar
    }
}

}

