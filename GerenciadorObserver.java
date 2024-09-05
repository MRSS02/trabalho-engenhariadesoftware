import java.util.ArrayList;
import java.util.List;

public class GerenciadorObserver {

    private static GerenciadorObserver instance; 
    List<Observer> observadores = new ArrayList<>();

    private GerenciadorObserver() {
    
    }

    public static GerenciadorObserver getInstance() {
        if (instance == null) {
                instance = new GerenciadorObserver();
        }
                return instance;   
    }


    

    public void inscrever(Observer observador) {
        observadores.add(observador);
    }

    public void desinscrever(Observer observador) {
         observadores.remove(observador);
    }

    public Observer getObservadorByCodigo(int codigo) {
        for (Observer observador : observadores) {
            if (observador.getCodigoUsuario() == codigo) {
                return observador;
            }
        }

        return null;

    }

    public void notificar(int codigo) {
        for (Observer observador : observadores) {
            if (observador.getCodigoLivro() == codigo) {
                observador.update(codigo);
            }
        }
    }
}
