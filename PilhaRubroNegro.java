public class PilhaRubroNegro{
    private int posicaoVermelho;
    private int posicaoPreto;

    private int tamanhoArray;
    private int fator_de_crescimento;

    private Object pilhaRubroNegro[];

    public PilhaRubroNegro(int tamanhoArray, int fator_de_crescimento){
        this.tamanhoArray = tamanhoArray;
        this.fator_de_crescimento = fator_de_crescimento;
        this.posicaoVermelho = -1;
        this.posicaoPreto = tamanhoArray;
        if (fator_de_crescimento <= 0)
        {
            this.fator_de_crescimento = 0;
        }   

        pilhaRubroNegro = new Object[tamanhoArray];
    }

    public int sizeVermelho(){
        // if ()
        return posicaoVermelho + 1;
    }

    public int sizePreto(){
        return tamanhoArray - posicaoPreto;
    }
    
    public int sizeArray(){
        return sizePreto() + sizeVermelho();
    }

    public int sizeArray_Dispoinivel(){
        return sizeArray() - tamanhoArray;
    }

    public boolean isEmpty_Vermelho(){
        return posicaoVermelho == -1;
    }

    public boolean isEmpty_Preto(){
        return posicaoPreto == tamanhoArray;
    }

    public void push(){
        if (sizePreto() + sizeVermelho() == tamanhoArray)
        {
            
            if (isEmpty_Preto()){
                posicaoPreto = tamanhoArray * 2;
            }
            tamanhoArray *= 2; 
            
            Object pilha_temporaria[] = new Object[tamanhoArray];
            for (int i = 0; i <= posicaoVermelho; i++){
                
                pilha_temporaria[i] = pilhaRubroNegro[i];
            }
            
            int nova_posicao_preto = tamanhoArray - sizePreto();
            for (int i = 0; i < sizePreto(); i++) {
                pilha_temporaria[nova_posicao_preto + i] = pilhaRubroNegro[posicaoPreto + i];
            }
            posicaoPreto = nova_posicao_preto;
            pilhaRubroNegro = pilha_temporaria;
        }
    }
    public void pushVermelho(Object novo_objeto){
        push();
        pilhaRubroNegro[++posicaoVermelho] = novo_objeto;
    }


    public void pushPreto(Object novo_objeto){
        push();
        pilhaRubroNegro[--posicaoPreto] = novo_objeto;
     }

    public void printarVermelho(){
        System.out.println(String.format("PILHA VERMELHA"));

        for (int i = 0; i <= posicaoVermelho; i++){
            // System.out.println(String.format("Posição %d -> %s | Capacidade: %d \n|| p Vermelho : %d  p Preto: %d", i, pilhaRubroNegro[i], tamanhoArray, posicaoVermelho, posicaoPreto));
            System.out.println(String.format("%d° -> %s",i + 1,pilhaRubroNegro[posicaoVermelho - i]));
        }
        System.out.println(String.format("-----------------------------------"));
    }

    public void printarPreto(){
        System.out.println(String.format("PILHA PRETA"));
        
        for (int i = posicaoPreto; i < tamanhoArray; i++){
            System.out.println(String.format("%d° -> %s", (tamanhoArray - i), pilhaRubroNegro[i]));
        }
        System.out.println("-----------------------------------");
    }
    
    public void printar_array(){
        
        System.out.println("-----------------------------------");
        System.out.println(String.format("Pilha Array"));
        System.out.println(String.format("Tamanho do Array: %d\nTamanho Pilha Vermelha: %d - P: %d\nTamanho Pilha Preta: %d - P: %d",tamanhoArray, sizeVermelho(), posicaoVermelho, sizePreto(), posicaoPreto));
        
        for (int i = 0; i < tamanhoArray; i++){
            if (i <= posicaoVermelho)
            {
                System.out.print(String.format(" %s V |",pilhaRubroNegro[i]));
                
            } 
            else if (i >= posicaoPreto)
            {
                System.out.print(String.format(" %s P |",pilhaRubroNegro[i]));
                
            } 
            else
            {
                System.out.print(String.format(" %s |",pilhaRubroNegro[i]));
                
            }
        }
        System.out.println("\n-----------------------------------");
    }
    
    public static void main(String[] args) {
        PilhaRubroNegro pilhaRubroNegro= new PilhaRubroNegro(1, 0);
        pilhaRubroNegro.pushVermelho(0);
        // pilhaRubroNegro.printarVermelho();
        pilhaRubroNegro.printar_array();
        pilhaRubroNegro.pushVermelho(1);
        pilhaRubroNegro.printar_array();
        // pilhaRubroNegro.printarVermelho();
        pilhaRubroNegro.pushPreto(2);
        pilhaRubroNegro.pushPreto(3);
        pilhaRubroNegro.printar_array();
        pilhaRubroNegro.pushPreto(4);
        // pilhaRubroNegro.printarPreto();
        
        

    }
}