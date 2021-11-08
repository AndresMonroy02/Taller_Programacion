package GUIA7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class connecction {
    public static void main(String[] args){
        String url="jdbc:mysql://127.0.0.1:3306/?user=root";
        String username="root";
        String password="admin1234";
        System.out.println("prueba");
        try {   
            //String id, int id_type, String name, String last_name, String mail, String celphone 
            Connection connection = DriverManager.getConnection(url, username,password);
            String sql = "INSERT INTO user (id, name, last_name, mail, celphone) VALUES(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "25");
            statement.setString(2, "andres");
            statement.setString(3, "monroy");
            statement.setString(4, "mon.andres");
            statement.setString(5, "325");
            int rows = statement.executeUpdate();
            if (rows>0){
                System.out.println("A row has been Inserted"); 
            }
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println("F, ERROR");
        }
    }
}
