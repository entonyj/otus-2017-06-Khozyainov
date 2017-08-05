package lesson5;

import lesson5.testframework.TestRunner;

/**
 * Created by entony on 01.08.17.
 */
public class Main {
    public static void main(String[] args) {
        TestRunner.run(new Class[]{lesson5.test.MyClassTest.class, lesson5.test.MySecondClassTest.class});
    }
}
