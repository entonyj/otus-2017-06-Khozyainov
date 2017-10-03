package lesson9.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by entony on 29.09.2017.
 */
public interface TResultHandler <T> {
    T handle (ResultSet resultSet) throws SQLException;
}
