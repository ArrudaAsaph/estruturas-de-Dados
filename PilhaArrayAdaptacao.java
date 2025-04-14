public class PilhaArrayAdaptacao {
    private int capacidade;
    private int posicaoVermelha;
    private int posicaoPreta;

    private Object pilha[];
    private int fator_de_crescimento;

    public PilhaArrayAdaptacao(int fator_de_crescimento) {
        this.capacidade = 2;

        this.posicaoVermelha = -1;
        this.posicaoPreta = capacidade - 1;

        if (fator_de_crescimento <= 0){
            this.fator_de_crescimento = 0;
        }
        pilha = new Object[capacidade];
        
    }

    public int size(){
        return posicaoPreta + 1;
    }

    public void push(){
        int capacidade_array = capacidade / 2;
        if (posicaoVermelha == capacidade_array - 1 || posicaoPreta == capacidade_array){
            int capacidade_antiga = capacidade; 
            if (fator_de_crescimento == 0){
                capacidade *= 2;
            } else {
                capacidade += fator_de_crescimento;
            }
    
            Object temp_pilha[] = new Object[capacidade];
    
            
            for (int i = 0; i <= posicaoVermelha; i++){
                temp_pilha[i] = pilha[i];
            }
    
            
            for (int j = posicaoPreta; j < capacidade_antiga; j++){
                temp_pilha[j] = pilha[j];
            }
    
           
            
    
            pilha = temp_pilha;
        }
    }
    

    public void pushVermelha(Object novo_objeto){
        push();
        pilha[++posicaoVermelha] = novo_objeto;
    }

    public void pushPreta(Object novo_objeto){
        push();
        pilha[--posicaoPreta] = novo_objeto;
    }

    public void printar_Vermelhos(){
        for (int i = 0; i <= posicaoVermelha; i++){
            System.out.println(String.format("Posição %d -> %s V | Capacidade %d", i, pilha[i],capacidade));
        }
        System.out.println(String.format("------------------------------------------------------------"));

    }

    public void printar_Pretos(){
        for (int i = capacidade-1; i <= posicaoPreta; i--){
            System.out.println(String.format("Posição %d -> %s P | Capacidade %d", i, pilha[i],capacidade));

        }
        System.out.println(String.format("------------------------------------------------------------"));
    }

    public static void main(String[] args) {
        PilhaArrayAdaptacao pilhaArrayAdaptacao = new PilhaArrayAdaptacao(0);
        pilhaArrayAdaptacao.pushVermelha(1);
        pilhaArrayAdaptacao.printar_Vermelhos();
        pilhaArrayAdaptacao.pushPreta(10);
        pilhaArrayAdaptacao.printar_Pretos();
        pilhaArrayAdaptacao.pushVermelha(2);
        pilhaArrayAdaptacao.printar_Vermelhos();
        pilhaArrayAdaptacao.pushVermelha(3);
        pilhaArrayAdaptacao.printar_Vermelhos();
        
    }
}