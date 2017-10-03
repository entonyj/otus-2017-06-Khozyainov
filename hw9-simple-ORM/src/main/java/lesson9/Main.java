package lesson9;

import lesson9.data.UserDataSet;
import lesson9.executor.Executor;
import lesson9.helpers.ConnectionHelper;

import java.sql.Connection;

/**
 * Created by entony on 26.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        ex();
    }

    private static void ex(){
        Connection connection = ConnectionHelper.getConnection();
        Executor executor = new Executor(connection);

        UserDataSet savingSet = new UserDataSet("Jb", 29);
        System.out.println(executor.save(savingSet));

        UserDataSet loadingSet = executor.load(1, UserDataSet.class);
        System.out.println(loadingSet);
    }

}
