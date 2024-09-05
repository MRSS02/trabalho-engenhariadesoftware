import java.util.ArrayList;

public class SistemaBiblioteca {

    private ArrayList<Usuario> ListaUsuarios = new ArrayList<>();
    private ArrayList<Livro> ListaLivros = new ArrayList<>();
    private ArrayList<Exemplar> ListaExemplares = new ArrayList<>();
    private int numeroReservas = 0;

    private static SistemaBiblioteca instance;

    private SistemaBiblioteca() {

    }

    public static SistemaBiblioteca getInstance() {
        if (instance == null) {
            instance = new SistemaBiblioteca();
        }
        return instance;
    }

    public void inicializarDados() {
        // Inicializa dados de livros e usuários para testes
        ListaUsuarios.add(Fabrica.cadastrarAlunoGraduacao(123, "João da Silva"));
        ListaUsuarios.add(Fabrica.cadastrarAlunoPos(456, "Luiz Fernando Rodrigues"));
        ListaUsuarios.add(Fabrica.cadastrarAlunoGraduacao(789, "Pedro Paulo"));
        ListaUsuarios.add(Fabrica.cadastrarProfessor(100, "Carlos Lucena"));
        ListaLivros.add(Fabrica.cadastrarLivro(100, "Engenharia de Software", "AddisonWesley",
                "Ian Sommervile", "6ª", 2000));
        ListaLivros.add(Fabrica.cadastrarLivro(101, "UML – Guia do Usuário",
                "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª", 2000));
        ListaLivros.add(Fabrica.cadastrarLivro(200, "Code Complete", "Microsoft Press",
                "Steve McConnell", "2ª", 2014));
        ListaLivros.add(Fabrica.cadastrarLivro(201, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "Robert Martin", "1ª", 2002));
        ListaLivros.add(Fabrica.cadastrarLivro(300, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "Martin Fowler", "1ª", 1999));
        ListaLivros.add(Fabrica.cadastrarLivro(301, "Software Metrics: A Rigorous and Practical Approach",
                "CRC Press", "Norman Fenton, James Bieman", "3ª", 2014));
        ListaLivros.add(Fabrica.cadastrarLivro(400, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1ª", 1994));
        ListaLivros.add(
                Fabrica.cadastrarLivro(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                        "Addison-Wesley Professional", "Martin Fowler", "3ª", 2003));
        ListaExemplares.add(Fabrica.cadastrarExemplar(100, 1));
        ListaExemplares.add(Fabrica.cadastrarExemplar(100, 2));
        ListaExemplares.add(Fabrica.cadastrarExemplar(101, 3));
        ListaExemplares.add(Fabrica.cadastrarExemplar(200, 4));
        ListaExemplares.add(Fabrica.cadastrarExemplar(201, 5));
        ListaExemplares.add(Fabrica.cadastrarExemplar(300, 6));
        ListaExemplares.add(Fabrica.cadastrarExemplar(300, 7));
        ListaExemplares.add(Fabrica.cadastrarExemplar(400, 8));
        ListaExemplares.add(Fabrica.cadastrarExemplar(400, 9));

    }

    public ArrayList<Livro> getListaLivros() {
        return this.ListaLivros;
    }

    public ArrayList<Exemplar> getListaExemplares() {
        return this.ListaExemplares;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return this.ListaUsuarios;
    }

    public Usuario getUsuarioByCodigo(int codigo) {
        for (Usuario usuario : this.getListaUsuarios()) {
            if (usuario.getCodigo() == codigo) {
                return usuario;
            }
        }
        return null;
    }

    public Livro getLivroByCodigo(int codigo) {
        for (Livro livro : this.getListaLivros()) {
            if (livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null;
    }

    public int getNumeroReservas() {
        return this.numeroReservas;
    }

    public Exemplar getExemplarByCodigoLivro(int codigo) {
        for (Exemplar exemplar : this.getListaExemplares()) {
            if (exemplar.getCodigoLivro() == codigo) {
                return exemplar;
            }
        }
        return null;
    }

}
