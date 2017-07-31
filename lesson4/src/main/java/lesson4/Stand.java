package lesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by entony on 31.07.17.
 */
public class Stand {
    private int size = 1000;

    public Stand(){
    }

    public Stand(int size){
        this.size = size;
    }

    void run() {
        List<String> array = new ArrayList<>(size);

        while(true){
            for (int i = 0; i < size; i++) {
                array.add(new String(new char[0]));
            }

            for (int i = 0; i < size/2; i++) {
                array.remove(i);
            }

            System.out.println("Array size: " + array.size() + ". Created: " + size + ". Removed: " + size/2);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
