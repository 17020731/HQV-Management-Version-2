package Database;

import java.sql.*;

public class DataClass1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3307/hqvmanagement","root", "");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
            String out = "";
            try {
                Statement st = connection.createStatement();
                //câu lệnh insert
                String sql = "INSERT INTO products\n" +
                        "VALUES ('GOL', 'Nhan', 'haha', 'CK', 10 );";
                //câu lệnh delete
                String sql1 = "DELETE FROM products\n" +
                        "WHERE productCode = 'Gol'";
                //câu lệnh update
                String sql2 = "UPDATE products\n" +
                        "SET productName = 'TTCK1'\n" +
                        "WHERE productCode = 'GOL';";
//                st.execute(sql);
//                Statement st = con.createStatement();
                String output;
                ResultSet rs = st.executeQuery("SELECT * FROM products");
                while (rs.next()) {
                    output =  (String) rs.getObject(1);
                    System.out.println(output);
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Failed to make connection!");
        }
    }
}
