
package service;

import database.Config;
import form.JTextFieldHintUI;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

public class Pembayaran extends javax.swing.JInternalFrame {
    
    public Pembayaran() {
        initComponents();
        setColor(btn_pembayaran);
        showHint();
        showDataPembayaran();
        tf_temp_data.setVisible(false);
    }
    
    void setColor(JPanel panel) {
        panel.setBackground(new Color(179, 201, 201));
    }
    
     public void showHint() {
        tf_caripembayaran.setUI(new JTextFieldHintUI("Silahkan Masukan Data yang ingin dicari..", Color.GRAY));
    }
     
     public void showDataPembayaran() {
         DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID Pembayaran");
        model.addColumn("Total Harga");
        model.addColumn("Tanggal");
        model.addColumn("Dibayar Oleh");
        
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "SELECT id_pembayaran, total_harga, tanggal, tamu.nama AS 'dibayar' FROM pembayaran INNER JOIN tamu ON pembayaran.id_tamu = tamu.id_tamu ORDER BY id_pembayaran ASC";
            
            ResultSet res = state.executeQuery(sql);
            
                    
            while (res.next()) {
                
                model.addRow(new Object [] {
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
                });
                tb_pembayaran.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
     }
     
     public void cariData() {
        DefaultTableModel model = new DefaultTableModel();
        String cari = tf_caripembayaran.getText();
        
        model.addColumn("ID Pembayaran");
        model.addColumn("Total Harga");
        model.addColumn("Tanggal");
        model.addColumn("Dibayar Oleh");
        
        int lengthRow = model.getRowCount();
        for (int n=0; n<lengthRow; n++) {
            model.removeRow(n);
        }
        
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "SELECT id_pembayaran, total_harga, tanggal, tamu.nama AS 'dibayar' FROM pembayaran INNER JOIN tamu ON pembayaran.id_tamu = tamu.id_tamu WHERE tamu.nama LIKE '%"+ tf_caripembayaran.getText() +"%'";
            
            ResultSet res = state.executeQuery(sql);
            
                    
            while (res.next()) {
                model.addRow(new Object [] {
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
                });
                tb_pembayaran.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        } 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_pembayaran = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_data_pembayaran = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_pembayaran = new javax.swing.JTable();
        tf_caripembayaran = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tf_temp_data = new javax.swing.JTextField();

        setBackground(new java.awt.Color(220, 228, 228));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_panel.setBackground(new java.awt.Color(192, 212, 212));

        jLabel1.setFont(new java.awt.Font("Quicksand SemiBold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pembayaran");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Interface Guidelanes");

        jLabel7.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(230, 247, 248));
        jLabel7.setText("Data ");

        btn_pembayaran.setBackground(new java.awt.Color(192, 212, 212));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/payment_white.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Quicksand SemiBold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Data Pembayaran");

        javax.swing.GroupLayout btn_pembayaranLayout = new javax.swing.GroupLayout(btn_pembayaran);
        btn_pembayaran.setLayout(btn_pembayaranLayout);
        btn_pembayaranLayout.setHorizontalGroup(
            btn_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_pembayaranLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        btn_pembayaranLayout.setVerticalGroup(
            btn_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_pembayaranLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(btn_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_pembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(53, 53, 53)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(411, Short.MAX_VALUE))
        );

        getContentPane().add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 200, 640));

        panel_data_pembayaran.setBackground(new java.awt.Color(220, 228, 228));

        tb_pembayaran.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        tb_pembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Pembayaran", "Total Harga", "Tanggal", "Dibayar Oleh"
            }
        ));
        tb_pembayaran.setGridColor(new java.awt.Color(255, 255, 255));
        tb_pembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pembayaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_pembayaran);

        tf_caripembayaran.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_caripembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_caripembayaranKeyPressed(evt);
            }
        });

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(220, 228, 228));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Quicksand SemiBold", 0, 36)); // NOI18N
        jLabel15.setText("Data Pembayaran");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Quicksand Light", 1, 18)); // NOI18N
        jLabel16.setText("Interface Guidlanes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(157, 157, 157))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        jLabel18.setText("Ketik Nama Pemesan untuk Mencari Data Pembayaran:");

        javax.swing.GroupLayout panel_data_pembayaranLayout = new javax.swing.GroupLayout(panel_data_pembayaran);
        panel_data_pembayaran.setLayout(panel_data_pembayaranLayout);
        panel_data_pembayaranLayout.setHorizontalGroup(
            panel_data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_data_pembayaranLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(panel_data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(panel_data_pembayaranLayout.createSequentialGroup()
                        .addComponent(tf_caripembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_cari)))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(panel_data_pembayaranLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_data_pembayaranLayout.createSequentialGroup()
                        .addComponent(tf_temp_data, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_hapus)
                        .addGap(57, 57, 57))
                    .addGroup(panel_data_pembayaranLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        panel_data_pembayaranLayout.setVerticalGroup(
            panel_data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_data_pembayaranLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_caripembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_data_pembayaranLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_hapus))
                    .addGroup(panel_data_pembayaranLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(tf_temp_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(229, Short.MAX_VALUE))
        );

        getContentPane().add(panel_data_pembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel1MousePressed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus Data?");
        if (opsi == JOptionPane.YES_OPTION)  {
            try {
                String sql = "DELETE FROM pembayaran WHERE id_pembayaran='"+ tf_temp_data.getText() +"'";
                Connection conn = (Connection)Config.configDB();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(this, "Hapus Data Berhasil...");
                showDataPembayaran();
            }
            catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak jadi dihapus");
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        cariData();

    }//GEN-LAST:event_btn_cariActionPerformed

    private void tf_caripembayaranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_caripembayaranKeyPressed
        // TODO add your handling code here:
        cariData();
        if(tf_caripembayaran.getText().trim().isEmpty()) {
            showDataPembayaran();
        }

    }//GEN-LAST:event_tf_caripembayaranKeyPressed

    private void tb_pembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pembayaranMouseClicked
        // TODO add your handling code here:
        int baris = tb_pembayaran.rowAtPoint(evt.getPoint());

        String id = tb_pembayaran.getValueAt(baris, 0).toString();
        tf_temp_data.setText(id);
        tf_temp_data.setEditable(false);
        tf_temp_data.setVisible(false);
    }//GEN-LAST:event_tb_pembayaranMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JPanel btn_pembayaran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_data_pembayaran;
    private javax.swing.JPanel side_panel;
    private javax.swing.JTable tb_pembayaran;
    private javax.swing.JTextField tf_caripembayaran;
    private javax.swing.JTextField tf_temp_data;
    // End of variables declaration//GEN-END:variables
}
