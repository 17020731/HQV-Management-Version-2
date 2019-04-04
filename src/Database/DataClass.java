package Database;

import java.sql.*;
import java.util.ArrayList;

public class DataClass {
    public static Connection con;

    public DataClass(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
        System.out.println("MySQL JDBC Driver Registered!");

        try {
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3307/hqvmanagement","root", "");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<Object>> getRequest(String que, int fieldNumber){
        ArrayList<ArrayList<Object>> arr = new ArrayList<>();
        if(con != null){
            System.out.println("You made it, take control your database now!");
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(que);
                while (rs.next()) {
                    ArrayList<Object> list = new ArrayList<>();
                    for(int i = 1; i <= fieldNumber; i++){
                        list.add(rs.getObject(i));
                    }
                    arr.add(list);
                }
                st.close();
                rs.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Failed to make connection!");
        }
        return arr;
    }

    public void putRequest(String que){
        if(con != null){
            System.out.println("You made it, take control your database now!");
            try {
                Statement st = con.createStatement();
                //câu lệnh insert
                String sql = "INSERT INTO products\n" +
                        "VALUES ('GTA00006', 'Nhan muoi chi', 'src/images/vangta/muoichi.jpg', 'Nhan muoi chi', 58);";
                st.execute(sql);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Failed to make connection!");
        }
    }
    public static void main(String [] args){
        DataClass data = new DataClass();
        data.putRequest("");
    }



    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        DataClass.con = con;
    }
}
