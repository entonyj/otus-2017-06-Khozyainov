package lesson6.atm;

import lesson6.atm.memento.Caretaker;
import lesson6.atm.memento.Memento;
import lesson6.money.Note;
import lesson6.service.Service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static lesson6.atm.Cell.copyCells;

/**
 * Created by entony on 15.08.17.
 */
public class ATM {
    private List<Cell> cells;
    private Caretaker caretaker = new Caretaker();

    public ATM(List<Cell> cells) {
        Collections.sort(cells);
        this.cells = copyCells(cells);
        caretaker.setDefaultMemento(saveToMemento());
    }

    public void collectMoney(){
        cells = caretaker.getDefaultMemento().getSavedState();
    }

    public Memento saveToMemento() {
        return new Memento(cells);
    }

    public void restoreFromMemento(Memento memento) {
        cells = memento.getSavedState();
    }

    public boolean withdraw(int cash) {
        caretaker.setMemento(saveToMemento());

        Iterator<Cell> i = cells.iterator();
        while ((i.hasNext()) && (cash != 0)) {
            cash = cash - i.next().withdraw(cash);
        }

        if (cash == 0)
            return true;

        restoreFromMemento(caretaker.getMemento());
        return false;
    }

    public List<Note> deposit(List<Note> notes) {
        List<Note> backingCash = notes;
        for (Cell cell: cells){
            backingCash = cell.deposit(notes);
        }
        return backingCash;
    }

    public int getBalance() {
        int total = 0;
        for (Cell cell : cells) {
            total = total + cell.getBalance();
        }
        return total;
    }

    public void doService(Service service){
        service.visit(this);
    }

}
