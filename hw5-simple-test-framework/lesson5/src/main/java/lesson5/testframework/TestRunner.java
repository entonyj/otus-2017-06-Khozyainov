package lesson5.testframework;

import lesson5.testframework.annotations.*;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by entony on 05.08.17.
 */
public class TestRunner {

    private TestRunner(){}

    public static void run(Class<?>[] klasses){
        for (Class<?> klass: klasses){
            List<Method> beforeList = ReflectionHelper.getMethodsByAnnotation(klass, Before.class);
            List<Method> testList = ReflectionHelper.getMethodsByAnnotation(klass, Test.class);
            List<Method> afterList = ReflectionHelper.getMethodsByAnnotation(klass, After.class);

            System.out.println(klass.getName() + " runs.");

            for (Method testMethod: testList){

                Object instance = ReflectionHelper.instantiate(klass);

                for (Method beforeMethod: beforeList){
                    ReflectionHelper.callMethod(instance, beforeMethod.getName());
                }

                ReflectionHelper.callMethod(instance, testMethod.getName());

                for (Method afterMethod: afterList){
                    ReflectionHelper.callMethod(instance, afterMethod.getName());
                }
            }
        }
    }
}
