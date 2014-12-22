package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.Formulario_RegistroParqueadero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Myrian Chica
 */
public class Parqueadero {

    int id;
    String nombre;
    String direccion;
    int telefono;
    String email;
    TipoVehiculo[] Tipo_Vehiculo;
    Tarifa[] Servicio;
    Ticket[] tickets;
    Usuario[] usuario;
    long minutos=60;
    long hora = 3600;
    long dia = 86400;
    long semana = 604800;
    long mes = 2592000;
    long ano = 31104000;
    

    public Parqueadero() {
    }

    public long getMinutos() {
        return minutos;
    }

    public void setMinutos(long minutos) {
        this.minutos = minutos;
    }

    public long getHora() {
        return hora;
    }

    public void setHora(long hora) {
        this.hora = hora;
    }

    public long getDia() {
        return dia;
    }

    public void setDia(long dia) {
        this.dia = dia;
    }

    public long getSemana() {
        return semana;
    }

    public void setSemana(long semana) {
        this.semana = semana;
    }

    public long getMes() {
        return mes;
    }

    public void setMes(long mes) {
        this.mes = mes;
    }

    public long getAno() {
        return ano;
    }

    public void setAno(long ano) {
        this.ano = ano;
    }

    public Parqueadero( String nombre, String direccion, int telefono, String email, TipoVehiculo[] Tipo_Vehiculo, Tarifa[] Servicio, Ticket[] tickets, Usuario[] usuario) {
        
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.Tipo_Vehiculo = Tipo_Vehiculo;
        this.Servicio = Servicio;
        this.tickets = tickets;
        this.usuario = usuario;
       

    }

    public Parqueadero getParqueadero(int id){
      Parqueadero p = new Parqueadero();
      try
      {
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        Statement st = reg.createStatement();
        //ResultSet rs = st.executeQuery("select * from usuario where email like .com");
        ResultSet rs = st.executeQuery("select * from parqueadero where idparqueadero ='"+id+"'");
        while (rs.next())
         {
             p.setNombre(rs.getString("nombre"));
             p.setDireccion(rs.getString("direccion"));
             p.setTelefono(rs.getInt("telefono"));
             p.setEmail(rs.getString("email"));
             System.out.println("obtenido parqueadero:"+rs.getString("nombre"));
             System.out.println("\n"+rs.getString("direccion"));
             System.out.println("\n"+rs.getString("telefono"));
             System.out.println("\n"+rs.getString("email"));
           
         }
         rs.close();
         st.close();
         reg.close();
        //return p;  
         
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      
     
      //return false;
        
      return p;
    }
    
    public int GetIdParquedero()
    {
       LinkedList<Parqueadero> listaParqueaderos=new LinkedList<Parqueadero>();
      try
      {
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        Statement st = reg.createStatement();
         ResultSet rs = st.executeQuery("select * from parqueadero" );
         while (rs.next())
         {
            Parqueadero parqueadero = new Parqueadero();
            parqueadero.setId(rs.getInt("idparqueadero"));
            parqueadero.setNombre(rs.getString("nombre"));
            parqueadero.setDireccion(rs.getString("direccion"));
            parqueadero.setTelefono(rs.getInt("telefono"));
            parqueadero.setEmail(rs.getString("email"));
            listaParqueaderos.add(parqueadero);
         }
         rs.close();
         st.close();
         reg.close();
         
         
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      
       
      
      return listaParqueaderos.getLast().getId();
              
             
    }

    
    

 public boolean LoginUsuario(String email, String password)
 {
     LinkedList<Usuario> listaUsuarios=new LinkedList<Usuario>();
      try
      {
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        Statement st = reg.createStatement();
        //ResultSet rs = st.executeQuery("select * from usuario where email like .com");
        ResultSet rs = st.executeQuery("select * from usuario where email ='"+email+"' && contraseña = '"+password+"'");
        while (rs.next())
         {
             
             System.out.println("LOGUEADO");
         }
         rs.close();
         st.close();
         reg.close();
        return true;  
         
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      
     
      return false;
 }    

 public void registrarParqueadero() {
        Conectar con = new Conectar();
        Connection reg = con.conexion();
      
        String sql;
        
        

        sql = "INSERT INTO `parqueadero`( `nombre`, `direccion`, `telefono`, `email`) VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = reg.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setInt(3, telefono);
            pst.setString(4, email);
            int n = pst.executeUpdate();
          
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registrado con exito ");
            }
            pst.close();
            reg.close();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario_RegistroParqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getId() {
        return id;
    }
    
    
    
    public Usuario getPropietario(){
        Usuario u = new Usuario();
        LinkedList<Usuario> listaPropietarios = new LinkedList<Usuario>();
        
      try
      {
        Conectar con = new Conectar();
        Connection reg = con.conexion();
        Statement st = reg.createStatement();
         ResultSet rs = st.executeQuery("select * from usuario where role='Propietario'" );
         while (rs.next())
         {
            u.setId(rs.getInt("idusuario"));
            u.setNombre(rs.getString("nombre"));
            u.setApellido(rs.getString("apellido"));
            u.setCedula(rs.getInt("cedula"));
            u.setTelefono(rs.getInt("telefono"));
            u.setRole(rs.getString("role"));
            u.setEmail(rs.getString("email"));
            
            listaPropietarios.add(u);
         }
         rs.close();
         st.close();
         reg.close();
         
         
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      
       
      
      return listaPropietarios.getLast();
        
        
    }
// public void ObtenerID(){
//     String sql;
//     sql=
// }
    public void setId(int id) {    
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoVehiculo[] getTipo_Vehiculo() {
        return Tipo_Vehiculo;
    }

    public void setTipo_Vehiculo(TipoVehiculo[] Tipo_Vehiculo) {
        this.Tipo_Vehiculo = Tipo_Vehiculo;
    }

    public Tarifa[] getServicio() {
        return Servicio;
    }

    public void setServicio(Tarifa[] Servicio) {
        this.Servicio = Servicio;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public Usuario[] getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario[] usuario) {
        this.usuario = usuario;
    }

}
