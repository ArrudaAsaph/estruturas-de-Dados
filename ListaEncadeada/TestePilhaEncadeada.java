public class TestePilhaEncadeada {
    public static void main(String[] args) {
        
        PilhaEncadeada pilhaEncadeada = new PilhaEncadeada();
        pilhaEncadeada.push(1);
        pilhaEncadeada.push(2);
        pilhaEncadeada.push(3);
        

        pilhaEncadeada.print();
        pilhaEncadeada.pop();
        pilhaEncadeada.print();
        
        pilhaEncadeada.top();
    }
}
