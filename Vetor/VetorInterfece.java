package Vetor;

public interface VetorInterfece {
    public int size();
    public boolean isEmpty();
    public Object elementAtRank(int indice) throws ElemVazia; 
    public Object replaceAtRank(int indice, Object novo_elemento) throws ElemVazia;
    public void insertAtRank(int indice, Object novo_elemento) throws ElemVazia;
    public Object remove(int indice) throws ElemVazia;
}
