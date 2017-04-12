package posttest7;

import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {
    private static Connection con;
    
    public static Connection getConnection(){
        try{
            con = DriverManager.getConnection
                  ("jdbc:mysql://localhost:3306/praktikum_visual","root","");
            JOptionPane.showMessageDialog(null, "koneksi Berhasil");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "koneksi gagal: "+e.getMessage());
        }
        return con;
    }
    
}
