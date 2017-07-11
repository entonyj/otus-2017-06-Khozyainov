package lesson2;

import java.util.function.Supplier;

/**
 * Created by entony on 08.07.17.
 */
class Measurer {
    private Object[] array;
    private final int size;

    Measurer(){
        this.size = 1000000;
    }

    Measurer(int size){
        this.size = size;
    };

    private static long getMem(Runnable proc){
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        long memBefore = runtime.totalMemory()-runtime.freeMemory();
        proc.run();
        System.gc();
        long memAfter = runtime.totalMemory()-runtime.freeMemory();
        return memAfter - memBefore;
    }

    void measure(Supplier<Object> supplier, String name){
        array = new Object[size];
        long memChanged = getMem(() -> {
            for (int i=0; i < size; i++){
                array[i] = supplier.get();
            }
        });
        System.out.println(name + ": " + Math.round((double)memChanged/size));
        System.gc();
    }
}
