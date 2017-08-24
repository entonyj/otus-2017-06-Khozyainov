package lesson6.atm;

import com.sun.source.tree.AssertTree;
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

        cell.add(new Cell(1,100));
        ATM atm = new ATM(cell);

        Assert.assertEquals(100, atm.getBalance());
    }

    @Test
    public void withdrawOk(){
        List<Cell> cells = new ArrayList<>();

        cells.add(new Cell(1, 10));
        cells.add(new Cell(5, 10));

        ATM atm = new ATM(cells);

        Assert.assertTrue(atm.withdraw(30));
    }

    @Test
    public void withdrawFail(){
        List<Cell> cells = new ArrayList<>();

        cells.add(new Cell(5, 10));
        cells.add(new Cell(10, 10));

        ATM atm = new ATM(cells);

        Assert.assertFalse(atm.withdraw(17));
    }

    @Test
    public void withdrawAndBalance(){
        List<Cell> cells = new ArrayList<>();

        cells.add(new Cell(50, 2));
        cells.add(new Cell(100, 1));

        ATM atm = new ATM(cells);

        Assert.assertTrue(atm.withdraw(100));
        Assert.assertEquals(100, atm.getBalance());
    }
}
