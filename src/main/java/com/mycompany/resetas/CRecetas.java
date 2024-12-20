package com.mycompany.resetas;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CRecetas {
    public void mostrarRecetas(JTable paramTABLARECETAS){
        CConexion objetoconeccion = new CConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String consulta="";        
        modelo.addColumn("RECETAS");
        modelo.addColumn("COSTOS");
        paramTABLARECETAS.setModel(modelo);
        consulta = "select distinct receta,costo from TABLARECETAS;";
        String [] datos = new String[2];
        Statement st;
        try{
            st = objetoconeccion.establecerConeccion().createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                modelo.addRow(datos);
            }
            paramTABLARECETAS.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "no se mostraron los registros, error: "+e.toString());
        }
    }
    
    public void insertarReceta(JTextField paramReceta, JTextField paramCosto){
        CConexion objetoconeccion = new CConexion();
        String consulta = "insert into TABLARECETAS (receta,costo) values(?,?)";
        try{
            CallableStatement cs = objetoconeccion.establecerConeccion().prepareCall(consulta);
            cs.setString(1, paramReceta.getText());
            cs.setString(2, paramCosto.getText());
            cs.execute();
            JOptionPane.showMessageDialog(null, "se inserto correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "la receta ya existe");
        }
    }
}
