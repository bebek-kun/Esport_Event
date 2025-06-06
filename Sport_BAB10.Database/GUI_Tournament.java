package Sport;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel; 

public class GUI_Tournament extends javax.swing.JFrame implements EventManager{
    public void koneksi() {
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_esport", "root", "");
        System.out.println("Koneksi berhasil!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void tampilData() {
    DefaultTableModel model = (DefaultTableModel) tbl_Tour.getModel();
    model.setRowCount(0); // Bersihkan tabel

    try {
        koneksi(); // Pastikan koneksi sudah tersedia
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM tournament_events"); // Sesuaikan nama tabel

        while (rs.next()) {
            Object[] row = {
                rs.getString("event_name"),
                rs.getString("game"),
                rs.getString("event_date"),
                rs.getString("location"),
                rs.getString("team_number"),
                rs.getString("prize")
            };
            model.addRow(row);
        }

        rs.close();
        st.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage());
    }
}

    public void simpanData() {
    try {
        koneksi(); // Pastikan koneksi tersedia

        String sql = "INSERT INTO tournament_events (event_name, game, event_date, location, team_number, prize) VALUES ('"
                + txtEventName.getText() + "', '"
                + txtGame.getText() + "', '"
                + txtDate.getText() + "', '"
                + txtLocation.getText() + "', '"
                + txtTeams.getText() + "', '"
                + txtPrize.getText() + "')";

        Statement st = conn.createStatement();
        st.executeUpdate(sql);
        st.close();

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke database!");
        tampilData(); // Refresh tabel
        clearForm(); // Kosongkan field input
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error saat menyimpan data: " + e.getMessage());
    }
}

    public void hapusData() {
    try {
        int selectedRow = tbl_Tour.getSelectedRow();
        if (selectedRow == -1) {
            throw new Exception("Pilih baris yang ingin dihapus!");
        }

        // Ambil nilai dari kolom event_name (kolom pertama)
        String eventName = tbl_Tour.getValueAt(selectedRow, 0).toString();

        koneksi(); // Pastikan koneksi dibuat
        Statement st = conn.createStatement();
        String sql = "DELETE FROM tournament_events WHERE event_name = '" + eventName + "'";
        st.executeUpdate(sql);
        st.close();

        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        tampilData(); // Refresh tabel setelah penghapusan
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    
    public Connection conn; 
   DefaultTableModel model; 
   public void batal() {
    txtEventName.setText("");
    txtGame.setText("");
    txtDate.setText("");
    txtLocation.setText("");
    txtTeams.setText("");
    txtPrize.setText("");
} 
    public GUI_Tournament() {
    initComponents();
    koneksi();
    
    setResizable(false);
    model = (DefaultTableModel) tbl_Tour.getModel();

    btnClose.addActionListener(e -> dispose());

    btnBatal.addActionListener(e -> batal());

    btnHapus.addActionListener(e -> {
        int selectedRow = tbl_Tour.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        }
    });

    btnSave.addActionListener(e -> btnSaveActionPerformed(null));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEventName = new javax.swing.JTextField();
        txtGame = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        txtTeams = new javax.swing.JTextField();
        txtPrize = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Tour = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama Acara");

        jLabel2.setText("Game");

        jLabel3.setText("Tanggal");

        jLabel4.setText("Lokasi");

        jLabel5.setText("Nomor Tim");

        jLabel6.setText("Hadiah");

        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        tbl_Tour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Acara", "Game", "Tanggal", "Lokasi", "No. Tim", "Hadiah"
            }
        ));
        jScrollPane2.setViewportView(tbl_Tour);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPrize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(txtTeams, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEventName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGame, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLocation, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnBatal)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTeams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave)
                        .addComponent(btnHapus)
                        .addComponent(btnBatal)
                        .addComponent(btnClose))
                    .addComponent(jLabel6))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    saveEvent();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int selectedRow = tbl_Tour.getSelectedRow();
        deleteEvent(selectedRow);
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal(); 
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Tournament().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_Tour;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEventName;
    private javax.swing.JTextField txtGame;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtPrize;
    private javax.swing.JTextField txtTeams;
    // End of variables declaration//GEN-END:variables

    @Override
    public void saveEvent() {
        String eventName = txtEventName.getText().trim();
        String game = txtGame.getText().trim();
        String date = txtDate.getText().trim();
        String location = txtLocation.getText().trim();
        String teams = txtTeams.getText().trim();
        String prize = txtPrize.getText().trim();

    if (eventName.isEmpty() || game.isEmpty() || date.isEmpty() || location.isEmpty() || teams.isEmpty() || prize.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Semua field harus diisi!", 
            "Input Tidak Lengkap", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

        Object[] row = {eventName, game, date, location, teams, prize};
        model.addRow(row);
        clearForm();
    }

    @Override
    public void deleteEvent(int rowIndex) {
        if (rowIndex != -1) {
        model.removeRow(rowIndex);
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Data berhasil dihapus.", 
            "Sukses", 
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Pilih baris yang ingin dihapus terlebih dahulu.", 
            "Tidak ada baris dipilih", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void clearForm() {
        batal();
    }
    
}
