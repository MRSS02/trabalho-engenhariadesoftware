public class Main {
    public static void main(String[] args) {
        ComandoInvoker invoker = new ComandoInvoker();
        while (true) {
            SistemaBiblioteca.getInstance().inicializarDados();
            invoker.executarComando();
        }
    }
}
