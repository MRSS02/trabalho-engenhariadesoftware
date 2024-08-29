import java.util.ArrayList;

public class SistemaBiblioteca {

    private static ArrayList<Usuario> ListaUsuarios;
    private static ArrayList<Livro> ListaLivros;
    private static ArrayList<Exemplar> ListaExemplares;

    private static void inicializarDados() {
        // Inicializa dados de livros e usuários para testes
        ListaUsuarios.add(Fabrica.cadastrarAlunoGraduacao(123, "João da Silva"));
        ListaUsuarios.add(Fabrica.cadastrarAlunoPos(456, "Luiz Fernando Rodrigues"));
        ListaUsuarios.add(Fabrica.cadastrarAlunoGraduacao(789, "Pedro Paulo"));
        ListaUsuarios.add(Fabrica.cadastrarProfessor(100, "Carlos Lucena"));
        ListaLivros.add(Fabrica.cadastrarLivro(100, "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6ª", 2000));
        ListaExemplares.add(Fabrica.cadastrarExemplar(100, 1, true));

        
    }

    public static ArrayList<Livro> getListaLivros() {
        return SistemaBiblioteca.ListaLivros;
    }

    public static void main(String[] args) {
        ComandoInvoker invoker = new ComandoInvoker();
        while (true) {
            invoker.executarComando();
        }
    }
}
