import java.time.LocalDate;

public class Fabrica {
		
    public static Usuario cadastrarProfessor(int codigo, String nome) {
        return new Professor(codigo, nome); 
    }
    public static Usuario cadastrarAlunoGraduacao(int codigo, String nome) {
        return new AlunoGraduacao(codigo, nome); 
    }
    public static Usuario cadastrarAlunoPos(int codigo, String nome) {
        return new AlunoPos(codigo, nome); 
    }
    public static Exemplar cadastrarExemplar(int codigoLivro, int codigoExemplar) {
        return new Exemplar(codigoLivro, codigoExemplar); 
    }
    public static Livro cadastrarLivro(int codigo, String titulo, String editora, String autores, String edicao, int anoPublicacao) {
        return new Livro(codigo, titulo, editora, autores, edicao, anoPublicacao); 
    }
    public static Observer cadastrarObservadorProfessor(int codigoUsuario, int codigoLivro) {
        return new ObserverProfessor(codigoUsuario, codigoLivro); 
    }

    public static Emprestimo cadastrarEmprestimo(int codigoLivro, LocalDate dataEmprestimo) {
        return new Emprestimo(codigoLivro, dataEmprestimo);
    }
    
    
}
