package com.mycompany.resetas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CConexion {
    Connection conectar = null;
    
    String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=SIS-INF;"
                        + "user=userSIS;"
                        + "password=1234;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
    
public Connection establecerConeccion(){
    try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          conectar = DriverManager.getConnection(connectionUrl);
          JOptionPane.showMessageDialog(null, "se conecto correctamente");
        }
        catch (Exception e) {
           JOptionPane.showMessageDialog(null, "no se conecto, error: ");
        }
    return conectar;
}
}
