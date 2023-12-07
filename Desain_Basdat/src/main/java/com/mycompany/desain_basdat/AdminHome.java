/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.desain_basdat;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author LENOVO
 */
public class AdminHome extends javax.swing.JFrame {

    String filename = null;
    byte[] person_image = null;
    
    int harga_frame = 0;
    int harga_lensa = 0;
    int harga_akhir = 0;
    
    Object[] row = new Object[7];
    
    public AdminHome() {
        initComponents();
        show_pemesanan();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
    }
    
    public ArrayList<Pemesanan> pemesananList() {
        ArrayList<Pemesanan> pemesananList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;" +
                        "databaseName=Kacamata;" +
                        "user=Ridha;" +
                        "password=kelompok7;" +
                        "encrypt=true;" +
                        "trustServerCertificate=true;" + "loginTimeout=30;";
            Connection con = DriverManager.getConnection(url);
            String query1 = "SELECT id, nama_pelanggan, nomor, frame, lensa, total_harga, image, user_sno FROM Pemesanan JOIN [User] ON Pemesanan.user_sno = [User].sno";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Pemesanan pemesanan;
            while(rs.next()){
                pemesanan = new Pemesanan(rs.getInt("id"), rs.getString("nama_pelanggan"), rs.getString("nomor"), rs.getString("frame"), rs.getString("lensa"), rs.getString("total_harga"), rs.getBytes("image"), rs.getInt("user_sno"));
                pemesananList.add(pemesanan);
            }
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
        }
        return pemesananList;
    }
    
    public void show_pemesanan() {
        ArrayList<Pemesanan> list = pemesananList();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Pemesanan.getModel();
        model.setRowCount(0);
        
        
        for(int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getsno();
            row[1] = list.get(i).getnama_pelanggan();
            row[2] = list.get(i).getnomor();
            row[3] = list.get(i).getframe();
            row[4] = list.get(i).getlensa();
            row[5] = list.get(i).gettotal_harga();
            row[6] = list.get(i).getuser_sno();
            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        nama_pelanggan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nomor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lensa = new javax.swing.JComboBox<>();
        frame = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        total_harga = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        lbl_hasil = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Pemesanan = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        btnImage = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        lbl_frame_image = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        hitung_harga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Name Pelanggan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 142, 150, -1));
        getContentPane().add(nama_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 142, 342, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nomor Telfon/WA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 182, 150, -1));
        getContentPane().add(nomor, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 182, 342, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Frame");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 234, 150, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Lensa");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 274, 150, -1));

        lensa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kosong", "Silinder [Rp250000]", "Plus [Rp200000]", "Minus [Rp150000]", "Silinder & Minus [Rp400000]", "Silinder & Plus [Rp350000]" }));
        lensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lensaActionPerformed(evt);
            }
        });
        getContentPane().add(lensa, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 274, -1, -1));

        frame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kosong", "Versace [Rp320000]", "Dolce [Rp220000]", "Levis [Rp400000]", "Calvin [Rp350000]", "Chanel [Rp190000]", "Oakley [Rp150000]" }));
        frame.setMinimumSize(new java.awt.Dimension(121, 22));
        frame.setPreferredSize(new java.awt.Dimension(121, 22));
        getContentPane().add(frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 234, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total Harga");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 314, 150, -1));

        total_harga.setText("0");
        getContentPane().add(total_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 315, 209, 20));

        reset.setText("Reset");
        reset.setMaximumSize(new java.awt.Dimension(102, 23));
        reset.setMinimumSize(new java.awt.Dimension(102, 23));
        reset.setPreferredSize(new java.awt.Dimension(102, 23));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 100, 30));
        getContentPane().add(lbl_hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 439, 501, 25));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel6.setText("Admin");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 25, -1, -1));

        jTable_Display_Pemesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Pelanggan", "Nomor", "Frame", "Lensa", "Total Harga", "Username"
            }
        ));
        jTable_Display_Pemesanan.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable_Display_Pemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_PemesananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Pemesanan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 25, 663, 191));

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1199, 258, 107, 31));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 408, 101, 31));

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1199, 348, 107, 31));

        lbl_image.setBackground(new java.awt.Color(0, 0, 0));
        lbl_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 349, 218, 90));

        btnImage.setText("Choose");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });
        getContentPane().add(btnImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 350, 99, -1));

        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        getContentPane().add(LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1342, 25, 107, 37));

        lbl_frame_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lbl_frame_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 245, 349, 197));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\Downloads\\backgroundhijau4.jpg")); // NOI18N
        jLabel8.setText("jLabel7");
        jLabel8.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 860, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        hitung_harga.setText("Hitung Harga");
        hitung_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitung_hargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(480, Short.MAX_VALUE)
                .addComponent(hitung_harga)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(309, Short.MAX_VALUE)
                .addComponent(hitung_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hitung_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitung_hargaActionPerformed
        if(frame.getSelectedItem().toString().equals("Kosong")) {
            harga_frame = 0;
        } else if(frame.getSelectedItem().toString().equals("Versace [Rp320000]")) {
            harga_frame = 320000;
        } else if(frame.getSelectedItem().toString().equals("Dolce [Rp220000")) {
            harga_frame = 220000;
        } else if(frame.getSelectedItem().toString().equals("Levis [Rp400000]")) {
            harga_frame = 400000;
        } else if(frame.getSelectedItem().toString().equals("Calvin [Rp350000]")) {
            harga_frame = 350000;
        } else if(frame.getSelectedItem().toString().equals("Chanel [Rp190000]")) {
            harga_frame = 190000;
        } else if(frame.getSelectedItem().toString().equals("Oakley [Rp150000]")) {
            harga_frame = 150000;
        }
                
                
        if(lensa.getSelectedItem().toString().equals("Kosong")) {
            harga_lensa = 0;
        } else if(frame.getSelectedItem().toString().equals("Silinder [Rp250000]")) {
            harga_lensa = 250000;
        } else if(frame.getSelectedItem().toString().equals("Minus [Rp200000]")) {
            harga_lensa = 200000;
        } else if(frame.getSelectedItem().toString().equals("Plus [Rp150000]")) {
            harga_lensa = 150000;
        } else if(frame.getSelectedItem().toString().equals("Silinder & Minus [Rp400000]")) {
            harga_lensa = 400000;
        } else if(frame.getSelectedItem().toString().equals("Silinder & Plus [Rp350000]")) {
            harga_lensa = 350000;
        }
        
        
        harga_akhir = harga_frame + harga_lensa;
        String hasil = String.valueOf(harga_akhir);            
        total_harga.setText(hasil);
    }//GEN-LAST:event_hitung_hargaActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        nama_pelanggan.setText("");
        nomor.setText("");
        frame.setSelectedIndex(0);
        lensa.setSelectedIndex(0);
        total_harga.setText("0");
    }//GEN-LAST:event_resetActionPerformed

    private void jTable_Display_PemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_PemesananMouseClicked
        int i = jTable_Display_Pemesanan.getSelectedRow();
        TableModel model = jTable_Display_Pemesanan.getModel();
        nama_pelanggan.setText(model.getValueAt(i, 1).toString());
        
        nomor.setText(model.getValueAt(i,2).toString());
        
        String frame1 = model.getValueAt(i, 3).toString();
        switch (frame1) {
            case "Kosong":
                frame.setSelectedIndex(0);
                harga_frame = 0;
                break;
            case "Versace [Rp320000]":
                frame.setSelectedIndex(1);
                harga_frame = 320000;
                break;
            case "Dolce [Rp220000]":
                frame.setSelectedIndex(2);
                harga_frame = 220000;
                break;
            case "Levis [Rp400000]":
                frame.setSelectedIndex(3);
                harga_frame = 400000;
                break;
            case "Calvin [Rp350000]":
                frame.setSelectedIndex(4);
                harga_frame = 350000;
                break;
            case "Chanel [Rp190000]":
                frame.setSelectedIndex(5);
                harga_frame = 190000;
                break;
            case "Oakley [Rp150000]":
                frame.setSelectedIndex(6);
                harga_frame = 150000;
                break;
        }
        
        
        
        String lensa1 = model.getValueAt(i, 4).toString();
        switch (lensa1) {
            case "Kosong":
                lensa.setSelectedIndex(0);
                harga_lensa = 0;
                break;
            case "Silinder [Rp250000]":
                lensa.setSelectedIndex(1);
                harga_lensa = 250000;
                break;
            case "Minus [Rp200000]":
                lensa.setSelectedIndex(2);
                harga_lensa = 200000;
                break;
            case "Plus [Rp150000]":
                lensa.setSelectedIndex(3);
                harga_lensa = 150000;
                break;
            case "Silinder & Minus [Rp400000]":
                lensa.setSelectedIndex(4);
                harga_lensa = 400000;
                break;
            case "Silinder & Plus [Rp350000]":
                lensa.setSelectedIndex(5);
                harga_lensa = 350000;
                break;
        }   
        byte[] img = (pemesananList().get(i).getImage());
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(),Image.SCALE_SMOOTH));
        lbl_image.setIcon(imageIcon);
        
        String selectedText = pemesananList().get(i).getframe();
        
        if(selectedText.equals("Versace [Rp320000]")) {
            String pathGambar = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Desain_Basdat\\src\\main\\java\\com\\mycompany\\desain_basdat\\Versace.jpeg"; // Ganti dengan path gambar yang sesuai

            // Coba baca gambar dari file dan atur sebagai ikon pada JLabel
            try {
                File fileGambar = new File(pathGambar);
                Image gambar = ImageIO.read(fileGambar);
                lbl_frame_image.setIcon(new ImageIcon(gambar));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(selectedText.equals("Dolce [Rp220000]")) {
            String pathGambar = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Desain_Basdat\\src\\main\\java\\com\\mycompany\\desain_basdat\\Dolce.jpeg"; // Ganti dengan path gambar yang sesuai

            // Coba baca gambar dari file dan atur sebagai ikon pada JLabel
            try {
                File fileGambar = new File(pathGambar);
                Image gambar = ImageIO.read(fileGambar);
                lbl_frame_image.setIcon(new ImageIcon(gambar));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(selectedText.equals("Levis [Rp400000]")) {
            String pathGambar = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Desain_Basdat\\src\\main\\java\\com\\mycompany\\desain_basdat\\Levis.png"; // Ganti dengan path gambar yang sesuai

            // Coba baca gambar dari file dan atur sebagai ikon pada JLabel
            try {
                File fileGambar = new File(pathGambar);
                Image gambar = ImageIO.read(fileGambar);
                lbl_frame_image.setIcon(new ImageIcon(gambar));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(selectedText.equals("Calvin [Rp350000]")) {
            String pathGambar = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Desain_Basdat\\src\\main\\java\\com\\mycompany\\desain_basdat\\Calvin.jpeg"; // Ganti dengan path gambar yang sesuai

            // Coba baca gambar dari file dan atur sebagai ikon pada JLabel
            try {
                File fileGambar = new File(pathGambar);
                Image gambar = ImageIO.read(fileGambar);
                lbl_frame_image.setIcon(new ImageIcon(gambar));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(selectedText.equals("Chanel [Rp190000]")) {
            String pathGambar = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Desain_Basdat\\src\\main\\java\\com\\mycompany\\desain_basdat\\Chanel.jpeg"; // Ganti dengan path gambar yang sesuai

            // Coba baca gambar dari file dan atur sebagai ikon pada JLabel
            try {
                File fileGambar = new File(pathGambar);
                Image gambar = ImageIO.read(fileGambar);
                lbl_frame_image.setIcon(new ImageIcon(gambar));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(selectedText.equals("Oakley [Rp150000]")) {
            String pathGambar = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Desain_Basdat\\src\\main\\java\\com\\mycompany\\desain_basdat\\Oakley.jpeg"; // Ganti dengan path gambar yang sesuai

            // Coba baca gambar dari file dan atur sebagai ikon pada JLabel
            try {
                File fileGambar = new File(pathGambar);
                Image gambar = ImageIO.read(fileGambar);
                lbl_frame_image.setIcon(new ImageIcon(gambar));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTable_Display_PemesananMouseClicked

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        AdminTambah field = new AdminTambah();
        field.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_tambahActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;" +
                        "databaseName=Kacamata;" +
                        "user=Ridha;" +
                        "password=kelompok7;" +
                        "encrypt=true;" +
                        "trustServerCertificate=true;" + "loginTimeout=30;";
            Connection con = DriverManager.getConnection(url);
            int row = jTable_Display_Pemesanan.getSelectedRow();
            String value = (jTable_Display_Pemesanan.getModel().getValueAt(row, 0).toString());
            String query = "UPDATE [Pemesanan] SET nama_pelanggan=?, nomor=?, frame=?, lensa=?, total_harga=? where id=" + value;
            
            PreparedStatement pst = con.prepareStatement(query);
                
            pst.setString(1, nama_pelanggan.getText());
            pst.setString(2, nomor.getText());
            pst.setString(3, frame.getSelectedItem().toString());
            pst.setString(4, lensa.getSelectedItem().toString());
            pst.setString(5, total_harga.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) jTable_Display_Pemesanan.getModel();
            model.setRowCount(0);
            show_pemesanan();

            JOptionPane.showMessageDialog(null, "Update Sucessfully");
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;" +
                        "databaseName=Kacamata;" +
                        "user=Ridha;" +
                        "password=kelompok7;" +
                        "encrypt=true;" +
                        "trustServerCertificate=true;" + "loginTimeout=30;";
            Connection con = DriverManager.getConnection(url);
            int row = jTable_Display_Pemesanan.getSelectedRow();
            String value = (jTable_Display_Pemesanan.getModel().getValueAt(row, 0).toString());
            String query = "DELETE FROM [Pemesanan] where id="+value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) jTable_Display_Pemesanan.getModel();
            model.setRowCount(0);
            show_pemesanan();
            JOptionPane.showMessageDialog(null,"Deleted Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(),Image.SCALE_SMOOTH));
        lbl_image.setIcon(imageIcon);
        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum=fis.read(buf)) != -1;){
                bos.write(buf, 0, readNum);
                
            }
            person_image=bos.toByteArray();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnImageActionPerformed

    private void lensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lensaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lensaActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOut;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> frame;
    private javax.swing.JButton hitung_harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Pemesanan;
    private javax.swing.JLabel lbl_frame_image;
    private javax.swing.JLabel lbl_hasil;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JComboBox<String> lensa;
    private javax.swing.JTextField nama_pelanggan;
    private javax.swing.JTextField nomor;
    private javax.swing.JButton reset;
    private javax.swing.JButton tambah;
    private javax.swing.JLabel total_harga;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
