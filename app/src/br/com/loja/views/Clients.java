package br.com.loja.views;

import java.sql.*;
import br.com.loja.dal.ConnectionModule;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Clients extends javax.swing.JInternalFrame {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Clients() {
        initComponents();
        connection = ConnectionModule.connector();
    }
    
        
    private void clearFields() {
        txtName.setText(null);
        txtPhone.setText(null);
        txtEmail.setText(null);
        txtAddress.setText(null);
    }
    
    private boolean isFieldsEmpty() {
        return (txtName.getText().isEmpty() 
                || txtPhone.getText().isEmpty() 
                || txtEmail.getText().isEmpty() 
                || txtAddress.getText().isEmpty());
    }
    
    private void search() {
        try {
            String sql = "SELECT * FROM clients WHERE name LIKE ?";
            
            ps = connection.prepareStatement(sql);
            ps.setString(1, "'" + txtSearch.getText() + "%'");
            rs = ps.executeQuery();
            
            tblClients.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void setFieldsFromTableData() {
        int indexOfSelectedRow = tblClients.getSelectedRow();
        txtName.setText(tblClients.getModel().getValueAt(indexOfSelectedRow, 1).toString());
        txtAddress.setText(tblClients.getModel().getValueAt(indexOfSelectedRow, 2).toString());
        txtPhone.setText(tblClients.getModel().getValueAt(indexOfSelectedRow, 3).toString());
        txtEmail.setText(tblClients.getModel().getValueAt(indexOfSelectedRow, 4).toString());
    }
    
    private void add() {
        try {
            if(isFieldsEmpty()) throw new Exception("Please, fill in all the fields");
            
            String sql = 
                "INSERT INTO clients (name, phone, email, address)"
                    + "VALUES (?,?,?,?);";
            
            ps = connection.prepareStatement(sql);
            ps.setString(1, txtName.getText());
            ps.setString(2, txtPhone.getText());
            ps.setString(3, txtEmail.getText());
            ps.setString(4, txtAddress.getText());
            int result = ps.executeUpdate();
            
            switch(result) {
                case 1:
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Client successfully created!");
                    break;
                default:
                    clearFields();
                    throw new Exception("Something went wrong, please try again later");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void update() {
        try {
            String sql = "SELECT id FROM clients WHERE email = ?";
            
            ps = connection.prepareStatement(sql);
            ps.setString(1, txtEmail.getText());
            rs = ps.executeQuery();
            
            if (!rs.next()) throw new Exception("User not found");
            
            String id = rs.getString(1);
            sql = "UPDATE clients SET "
                    + "name=?, "
                    + "phone=?, "
                    + "address=? "
                    + "WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, txtName.getText());
            ps.setString(2, txtPhone.getText());
            ps.setString(3, txtAddress.getText());
            ps.setString(4, id);
            int result = ps.executeUpdate();
            
            switch(result) {
                case 1:
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Client successfully updated!");
                    break;
                default:
                    clearFields();
                    throw new Exception("Something went wrong, please try again later");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            clearFields();
        }
    }
    
    private void remove() {
        try {
            String sql = "SELECT id FROM clients WHERE email = ?";
            
            ps = connection.prepareStatement(sql);
            ps.setString(1, txtEmail.getText());
            rs = ps.executeQuery();
            
            if (!rs.next()) throw new Exception("Client not found");
            
            String id = rs.getString(1);
            sql = "DELETE FROM clients WHERE id = " + id;
            ps = connection.prepareStatement(sql);
            int result = ps.executeUpdate();
            
            switch(result) {
                case 1:
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Client successfully deleted!");
                    break;
                default:
                    clearFields();
                    throw new Exception("Something went wrong, please try again later");
            }
            
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            clearFields();
        }
    }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel6.setText("jLabel6");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clients");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        tblClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Address", "Phone", "Email"
            }
        ));
        tblClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClients);

        jLabel1.setText("Name:");

        jLabel2.setText("Address:");

        jLabel3.setText("Phone:");

        jLabel4.setText("Email:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icons/search.png"))); // NOI18N

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icons/create.png"))); // NOI18N
        btnCreate.setToolTipText("Create a new user");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icons/delete.png"))); // NOI18N
        btnDelete.setToolTipText("delete a user by his email");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icons/update.png"))); // NOI18N
        btnUpdate.setToolTipText("Update a user");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(189, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        add();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        remove();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        search();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientsMouseClicked
        setFieldsFromTableData();
    }//GEN-LAST:event_tblClientsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblClients;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
