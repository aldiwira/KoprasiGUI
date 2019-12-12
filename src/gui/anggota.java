/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aldi Wirawan
 */
public class anggota extends javax.swing.JFrame {

    /**
     * Creates new form anggota
     */
    private static Connection koneksi;
    private DefaultTableModel model;
    public anggota() {
        initComponents();
        model = new DefaultTableModel();
        this.anggotaTable.setModel(model);
        model.addColumn("nama");
        model.addColumn("no hp");
        model.addColumn("alamat");
        ambil_data_anggota();
        
    }
    private void ambil_data_anggota(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            buka_koneksi();
            Statement s = koneksi.createStatement();
            String sql = "SELECT * FROM `nasabah`";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {      
                Object[] o = new Object[3];
                o[0] = r.getString("nama");
                o[1] = r.getString("no_telp");
                o[2] = r.getString("alamat");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Terjadi kesalahan " + e.getMessage());

        }
    }
    public void buka_koneksi(){
        if(koneksi == null){
            try {
            String url = "jdbc:mysql://localhost:3306/pbo";
            String user = "root";
            String password = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = (Connection) DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(anggota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void insertDataAnggota(){
        buka_koneksi();
        String inputAnggota = "INSERT INTO `nasabah` (`id_nasabah`, `nama`, `no_telp`, `alamat`) VALUES (NULL, "
                + "'"+namaField.getText()+"', "
                + "'"+telpField.getText()+"', "
                + "'"+alamatField.getText()+"')";
        try {
            PreparedStatement inputStatement = koneksi.prepareStatement(inputAnggota);
            inputStatement.executeUpdate();
            inputStatement.close();
            System.out.println("inserted");
            ambil_data_anggota();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi "+e.getMessage());
        }
    }
    public void editDataAnggota(String i){
        buka_koneksi();
        String updateAnggota = "UPDATE `nasabah` SET `nama` = "
                + "'"+namaField.getText()+"', `no_telp` = '"+telpField.getText()+"', `alamat` = '"+alamatField.getText()+"' WHERE `nasabah`.`nama` = '"+i+"'";
        try {
            PreparedStatement inputStatement = koneksi.prepareStatement(updateAnggota);
            inputStatement.executeUpdate();
            inputStatement.close();
            System.out.println(i+" Has Edited");
            ambil_data_anggota();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi "+e.getMessage());
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

        anggotaGrpup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        anggotaTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        namaField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telpField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamatField = new javax.swing.JTextArea();
        tambahButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Anggota Koperasi Sayang Uang");

        anggotaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        anggotaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anggotaTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(anggotaTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("No Telp");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Alamat");

        alamatField.setColumns(20);
        alamatField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        alamatField.setLineWrap(true);
        alamatField.setRows(5);
        jScrollPane2.setViewportView(alamatField);

        tambahButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tambahButton.setText("Tambah");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        refreshButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        hapusButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hapusButton.setText("Hapus");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });

        anggotaGrpup.add(jRadioButton1);
        jRadioButton1.setText("Anggota Lama");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        anggotaGrpup.add(jRadioButton2);
        jRadioButton2.setText("Anggota Baru");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(131, 131, 131)
                                                .addComponent(jRadioButton2))
                                            .addComponent(jRadioButton1)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(namaField)
                                                .addComponent(telpField)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tambahButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(editButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(hapusButton)
                                        .addGap(4, 4, 4)))
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(refreshButton)
                                .addGap(92, 92, 92)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(telpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahButton)
                            .addComponent(editButton)
                            .addComponent(hapusButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton)
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        ambil_data_anggota();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        // TODO add your handling code here:
        insertDataAnggota();
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void anggotaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anggotaTableMouseClicked
        // TODO add your handling code here:
        int i = anggotaTable.getSelectedRow();
        namaField.setText(model.getValueAt(i, 0).toString());
        telpField.setText(model.getValueAt(i, 1).toString());
        alamatField.setText(model.getValueAt(i, 2).toString());
    }//GEN-LAST:event_anggotaTableMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        int i = anggotaTable.getSelectedRow();
        String namaAnggota = model.getValueAt(i, 0).toString();
        if (i >= 0) {
            editDataAnggota(namaAnggota);
            
        } else {
            System.out.println("Error");
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new anggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatField;
    private javax.swing.ButtonGroup anggotaGrpup;
    private javax.swing.JTable anggotaTable;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namaField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton tambahButton;
    private javax.swing.JTextField telpField;
    // End of variables declaration//GEN-END:variables
}
