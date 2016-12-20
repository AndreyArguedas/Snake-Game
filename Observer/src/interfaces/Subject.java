package interfaces;

public interface Subject {
    public void agregar(Observer e);
    public void remover(Observer e);
    public void notificar();
}
