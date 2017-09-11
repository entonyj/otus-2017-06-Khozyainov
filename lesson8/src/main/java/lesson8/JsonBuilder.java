package lesson8;

import lesson8.objects.ArrayExample;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by entony on 10.09.17.
 */
public class JsonBuilder {

    public static String toJson(Object o) {
        return objectToJson(o).build().toString();
    }

    private static JsonObjectBuilder objectToJson(Object o) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        List<Field> fields = getFields(o);

        for (Field field : fields) {

            Object value = null;
            Class type = field.getType();
            String fieldName = field.getName();

            try {
                value = field.get(o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (value == null) {
                builder.addNull(fieldName);
            } else if (type.isPrimitive()){
                if (value instanceof Byte) {
                    builder.add(field.getName(), (byte) value);
                } else if (value instanceof Integer) {
                    builder.add(field.getName(), (int) value);
                } else if (value instanceof Short) {
                    builder.add(field.getName(), (short) value);
                } else if (value instanceof Long) {
                    builder.add(field.getName(), (long) value);
                } else if (value instanceof Float) {
                    builder.add(field.getName(), (float) value);
                } else if (value instanceof Double) {
                    builder.add(field.getName(), (double) value);
                } else if (value instanceof Boolean) {
                    builder.add(field.getName(), (boolean) value);
                } else if (value instanceof Character) {
                    builder.add(field.getName(), (char) value);
                }
            } else if (value instanceof String) {
                builder.add(field.getName(), (String) value);
            } else if (type.isArray()) {
                JsonArrayBuilder arrayBuilder;
                Object isPrim = Array.get(value, 0);
                System.out.println(isPrim);
                if (isPrim instanceof Number) {
                    arrayBuilder =  primitiveArrayToJson((Object) value);
                } else {
                    arrayBuilder =  arrayToJson((Object[]) value);
                }
                builder.add(fieldName, arrayBuilder);
            } else if (Collection.class.isAssignableFrom(type)) {
                value = ((Collection) value).toArray();
                JsonArrayBuilder arrayBuilder = arrayToJson((Object[]) value);
                builder.add(field.getName(), arrayBuilder);
            } else if (value instanceof Object) {
                builder.add(fieldName, objectToJson(value));
            }
        }
        return builder;
    }

    private static List<Field> getFields(Object o) {
        List<Field> fields = new ArrayList<Field>();
        Class<?> cls = o.getClass();
        fields = Arrays.asList(cls.getDeclaredFields());
        return fields;
    }

    private static String valueToJson(Object value){
        if (value.getClass().isPrimitive()){
            return value.toString();
        } else if (value instanceof String) {
            return  value.toString();
        }
        return toJson(value);
    }

    private static JsonArrayBuilder primitiveArrayToJson (Object array){
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            arrayBuilder.add(valueToJson(Array.get(array,i)));
        }
        return arrayBuilder;
    }

    private static JsonArrayBuilder arrayToJson(Object[] array) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object o : array) {
            arrayBuilder.add(valueToJson(o));
        }
        return arrayBuilder;
    }
}
