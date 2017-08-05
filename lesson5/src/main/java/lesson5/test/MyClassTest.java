package lesson5.test;

import lesson5.testframework.annotations.After;
import lesson5.testframework.annotations.Before;
import lesson5.testframework.annotations.Test;

/**
 * Created by entony on 05.08.17.
 */
public class MyClassTest {

    @Before
    public void printBefore(){
        System.out.println("Before");
    }

    @Test
    public void printA() {
        System.out.println("Test A");
    }

    @Test
    public void printB() {
        System.out.println("Test B");
    }

    @Test
    public void printC() {
        System.out.println("Test C");
    }

    @After
    public void printAfter() {
        System.out.println("After");
    }

}
