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

        myArrayList.add(1);

        System.out.println((9+1)*3/2);

        //Collections.addAll(myArrayList, srcArray);
        //Collections.copy(destArray, myArrayList);
    }
}
