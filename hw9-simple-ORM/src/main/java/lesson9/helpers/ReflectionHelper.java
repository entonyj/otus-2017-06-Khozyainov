package lesson9.helpers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by entony on 28.09.2017.
 */
public class ReflectionHelper {

    private ReflectionHelper(){}

    public static <T> T instantiate(Class<T> type, Object... args){
        try{
            if (args.length == 0){
                return type.newInstance();
            } else {
                return type.getConstructor(toClasses(args)).newInstance(args);
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getFieldValue(Object object, String name){
        Field field = null;
        boolean isAccessible = true;
        try {
            field = object.getClass().getDeclaredField(name);
            isAccessible = field.isAccessible();
            field.setAccessible(true);
            return field.get(object);

        } catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        } finally{
            if (field != null && !isAccessible){
                field.setAccessible(false);
            }
        }
        return  null;
    }

    public static void setFieldValue(Object object, String name, Object value){
        Field field = null;
        boolean isAccessible = true;
        try{
            field = object.getClass().getDeclaredField(name);
            isAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        } finally {
            if (field != null && !isAccessible){
                field.setAccessible(false);
            }
        }
    }

    public static List<Method> getMethodsByAnnotation(Class<?> type, Class<? extends Annotation> annotation) {
        List<Method> result = new ArrayList<>();
        List<Method> methods = new ArrayList<>(Arrays.asList(type.getDeclaredMethods()));

        for (Method m: methods){
            if (m.isAnnotationPresent(annotation)){
                result.add(m);
            }
        }
        return result;
    }

    public static List<Field> getFieldsByAnnotation(Class<?> type, Class<? extends Annotation> annotation){
        List<Field> result = new ArrayList<>();
        List<Field> fields = new ArrayList<>(Arrays.asList(type.getDeclaredFields()));

        for (Field f: fields){
            if(f.isAnnotationPresent(annotation)){
                result.add(f);
            }
        }
        return result;
    }

    public static Object callMethod(Object object, String name, Object... args){
        Method method = null;
        boolean isAccessible = true;
        try {
            method = object.getClass().getDeclaredMethod(name, toClasses(args));
            isAccessible = method.isAccessible();
            method.setAccessible(true);
            return method.invoke(object, args);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            e.printStackTrace();
        } finally {
            if (method != null && !isAccessible){
                method.setAccessible(false);
            }
        }
        return null;
    }

    public static Class<?>[] toClasses(Object[] args){
        List<Class<?>> classes = Arrays.stream(args).map(Object::getClass).collect(Collectors.toList());
        return classes.toArray(new Class<?>[classes.size()]);
    }

}
