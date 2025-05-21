public class TesteDeque {
    public static void main(String[] args) {
        Deque d = new Deque(0);

        d.enqueueLast("a");
        d.enqueueLast("b");
        d.enqueueLast("c");
        d.enqueueLast("d");
        d.enqueueLast("e");
        d.enqueueLast("f");
        d.desenhar();

        d.enqueueFirst("89");
        d.desenhar();

        d.enqueueFirst("@");
        d.enqueueLast("X");
        d.desenhar();

        d.dequeueFirst();
        d.dequeueLast();
        d.desenhar();
    }
}
