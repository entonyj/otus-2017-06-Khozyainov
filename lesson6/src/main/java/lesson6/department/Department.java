package lesson6.department;

import lesson6.atm.ATM;
import lesson6.service.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by entony on 02.09.17.
 */
public class Department {
    private List<ATM> atmList = new ArrayList<>();

    public Department(ATM ... atms){
        for (ATM atm: atms){
            atmList.add(atm);
        }
    }

    public Department(List<ATM> atms){
        atmList.addAll(atms);
    }

    public boolean add(ATM atm){
        return atmList.add(atm);
    }

    public boolean addAll(List<ATM> atms){
        return atmList.addAll(atms);
    }

    public int getBalance() {
        int sum = 0;
        for (ATM atm: atmList){
            sum += atm.getBalance();
        }
        return sum;
    }

    public void doService(Service service) {
        for (ATM atm: atmList){
            atm.doService(service);
        }
    }
}
