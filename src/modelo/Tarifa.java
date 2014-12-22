package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.Formulario_RegistroTarifas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Myrian Chica
 */
public class Tarifa {

    float costo;
    long segundosTc;
    int id_TipoVehiculo;
    int idParqueadero;

    public void crearTarifa(int idParqueadero, long segundos ,int idTipoVehiculo, float costo) {
        
        this.idParqueadero = idParqueadero; 
        this.segundosTc = segundos;
        this.id_TipoVehiculo = idTipoVehiculo;
        this.costo = costo;
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        String sql;
        sql = "INSERT INTO `tarifa`( `segundos`, `costo`, `parqueadero_idparqueadero`, `tipo_vehiculo_idtipo_vehiculo`) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = reg.prepareStatement(sql);
            pst.setLong(1, this.segundosTc);
            pst.setFloat(2, this.costo);
            pst.setInt(3, this.idParqueadero);
            pst.setInt(4, this.id_TipoVehiculo);
            
            int n = pst.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Tarifa guardada con exito ");
            }
            pst.close();
            reg.close();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_RegistroTarifas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getId_TipoVehiculo() {
        return id_TipoVehiculo;
    }

    public void setId_TipoVehiculo(int id_TipoVehiculo) {
        this.id_TipoVehiculo = id_TipoVehiculo;
    }
    
    
}
