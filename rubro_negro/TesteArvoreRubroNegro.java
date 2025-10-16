package rubro_negro;

public class TesteArvoreRubroNegro {
    
    public static void main(String[] args) {
        System.out.println("=== TESTE DA ÁRVORE RUBRO-NEGRO ===\n");
        
        // Teste 1: Inserção básica
        System.out.println("TESTE 1: Inserção básica");
        ArvoreRubroNegro arvore1 = new ArvoreRubroNegro();
        arvore1.inserir(10);
        arvore1.inserir(5);
        arvore1.inserir(15);
        arvore1.print();
        verificarPropriedades(arvore1, "Teste 1");
        
        // Teste 2: Caso 2 - Tio vermelho
        System.out.println("\nTESTE 2: Caso 2 - Tio vermelho");
        ArvoreRubroNegro arvore2 = new ArvoreRubroNegro();
        arvore2.inserir(10);
        arvore2.inserir(5);
        arvore2.inserir(15);
        arvore2.inserir(3); // Deve acionar o Caso 2
        arvore2.print();
        verificarPropriedades(arvore2, "Teste 2");
        
        // Teste 3: Caso 3 - Rotação simples à direita
        System.out.println("\nTESTE 3: Caso 3 - Rotação simples à direita");
        ArvoreRubroNegro arvore3 = new ArvoreRubroNegro();
        arvore3.inserir(10);
        arvore3.inserir(5);
        arvore3.inserir(3); // Deve acionar rotação simples direita
        arvore3.print();
        verificarPropriedades(arvore3, "Teste 3");
        
        // Teste 4: Caso 3 - Rotação simples à esquerda
        System.out.println("\nTESTE 4: Caso 3 - Rotação simples à esquerda");
        ArvoreRubroNegro arvore4 = new ArvoreRubroNegro();
        arvore4.inserir(10);
        arvore4.inserir(15);
        arvore4.inserir(20); // Deve acionar rotação simples esquerda
        arvore4.print();
        verificarPropriedades(arvore4, "Teste 4");
        
        // Teste 5: Caso 3 - Rotação dupla (esquerda-direita)
        System.out.println("\nTESTE 5: Caso 3 - Rotação dupla esquerda-direita");
        ArvoreRubroNegro arvore5 = new ArvoreRubroNegro();
        arvore5.inserir(10);
        arvore5.inserir(5);
        arvore5.inserir(7); // Deve acionar rotação dupla
        arvore5.print();
        verificarPropriedades(arvore5, "Teste 5");
        
        // Teste 6: Caso 3 - Rotação dupla (direita-esquerda)
        System.out.println("\nTESTE 6: Caso 3 - Rotação dupla direita-esquerda");
        ArvoreRubroNegro arvore6 = new ArvoreRubroNegro();
        arvore6.inserir(10);
        arvore6.inserir(15);
        arvore6.inserir(12); // Deve acionar rotação dupla
        arvore6.print();
        verificarPropriedades(arvore6, "Teste 6");
        
        // Teste 7: Sequência complexa
        System.out.println("\nTESTE 7: Sequência complexa");
        ArvoreRubroNegro arvore7 = new ArvoreRubroNegro();
        int[] valores = {41, 38, 31, 12, 19, 8, 15, 20, 25, 30};
        for (int valor : valores) {
            System.out.println("Inserindo: " + valor);
            arvore7.inserir(valor);
        }
        arvore7.print();
        verificarPropriedades(arvore7, "Teste 7");
        
        // Teste 8: Valores duplicados
        System.out.println("\nTESTE 8: Valores duplicados");
        ArvoreRubroNegro arvore8 = new ArvoreRubroNegro();
        arvore8.inserir(10);
        arvore8.inserir(5);
        arvore8.inserir(10); // Deve mostrar mensagem de erro
        arvore8.print();
        verificarPropriedades(arvore8, "Teste 8");
        
        // Teste 9: Sequência em ordem crescente (pior caso para BST normal)
        System.out.println("\nTESTE 9: Sequência crescente");
        ArvoreRubroNegro arvore9 = new ArvoreRubroNegro();
        for (int i = 1; i <= 10; i++) {
            arvore9.inserir(i);
        }
        arvore9.print();
        verificarPropriedades(arvore9, "Teste 9");
        
        // Teste 10: Sequência em ordem decrescente
        System.out.println("\nTESTE 10: Sequência decrescente");
        ArvoreRubroNegro arvore10 = new ArvoreRubroNegro();
        for (int i = 10; i >= 1; i--) {
            arvore10.inserir(i);
        }
        arvore10.print();
        verificarPropriedades(arvore10, "Teste 10");
        
        System.out.println("\n=== TODOS OS TESTES FORAM CONCLUÍDOS ===");
    }
    
    private static void verificarPropriedades(ArvoreRubroNegro arvore, String nomeTeste) {
        System.out.println(nomeTeste + " - Verificando propriedades:");
        
        // Verifica se a raiz é preta
        if (arvore.raiz() != null && !arvore.raiz().getCor().equals("preto")) {
            System.out.println("❌ ERRO: A raiz não é preta!");
        } else {
            System.out.println("✓ Raiz é preta");
        }
        
        // Verifica altura negra (deve ser igual em todos os caminhos)
        int alturaNegra = calcularAlturaNegra(arvore.raiz());
        System.out.println("✓ Altura negra: " + alturaNegra);
        
        // Verifica se não há dois nós vermelhos consecutivos
        boolean semVermelhosConsecutivos = verificarVermelhosConsecutivos(arvore.raiz());
        if (semVermelhosConsecutivos) {
            System.out.println("✓ Não há nós vermelhos consecutivos");
        } else {
            System.out.println("❌ ERRO: Encontrados nós vermelhos consecutivos!");
        }
        
        System.out.println("✓ Tamanho da árvore: " + getTamanho(arvore.raiz()));
        System.out.println("✓ Altura total: " + arvore.altura(arvore.raiz()));
        System.out.println();
    }
    
    private static int calcularAlturaNegra(No no) {
        if (no == null) return 0;
        
        int alturaEsq = calcularAlturaNegra(no.getFilhoEsquerdo());
        int alturaDir = calcularAlturaNegra(no.getFilhoDireito());
        
        // Verifica se as alturas negras são iguais
        if (alturaEsq != alturaDir) {
            System.out.println("❌ ERRO: Alturas negras diferentes! Esq: " + alturaEsq + ", Dir: " + alturaDir);
        }
        
        int incremento = no.getCor().equals("preto") ? 1 : 0;
        return Math.max(alturaEsq, alturaDir) + incremento;
    }
    
    private static boolean verificarVermelhosConsecutivos(No no) {
        if (no == null) return true;
        
        if (no.getCor().equals("vermelho")) {
            if (no.getFilhoEsquerdo() != null && no.getFilhoEsquerdo().getCor().equals("vermelho")) {
                return false;
            }
            if (no.getFilhoDireito() != null && no.getFilhoDireito().getCor().equals("vermelho")) {
                return false;
            }
        }
        
        return verificarVermelhosConsecutivos(no.getFilhoEsquerdo()) && 
               verificarVermelhosConsecutivos(no.getFilhoDireito());
    }
    
    private static int getTamanho(No no) {
        if (no == null) return 0;
        return 1 + getTamanho(no.getFilhoEsquerdo()) + getTamanho(no.getFilhoDireito());
    }
}