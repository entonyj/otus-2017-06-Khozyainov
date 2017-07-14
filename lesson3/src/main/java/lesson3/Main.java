package lesson3;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by entony on 12.07.17.
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        Integer[] srcArray = {1,2,3};
        ArrayList<Integer> destArray = new ArrayList<Integer>(3);

        Collections.addAll(myArrayList, srcArray);

        Collections.copy(destArray, myArrayList);

        for (int num: myArrayList){
            System.out.println(num);
        }

    }
}
