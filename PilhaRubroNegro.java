public class PilhaRubroNegro {
    private int posicaoVermelho;
    private int posicaoPreto;

    private int tamanhoArray;
    private int fator_de_crescimento;

    private Object pilhaRubroNegro[];

    public PilhaRubroNegro(int tamanhoArray, int fator_de_crescimento) {
        this.tamanhoArray = tamanhoArray;
        this.fator_de_crescimento = fator_de_crescimento > 0 ? fator_de_crescimento : 2;
        this.posicaoVermelho = -1;
        this.posicaoPreto = tamanhoArray;

        pilhaRubroNegro = new Object[tamanhoArray];
    }

    public int sizeVermelho() {
        return posicaoVermelho + 1;
    }

    public int sizePreto() {
        return tamanhoArray - posicaoPreto;
    }

    public int sizeArray() {
        return sizePreto() + sizeVermelho();
    }

    public int sizeArray_Disponivel() {
        return posicaoPreto - posicaoVermelho - 1;
    }

    public boolean isEmpty_Vermelho() {
        return posicaoVermelho == -1;
    }

    public boolean isEmpty_Preto() {
        return posicaoPreto == tamanhoArray;
    }

    private void verificarEspaco() {
        if (posicaoVermelho + 1 == posicaoPreto) {
            int novoTamanho = tamanhoArray * fator_de_crescimento;
            push(novoTamanho);
        } 
        else if (sizeArray_Disponivel() >= tamanhoArray * 2 / 3 && tamanhoArray > 1) {
            int novoTamanho = tamanhoArray / 2;
            push(novoTamanho);
        }
    }

    private void push(int novoTamanho) {
        
        Object[] novaPilha = new Object[novoTamanho];

        
        for (int i = 0; i <= posicaoVermelho; i++) {
            novaPilha[i] = pilhaRubroNegro[i];
        }

        
        int tamanhoPreto = tamanhoArray - posicaoPreto;
        int novaPosicaoPreto = novoTamanho - tamanhoPreto;
        for (int i = 0; i < tamanhoPreto; i++) {
            novaPilha[novaPosicaoPreto + i] = pilhaRubroNegro[posicaoPreto + i];
        }

        posicaoPreto = novaPosicaoPreto;
        tamanhoArray = novoTamanho;
        pilhaRubroNegro = novaPilha;
    }

    public Object topVermelho(){
        return pilhaRubroNegro[posicaoVermelho];
    }

    public Object topPreto(){
        return pilhaRubroNegro[posicaoPreto];
    }

    public Object popVermelho(){
        return pilhaRubroNegro[posicaoVermelho--];
    }

    public Object popPreto(){
        return pilhaRubroNegro[posicaoPreto++];
    }
    public void pushVermelho(Object novo_objeto) {
        verificarEspaco();
        pilhaRubroNegro[++posicaoVermelho] = novo_objeto;
    }

    public void pushPreto(Object novo_objeto) {
        verificarEspaco();
        pilhaRubroNegro[--posicaoPreto] = novo_objeto;
    }

    public void printarVermelho() {
        System.out.println("PILHA VERMELHA");
        for (int i = 0; i <= posicaoVermelho; i++) {
            System.out.println(String.format("%dº -> %s", i + 1, pilhaRubroNegro[posicaoVermelho - i]));
        }
        System.out.println("-----------------------------------");
    }

    public void printarPreto() {
        System.out.println("PILHA PRETA");
        for (int i = posicaoPreto; i < tamanhoArray; i++) {
            System.out.println(String.format("%dº -> %s", (tamanhoArray - i), pilhaRubroNegro[i]));
        }
        System.out.println("-----------------------------------");
    }

    public void printar_array() {
        System.out.println("-----------------------------------");
        System.out.println("Pilha Array");
        System.out.println(String.format("Tamanho do Array: %d\nTamanho Pilha Vermelha: %d - P: %d\nTamanho Pilha Preta: %d - P: %d", tamanhoArray, sizeVermelho(), posicaoVermelho, sizePreto(), posicaoPreto));

        for (int i = 0; i < tamanhoArray; i++) {
            if (i <= posicaoVermelho) {
                System.out.print(String.format(" %s V |", pilhaRubroNegro[i]));
            } else if (i >= posicaoPreto) {
                System.out.print(String.format(" %s P |", pilhaRubroNegro[i]));
            } else {
                System.out.print(String.format(" %s |", pilhaRubroNegro[i]));
            }
        }
        System.out.println("\n-----------------------------------");
    }

    public static void main(String[] args) {
        PilhaRubroNegro pilha = new PilhaRubroNegro(1, 2);
        pilha.pushVermelho(0);
        pilha.printar_array();
        pilha.pushVermelho(9);
        pilha.printar_array();
        pilha.pushPreto(2);
        pilha.pushPreto(3);
        pilha.printar_array();
        pilha.pushPreto(4);
        pilha.printar_array();
        Object topo = pilha.topVermelho();
        System.out.println(topo);
        pilha.pushVermelho(48);
        topo = pilha.topVermelho();
        System.out.println(topo);
        pilha.popPreto();
        topo = pilha.topPreto();
        pilha.printar_array();
        System.out.println(topo);
        pilha.popVermelho();
        pilha.printar_array();
    }
}
