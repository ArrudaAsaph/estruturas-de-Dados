package arvoreGenerica;
import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreGenerica {
    private  No raiz;
    private int tamanho;

    public ArvoreGenerica(Object elemento) {
        this.raiz = new No(elemento, null);
        this.tamanho = 1;
    }


    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void posOrdem(No no, ArrayList<Object> listaElementos) {
        for (No filho: no.getFilhos()) {
            posOrdem(filho, listaElementos);
        }
        listaElementos.add(no.getElemento());
    }

    public void  preOrdem(No no, ArrayList<No> listaElementos) {
        listaElementos.add(no);

        for (No filho: no.getFilhos()) {
            preOrdem(filho, listaElementos);
        }

        
    }


    public Iterator<No> nos() {
        ArrayList<No> lista = new ArrayList<>();
        if (tamanho != 0) {
           preOrdem(raiz, lista);
        }
        return lista.iterator();
    }

    public Iterator<Object> elements() {
        ArrayList<Object> lista = new ArrayList<>();
        if (!isEmpty()) {
            posOrdem(raiz, lista);
        }
        return lista.iterator();
    }

    public No raiz() {
        return raiz;
    }

    public No pai(No no) {
        return no.getNoPai();
    }

    public Iterator<No> filhos(No no) {
        return no.getFilhos().iterator();
    }

    public boolean isExternal(No no) {
        return no.size() == 0;
    }

    public boolean isInternal(No no) {
        return no.size() > 0;
    }

    public boolean isRoot(No no) {
        return no == raiz;
    }


    public int profundidade(No no) {
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
    


//     public No raiz() {
//         return raiz;
//     }

//     public No noPai(final No no) {
//         return no.getNoPai();
//     }

//     public Iterator noFilho(final No no) {
//         return no.filhos();
//     }

//     public boolean isInternal(final No no) {
//         return (no.size() > 0);
//     }

//     public boolean isExternal(final No no) {
//         return (no.size() == 0);
//     }

//     public boolean isRoot(final No no) {
//         return (no == raiz);
//     }

//     public void addChild(final No no, final Object elemento) {
//         No novo_no = new No(elemento, no);
//         no.add(novo_no);
//         tamanho++;
//     }

//     public void swapElement(final No no1, final No no2) {
//         final Object elemento1 = no1.getElemento();

//         no1.setElemento(no2.getElemento());
//         no2.setElemento(elemento1);
//     }

//     public int profundidade(No no) {
        
//         if (no == raiz) {
//             return 0;
//         }
//         return 1 + profundidade(no.getNoPai());
//     }

//     public int height(No no) {

//         if (isExternal(no)) {
//             return 0;
//         }
//         int contador = 0;
//         for (No filho: no.getFilhos()){
//             contador = Math.max(contador, height(filho));
//         }
//         return contador + 1;
        
//     }

//     public Object replace(No no, Object elemento) {
//         Object elemento_out = no.getElemento();
//         no.setElemento(elemento);
//         return elemento_out;

//     }

}
