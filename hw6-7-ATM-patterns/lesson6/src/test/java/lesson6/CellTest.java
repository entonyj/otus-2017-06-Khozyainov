package lesson6;

import lesson6.money.Nominal;
import lesson6.money.Note;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by entony on 24.08.17.
 */
public class CellTest {
    @Test
    public void withdrawSimple(){
        Cell cell = new Cell(Nominal.TEN, 10);
        Assert.assertEquals(40, cell.withdraw(40));
    }

    @Test
    public void withdrawBig(){
        Cell cell = new Cell(Nominal.TEN,10);
        Assert.assertEquals(100, cell.withdraw(101));
    }

    @Test
    public void withdrawBigCash(){
        Cell cell = new Cell(Nominal.HUNDRED,1);
        Assert.assertEquals(100, cell.withdraw(101));
    }

    @Test
    public void withdrawBigNominal(){
        Cell cell = new Cell(Nominal.HUNDRED,1);
        Assert.assertEquals(0, cell.withdraw(50));
    }

    @Test
    public void depositSimple(){
        Cell cell = new Cell(Nominal.TEN, 1);
        Assert.assertTrue(cell.deposit(new Note(Nominal.TEN)));
    }

    @Test
    public void depositNotEquals(){
        Cell cell = new Cell(Nominal.TEN, 1);
        Assert.assertFalse(cell.deposit(new Note(Nominal.FIVE)));
    }
}
