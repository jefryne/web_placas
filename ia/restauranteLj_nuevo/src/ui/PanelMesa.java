/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import clases.DataBase;
import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author INSTRUCTOR
 */
public class PanelMesa extends javax.swing.JPanel {

    DataBase data_base;
    Mesas mesas;
    JLabel arreglo_mesas[];
    public PanelMesa(DataBase data_base,Mesas mesas) {
        this.mesas = mesas;
        this.data_base = data_base;
        arreglo_mesas = new JLabel[8];
        initComponents();
        alternInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l_mesa4 = new javax.swing.JLabel();
        l_mesa2 = new javax.swing.JLabel();
        l_mesa3 = new javax.swing.JLabel();
        l_mesa6 = new javax.swing.JLabel();
        l_mesa1 = new javax.swing.JLabel();
        l_mesa8 = new javax.swing.JLabel();
        l_mesa5 = new javax.swing.JLabel();
        l_mesa7 = new javax.swing.JLabel();

        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(242, 255, 255));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setOpaque(false);

        l_mesa4.setBackground(new java.awt.Color(204, 255, 204));
        l_mesa4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l_mesa4.setOpaque(true);
        l_mesa4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_mesa4reservarMesa(evt);
            }
        });

        l_mesa2.setBackground(new java.awt.Color(204, 255, 204));
        l_mesa2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l_mesa2.setOpaque(true);
        l_mesa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_mesa2reservarMesa(evt);
            }
        });

        l_mesa3.setBackground(new java.awt.Color(204, 255, 204));
        l_mesa3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l_mesa3.setOpaque(true);
        l_mesa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_mesa3reservarMesa(evt);
            }
        });

        l_mesa6.setBackground(new java.awt.Color(204, 255, 204));
        l_mesa6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l_mesa6.setOpaque(true);
        l_mesa6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_mesa6reservarMesa(evt);
            }
        });

        l_mesa1.setBackground(new java.awt.Color(204, 255, 204));
        l_mesa1.setAlignmentX(0.5F);
        l_mesa1.setOpaque(true);
        l_mesa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_mesa1reservarMesa(evt);
            }
        });

        l_mesa8.setBackground(new java.awt.Color(204, 255, 204));
        l_mesa8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l_mesa8.setOpaque(true);
        l_mesa8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_mesa8reservarMesa(evt);
            }
        });

        l_mesa5.setBackground(new java.awt.Color(204, 255, 204));
        l_mesa5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l_mesa5.setOpaque(true);
        l_mesa5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_mesa5reservarMesa(evt);
            }
        });

        l_mesa7.setBackground(new java.awt.Color(204, 255, 204));
        l_mesa7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l_mesa7.setOpaque(true);
        l_mesa7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_mesa7reservarMesa(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_mesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_mesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(l_mesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(l_mesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(l_mesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(l_mesa7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_mesa4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_mesa8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_mesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_mesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_mesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_mesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_mesa8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_mesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_mesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_mesa7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void l_mesa4reservarMesa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_mesa4reservarMesa
        ResultSet respuesta =  data_base.buscarMesa(4);
        if(respuesta != null){
            try {
                String estado = respuesta.getString("estado");
                if(estado.equals("desocupada")){
                    mesas.removerPanel(4);
                }else{
                    ResultSet respuesta_factura = data_base.buscarFacturaDeMesa( 4);
                    String id_factura = respuesta_factura.getString("id_factura");
                    System.out.println(id_factura);
                    mesas.removerPanelPedido(Integer.parseInt(id_factura) );
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_l_mesa4reservarMesa

    private void l_mesa2reservarMesa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_mesa2reservarMesa
        ResultSet respuesta =  data_base.buscarMesa(2);
        if(respuesta != null){
            try {
                String estado = respuesta.getString("estado");
                if(estado.equals("desocupada")){
                    mesas.removerPanel(2);
                }else{
                    ResultSet respuesta_factura = data_base.buscarFacturaDeMesa( 2);
                    String id_factura = respuesta_factura.getString("id_factura");
                    System.out.println(id_factura);
                    mesas.removerPanelPedido(Integer.parseInt(id_factura) );
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
    }//GEN-LAST:event_l_mesa2reservarMesa

    private void l_mesa3reservarMesa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_mesa3reservarMesa
        ResultSet respuesta =  data_base.buscarMesa(3);
        if(respuesta != null){
            try {
                String estado = respuesta.getString("estado");
                if(estado.equals("desocupada")){
                    mesas.removerPanel(3);
                }else{
                    ResultSet respuesta_factura = data_base.buscarFacturaDeMesa( 3);
                    String id_factura = respuesta_factura.getString("id_factura");
                    System.out.println(id_factura);
                    mesas.removerPanelPedido(Integer.parseInt(id_factura) );
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_l_mesa3reservarMesa

    private void l_mesa6reservarMesa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_mesa6reservarMesa
        ResultSet respuesta =  data_base.buscarMesa(6);
        if(respuesta != null){
            try {
                String estado = respuesta.getString("estado");
                if(estado.equals("desocupada")){
                    mesas.removerPanel(6);
                }else{
                    ResultSet respuesta_factura = data_base.buscarFacturaDeMesa( 6);
                    String id_factura = respuesta_factura.getString("id_factura");
                    System.out.println(id_factura);
                    mesas.removerPanelPedido(Integer.parseInt(id_factura) );
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_l_mesa6reservarMesa

    private void l_mesa1reservarMesa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_mesa1reservarMesa
        ResultSet respuesta =  data_base.buscarMesa(1);
        if(respuesta != null){
            try {
                String estado = respuesta.getString("estado");
                if(estado.equals("desocupada")){
                    mesas.removerPanel(1);
                }else{
                    ResultSet respuesta_factura = data_base.buscarFacturaDeMesa( 1);
                    String id_factura = respuesta_factura.getString("id_factura");
                    System.out.println(id_factura);
                    mesas.removerPanelPedido(Integer.parseInt(id_factura) );
                }
                revalidate();
                mesas.repaint();
                mesas.revalidate();
            } catch (SQLException ex) {
                Logger.getLogger(PanelMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_l_mesa1reservarMesa

    private void l_mesa8reservarMesa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_mesa8reservarMesa
        ResultSet respuesta =  data_base.buscarMesa(8);
        if(respuesta != null){
            try {
                String estado = respuesta.getString("estado");
                if(estado.equals("desocupada")){
                    mesas.removerPanel(8);
                }else{
                    ResultSet respuesta_factura = data_base.buscarFacturaDeMesa( 8);
                    String id_factura = respuesta_factura.getString("id_factura");
                    System.out.println(id_factura);
                    mesas.removerPanelPedido(Integer.parseInt(id_factura) );
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_l_mesa8reservarMesa

    private void l_mesa5reservarMesa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_mesa5reservarMesa
        ResultSet respuesta =  data_base.buscarMesa(5);
        if(respuesta != null){
            try {
                String estado = respuesta.getString("estado");
                if(estado.equals("desocupada")){
                    mesas.removerPanel(5);
                }else{
                    ResultSet respuesta_factura = data_base.buscarFacturaDeMesa( 5);
                    String id_factura = respuesta_factura.getString("id_factura");
                    mesas.removerPanelPedido(Integer.parseInt(id_factura) );
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_l_mesa5reservarMesa

    private void l_mesa7reservarMesa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_mesa7reservarMesa
        ResultSet respuesta =  data_base.buscarMesa(7);
        if(respuesta != null){
            try {
                String estado = respuesta.getString("estado");
                if(estado.equals("desocupada")){
                    mesas.removerPanel(7);
                }else{
                    ResultSet respuesta_factura = data_base.buscarFacturaDeMesa( 7);
                    String id_factura = respuesta_factura.getString("id_factura");
                    System.out.println(id_factura);
                    mesas.removerPanelPedido(Integer.parseInt(id_factura) );
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  
    }//GEN-LAST:event_l_mesa7reservarMesa
    
    public void alternInitComponents(){
        arreglo_mesas[0] =l_mesa1;
        arreglo_mesas[1] =l_mesa2;
        arreglo_mesas[2] =l_mesa3;
        arreglo_mesas[3] =l_mesa4;
        arreglo_mesas[4] =l_mesa5;
        arreglo_mesas[5] =l_mesa6;
        arreglo_mesas[6] =l_mesa7;
        arreglo_mesas[7] =l_mesa8;
        Image mesa_disponible = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/mesa_disponible.png"));
        mesa_disponible = mesa_disponible.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        
        arreglo_mesas[0].setIcon(new ImageIcon(mesa_disponible));
        arreglo_mesas[1].setIcon(new ImageIcon(mesa_disponible));
        arreglo_mesas[2].setIcon(new ImageIcon(mesa_disponible));
        arreglo_mesas[3].setIcon(new ImageIcon(mesa_disponible));
        arreglo_mesas[4].setIcon(new ImageIcon(mesa_disponible));
        arreglo_mesas[5].setIcon(new ImageIcon(mesa_disponible));
        arreglo_mesas[6].setIcon(new ImageIcon(mesa_disponible));
        arreglo_mesas[7].setIcon(new ImageIcon(mesa_disponible));
        Border emptyBorder = new EmptyBorder(0, 20, 0, 0);
        
        l_mesa1.setBorder(emptyBorder);
        l_mesa2.setBorder(emptyBorder);
        l_mesa3.setBorder(emptyBorder);
        l_mesa4.setBorder(emptyBorder);
        l_mesa5.setBorder(emptyBorder);
        l_mesa6.setBorder(emptyBorder);
        l_mesa7.setBorder(emptyBorder);
        l_mesa8.setBorder(emptyBorder);
        cargaMesas();
        
        this.setVisible(true);
        this.revalidate();
    }
    public void cargaMesas(){
        ResultSet listado = this.data_base.consultaGeneral("mesa");
        if(listado != null){
            try {
                int contador_mesa =0;
                do{
                    String estado_mesa = listado.getString("estado");
                    if(!estado_mesa.equals("desocupada")){
                        arreglo_mesas[contador_mesa].setBackground(Color.red);
                    }
                    contador_mesa++;
                }while(listado.next());
            } catch (SQLException ex) {
                System.out.println("Error al extraer datos: "+ex.getMessage());
            }
        }else{
            System.out.println("LISTA VACIA");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_mesa1;
    private javax.swing.JLabel l_mesa2;
    private javax.swing.JLabel l_mesa3;
    private javax.swing.JLabel l_mesa4;
    private javax.swing.JLabel l_mesa5;
    private javax.swing.JLabel l_mesa6;
    private javax.swing.JLabel l_mesa7;
    private javax.swing.JLabel l_mesa8;
    // End of variables declaration//GEN-END:variables
}
