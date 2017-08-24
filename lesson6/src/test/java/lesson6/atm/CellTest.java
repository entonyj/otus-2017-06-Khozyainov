package lesson6.atm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by entony on 24.08.17.
 */
public class CellTest {
    @Test
    public void withdrawSimple(){
        Cell cell = new Cell(1, 100);
        Assert.assertEquals(40, cell.withdraw(40));
        Assert.assertEquals(60, cell.getCount());
    }

    @Test
    public void withdrawBig(){
        Cell cell = new Cell(1,100);
        // ячейка может вернуть только 100
        Assert.assertEquals(100, cell.withdraw(101));
    }

    @Test
    public void withdrawBigCash(){
        Cell cell = new Cell(100,1);
        Assert.assertEquals(100, cell.withdraw(101));
    }

    @Test
    public void withdrawBigNominal(){
        Cell cell = new Cell(100,1);
        Assert.assertEquals(0, cell.withdraw(50));
    }
}
