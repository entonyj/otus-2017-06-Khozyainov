package lesson6.money;

/**
 * Created by entony on 27.08.17.
 */
public enum Nominal {

    FIVE(5),
    TEN(10),
    FIFTY(50),
    HUNDRED(100);

    private final int value;

    Nominal(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
