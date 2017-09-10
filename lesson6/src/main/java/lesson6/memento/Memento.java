package lesson6.memento;

import lesson6.Cell;

import java.util.List;

/**
 * Created by entony on 26.08.17.
 */
public class Memento {
    private final List<Cell> state;

    public Memento(List<Cell> cells){
        state = Cell.copyCells(cells);
    }

    public List<Cell> getSavedState(){
        return Cell.copyCells(state);
    }



}
