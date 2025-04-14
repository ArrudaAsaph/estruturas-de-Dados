public class PilhaArray implements Pilha {
    private int capacidade;
    private int posicao;
    private int fator_de_crescimento;
    private Object objeto[];

    public PilhaArray(int capacidade, int fator_de_crescimento){
        this.capacidade = capacidade;
        this.posicao = -1;
        if (fator_de_crescimento <= 0){
            this.fator_de_crescimento = 0;
        } 
        objeto = new Object[capacidade];
    }

    public int size(){
        return posicao + 1;
    }

    public boolean isEmpty(){
        return posicao == -1;
    }

    public Object top() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("A Pilha está vazia");
        }
        Object r = objeto[posicao--];
        return r;
    }
    

    public void push(Object adicionar_objeto){
        if (capacidade -1 == posicao){
            if (fator_de_crescimento == 0){
                capacidade *= 2;
            } else {
                capacidade += fator_de_crescimento;
            }

            Object novo_Objeto[] = new Object[capacidade];
            for (int i = 0; i < objeto.length; i++){
                novo_Objeto[i] = objeto[i];
            }
            objeto = novo_Objeto;
        }
        objeto[++posicao] = adicionar_objeto;
    }


    public Object pop() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("A Pilha está vazia");
        }
        Object r = objeto[posicao--];
        return r;
    }


    public void printar_elementos() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("A Pilha está vazia");
        }
        for (int i = 0; i <= posicao; i++){
            System.out.println(String.format("Posição %d -> %s | Capacidade: %d", i, objeto[i], capacidade));
        }
        System.out.println(String.format("------------------------------------------------------------"));
    }


    public void empty() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("Pilha vazia");
        }
        posicao = -1;
    }
    public static void main(String[] args) {
        PilhaArray pilhaArray = new PilhaArray(1, 0);
// push(5), push(3), pop(), push(2), push(8), pop(), pop(), push(9), push(1), pop(), push(7), push(6), pop(), pop(),
// push(4), pop(), pop().
        pilhaArray.push(5);
        
        pilhaArray.push(3);
        
        
        pilhaArray.push(2);
        pilhaArray.push(8);
        pilhaArray.push(9);
        pilhaArray.push(1);
        pilhaArray.push(7);
        pilhaArray.push(6);
        pilhaArray.push(4);
        pilhaArray.printar_elementos();
        pilhaArray.empty();
        pilhaArray.printar_elementos();
    }
}

