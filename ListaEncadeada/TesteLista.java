public class TesteLista {
    public static void main(String[] args) {
        ListaEncadeada listaEncadeada = new ListaEncadeada();

        listaEncadeada.exibirElementos();
        
        listaEncadeada.adicionarElemento(5);
        listaEncadeada.adicionarElemento(8);
        listaEncadeada.adicionarElemento(8);
        listaEncadeada.adicionarElemento(8);
        listaEncadeada.exibirElementos();

    }
}
