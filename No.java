import java.util.ArrayList;
import java.util.Iterator;

public class No {
    private Object elemento;
    private No noPai;
    private ArrayList<No> filhos;

    public No (Object elemento, No paiNo) {
        this.elemento = elemento;
        this.noPai = paiNo;

        this.filhos = new ArrayList<No>();
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public No getNoPai() {
        return noPai;
    }

    public void setNoPai(No noPai) {
        this.noPai = noPai;
    }

    public ArrayList<No> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<No> filhos) {
        this.filhos = filhos;
    }

    public void add(No noFilho) {
        filhos.add(noFilho);
    }

    public void removeChild(No noFilho) {
        filhos.remove(noFilho);
    }

    public int size() {
        return filhos.size();
    }
    
    public Iterator filhos() {
        return filhos.iterator();
    }
    
}
