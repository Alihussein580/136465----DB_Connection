//136465
package simple;
import java.sql.*;
import javax.swing.*;

public class Simple {
    
   
    public static void insert(String username,String password, String role){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name","root","password");
            Statement stmt = con.createStatement();
            String newRow = "INSERT INTO users (username,password,role) VALUES ('"+username+"','"+password+"','"+role+"')";
            stmt.executeUpdate(newRow);
            JOptionPane.showMessageDialog(null, "Sucessfully inserted");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void select(String username){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name","root","password");
            Statement stmt = con.createStatement();
            String selectRow = "SELECT * FROM users WHERE username = '"+username+"'";
            ResultSet rs = stmt.executeQuery(selectRow);
            rs.next();
            String password = rs.getString("password");
            String role = rs.getString("role");
            JOptionPane.showMessageDialog(null, username+", Password: " + password + ", Role :" + role);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void update(String username,String password, String role){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name","root","password");
            Statement stmt = con.createStatement();
            String update = "UPDATE users SET password ='"+password+"',role = '"+role+"' WHERE username = '"+username+"'";
            stmt.executeUpdate(update);
            JOptionPane.showMessageDialog(null,"Successfully Updated");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void delete(String username){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name","root","password");
            Statement stmt = con.createStatement();
            String delete = "DELETE FROM users WHERE username ='"+username+"'";
            stmt.executeUpdate(delete);
            JOptionPane.showMessageDialog(null,"Successfully Deleted");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void main(String[] args) {
        delete("User");
    }
    
}
