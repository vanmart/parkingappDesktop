package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.Formulario_RegistroParqueadero;
import vistas.Formulario_RegistroTarifas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 
 */
public class TipoVehiculo {
    int id;
    String nombre;
    int id_parqueadero;

    
     public void crearTipoVehiculo(int idParqueadero, String nombre) {
        
        this.id_parqueadero = idParqueadero;
        this.nombre=nombre;
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        String sql;
        sql = "INSERT INTO `tipo_vehiculo`( `nombre`,`parqueadero_idparqueadero`) VALUES (?,?)";
        try {
            PreparedStatement pst = reg.prepareStatement(sql);
            pst.setString(1, this.nombre);
            pst.setInt(2, this.id_parqueadero);
            int n = pst.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Tipo de vehiculo guardado con exito ");
            }
            pst.close();
            reg.close();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_RegistroTarifas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getId() {
        LinkedList<TipoVehiculo> listaTipoVehiculos=new LinkedList<TipoVehiculo>();
      try
      {
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        Statement st = reg.createStatement();
         ResultSet rs = st.executeQuery("select * from tipo_vehiculo where nombre ='" + nombre + "'" );
         while (rs.next())
         {
            TipoVehiculo parqueadero = new TipoVehiculo();
            parqueadero.setId(rs.getInt("idtipo_vehiculo"));
            
            listaTipoVehiculos.add(parqueadero);
         }
         rs.close();
         st.close();
         reg.close();
         
         
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      
       
      
      return listaTipoVehiculos.getLast().getId();
              
             
    }
        
    

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_parqueadero() {
        return id_parqueadero;
    }

    public void setId_parqueadero(int id_parqueadero) {
        this.id_parqueadero = id_parqueadero;
    }
    
    
}
