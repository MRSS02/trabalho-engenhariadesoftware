public class Programa {
    public static void main(String[] args) {
        ComandoInvoker invoker = new ComandoInvoker();
        while (true) {
            invoker.executarComando();
        }
    }
}
