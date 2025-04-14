public class TestePilha {

    public static void main(String[] args) {
        int[] quantidades = {1000, 10000, 100000, 1000000};
        int crescimentoConstante = 100;

        System.out.printf("%-15s %-25s %-25s\n", "Elementos", "Duplicação (ms)", "Cresc. Constante (ms)");
        System.out.println("--------------------------------------------------------------------------");

        for (int quantidade : quantidades) {
            // Teste com duplicação
            PilhaArray pilhaDuplicacao = new PilhaArray(1, 1000); // fator = 0 → duplicação
            long inicioDup = System.currentTimeMillis();
            for (int i = 0; i < quantidade; i++) {
                pilhaDuplicacao.push(i);
            }
            long fimDup = System.currentTimeMillis();
            long tempoDup = fimDup - inicioDup;

            // Teste com crescimento constante
            PilhaArray pilhaConstante = new PilhaArray(1, crescimentoConstante);
            long inicioConst = System.currentTimeMillis();
            for (int i = 0; i < quantidade; i++) {
                pilhaConstante.push(i);
            }
            long fimConst = System.currentTimeMillis();
            long tempoConst = fimConst - inicioConst;

            // Mostrar resultados
            System.out.printf("%-15d %-25d %-25d\n", quantidade, tempoDup, tempoConst);
        }
    }
}
