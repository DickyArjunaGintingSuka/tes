/*
 * POLITEKNIK CALTEX RIAU
 * 1 TEKNIK KOMPUTER
 */
package TRAVEL;

/**
 *
 * @author Dicky Arjuna Ginting Suka <2056401008>
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
public class konfig {
    private static Connection MySQLConfig;
    public static Connection configDB() throws SQLException{
        try {
            String url="jdbc:mysql://localhost:3308/travel";
            String user="root";
            String pass="";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Koneksi gagal "+e.getMessage());
        }
        return MySQLConfig;
    }
}
