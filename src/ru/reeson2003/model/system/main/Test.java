package ru.reeson2003.model.system.main;

import java.sql.*;


/**
 * Created by Toshiba on 22.11.2016.
 */
public class Test {
    public static final String BASE_URL = "jdbc:mysql://127.0.0.1:3306/mygame";
    public static final String USER = "admin";
    public static final String PASSWORD = "34551801";
    public static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " +
            "`users` (`id` int(16) NOT NULL, " +
            "`name` varchar(50) NOT NULL, " +
            "`password` varchar(50) NOT NULL, " +
            "PRIMARY KEY (`id`))" +
            "ENGINE=InnoDB DEFAULT CHARSET=latin1";
    public static final String DELETE_USERS_TABLE = "DROP TABLE IF EXISTS`users`";
    public static final String SHOW_TABLES = "SHOW TABLES";
    public static final String ADD_COLUMN = "ALTER TABLE `users` ADD `email` varchar(50) NOT NULL";
    public static final String DELETE_COLUMN = "ALTER TABLE `users` DROP `email`";
    public static final String SHOW_COLUMNS = "SHOW COLUMNS FROM `users`";
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String  URL = BASE_URL, user = USER, password = PASSWORD;
//            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(URL,user,password);
            statement = connection.createStatement();
            statement.execute(SHOW_COLUMNS);
            resultSet = statement.getResultSet();
            System.out.println(resultSet);
            while (resultSet.next()) {
                System.out.println(resultSet.getNString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
    }
}
