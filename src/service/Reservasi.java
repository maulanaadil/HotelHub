
package service;

import java.awt.Color;
import javax.swing.JPanel;

public class Reservasi extends javax.swing.JInternalFrame {

   
    public Reservasi() {
        initComponents();
        setColor(btn_reservasi);
    }
    
     void setColor(JPanel panel) {
        panel.setBackground(new Color(179, 201, 201));
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_reservasi = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_data_tamu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_reservasi = new javax.swing.JTable();
        tf_cariDataReservasi = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        tv_rincianDataTamu = new javax.swing.JLabel();
        tv_rincianIdTamu = new javax.swing.JLabel();
        tf_rincianIdTamu = new javax.swing.JTextField();
        tv_rincianNama = new javax.swing.JLabel();
        tf_rincianNama = new javax.swing.JTextField();
        tv_rincianAlamat = new javax.swing.JLabel();
        tf_rincianAlamat = new javax.swing.JTextField();
        tv_rincianNoTelepon = new javax.swing.JLabel();
        tf_rincianNoTelepon = new javax.swing.JTextField();

        setBackground(new java.awt.Color(220, 228, 228));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_panel.setBackground(new java.awt.Color(192, 212, 212));

        jLabel1.setFont(new java.awt.Font("Quicksand SemiBold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reservasi");
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

        btn_reservasi.setBackground(new java.awt.Color(192, 212, 212));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reservation_white.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Quicksand SemiBold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Data Reservasi");

        javax.swing.GroupLayout btn_reservasiLayout = new javax.swing.GroupLayout(btn_reservasi);
        btn_reservasi.setLayout(btn_reservasiLayout);
        btn_reservasiLayout.setHorizontalGroup(
            btn_reservasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_reservasiLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_reservasiLayout.setVerticalGroup(
            btn_reservasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_reservasiLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(btn_reservasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_reservasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(side_panelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7))
                    .addGroup(side_panelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(52, 52, 52)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_reservasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );

        getContentPane().add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 200, 670));

        panel_data_tamu.setBackground(new java.awt.Color(220, 228, 228));

        tb_reservasi.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        tb_reservasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Atas Nama", "Tipe Kamar", "Check In", "Check Out", "Dilayani"
            }
        ));
        tb_reservasi.setGridColor(new java.awt.Color(255, 255, 255));
        tb_reservasi.getTableHeader().setReorderingAllowed(false);
        tb_reservasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_reservasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_reservasi);
        if (tb_reservasi.getColumnModel().getColumnCount() > 0) {
            tb_reservasi.getColumnModel().getColumn(3).setResizable(false);
            tb_reservasi.getColumnModel().getColumn(5).setResizable(false);
        }

        tf_cariDataReservasi.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_cariDataReservasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_cariDataReservasiKeyPressed(evt);
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
        jLabel15.setText("Data Reservasi");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Quicksand Light", 1, 18)); // NOI18N
        jLabel16.setText("Interface Guidlanes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16))
        );

        jLabel18.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        jLabel18.setText("Ketik Nama untuk Mencari Data Reservasi:");

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        tv_rincianDataTamu.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianDataTamu.setText("Rincian Data Tamu");

        tv_rincianIdTamu.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianIdTamu.setText("ID Tamu");

        tf_rincianIdTamu.setBackground(new java.awt.Color(234, 246, 248));
        tf_rincianIdTamu.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        tv_rincianNama.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianNama.setText("Nama");

        tf_rincianNama.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_rincianNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_rincianNamaKeyPressed(evt);
            }
        });

        tv_rincianAlamat.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianAlamat.setText("Alamat");

        tf_rincianAlamat.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_rincianAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_rincianAlamatKeyPressed(evt);
            }
        });

        tv_rincianNoTelepon.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianNoTelepon.setText("No Telepon");

        tf_rincianNoTelepon.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_rincianNoTelepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_rincianNoTeleponKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panel_data_tamuLayout = new javax.swing.GroupLayout(panel_data_tamu);
        panel_data_tamu.setLayout(panel_data_tamuLayout);
        panel_data_tamuLayout.setHorizontalGroup(
            panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_data_tamuLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addComponent(tf_cariDataReservasi, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_cari)))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(panel_data_tamuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(panel_data_tamuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tv_rincianDataTamu)
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tv_rincianNama)
                            .addComponent(tv_rincianIdTamu)
                            .addComponent(tv_rincianAlamat)
                            .addComponent(tv_rincianNoTelepon))
                        .addGap(15, 15, 15)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_rincianIdTamu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rincianNama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rincianAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rincianNoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_hapus)
                .addGap(57, 57, 57))
        );
        panel_data_tamuLayout.setVerticalGroup(
            panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_data_tamuLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cariDataReservasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapus)
                            .addComponent(btn_update)))
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(tv_rincianDataTamu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tv_rincianIdTamu)
                            .addComponent(tf_rincianIdTamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tv_rincianNama)
                            .addComponent(tf_rincianNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tv_rincianAlamat)
                            .addComponent(tf_rincianAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tv_rincianNoTelepon)
                            .addComponent(tf_rincianNoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        getContentPane().add(panel_data_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MousePressed

    private void tb_reservasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_reservasiMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tb_reservasiMouseClicked

    private void tf_cariDataReservasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariDataReservasiKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tf_cariDataReservasiKeyPressed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tf_rincianNamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rincianNamaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_rincianNamaKeyPressed

    private void tf_rincianAlamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rincianAlamatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_rincianAlamatKeyPressed

    private void tf_rincianNoTeleponKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rincianNoTeleponKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tf_rincianNoTeleponKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JPanel btn_reservasi;
    private javax.swing.JButton btn_update;
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
    private javax.swing.JPanel panel_data_tamu;
    private javax.swing.JPanel side_panel;
    private javax.swing.JTable tb_reservasi;
    private javax.swing.JTextField tf_cariDataReservasi;
    private javax.swing.JTextField tf_rincianAlamat;
    private javax.swing.JTextField tf_rincianIdTamu;
    private javax.swing.JTextField tf_rincianNama;
    private javax.swing.JTextField tf_rincianNoTelepon;
    private javax.swing.JLabel tv_rincianAlamat;
    private javax.swing.JLabel tv_rincianDataTamu;
    private javax.swing.JLabel tv_rincianIdTamu;
    private javax.swing.JLabel tv_rincianNama;
    private javax.swing.JLabel tv_rincianNoTelepon;
    // End of variables declaration//GEN-END:variables
}
