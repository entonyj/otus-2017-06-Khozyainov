package lesson5.test;

import lesson5.testframework.annotations.After;
import lesson5.testframework.annotations.Before;
import lesson5.testframework.annotations.Test;

/**
 * Created by entony on 05.08.17.
 */
public class MySecondClassTest {

    @Before
    public void checkBefore(){
        System.out.println("Checked before");
    }

    @Test
    public void test1(){
        System.out.println("Success test1");
    }

    @Test
    public void test2(){
        System.out.println("Success test2");
    }

    @After
    public void checkAfter(){
        System.out.println("Checked after");
    }
}
