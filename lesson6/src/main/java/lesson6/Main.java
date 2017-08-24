package lesson6;

import lesson6.atm.ATM;
import lesson6.atm.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by entony on 05.08.17.
 */
public class Main {
    public static void main(String[] args) {
        List<Cell> cells = new ArrayList<Cell>();
        //cells.add(new Cell(1, 10));
        cells.add(new Cell(5,10));
        cells.add(new Cell(10, 10));
        cells.add(new Cell(50, 10));
        cells.add(new Cell(100, 10));

        ATM atm = new ATM(cells);
        System.out.println(atm.getBalance());

        System.out.println(atm.withdraw(10));
        System.out.println(atm.getBalance());

        atm.printCells();
    }
}
