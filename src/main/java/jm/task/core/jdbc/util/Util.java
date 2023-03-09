package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Util {
    // реализуйте настройку соеденения с БД
    public static final String dbName = "kata_preproject";
    public static final String dbTableName = "kata_preproject";
    private static final String dbUrlConnection = "jdbc:mysql://localhost:3306/kata_preproject";

    private static final String dbUserName = "kir";
    private static final String dbUserPassword = "123";

    public static Connection connection = getConnection();

    public static Connection getConnection() {
        try {
            System.out.println("Есть соединение");
            return DriverManager.getConnection(dbUrlConnection, dbUserName, dbUserPassword);
        } catch (SQLException e) {

            System.out.println("Error connect with database");
            throw new RuntimeException(e);
        }
    }
   /*
        public static Connection connection;
   public static Connection getConnection() {
       Connection connection;
       try {
           Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection(dbUrlConnection, dbUserName, dbUserPassword);
           System.out.println("Есть соединение");
           return connection;
       } catch ( SQLException e) {
           System.out.println("DB connection error");
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }

       return connection = null;
   }
*/

    public String getDbTableName() {
        return dbTableName;
    }

    public String getDbName() {
        return dbName;
    }
}
