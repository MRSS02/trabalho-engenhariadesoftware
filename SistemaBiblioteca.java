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



    private void inicializarDados() {
        // Inicializa dados de livros e usuários para testes
        ListaUsuarios.add(Fabrica.cadastrarAlunoGraduacao(123, "João da Silva"));
        ListaUsuarios.add(Fabrica.cadastrarAlunoPos(456, "Luiz Fernando Rodrigues"));
        ListaUsuarios.add(Fabrica.cadastrarAlunoGraduacao(789, "Pedro Paulo"));
        ListaUsuarios.add(Fabrica.cadastrarProfessor(100, "Carlos Lucena"));
        ListaLivros.add(Fabrica.cadastrarLivro(100, "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6ª", 2000));
        ListaExemplares.add(Fabrica.cadastrarExemplar(100, 1, true));

        
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
        for(Usuario usuario : this.getListaUsuarios()) {
            if(usuario.getCodigo() == codigo ) {
                return usuario;
            }
        }
        return null;
    }

    public Livro getLivroByCodigo(int codigo) {
        for(Livro livro : this.getListaLivros()) {
            if(livro.getCodigo() == codigo ) {
                return livro;
            }
        }
        return null;
    }

    public int getNumeroReservas() {
        return this.numeroReservas;
    }

    public Exemplar getExemplarByCodigoLivro(int codigo) {
        for(Exemplar exemplar : this.getListaExemplares()) {
            if(exemplar.getCodigo() == codigo ) {
                return exemplar;
            }
        }
        return null;
    }

    
}
