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
    private final double i = 1.;
}

public class Main {
    public static void main(String... args) throws InterruptedException{
        Measurer measurer = new Measurer();

        measurer.measure(Object::new, "Object");
        measurer.measure(String::new, "String with pool");
        measurer.measure(() -> new String(new char[0]), "String");
        measurer.measure(() -> new MyClass(), "MyClass");

    }
}
