import java.util.Iterator;

public class ArvoreGenerica {
    private final No raiz;
    private int tamanho;

    public ArvoreGenerica(final Object elemento) {
        this.raiz = new No(elemento, null);
        this.tamanho = 0;
    }


    public No raiz() {
        return raiz;
    }

    public No noPai(final No no) {
        return no.getNoPai();
    }

    public Iterator noFilho(final No no) {
        return no.filhos();
    }

    public boolean isInternal(final No no) {
        return (no.size() > 0);
    }

    public boolean isExternal(final No no) {
        return (no.size() == 0);
    }

    public boolean isRoot(final No no) {
        return (no == raiz);
    }

    public void addChild(final No no, final Object elemento) {
        final No novo_no = new No(elemento, no);
        no.add(novo_no);
        tamanho++;
    }

    public void swapElement(final No no1, final No no2) {
        final Object elemento1 = no1.getElemento();

        no1.setElemento(no2.getElemento());
        no2.setElemento(elemento1);
    }

    public int profundidade(final No no) {
        
        if (no == raiz) {
            return 0;
        }
        return 1 + profundidade(no.getNoPai());
    }

    public int height(No no) {

        if (isExternal(no)) {
            return 0;
        }
        int contador = 0;
        for (No filho: no.getFilhos()){
            contador = Math.max(contador, height(filho));
        }
        return contador + 1;
        
    }

}
