package lesson9.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by entony on 28.09.2017.
 */
public class ConnectionHelper {

    public static Connection getConnection(){
        try {
            DriverManager.registerDriver(new  com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://" +      //db type
                    "localhost:" +              //host name
                    "3306/" +                   //port
                    "users?" +                   //db name
                    "useSSL=false&" +           //do not use ssl
                    "user=root&" +              //login
                    "password=Ww19082001";      //password
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
