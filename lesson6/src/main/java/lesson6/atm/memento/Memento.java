package lesson6.atm.memento;

import lesson6.atm.Cell;

import java.util.ArrayList;
import java.util.List;

import static lesson6.atm.Cell.copyCells;

/**
 * Created by entony on 26.08.17.
 */
public class Memento {
    private final List<Cell> state;

    public Memento(List<Cell> cells){
        state = copyCells(cells);
    }

    public List<Cell> getSavedState(){
        return copyCells(state);
    }



}
