package lesson6.money;

/**
 * Created by entony on 02.09.17.
 */
public class Note {
    private final Nominal nominal;

    public Note(Nominal nominal){
        this.nominal = nominal;
    }

    public Nominal getNominal(){
        return this.nominal;
    }



}
