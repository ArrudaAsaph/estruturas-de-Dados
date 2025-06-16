import java.util.Iterator;

public class ArvoreGenerica {
    private No raiz;
    private int tamanho;

    public ArvoreGenerica(Object elemento) {
        this.raiz = new No(elemento, null);
        this.tamanho = 0;
    }


    public No raiz() {
        return raiz;
    }

    public No noPai(No no) {
        return no.getNoPai();
    }

    public Iterator noFilho(No no) {
        return no.filhos();
    }

    public boolean isInternal(No no) {
        return (no.size() > 0);
    }

    public boolean isExternal(No no) {
        return (no.size() == 0);
    }

    public boolean isRoot(No no) {
        return (no == raiz);
    }

}
