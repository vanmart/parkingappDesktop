/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.event.ListDataListener;
import modelo.Conectar;
import modelo.Parqueadero;
import modelo.Tarifa;
import modelo.TipoVehiculo;
import modelo.Usuario;

/**
 *
 * @author JP
 */
public class Formulario_RegistroTarifas extends javax.swing.JFrame {
Usuario admin;
int idTipoVehiculo;
TipoVehiculo tV;
    /**
     * Creates new form Formulario_RegistroTarifas
     */
    public Formulario_RegistroTarifas() {
        initComponents();
        this.setTitle("Registro de tarifas");
        URL url=getClass().getResource("/ASSETS/bigIcon.png");
        ImageIcon ima=new ImageIcon(url);
        setIconImage(ima.getImage());
        
       consultarTiposDeVehiculos();
       
//      CAMBIAR MODELO DE UN JCOMBOBOX 
        
//        DefaultComboBoxModel cmd=new DefaultComboBoxModel(); ;
//        cmd.addElement("");
//        jComboBox1.setModel(cmd);
    }
    
    public void actualizarComboBox(String tipoVehiculo){
        jCB_tipoVehiculo.setSelectedItem(tipoVehiculo);
    }
    public void recibirAdmin(Usuario admin){
        this.admin=admin;
    }
public void consultarTiposDeVehiculos()
{
     Conectar con = new Conectar();
     try{
            Parqueadero p = new Parqueadero();
            int idParqueadero = p.GetIdParquedero();
            Connection reg = con.conexion();
            Statement st = reg.createStatement();
            //ResultSet rs = st.executeQuery("select * from usuario where email like .com");
            ResultSet rs = st.executeQuery("select * from tipo_vehiculo where parqueadero_idparqueadero = "+idParqueadero+" ");
            DefaultComboBoxModel cmd=new DefaultComboBoxModel();
            cmd.addElement("TIPO VEHICULO");
            while (rs.next()) 
            {
                
                cmd.addElement(rs.getString("nombre"));
                jCB_tipoVehiculo.setModel(cmd);
                idTipoVehiculo = rs.getInt("idtipo_vehiculo");
                
            }
            
            rs.close();
            st.close();
            reg.close();
     }catch(Exception e) {
            e.printStackTrace();
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jCB_tipoVehiculo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCB_tipoDeCobro = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTF_costo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Crear tipo vehiculo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCB_tipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        jCB_tipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_tipoVehiculoActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione o cree el tipo de vehiculo:");

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione Tipo de Cobro:");

        jCB_tipoDeCobro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione tipo de Cobro", "hora", "dia", "semana", "quincenal", "mes", "anual" }));
        jCB_tipoDeCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_tipoDeCobroActionPerformed(evt);
            }
        });

        jLabel4.setText("Costo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(63, 63, 63)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(155, 155, 155)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jCB_tipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jCB_tipoDeCobro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jTF_costo)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCB_tipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCB_tipoDeCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTF_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCB_tipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_tipoVehiculoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jCB_tipoVehiculoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RegistroTipoVechiculo registroTV=new RegistroTipoVechiculo();
        registroTV.setVisible(true);
        setVisible(false);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCB_tipoDeCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_tipoDeCobroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCB_tipoDeCobroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        long segundos = 0;
        Parqueadero par= new Parqueadero();
        Tarifa t = new Tarifa();
        segundos = TipodeCobroEnSegundos(segundos, par);
                
        float costo = Float.parseFloat(jTF_costo.getText());
              
        t.crearTarifa(par.GetIdParquedero(), segundos,idTipoVehiculo,costo);
        
        
        System.out.println(segundos);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Formulario_Admin form_A = new Formulario_Admin();
        form_A.RecibirUsuario(admin);
        form_A.setVisible(true);
        dispose();
               
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public long TipodeCobroEnSegundos(long segundos, Parqueadero par)
{
    if(jCB_tipoDeCobro.getSelectedItem().equals("hora"))
        {
            segundos=par.getHora();
            
            
        }else if(jCB_tipoDeCobro.getSelectedItem().equals("dia"))
        {
            segundos=par.getDia();
            
        }else if(jCB_tipoDeCobro.getSelectedItem().equals("semana"))
        {
            segundos=par.getSemana();
            
        }
    return segundos;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario_RegistroTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_RegistroTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_RegistroTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_RegistroTarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_RegistroTarifas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jCB_tipoDeCobro;
    private javax.swing.JComboBox jCB_tipoVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTF_costo;
    // End of variables declaration//GEN-END:variables
}
