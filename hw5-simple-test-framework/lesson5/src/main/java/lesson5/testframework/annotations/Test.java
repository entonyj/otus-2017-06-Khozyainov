package lesson5.testframework.annotations;

import java.lang.annotation.*;

/**
 * Created by entony on 05.08.17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Inherited
public @interface Test {
}
