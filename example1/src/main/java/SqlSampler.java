import java.sql.*;

public class SqlSampler {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
                System.out.println("No sqlite driver");
                return;
        }
        Connection connection = null;
        Statement statement = null;
        try {
            connection =
                DriverManager.getConnection("jdbc:sqlite:C:\\Program Files\\sqlite\\mydb2.db");
            statement = connection.createStatement();
            //если множество ResultSet
           // statement.execute("");
            //один ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM students WHERE average_grade>7");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            //запрос без возвращения результатов
           // statement.executeUpdate("INSERT INTO students VALUES()");
            statement.close();
            connection.close();
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Can't close the connection");
            }
        }
    }
}
