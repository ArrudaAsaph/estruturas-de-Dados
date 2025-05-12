package ListaDuplaEncadeada;

public class TesteListaEncadeada {

    public static void main(String[] args) {
        ListaEncadeadaDoble lista = new ListaEncadeadaDoble();

        System.out.println("Testando inserções:");
        lista.print();
        lista.insertFirst("C");
        lista.insertFirst("B");
        lista.insertFirst("A"); 
        lista.insertLast("D");  
        lista.print();
        System.out.println("\nTamanho: " + lista.size());

        System.out.println("\n\nTestando insertAfter:");
        DobleNo noB = lista.getInicio().getProximo(); 
        lista.insertAfter(noB, "X"); 
        lista.print();
        System.out.println("\nTamanho: " + lista.size());

        System.out.println("\n\nTestando insertBefore:");
        DobleNo noC = noB.getProximo().getProximo(); 
        lista.insertBefore(noC, "Y"); 
        lista.print();
        System.out.println("\nTamanho: " + lista.size());

        System.out.println("\n\nTestando swapElements entre B e Y:");
        DobleNo noY = noB.getProximo().getProximo(); 
        lista.swapElements(noB, noY); 
        lista.print();

        // System.out.println("\n\nTestando replaceElement (trocando 'D' por 'Z'):");
        // DobleNo noD = lista.getFim();
        // lista.replaceElement(noD, "Z");
        // lista.print();

        // System.out.println("\n\nTestando remoção do início (A):");
        // lista.remove(lista.getInicio());
        // lista.print();
        // System.out.println("\nTamanho: " + lista.size());

        // System.out.println("\n\nTestando remoção do fim (Z):");
        // lista.remove(lista.getFim());
        // lista.print();
        // System.out.println("\nTamanho: " + lista.size());

        // System.out.println("\n\nTestando first e last:");
        // try {
        //     System.out.println("Primeiro: " + lista.first());
        //     System.out.println("Último: " + lista.last());
        // } catch (ElemenVazia e) {
        //     System.out.println(e.getMessage());
        // }

        // System.out.println("\n\nImprimindo final da lista:");
        // lista.print();
    }
}

