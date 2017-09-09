package lesson6;

import lesson6.atm.ATM;
import lesson6.atm.Cell;
import lesson6.department.Department;
import lesson6.money.Nominal;
import lesson6.money.Note;
import lesson6.service.CollectingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by entony on 05.08.17.
 */
public class Main {
    public static void main(String[] args) {
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(Nominal.TEN, 10));

        ATM shopAtm = new ATM(cells);
        cells.add(new Cell(Nominal.HUNDRED, 1));
        ATM schoolAtm = new ATM(cells);
        Department department = new Department(shopAtm, schoolAtm);

        List<Note> notes = new ArrayList<>();
        notes = makeBankroll(Nominal.TEN, Nominal.TEN);

        System.out.println("At start: " + department.getBalance());

        schoolAtm.withdraw(10);
        System.out.println("Withdraw(10): " + department.getBalance());

        shopAtm.deposit(notes);
        System.out.println("Deposit(20): " + department.getBalance());

        department.doService(new CollectingService());
        System.out.println("Encashment: " + department.getBalance());
    }

    public static List<Note> makeBankroll(Nominal ... nominals){
        List<Note> notes = new ArrayList<>();
        for (Nominal nominal: nominals){
            notes.add(new Note(nominal));
        }
        return notes;
    }
}
