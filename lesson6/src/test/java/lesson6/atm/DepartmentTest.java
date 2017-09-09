package lesson6.atm;

import lesson6.department.Department;
import lesson6.money.Nominal;
import lesson6.money.Note;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by entony on 09.09.17.
 */
public class DepartmentTest {
    @Test
    public void departmentBalance(){
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(Nominal.TEN, 10));

        ATM shopAtm = new ATM(cells);
        ATM schoolAtm = new ATM(cells);

        Department department = new Department(shopAtm, schoolAtm);

        Assert.assertEquals(200, department.getBalance());
    }

    @Test
    public void departmentEncashmentService(){
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(Nominal.TEN, 10));

        ATM shopAtm = new ATM(cells);
        ATM schoolAtm = new ATM(cells);

        Department department = new Department(shopAtm, schoolAtm);

        shopAtm.withdraw(100);
        Assert.assertEquals(100, department.getBalance());
    }

}
