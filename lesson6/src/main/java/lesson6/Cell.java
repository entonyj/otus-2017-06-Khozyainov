package lesson6;


import lesson6.money.Nominal;
import lesson6.money.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by entony on 15.08.17.
 */
public class Cell implements Comparable<Cell> {
    private final Nominal nominal;
    private int count;


    public Cell(Nominal nominal, int count) {
        this.nominal = nominal;
        this.count = count;
    }

    public Cell(Cell cell) {
        this.nominal = cell.getNominal();
        this.count = cell.getCount();
    }

    public int getCount() {
        return count;
    }

    public Nominal getNominal() {
        return nominal;
    }

    public int getBalance() {
        return count * nominal.getValue();
    }

    public int withdraw(int requestedCash) {
        int expectedCount = Math.min(requestedCash / nominal.getValue(), count);
        int cash = expectedCount * nominal.getValue();
        count = count - expectedCount;
        return cash;
    }

    public boolean deposit(Note note){
        if (this.getNominal().equals(note.getNominal())){
            this.count++;
            return true;
        }
        return false;
    }

    public List<Note> deposit(List<Note> notes){
        List<Note> backingCash = new ArrayList<>();
        for (Note note: notes){
            if (!this.deposit(note)){
                backingCash.add(note);
            }
        }
        return backingCash;
    }

    public int compareTo(Cell o) {
        if (nominal.getValue() > o.getNominal().getValue())
            return -1;
        if (nominal.getValue() < o.getNominal().getValue())
            return 1;
        return 0;
    }

    public static List<Cell> copyCells(List<Cell> src){
        List<Cell> result = new ArrayList<>();
        for (Cell cell: src){
            result.add(new Cell(cell));
        }
        return result;
    }


}
