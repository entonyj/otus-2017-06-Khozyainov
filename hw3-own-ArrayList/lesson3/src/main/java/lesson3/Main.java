package lesson3;

import java.util.Collections;
import java.util.List;

/**
 * Created by entony on 12.07.17.
 */
public class Main {

    private static void printArray(List list, String name) {
        int size = list.size();
        System.out.println(name + ":");
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> array = new MyArrayList<>();
        List<Integer> dest = new MyArrayList<>();


        System.out.println("Checking Collections.addAll");
        Collections.addAll(array, 1, 2, 3, 4, 5);
        printArray(array, "array");
        Collections.addAll(dest, 10, 11, 12, 13, 14);
        printArray(dest, "dest");

        System.out.println("\nChecking Collections.copy");
        Collections.copy(dest, array);
        printArray(dest, "dest");

        System.out.println("\nChecking Collections.sort");
        Collections.sort(dest, Collections.reverseOrder());
        printArray(dest, "Reversed dest");
    }
}
