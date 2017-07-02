package lesson2;

/**
 * Created by entony on 21.06.17.
 */

/**
 * VM options -Xmx512m -Xms512m
 * <p>
 * Runtime runtime = Runtime.getRuntime();
 * long mem = runtime.totalMemory() - runtime.freeMemory();
 * <p>
 * System.gc()
 * <p>
 * jconsole, connect to pid
 */

class MyClass{
    private int i;
}

public class Main {
    public static void main(String... args) throws InterruptedException{

        //new Object()
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memBefore = runtime.totalMemory() - runtime.freeMemory();
        int size = 1000000;
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Object();
        }
        long memAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("new Object(): " + (memAfter - memBefore)/size + " bytes");
        System.gc();
        Thread.sleep(100); //wait for 1 sec

        //new String("")
        System.gc();
        memBefore = runtime.totalMemory() - runtime.freeMemory();
        Object[] array1 = new Object[size];
        for (int i = 0; i < size; i++) {
            array1[i] = new String(""); //String pool
        }
        memAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("new String(\"\"): " + (memAfter - memBefore)/size + " bytes");
        System.gc();
        Thread.sleep(100); //wait for 1 secSystem.gc();

        //new String(new char[0])
        System.gc();
        memBefore = runtime.totalMemory() - runtime.freeMemory();
        Object[] array2 = new Object[size];
        for (int i = 0; i < size; i++) {
            array2[i] = new String(new char[0]); //String pool
        }
        memAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("new String(new char[0]): " + (memAfter - memBefore)/size + " bytes");
        System.gc();
        Thread.sleep(100); //wait for 1 secSystem.gc();

        //new MyClass()
        System.gc();
        memBefore = runtime.totalMemory() - runtime.freeMemory();
        Object[] array3 = new Object[size];
        for (int i = 0; i < size; i++) {
            array3[i] = new MyClass(); //String pool
        }
        memAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("MyClass(): " + (memAfter - memBefore)/size + " bytes");
    }
}
