package Vetor;

public class TesteVetor {
    public static void main(String[] args) {
        
            Vetor vetor = new Vetor(2); // cresce de 2 em 2

            System.out.println("Vetor vazio? " + vetor.isEmpty());

            vetor.insertAtRank(0, "A");
            vetor.insertAtRank(1, "B");
            vetor.insertAtRank(2, "C");
            vetor.insertAtRank(1, "X"); 

            System.out.print("Conteúdo atual do vetor: ");
            vetor.printar(); 
            System.out.println();

            System.out.println("Elemento na posição 2: " + vetor.elementAtRank(2)); 

            Object antigo = vetor.replaceAtRank(2, "Y");
            System.out.println("Elemento substituído na posição 2: " + antigo); 

            System.out.print("Vetor após replace: ");
            vetor.printar();
            System.out.println();

            Object removido = vetor.removeAtRank(1); 
            System.out.println("Elemento removido na posição 1: " + removido);

            System.out.print("Vetor após remoção: ");
            vetor.printar();
            System.out.println();

            System.out.println("Tamanho usado: " + vetor.tamanhoUsado());
            System.out.println("Tamanho total (capacidade): " + vetor.size());

       
    }
}

