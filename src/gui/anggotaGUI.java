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
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.*;

/**
 *
 * @author Aldi Wirawan
 */
public class anggotaGUI extends javax.swing.JFrame {

    /**
     * Creates new form anggota
     */
    Anggota anggota = new Anggota();
    private static Connection koneksi;
    private DefaultTableModel model;
    public anggotaGUI() {
        initComponents();
        model = new DefaultTableModel();
        this.anggotaTable.setModel(model);
        model.addColumn("Nama");
        model.addColumn("No Telp");
        model.addColumn("Alamat");
        model.addColumn("Anggota");
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
                Object[] o = new Object[4];
                o[0] = r.getString("nama");
                o[1] = r.getString("no_telp");
                o[2] = r.getString("alamat");
                o[3] = r.getString("jenis_anggota");
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
                Logger.getLogger(anggotaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void insertDataAnggota(){
        buka_koneksi();
        String inputAnggota1 = "INSERT INTO `nasabah` (`id_nasabah`, `nama`, `no_telp`, `alamat`, 'jenis_anggota') VALUES (NULL, "
                + "'"+namaField.getText()+"', "
                + "'"+telpField.getText()+"', "
                + "'"+alamatField.getText()+"', "
                + "'"+anggotaCombo.getSelectedItem().toString()+"')";
        String inputAnggota = "INSERT INTO `nasabah` (`id_nasabah`, `nama`, `no_telp`, `alamat`, `jenis_anggota`) VALUES (NULL, "
                + "'"+namaField.getText()+"',"
                + "'"+telpField.getText()+"',"
                + "'"+alamatField.getText()+"',"
                + "'"+anggotaCombo.getSelectedItem().toString()+"')";
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
        String exepct;
        String updateAnggot = "UPDATE `nasabah` SET `nama` = "
                + "'"+namaField.getText()+"', "
                + "`no_telp` = '"+telpField.getText()+"',"
                + "`alamat` = '"+alamatField.getText()+"',"
                + "'jenis_anggota' = '"+anggotaCombo.getSelectedItem().toString()+"'"
                + " WHERE `nasabah`.`nama` = '"+i+"'";
        String updateAnggota = "UPDATE `nasabah` SET `nama` = '"+namaField.getText()+"',"
                + "`no_telp` = '"+telpField.getText()+"',"
                + "`alamat` = '"+alamatField.getText()+"',"
                + "`jenis_anggota` = '"+anggotaCombo.getSelectedItem().toString()+"'"
                + " WHERE `nasabah`.`nama` = '"+i+"'";
        try {
            PreparedStatement inputStatement = koneksi.prepareStatement(updateAnggota);
            inputStatement.executeUpdate();
            inputStatement.close();
            System.out.println(i+" Has Edited");
            ambil_data_anggota();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi "+e.getMessage());
            exepct = e.getMessage();
        }
    }
    public void deleteAnggota(String i){
        buka_koneksi();
        String exepct;
        String deleteAnggota = "DELETE FROM `nasabah` WHERE `nasabah`.`nama` = '"+i+"'";
        try {
            PreparedStatement deleteStatement = koneksi.prepareCall(deleteAnggota);
            deleteStatement.executeUpdate();
            deleteStatement.close();
            System.out.println(i+" Has Deleted");
            ambil_data_anggota();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi "+e.getMessage());
            exepct = e.getMessage();
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
        anggotaCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

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
        editButton.setText("Update");
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

        anggotaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anggota Lama", "Anggota Baru" }));
        anggotaCombo.setSelectedIndex(-1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Anggota");

        jToggleButton1.setText("Home");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(namaField)
                                    .addComponent(telpField)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(anggotaCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tambahButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(editButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(hapusButton)))))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(anggotaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahButton)
                            .addComponent(editButton)
                            .addComponent(hapusButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(refreshButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        ambil_data_anggota();
//        System.out.println(anggotaCombo.getSelectedItem().toString());
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
        anggotaCombo.setSelectedItem(model.getValueAt(i, 3).toString());
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
        int i = anggotaTable.getSelectedRow();
        String boom ;
        String namaAnggota = model.getValueAt(i, 0).toString();
        if (i>=0 ) {
            deleteAnggota(namaAnggota);
            namaField.setText("");
            telpField.setText("");
            alamatField.setText("");
            anggotaCombo.setSelectedItem("");
        } else {
        System.out.println("Errorr");
        }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(anggotaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(anggotaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(anggotaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(anggotaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new anggotaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatField;
    private javax.swing.JComboBox<String> anggotaCombo;
    private javax.swing.ButtonGroup anggotaGrpup;
    private javax.swing.JTable anggotaTable;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField namaField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton tambahButton;
    private javax.swing.JTextField telpField;
    // End of variables declaration//GEN-END:variables
}
