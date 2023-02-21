import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlSampler {


    public static class StudentNames {
        private String name;
        private String lastName;

        public StudentNames(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }
    }

    private static Map<Double, List<StudentNames>> mapGrades;

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
            final ResultSet rs = statement.executeQuery("SELECT name,last_name,average_grade FROM students");
            mapGrades = new HashMap<Double, List<StudentNames>>();
            while (rs.next()) {
                Double grade = rs.getDouble("average_grade");
                if (mapGrades.get(grade) == null) {
                    mapGrades.put(grade, new ArrayList<StudentNames>());
                }
                mapGrades.get(grade).add(new StudentNames(rs.getString(1), rs.getString(2)));
                //System.out.println(rs.getString("name"));
            }
            for (List<StudentNames> lst : mapGrades.values()) {
                if (lst.size() > 1) {
                    for (StudentNames names : lst) {
                        System.out.println(names.name + " " + names.lastName);
                    }
                }
            }
            //запрос без возвращения результатов
            //statement.executeUpdate("INSERT INTO students VALUES(5, 'Alex', 'Str', 12, 7.2)");
            //statement.close();
            //connection.close();
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
