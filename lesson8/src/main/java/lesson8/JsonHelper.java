package lesson8;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by entony on 11.09.17.
 */
public class JsonHelper {
    public static String toJson(Object obj){
        JsonObjectBuilder objBuilder = Json.createObjectBuilder();
        return objToJson(null, obj, objBuilder).build().toString();
    }

    private static JsonObjectBuilder objToJson (String fieldName, Object obj, JsonObjectBuilder objBuilder){
        Class cls = obj.getClass();
        if (obj == null){
            return objBuilder.addNull(fieldName);
        } else if (cls.isPrimitive() || obj instanceof String){
            return valueToJson(fieldName, obj, objBuilder);
        } else if (cls.isArray()){
            return objBuilder.add(fieldName, arrayToJson(obj, Json.createArrayBuilder()));
        } else {
            List<Field> fields = getFields(obj);
            for (Field field: fields){

                Object value = null;

                try {
                    value = field.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                Class type = field.getType();
                fieldName = field.getName();

                return objToJson(fieldName, value, objBuilder);
            }
        }
        return objBuilder;
    }


    private static JsonObjectBuilder valueToJson (String fieldName, Object value, JsonObjectBuilder objBuilder) {
        Class type = value.getClass();
        if (type.isPrimitive()) {
            if (value instanceof Byte) {
                return objBuilder.add(fieldName, (byte) value);
            } else if (value instanceof Integer) {
                return objBuilder.add(fieldName, (int) value);
            } else if (value instanceof Short) {
                return objBuilder.add(fieldName, (short) value);
            } else if (value instanceof Long) {
                return objBuilder.add(fieldName, (long) value);
            } else if (value instanceof Float) {
                return objBuilder.add(fieldName, (float) value);
            } else if (value instanceof Double) {
                return objBuilder.add(fieldName, (double) value);
            } else if (value instanceof Boolean) {
                return objBuilder.add(fieldName, (boolean) value);
            } else if (value instanceof Character) {
                return objBuilder.add(fieldName, (char) value);
            }
        } else if (value instanceof String) {
            return objBuilder.add(fieldName, (String) value);
        }
        return objBuilder;
    }

    private static JsonArrayBuilder arrayToJson (Object value, JsonArrayBuilder arrayBuilder){
        int length = Array.getLength(value);
        for (int i = 0; i < length; i++) {
            Object item = Array.get(value, i);
            if (item instanceof Byte) {
                arrayBuilder.add((byte) item);
            } else if (item instanceof Integer) {
                arrayBuilder.add((int) item);
            } else if (item instanceof Short) {
                arrayBuilder.add((short) item);
            } else if (item instanceof Long) {
                arrayBuilder.add((long) item);
            } else if (item instanceof Float) {
                arrayBuilder.add((float) item);
            } else if (item instanceof Double) {
                arrayBuilder.add((double) item);
            } else if (item instanceof Boolean) {
                arrayBuilder.add((boolean) item);
            } else if (item instanceof Character) {
                arrayBuilder.add((char) item);
            } else if (item instanceof String) {
                arrayBuilder.add((String) item);
            } else if (item.getClass().isArray()){
                arrayBuilder.add(arrayToJson(item, Json.createArrayBuilder()));
            } else if (Collection.class.isAssignableFrom(item.getClass())){
                item = ((Collection) item).toArray();
                arrayBuilder.add(arrayToJson(item, Json.createArrayBuilder()));
            } else if (item instanceof Object){
                arrayBuilder.add(objToJson(null, item, Json.createObjectBuilder()));
            }
        }
        return arrayBuilder;
    }

    private static List<Field> getFields(Object o) {
        List<Field> fields = new ArrayList<Field>();
        fields = Arrays.asList(o.getClass().getDeclaredFields());
        return fields;
    }

}
