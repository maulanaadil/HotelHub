
package service;

import database.Config;
import form.JTextFieldHintUI;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Reservasi extends javax.swing.JInternalFrame {

   
    public Reservasi() {
        initComponents();
        setColor(btn_reservasi);
        showHint();
        showDataReservasi();
        setVisibleComponents(false);
        showIDKamar();
    }
    
    public void setVisibleComponents(Boolean b) {
        btn_hapus.setVisible(b);
        btn_update.setVisible(b);
        tv_rincianDataReservasi.setVisible(b);
        tv_rincianIdReservasi.setVisible(b);
        tv_rincianIdKamar.setVisible(b);
        tv_rincianCheckIn.setVisible(b);
        tv_rincianCheckOut.setVisible(b);
        tf_rincianIdReservasi.setVisible(b);
        cb_rincianIdKamar.setVisible(b);
        date_rincianCheckIn.setVisible(b);
        date_rincianCheckOut.setVisible(b);
        btn_hapus.setVisible(b);
        btn_update.setVisible(b);
    }
    
    public void showHint() {
        tf_cariDataReservasi.setUI(new JTextFieldHintUI("Silahkan Masukan Data yang ingin dicari..", Color.GRAY));
    }
    
     void setColor(JPanel panel) {
        panel.setBackground(new Color(179, 201, 201));
    }
     
     public void showDataReservasi() {
         DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("No");
        model.addColumn("ID Reservasi");
        model.addColumn("Atas Nama");
        model.addColumn("ID Tamu");
        model.addColumn("ID Kamar");
        model.addColumn("Tipe Kamar");
        model.addColumn("Check In");
        model.addColumn("Check Out");
        model.addColumn("Dilayani");
        
        int no=1;
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "SELECT reservasi.id_reservasi as 'IDReservasi', tamu.nama as 'AtasNama', tamu.id_tamu as 'IDTamu', room.id_room as 'IDKamar', room.tipe_room as 'TipeKamar', reservasi.check_in as 'checkIn', reservasi.check_out as 'checkOut', pegawai.nama as 'Dilayani'" +
                        " FROM reservasi" +
                        " INNER JOIN" +
                        " tamu ON reservasi.id_tamu = tamu.id_tamu" +
                        " INNER JOIN" +
                        " room ON reservasi.id_room = room.id_room" +
                        " INNER JOIN" +
                        " pegawai ON reservasi.id_pegawai = pegawai.id_pegawai";
            
            ResultSet res = state.executeQuery(sql);
            
                    
            while (res.next()) {
                
                model.addRow(new Object [] {
                    no++,
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8)
                });
                tb_reservasi.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
     }
     
     public void cariData() {
         DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("No");
        model.addColumn("ID Reservasi");
        model.addColumn("Atas Nama");
        model.addColumn("ID Tamu");
        model.addColumn("ID Kamar");
        model.addColumn("Tipe Kamar");
        model.addColumn("Check In");
        model.addColumn("Check Out");
        model.addColumn("Dilayani");
        
        int no=1;
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "SELECT reservasi.id_reservasi as 'IDReservasi', tamu.nama as 'AtasNama', tamu.id_tamu as 'IDTamu', room.id_room as 'IDKamar', room.tipe_room as 'TipeKamar', reservasi.check_in as 'checkIn', reservasi.check_out as 'checkOut', pegawai.nama as 'Dilayani'" +
                        " FROM reservasi" +
                        " INNER JOIN" +
                        " tamu ON reservasi.id_tamu = tamu.id_tamu" +
                        " INNER JOIN" +
                        " room ON reservasi.id_room = room.id_room" +
                        " INNER JOIN" +
                        " pegawai ON reservasi.id_pegawai = pegawai.id_pegawai" +
                        " WHERE tamu.nama LIKE '%"+ tf_cariDataReservasi.getText() +"%'";
            
            ResultSet res = state.executeQuery(sql);
            
                    
            while (res.next()) {
                
                model.addRow(new Object [] {
                    no++,
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8)
                });
                tb_reservasi.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
     }
     
      public void showIDKamar() {
         try {
            Connection conn = (Connection) Config.configDB();

            Statement state = conn.createStatement();
            
            String sql = "SELECT id_room FROM room WHERE status = 'kosong' ORDER BY id_room ASC";
            
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()) {
                Object[] ob = new Object[1];
                ob[0] = rs.getString("id_room");
                cb_rincianIdKamar.addItem((String) ob[0]);
            }
            rs.close();
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
      
      public void updateDataReservasi() {
          
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String checkIn = sdf.format(date_rincianCheckIn.getDate());
          String checkOut = sdf.format(date_rincianCheckOut.getDate());
        try {
            String sql = "UPDATE reservasi SET id_reservasi='" + tf_rincianIdReservasi.getText() + 
                    "',id_room='" + cb_rincianIdKamar.getSelectedItem() + 
                    "',check_in='" + checkIn + 
                    "',check_out='" + checkOut + 
                    "' WHERE id_reservasi='" + tf_rincianIdReservasi.getText() + 
                    "'";
            Connection conn = (Connection)Config.configDB();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(this, "Edit Data Berhasil");
            showDataReservasi();
            setVisibleComponents(false);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
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
        tv_rincianDataReservasi = new javax.swing.JLabel();
        tv_rincianIdReservasi = new javax.swing.JLabel();
        tf_rincianIdReservasi = new javax.swing.JTextField();
        tv_rincianIdKamar = new javax.swing.JLabel();
        tv_rincianCheckIn = new javax.swing.JLabel();
        tv_rincianCheckOut = new javax.swing.JLabel();
        date_rincianCheckIn = new com.toedter.calendar.JDateChooser();
        date_rincianCheckOut = new com.toedter.calendar.JDateChooser();
        cb_rincianIdKamar = new javax.swing.JComboBox<>();

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
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "ID Reservasi", "Atas Nama", "ID Kamar", "Tipe Kamar", "Check In", "Check Out", "ID Pegawai", "Dilayani"
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

        tv_rincianDataReservasi.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianDataReservasi.setText("Rincian Data Reservasi");

        tv_rincianIdReservasi.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianIdReservasi.setText("ID Reservasi");

        tf_rincianIdReservasi.setBackground(new java.awt.Color(234, 246, 248));
        tf_rincianIdReservasi.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_rincianIdReservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_rincianIdReservasiActionPerformed(evt);
            }
        });

        tv_rincianIdKamar.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianIdKamar.setText("ID Kamar");

        tv_rincianCheckIn.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianCheckIn.setText("Check In");

        tv_rincianCheckOut.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianCheckOut.setText("Check Out");

        date_rincianCheckIn.setDateFormatString("yyyy-MM-dd");

        date_rincianCheckOut.setDateFormatString("yyyy-MM-dd");

        cb_rincianIdKamar.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        cb_rincianIdKamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih ID Kamar" }));
        cb_rincianIdKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_rincianIdKamarActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_data_tamuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addComponent(tv_rincianDataReservasi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_hapus)
                        .addGap(57, 57, 57))
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tv_rincianIdReservasi)
                            .addComponent(tv_rincianIdKamar)
                            .addComponent(tv_rincianCheckIn)
                            .addComponent(tv_rincianCheckOut))
                        .addGap(18, 18, 18)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_rincianCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rincianIdReservasi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_rincianCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_rincianIdKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panel_data_tamuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
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
                        .addGap(30, 30, 30)
                        .addComponent(tv_rincianDataReservasi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tv_rincianIdReservasi)
                            .addComponent(tf_rincianIdReservasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapus)
                            .addComponent(btn_update))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tv_rincianIdKamar)
                    .addComponent(cb_rincianIdKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tv_rincianCheckIn)
                    .addComponent(date_rincianCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tv_rincianCheckOut)
                    .addComponent(date_rincianCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        getContentPane().add(panel_data_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MousePressed

    private void tb_reservasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_reservasiMouseClicked
        // TODO add your handling code here:
        setVisibleComponents(true);
        int baris = tb_reservasi.rowAtPoint(evt.getPoint());
        
        int idReservasi = Integer.parseInt(tb_reservasi.getValueAt(baris, 1).toString());
        tf_rincianIdReservasi.setText(String.valueOf(idReservasi));
        
        String idKamar = tb_reservasi.getValueAt(baris, 4).toString();
        cb_rincianIdKamar.getModel().setSelectedItem(idKamar);
        
        String checkIn = tb_reservasi.getValueAt(baris, 6).toString();
        String checkOut = tb_reservasi.getValueAt(baris, 7).toString();
        Date date1;  
        Date date2;  
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(checkIn);
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(checkOut);
            date_rincianCheckIn.setDate(date1);
            date_rincianCheckOut.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(Reservasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tb_reservasiMouseClicked

    private void tf_cariDataReservasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariDataReservasiKeyPressed
        // TODO add your handling code here:
        cariData();
        if (tf_cariDataReservasi.getText().isEmpty()) {
            showDataReservasi();
            setVisibleComponents(false);
        }
    }//GEN-LAST:event_tf_cariDataReservasiKeyPressed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        cariData();
        setVisibleComponents(false);
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus Data?");
        if (opsi == JOptionPane.YES_OPTION)  {
            try {
                String sql = "DELETE FROM reservasi WHERE id_reservasi='"+ tf_rincianIdReservasi.getText() +"'";
                Connection conn = (Connection)Config.configDB();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(this, "Hapus Data Berhasil");
                showDataReservasi();
                setVisibleComponents(false);
            }
            catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak jadi dihapus");
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        updateDataReservasi();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tf_rincianIdReservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_rincianIdReservasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_rincianIdReservasiActionPerformed

    private void cb_rincianIdKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_rincianIdKamarActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_cb_rincianIdKamarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JPanel btn_reservasi;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cb_rincianIdKamar;
    private com.toedter.calendar.JDateChooser date_rincianCheckIn;
    private com.toedter.calendar.JDateChooser date_rincianCheckOut;
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
    private javax.swing.JTextField tf_rincianIdReservasi;
    private javax.swing.JLabel tv_rincianCheckIn;
    private javax.swing.JLabel tv_rincianCheckOut;
    private javax.swing.JLabel tv_rincianDataReservasi;
    private javax.swing.JLabel tv_rincianIdKamar;
    private javax.swing.JLabel tv_rincianIdReservasi;
    // End of variables declaration//GEN-END:variables
}
