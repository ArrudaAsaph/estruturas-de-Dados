public interface filaInterface {

    public int tamanho();

    public boolean isEmpty();

    public Object inicio()

    throws EFilaVazia;

    public void enqueue(Object o);

    public Object desenfileirar()
    
    throws EFilaVazia;

    }
    
