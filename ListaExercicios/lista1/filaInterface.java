package ListaExercicios.lista1;


public interface filaInterface {

    public int size();

    public boolean isEmpty();

    public Object first() throws EFilaVazia;

    public void enqueue(Object o);

    public Object dequeue() throws EFilaVazia;

    }
    
// public interface IFila {
// 	    public abstract void enqueue(Object o);
// 	    public abstract Object dequeue();
// 	    public Object first();
// 	    public abstract int size();
// 	    public abstract boolean isEmpty();
// }

