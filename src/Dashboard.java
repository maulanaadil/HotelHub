
import form.FormPembayaran;
import form.FormPendaftaranTamu;
import form.FormReservasi;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import laporan.LaporanHarian;
import pengaturan.History;
import service.Pegawai;
import service.Pembayaran;
import service.Reservasi;
import service.Ruangan;
import service.Tamu;


public class Dashboard extends javax.swing.JFrame {
    private Dimension layarUtama;
    private Dimension layarMenu;
    private FormPendaftaranTamu formPendaftaranTamu;
    private FormReservasi formReservasi;
    private FormPembayaran formPembayaran;
    private Pegawai pegawai;
    private Ruangan ruangan;
    private Pembayaran pembayaran;
    private Tamu tamu;
    private Reservasi reservasi; 
    private LaporanHarian laporan;
    private History history;

    public Dashboard() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    private void setMenu(JInternalFrame tampilan, Boolean kondisi) {
        tampilan.setVisible(kondisi);
        tampilan.setIconifiable(kondisi);
        tampilan.setClosable(kondisi);
    }
    
    private void clearMenu() {
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("assets/hotel.jpg"));
        Image img = icon.getImage();
        mainPanel = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g) {
                g.drawImage(img ,0 ,0 ,getWidth(), getHeight(), this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        menuForm = new javax.swing.JMenu();
        menuFormDaftarTamu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuFormReservasi = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuFormPembayaran = new javax.swing.JMenuItem();
        menuService = new javax.swing.JMenu();
        menuServiceDataPegawai = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuServiceDataRuangan = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuServiceDataPembayaran = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuServiceDataTamu = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        menuServiceDataReservasi = new javax.swing.JMenuItem();
        menuLaporan = new javax.swing.JMenu();
        menuLaporanHarian = new javax.swing.JMenuItem();
        menuPengaturan = new javax.swing.JMenu();
        menuPengaturanAboutUs = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        menuPengaturanHistory = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuPengaturanKeluar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        menuForm.setText("Form");
        menuForm.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N

        menuFormDaftarTamu.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuFormDaftarTamu.setText("Pendaftaran Tamu");
        menuFormDaftarTamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFormDaftarTamuActionPerformed(evt);
            }
        });
        menuForm.add(menuFormDaftarTamu);
        menuForm.add(jSeparator1);

        menuFormReservasi.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuFormReservasi.setText("Reservasi");
        menuFormReservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFormReservasiActionPerformed(evt);
            }
        });
        menuForm.add(menuFormReservasi);
        menuForm.add(jSeparator2);

        menuFormPembayaran.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuFormPembayaran.setText("Pembayaran");
        menuFormPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFormPembayaranActionPerformed(evt);
            }
        });
        menuForm.add(menuFormPembayaran);

        jMenuBar1.add(menuForm);

        menuService.setText("Service");
        menuService.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N

        menuServiceDataPegawai.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuServiceDataPegawai.setText("Data Pegawai");
        menuServiceDataPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuServiceDataPegawaiActionPerformed(evt);
            }
        });
        menuService.add(menuServiceDataPegawai);
        menuService.add(jSeparator3);

        menuServiceDataRuangan.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuServiceDataRuangan.setText("Data Ruangan");
        menuServiceDataRuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuServiceDataRuanganActionPerformed(evt);
            }
        });
        menuService.add(menuServiceDataRuangan);
        menuService.add(jSeparator4);

        menuServiceDataPembayaran.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuServiceDataPembayaran.setText("Data Pembayaran");
        menuServiceDataPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuServiceDataPembayaranActionPerformed(evt);
            }
        });
        menuService.add(menuServiceDataPembayaran);
        menuService.add(jSeparator5);

        menuServiceDataTamu.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuServiceDataTamu.setText("Data Tamu");
        menuServiceDataTamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuServiceDataTamuActionPerformed(evt);
            }
        });
        menuService.add(menuServiceDataTamu);
        menuService.add(jSeparator6);

        menuServiceDataReservasi.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuServiceDataReservasi.setText("Data Reservasi");
        menuServiceDataReservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuServiceDataReservasiActionPerformed(evt);
            }
        });
        menuService.add(menuServiceDataReservasi);

        jMenuBar1.add(menuService);

        menuLaporan.setText("Laporan");
        menuLaporan.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N

        menuLaporanHarian.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuLaporanHarian.setText("Laporan Harian");
        menuLaporanHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLaporanHarianActionPerformed(evt);
            }
        });
        menuLaporan.add(menuLaporanHarian);

        jMenuBar1.add(menuLaporan);

        menuPengaturan.setText("Pengaturan");
        menuPengaturan.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N

        menuPengaturanAboutUs.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuPengaturanAboutUs.setText("About Us");
        menuPengaturan.add(menuPengaturanAboutUs);
        menuPengaturan.add(jSeparator7);

        menuPengaturanHistory.setText("History");
        menuPengaturanHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPengaturanHistoryActionPerformed(evt);
            }
        });
        menuPengaturan.add(menuPengaturanHistory);
        menuPengaturan.add(jSeparator8);

        menuPengaturanKeluar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuPengaturanKeluar.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuPengaturanKeluar.setText("Keluar");
        menuPengaturanKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPengaturanKeluarActionPerformed(evt);
            }
        });
        menuPengaturan.add(menuPengaturanKeluar);

        jMenuBar1.add(menuPengaturan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuFormDaftarTamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFormDaftarTamuActionPerformed
        // TODO add your handling code here:
        
        formPendaftaranTamu = new FormPendaftaranTamu();
        layarUtama = this.getSize();
        layarMenu = formPendaftaranTamu.getSize();
        
        formPendaftaranTamu.setLocation(layarUtama.width/2 - layarMenu.width/2, layarUtama.height/2-layarMenu.height/2);
        
        mainPanel.add(formPendaftaranTamu);
        setMenu(formPendaftaranTamu, true);
    }//GEN-LAST:event_menuFormDaftarTamuActionPerformed

    private void menuPengaturanKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPengaturanKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuPengaturanKeluarActionPerformed

    private void menuFormReservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFormReservasiActionPerformed
        // TODO add your handling code here:
        
        formReservasi = new FormReservasi();
        layarUtama = this.getSize();
        layarMenu = formReservasi.getSize();
        
        formReservasi.setLocation(layarUtama.width/2 - layarMenu.width/2, layarUtama.height/2-layarMenu.height/2);
        
        mainPanel.add(formReservasi);
        setMenu(formReservasi, true);
    }//GEN-LAST:event_menuFormReservasiActionPerformed

    private void menuFormPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFormPembayaranActionPerformed
        // TODO add your handling code here:
        
        formPembayaran = new FormPembayaran();
        layarUtama = this.getSize();
        layarMenu = formPembayaran.getSize();
        
        formPembayaran.setLocation(layarUtama.width/2 - layarMenu.width/2, layarUtama.height/2-layarMenu.height/2);
        
        mainPanel.add(formPembayaran);
        setMenu(formPembayaran, true);
    }//GEN-LAST:event_menuFormPembayaranActionPerformed

    private void menuServiceDataPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServiceDataPegawaiActionPerformed
        // TODO add your handling code here:

        pegawai = new Pegawai();
        layarUtama = this.getSize();
        layarMenu = pegawai.getSize();
        
        pegawai.setLocation(layarUtama.width/2 - layarMenu.width/2, layarUtama.height/2-layarMenu.height/2);
        
        mainPanel.add(pegawai);
        setMenu(pegawai, true);
    }//GEN-LAST:event_menuServiceDataPegawaiActionPerformed

    private void menuServiceDataRuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServiceDataRuanganActionPerformed
        // TODO add your handling code here:

        ruangan = new Ruangan();
        layarUtama = this.getSize();
        layarMenu = ruangan.getSize();
        
        ruangan.setLocation(layarUtama.width/2 - layarMenu.width/2, layarUtama.height/2-layarMenu.height/2);
        
        mainPanel.add(ruangan);
        setMenu(ruangan, true);
    }//GEN-LAST:event_menuServiceDataRuanganActionPerformed

    private void menuServiceDataPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServiceDataPembayaranActionPerformed
        // TODO add your handling code here:
        
        pembayaran = new Pembayaran();
        layarUtama = this.getSize();
        layarMenu = pembayaran.getSize();
        
        pembayaran.setLocation(layarUtama.width/2 - layarMenu.width/2, layarUtama.height/2-layarMenu.height/2);
        
        mainPanel.add(pembayaran);
        setMenu(pembayaran, true);
    }//GEN-LAST:event_menuServiceDataPembayaranActionPerformed

    private void menuServiceDataTamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServiceDataTamuActionPerformed
        // TODO add your handling code here:
        
        tamu = new Tamu();
        layarUtama = this.getSize();
        layarMenu = tamu.getSize();
        
        tamu.setLocation(layarUtama.width/2 - layarMenu.width/2, layarUtama.height/2-layarMenu.height/2);
        
        mainPanel.add(tamu);
        setMenu(tamu, true);
    }//GEN-LAST:event_menuServiceDataTamuActionPerformed

    private void menuServiceDataReservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServiceDataReservasiActionPerformed
        // TODO add your handling code here:
        
        reservasi = new Reservasi();
        layarUtama = this.getSize();
        layarMenu = reservasi.getSize();
        
        reservasi.setLocation(layarUtama.width/2 - layarMenu.width/2, layarUtama.height/2-layarMenu.height/2);
        
        mainPanel.add(reservasi);
        setMenu(reservasi, true);
    }//GEN-LAST:event_menuServiceDataReservasiActionPerformed

    private void menuLaporanHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLaporanHarianActionPerformed
        // TODO add your handling code here:
        clearMenu();
        
        laporan = new LaporanHarian();
        layarUtama = this.getSize();
        layarMenu = laporan.getSize();
        
        laporan.setLocation(layarUtama.width/2 - layarMenu.width/2, layarUtama.height/2-layarMenu.height/2);
        
        mainPanel.add(laporan);
        setMenu(laporan, true);
    }//GEN-LAST:event_menuLaporanHarianActionPerformed

    private void menuPengaturanHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPengaturanHistoryActionPerformed
        // TODO add your handling code here:
        clearMenu();
        
        history = new History();
        layarUtama = this.getSize();
        layarMenu = history.getSize();
        
        history.setLocation(layarUtama.width/2 - layarMenu.width/2, layarUtama.height/2-layarMenu.height/2);
        
        mainPanel.add(history);
        setMenu(history, true);        
    }//GEN-LAST:event_menuPengaturanHistoryActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JDesktopPane mainPanel;
    private javax.swing.JMenu menuForm;
    private javax.swing.JMenuItem menuFormDaftarTamu;
    private javax.swing.JMenuItem menuFormPembayaran;
    private javax.swing.JMenuItem menuFormReservasi;
    private javax.swing.JMenu menuLaporan;
    private javax.swing.JMenuItem menuLaporanHarian;
    private javax.swing.JMenu menuPengaturan;
    private javax.swing.JMenuItem menuPengaturanAboutUs;
    private javax.swing.JMenuItem menuPengaturanHistory;
    private javax.swing.JMenuItem menuPengaturanKeluar;
    private javax.swing.JMenu menuService;
    private javax.swing.JMenuItem menuServiceDataPegawai;
    private javax.swing.JMenuItem menuServiceDataPembayaran;
    private javax.swing.JMenuItem menuServiceDataReservasi;
    private javax.swing.JMenuItem menuServiceDataRuangan;
    private javax.swing.JMenuItem menuServiceDataTamu;
    // End of variables declaration//GEN-END:variables
}
