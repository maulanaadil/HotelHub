
import form.FormPembayaran;
import form.FormPendaftaranTamu;
import form.FormReservasi;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import service.Pegawai;
import service.Pembayaran;
import service.Ruangan;
import service.Tamu;


public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("assets/kopi.jpg"));
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
        menuPengaturan = new javax.swing.JMenu();
        menuPengaturanAboutUs = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
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
        menuService.add(menuServiceDataReservasi);

        jMenuBar1.add(menuService);

        menuPengaturan.setText("Pengaturan");
        menuPengaturan.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N

        menuPengaturanAboutUs.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        menuPengaturanAboutUs.setText("About Us");
        menuPengaturan.add(menuPengaturanAboutUs);
        menuPengaturan.add(jSeparator7);

        menuPengaturanKeluar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        FormPendaftaranTamu formPendaftaranTamu = new FormPendaftaranTamu();
        Dimension layarUtama = this.getSize();
        Dimension layarPendaftaranTamu = formPendaftaranTamu.getSize();
        
        formPendaftaranTamu.setLocation(layarUtama.width/2 - layarPendaftaranTamu.width/2, layarUtama.height/2-layarPendaftaranTamu.height/2);
        
        mainPanel.add(formPendaftaranTamu);
        formPendaftaranTamu.setVisible(true);
        formPendaftaranTamu.setIconifiable(true);
        formPendaftaranTamu.setClosable(true);
        
    }//GEN-LAST:event_menuFormDaftarTamuActionPerformed

    private void menuPengaturanKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPengaturanKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuPengaturanKeluarActionPerformed

    private void menuFormReservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFormReservasiActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        FormReservasi formReservasi = new FormReservasi();
        Dimension layarUtama = this.getSize();
        Dimension layarReservasi = formReservasi.getSize();
        
        formReservasi.setLocation(layarUtama.width/2 - layarReservasi.width/2, layarUtama.height/2-layarReservasi.height/2);
        
        mainPanel.add(formReservasi);
        formReservasi.setVisible(true);
        formReservasi.setIconifiable(true);
        formReservasi.setClosable(true);
        
        
        
        
    }//GEN-LAST:event_menuFormReservasiActionPerformed

    private void menuFormPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFormPembayaranActionPerformed
        // TODO add your handling code here:
         mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        FormPembayaran formPembayaran = new FormPembayaran();
        Dimension layarUtama = this.getSize();
        Dimension layarPembayaran = formPembayaran.getSize();
        
        formPembayaran.setLocation(layarUtama.width/2 - layarPembayaran.width/2, layarUtama.height/2-layarPembayaran.height/2);
        
        mainPanel.add(formPembayaran);
        formPembayaran.setVisible(true);
        formPembayaran.setIconifiable(true);
        formPembayaran.setClosable(true);
        
    }//GEN-LAST:event_menuFormPembayaranActionPerformed

    private void menuServiceDataPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServiceDataPegawaiActionPerformed
        // TODO add your handling code here:
        
        Pegawai pegawai = new Pegawai();
        Dimension layarUtama = this.getSize();
        Dimension layarPegawai = pegawai.getSize();
        
        pegawai.setLocation(layarUtama.width/2 - layarPegawai.width/2, layarUtama.height/2-layarPegawai.height/2);
        
        mainPanel.add(pegawai);
        pegawai.setVisible(true);
        pegawai.setIconifiable(true);
        pegawai.setClosable(true);
    }//GEN-LAST:event_menuServiceDataPegawaiActionPerformed

    private void menuServiceDataRuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServiceDataRuanganActionPerformed
        // TODO add your handling code here:
        
        Ruangan ruangan = new Ruangan();
        Dimension layarUtama = this.getSize();
        Dimension layarRuangan = ruangan.getSize();
        
        ruangan.setLocation(layarUtama.width/2 - layarRuangan.width/2, layarUtama.height/2-layarRuangan.height/2);
        
        mainPanel.add(ruangan);
        ruangan.setVisible(true);
        ruangan.setIconifiable(true);
        ruangan.setClosable(true);
    }//GEN-LAST:event_menuServiceDataRuanganActionPerformed

    private void menuServiceDataPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServiceDataPembayaranActionPerformed
        // TODO add your handling code here:
        
        Pembayaran pembayaran = new Pembayaran();
        Dimension layarUtama = this.getSize();
        Dimension layarPembayaran = pembayaran.getSize();
        
        pembayaran.setLocation(layarUtama.width/2 - layarPembayaran.width/2, layarUtama.height/2-layarPembayaran.height/2);
        
        mainPanel.add(pembayaran);
        pembayaran.setVisible(true);
        pembayaran.setIconifiable(true);
        pembayaran.setClosable(true);
    }//GEN-LAST:event_menuServiceDataPembayaranActionPerformed

    private void menuServiceDataTamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServiceDataTamuActionPerformed
        // TODO add your handling code here:
        
        Tamu tamu = new Tamu();
        Dimension layarUtama = this.getSize();
        Dimension layarTamu = tamu.getSize();
        
        tamu.setLocation(layarUtama.width/2 - layarTamu.width/2, layarUtama.height/2-layarTamu.height/2);
        
        mainPanel.add(tamu);
        tamu.setVisible(true);
        tamu.setIconifiable(true);
        tamu.setClosable(true);
    }//GEN-LAST:event_menuServiceDataTamuActionPerformed


    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            SwingUtilities.updateComponentTreeUI(new MainFrame());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Karena : " + e);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JDesktopPane mainPanel;
    private javax.swing.JMenu menuForm;
    private javax.swing.JMenuItem menuFormDaftarTamu;
    private javax.swing.JMenuItem menuFormPembayaran;
    private javax.swing.JMenuItem menuFormReservasi;
    private javax.swing.JMenu menuPengaturan;
    private javax.swing.JMenuItem menuPengaturanAboutUs;
    private javax.swing.JMenuItem menuPengaturanKeluar;
    private javax.swing.JMenu menuService;
    private javax.swing.JMenuItem menuServiceDataPegawai;
    private javax.swing.JMenuItem menuServiceDataPembayaran;
    private javax.swing.JMenuItem menuServiceDataReservasi;
    private javax.swing.JMenuItem menuServiceDataRuangan;
    private javax.swing.JMenuItem menuServiceDataTamu;
    // End of variables declaration//GEN-END:variables
}
