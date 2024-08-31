import java.util.ArrayList;
import java.util.List;

public class GerenciadorObserver {

    private static GerenciadorObserver instance; 

    private GerenciadorObserver() {
    
    }

    public static GerenciadorObserver getInstance() {
        if (instance == null) {
                instance = new GerenciadorObserver();
        }
                return instance;   
    }


    List<Observer> observadores = new ArrayList<>();

    public void inscrever(Observer observador) {
        observadores.add(observador);
    }

    public void desinscrever(Observer observador) {
         observadores.remove(observador);
    }

    public void notificar(int codigo) {
        for (Observer observador : observadores) {
            if (observador.getCodigoLivro() == codigo) {
                observador.update(codigo);
            }
        }
    }
}
