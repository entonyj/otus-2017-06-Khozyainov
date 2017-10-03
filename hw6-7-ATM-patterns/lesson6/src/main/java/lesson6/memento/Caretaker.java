package lesson6.memento;

/**
 * Created by entony on 28.08.17.
 */
public class Caretaker {
    private Memento memento;
    private Memento defaultMemento;

    public Memento getMemento(){
        return memento;
    }

    public void setMemento(Memento memento){
        this.memento = memento;
    }

    public Memento getDefaultMemento(){return defaultMemento;}

    public void setDefaultMemento(Memento memento) {this.defaultMemento = memento;}
}
