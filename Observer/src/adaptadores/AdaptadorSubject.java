package adaptadores;

import interfaces.Observer;
import interfaces.Subject;
import java.util.LinkedList;

public class AdaptadorSubject implements Subject{
 
    public AdaptadorSubject(){
        vistas = new LinkedList<>();
    }
    
    @Override
    public void agregar(Observer e) {
        vistas.add(e);
    }

    @Override
    public void remover(Observer e) {
        vistas.remove(e);
    }

    @Override
    public void notificar() {
        for(Observer e : vistas){
            e.update();
        }
    }
    
    private LinkedList<Observer> vistas;
}
