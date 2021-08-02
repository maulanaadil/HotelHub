
package laporan;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import database.Config;
import form.JTextFieldHintUI;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class LaporanHarian extends javax.swing.JInternalFrame {

    private String hintCari;
    
    public LaporanHarian() {
        hintCari = "Silahkan Masukan Data yang ingin dicari..";
        
        initComponents();
        showDataLaporan();
        showHint();
        resetColor(btn_export);
    }
    
    private void setColor(JPanel panel) {
        panel.setBackground(new Color(179, 201, 201));
    }
    
    private void resetColor(JPanel panel) {
        panel.setBackground(new Color(192,212,212));
    }
    
    private void showHint() {
        tf_cariLaporan.setUI(new JTextFieldHintUI(hintCari, Color.GRAY));
    }
    
    
    public void showDataLaporan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Tanggal");
        model.addColumn("Dibayar");
        model.addColumn("Check In");
        model.addColumn("Check Out");
        model.addColumn("Tipe Kamar");
        
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "SELECT" +
                        " tamu.nama AS nama_tamu," +
                        " pembayaran.tanggal AS tanggal_pembayaran," +
                        " pembayaran.total_harga AS total_harga," +
                        " reservasi.check_in AS check_in," +
                        " reservasi.check_out AS check_out," +
                        " room.tipe_room AS tipe_kamar" +
                        " FROM tamu" +
                        " JOIN reservasi ON reservasi.id_tamu=tamu.id_tamu" +
                        " JOIN room ON room.id_room=reservasi.id_room" +
                        " JOIN pembayaran ON pembayaran.id_pembayaran=reservasi.id_pembayaran";
            
            ResultSet res = state.executeQuery(sql);         
            while (res.next()) {
                model.addRow(new Object [] {
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6)
                });
                tb_laporan.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
     }
    
    public void cariDataLaporan() {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Nama");
        model.addColumn("Tanggal");
        model.addColumn("Dibayar");
        model.addColumn("Check In");
        model.addColumn("Check Out");
        model.addColumn("Tipe Kamar");
        
        
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "SELECT" +
                        " tamu.nama AS nama_tamu," +
                        " pembayaran.tanggal AS tanggal_pembayaran," +
                        " pembayaran.total_harga AS total_harga," +
                        " reservasi.check_in AS check_in," +
                        " reservasi.check_out AS check_out," +
                        " room.tipe_room AS tipe_kamar" +
                        " FROM tamu" +
                        " JOIN reservasi ON reservasi.id_tamu=tamu.id_tamu" +
                        " JOIN room ON room.id_room=reservasi.id_room" +
                        " JOIN pembayaran ON pembayaran.id_pembayaran=reservasi.id_pembayaran" +
                        " WHERE pembayaran.tanggal LIKE '%"+ tf_cariLaporan.getText() +"%'";
            
            ResultSet res = state.executeQuery(sql);
            
            while (res.next()) {
                
                model.addRow(new Object [] {
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6)
                });
                tb_laporan.setModel(model);
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
        btn_export = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_data_laporan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_laporan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        tf_cariLaporan = new javax.swing.JTextField();
        btn_refresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(220, 228, 228));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_panel.setBackground(new java.awt.Color(192, 212, 212));

        jLabel1.setFont(new java.awt.Font("Quicksand SemiBold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Laporan");

        jLabel2.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Interface Guidelanes");

        jLabel7.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(230, 247, 248));
        jLabel7.setText("Export");

        btn_export.setBackground(new java.awt.Color(192, 212, 212));
        btn_export.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exportMouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf_white.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Quicksand SemiBold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Export to PDF");

        javax.swing.GroupLayout btn_exportLayout = new javax.swing.GroupLayout(btn_export);
        btn_export.setLayout(btn_exportLayout);
        btn_exportLayout.setHorizontalGroup(
            btn_exportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_exportLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        btn_exportLayout.setVerticalGroup(
            btn_exportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_exportLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(btn_exportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(btn_export, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );

        getContentPane().add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 200, 670));

        panel_data_laporan.setBackground(new java.awt.Color(220, 228, 228));

        tb_laporan.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        tb_laporan.setModel(new javax.swing.table.DefaultTableModel(
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
                "Nama", "Tanggal", "Total Harga", "CheckIn", "CheckOut", "Tipe Kamar"
            }
        ));
        tb_laporan.setGridColor(new java.awt.Color(255, 255, 255));
        tb_laporan.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tb_laporan);

        jPanel1.setBackground(new java.awt.Color(220, 228, 228));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Quicksand SemiBold", 0, 36)); // NOI18N
        jLabel15.setText("Laporan");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Quicksand Light", 1, 18)); // NOI18N
        jLabel16.setText("Interface Guidlanes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(252, 252, 252))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        jLabel18.setText("Masukan Tanggal:");

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_refresh.setText("refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_data_laporanLayout = new javax.swing.GroupLayout(panel_data_laporan);
        panel_data_laporan.setLayout(panel_data_laporanLayout);
        panel_data_laporanLayout.setHorizontalGroup(
            panel_data_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_data_laporanLayout.createSequentialGroup()
                .addGroup(panel_data_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_data_laporanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(panel_data_laporanLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(panel_data_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(panel_data_laporanLayout.createSequentialGroup()
                                .addComponent(tf_cariLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_refresh)))
                        .addGap(0, 108, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_data_laporanLayout.setVerticalGroup(
            panel_data_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_data_laporanLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addGap(9, 9, 9)
                .addGroup(panel_data_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cari)
                    .addComponent(tf_cariLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        getContentPane().add(panel_data_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exportMouseClicked
        // TODO add your handling code here:
        setColor(btn_export);
        String path="";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
        
        Document doc = new Document();
        Paragraph title = new Paragraph("                                                           Laporan Harian HotelHub");
        
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "LaporanHarian.pdf"));
            
            doc.open();
            PdfPTable tabel = new PdfPTable(6);
            doc.add(title);
            doc.add(new Paragraph(" "));
            
            // Adding Header
            tabel.addCell("Nama");
            tabel.addCell("Tanggal");
            tabel.addCell("Dibayar");
            tabel.addCell("Check In");
            tabel.addCell("Check Out");
            tabel.addCell("Tipe Kamar");
            
            for (int i = 0; i < tb_laporan.getRowCount(); i++){
                
                String nama = tb_laporan.getValueAt(i, 0).toString();
                String tanggal = tb_laporan.getValueAt(i, 1).toString();
                String diBayar = tb_laporan.getValueAt(i, 2).toString();
                String checkIn = tb_laporan.getValueAt(i, 3).toString();
                String checkOut = tb_laporan.getValueAt(i, 4).toString();
                String tipeKamar = tb_laporan.getValueAt(i, 5).toString(); 
                
                
                tabel.addCell(nama);
                tabel.addCell(tanggal);
                tabel.addCell(diBayar);
                tabel.addCell(checkIn);
                tabel.addCell(checkOut);
                tabel.addCell(tipeKamar);
            }
            doc.add(tabel);
            JOptionPane.showMessageDialog(null, "File Has Been Downloaded", "ALERT MESSAGE", JOptionPane.WARNING_MESSAGE);
            
        } catch (FileNotFoundException | DocumentException e) {
            Logger.getLogger(LaporanHarian.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
        doc.close();
    }//GEN-LAST:event_btn_exportMouseClicked

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        cariDataLaporan();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        showDataLaporan();
        tf_cariLaporan.setText("");
       
    }//GEN-LAST:event_btn_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JPanel btn_export;
    private javax.swing.JButton btn_refresh;
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
    private javax.swing.JPanel panel_data_laporan;
    private javax.swing.JPanel side_panel;
    private javax.swing.JTable tb_laporan;
    private javax.swing.JTextField tf_cariLaporan;
    // End of variables declaration//GEN-END:variables
}
