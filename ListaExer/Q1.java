package ListaExer;

// Implemente uma classe VetorArray, que implemente a interface Vetor (baixe da p ́agina da
// disciplina). Faça uma tabela com os tempos de execução de cada método. Use a
// implementação da classe java.util.Vector de JAVA.

public class Q1 {
    public interface VetorInterface {
        public int Size();
        public boolean isEmpty();
        public Object elementAtRank(int indice);
        public void replaceAtRank(int indice, Object novo_obj);
        public void insertAtRank(int indice, Object novo_obj);
        public Object removeAtRank(int indice);
    }

    public class Vector implements VetorInterface {

        private int tamanho;
        private int fator_crescimento;
        private int fim;

        private Object Vetor[];

        public Vector( int fator_crescimento) {
            this.tamanho = 1;
            this.fator_crescimento = fator_crescimento;
            if (fator_crescimento <= 0) {
                this.fator_crescimento = 0;
            }
    
            this.fim = 0;
    
            Vetor = new Object[tamanho];
        }
        public int size(){
            return tamanho;
        }

        public boolean isEmpty() {
            return fim == 0;
        }

        public Object elementAtRank(int indice) {
            Object elemento = Vetor[indice];
            return elemento; 
        }

        public void replaceAtRank(int indice, Object novo_elemento) {
            
        }

        public void insertAtRank(int indice, Object novo_elemento) {

        }

        public Object removeAtRank(int indice) {

        }
    }
}   
