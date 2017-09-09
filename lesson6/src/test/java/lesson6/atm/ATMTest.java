package lesson6.atm;

import lesson6.money.Nominal;
import lesson6.money.Note;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by entony on 24.08.17.
 */
public class ATMTest {
    @Test
    public void balanceOk(){
        List<Cell> cell = new ArrayList<>();

        cell.add(new Cell(Nominal.TEN,10));
        ATM atm = new ATM(cell);

        Assert.assertEquals(100, atm.getBalance());
    }

    @Test
    public void withdrawOk(){
        List<Cell> cells = new ArrayList<>();

        cells.add(new Cell(Nominal.FIFTY, 10));
        cells.add(new Cell(Nominal.TEN, 10));

        ATM atm = new ATM(cells);

        Assert.assertTrue(atm.withdraw(30));
    }

    @Test
    public void withdrawFail(){
        List<Cell> cells = new ArrayList<>();

        cells.add(new Cell(Nominal.FIFTY, 10));
        cells.add(new Cell(Nominal.TEN, 10));

        ATM atm = new ATM(cells);

        Assert.assertFalse(atm.withdraw(17));
    }

    @Test
    public void withdrawAndBalance(){
        List<Cell> cells = new ArrayList<>();

        cells.add(new Cell(Nominal.FIFTY, 2));
        cells.add(new Cell(Nominal.HUNDRED, 1));

        ATM atm = new ATM(cells);

        Assert.assertTrue(atm.withdraw(100));
        Assert.assertEquals(100, atm.getBalance());
    }

    @Test
    public void depositNotesOk(){
        List<Cell> cells = new ArrayList<>();
        List<Note> notes= new ArrayList<>();

        cells.add(new Cell(Nominal.TEN, 1));
        cells.add(new Cell(Nominal.HUNDRED, 1));
        notes.add(new Note(Nominal.TEN));

        ATM atm = new ATM(cells);

        Assert.assertEquals(new ArrayList<Note>(), atm.deposit(notes));
    }

    @Test
    public void depositWithOneReturned(){
        List<Cell> cells = new ArrayList<>();
        List<Note> notes= new ArrayList<>();

        cells.add(new Cell(Nominal.TEN, 1));
        cells.add(new Cell(Nominal.HUNDRED, 1));
        notes.add(new Note(Nominal.FIFTY));

        ATM atm = new ATM(cells);

        Assert.assertEquals(notes, atm.deposit(notes));
    }
}
