public class SistemaBiblioteca {
    private static BibliotecaSistema instance;
    private ComandoInvoker invoker = new ComandoInvoker();

    public void executarComando(String linhaComando) {
        invoker.executarComando(linhaComando);
    }

    private void inicializarDados() {
        // Inicializa dados de livros e usuários para testes
    }

    public static void main(String[] args) {
        BibliotecaSistema sistema = BibliotecaSistema.getInstance();
        sistema.executarComando("emp 123 100");
        sistema.executarComando("dev 123 100");
        sistema.executarComando("res 123 100");
        sistema.executarComando("obs 200 100");
        sistema.executarComando("liv 100");
        sistema.executarComando("usu 123");
        sistema.executarComando("ntf 200");
        sistema.executarComando("sai");
    }
}
