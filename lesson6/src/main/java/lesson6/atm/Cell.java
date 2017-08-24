package lesson6.atm;

/**
 * Created by entony on 15.08.17.
 */
public class Cell implements Comparable<Cell>{
    private final int nominal;
    private int count;

    public Cell(int nominal, int count){
        this.nominal = nominal;
        this.count = count;
    }

    public Cell(Cell cell){
        this.nominal = cell.getNominal();
        this.count = cell.getCount();
    }

    public int getNominal(){
        return nominal;
    }

    public int getCount(){
        return count;
    }

    public int getBalance(){
        return count*nominal;
    }

    public int withdraw(int requestedCash){
        int expectedCount = Math.min(requestedCash / nominal, count);
        int cash = expectedCount * nominal;
        count = count - expectedCount;
        return cash;
    }

    public void printCell(){
        System.out.println("Nominal: " + nominal + "; count: " + count);
    }

    @Override
    public int compareTo(Cell o){
        if (nominal > o.getNominal())
            return -1;
        if (nominal < o.getNominal())
            return 1;
        return 0;
    }

}
