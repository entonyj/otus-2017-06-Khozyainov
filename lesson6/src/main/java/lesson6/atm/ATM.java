package lesson6.atm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by entony on 15.08.17.
 */
public class ATM {
    private List<Cell> cells;
    private List<Cell> beforeWithdraw;
    private final List<Cell> defaultCells;

    public ATM(List<Cell> cells){
        Collections.sort(cells);
        this.cells = cells;
        defaultCells = copyCells(cells);
    }

    public List<Cell> copyCells(List<Cell> src){
        List<Cell> result = new ArrayList<>();
        for (Cell cell: src){
            result.add(new Cell(cell));
        }
        return result;
    }

    public void setBeforeWithdraw(){
        cells = copyCells(beforeWithdraw);
    }

    public void setDefaultCells(){
        cells = copyCells(defaultCells);
    }

    public boolean withdraw(int cash){
        beforeWithdraw = copyCells(cells);
        Iterator<Cell> i = cells.iterator();
        while ((i.hasNext()) && (cash != 0)){
            cash = cash - i.next().withdraw(cash);
        }
        if (cash == 0)
            return true;
        setBeforeWithdraw();
        return false;
    }

    public int getBalance(){
        int total = 0;
        for(Cell cell: cells){
            total = total + cell.getBalance();
        }
        return total;
    }

    public void printCells(){
        for (Cell cell: cells)
            cell.printCell();
    }

}
