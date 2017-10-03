package lesson9.executor;

import lesson9.data.DataSet;
import lesson9.handler.TResultHandler;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * Created by entony on 28.09.2017.
 */
public class Executor {

    private final Connection connection;

    public Executor(Connection connection){
        this.connection = connection;
    }

    public <T extends DataSet> boolean save (T entity){
        LinkedHashMap<String, Field> fields = getEntityFields(entity);
        fields.remove("id");

        if (fields == null || fields.size() == 0){
            return false;
        }

        String tableName = getTableName(entity.getClass());
        if (tableName == null){
            return false;
        }

        String query = "INSERT INTO " + tableName;
        List<String> columns = new ArrayList<>();
        List<String> values = new ArrayList<>();
        for (Map.Entry<String, Field> item: fields.entrySet()){

            Field f = item.getValue();
            Column column = f.getAnnotation(Column.class);
            String fieldName = column.name();
            Object fieldValue = null;
            columns.add(fieldName);

            Boolean isAccessible = true;
            try{
                isAccessible = f.isAccessible();
                f.setAccessible(true);
                fieldValue = f.get(entity);
            } catch (IllegalAccessException e){
                e.printStackTrace();
            } finally {
                f.setAccessible(isAccessible);
            }

            values.add("'" + fieldValue.toString() + "'");
        }

        String columnsString = "( " + String.join(", ", columns) + " )";
        String valuesString = "( " + String.join(", ", values) + " )";

        query += " " + columnsString + " VALUES " + valuesString + ";";



        try {
            return update(query) > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public <T extends DataSet> T load (long id, Class<T> entityClass){
        T entity = null;

        String tableName = getTableName(entityClass);
        if (tableName == null){
            return null;
        }

        String query = "SELECT * FROM " + tableName + " WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();

            entity = entityClass.newInstance();
            LinkedHashMap<String, Field> fields = getEntityFields(entity);
            for(Map.Entry<String, Field> item: fields.entrySet()){
                Field field = item.getValue();
                field.setAccessible(true);
                field.set(entity, resultSet.getObject(item.getKey()));
            }
        }catch (SQLException | IllegalAccessException | InstantiationException e){
            e.printStackTrace();
        }
        return entity;
    }

    private int update(String query)throws SQLException{
        try(Statement stmt = connection.createStatement()){
            stmt.execute(query);
            return stmt.getUpdateCount();
        }
    }

    private <T> T execQuery(String query, TResultHandler<T> handler)throws SQLException{
        try (Statement stmt = connection.createStatement()){
            stmt.execute(query);
            ResultSet result = stmt.getResultSet();
            return handler.handle(result);
        }

    }

    private String getTableName(Class<?> entityClass){
        Table annotation = entityClass.getAnnotation(Table.class);
        if (annotation != null){
            return annotation.name();
        }
        return null;
    }

    private LinkedHashMap<String, Field> getEntityFields (Object object){
        LinkedHashMap<String, Field> fields = new LinkedHashMap<>();

        Class<?> c = object.getClass();
        while (!c.equals(Object.class)){
            for (Field field: c.getDeclaredFields()){
                if(field.isAnnotationPresent(Column.class)){
                    fields.put(field.getAnnotation(Column.class).name(),field);
                }
            }
            c = c.getSuperclass();
        }

        return fields;

    }


}
