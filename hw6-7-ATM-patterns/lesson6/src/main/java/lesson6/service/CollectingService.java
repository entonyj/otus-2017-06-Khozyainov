package lesson6.service;

import lesson6.ATM;

/**
 * Created by entony on 02.09.17.
 */
public class CollectingService implements Service {

    @Override
    public void visit(ATM atm) {
        atm.collectMoney();
    }
}
