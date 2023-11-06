/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Supplier;
import model.SupplierDirectory;
import ui.admin.AdminWorkAreaJPanel;
import ui.supplier.SupplierWorkAreaJPanel;

/**
 *
 * @author archil
 */
public class LoginScreen extends javax.swing.JPanel {

    JPanel mainWorkArea;
    SupplierDirectory supplierDirectory;
    Supplier selectedSupplier = null;
    
    
    /**
     * Creates new form LoginScreen
     */
    public LoginScreen(JPanel mainWorkArea, SupplierDirectory supplierDirectory) {
        initComponents();
        
        this.mainWorkArea = mainWorkArea;
        this.supplierDirectory = supplierDirectory;
        
        populateRoleCombo();
        populateSupplierCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        cmbRoles = new javax.swing.JComboBox<>();
        lblRole = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        cmbSuppliers = new javax.swing.JComboBox<>();
        lblSupplier = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 51));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Welcome to Lab 4");

        cmbRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolesActionPerformed(evt);
            }
        });

        lblRole.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRole.setText("Choose Role:");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        cmbSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSuppliersActionPerformed(evt);
            }
        });

        lblSupplier.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSupplier.setText("Select Supplier:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRole, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin)
                    .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(294, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblRole, lblSupplier});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblTitle)
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplier))
                .addGap(23, 23, 23)
                .addComponent(btnLogin)
                .addContainerGap(288, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSuppliersActionPerformed
        // TODO add your handling code here:
        
        if (cmbSuppliers.getSelectedItem() == null) return;
        selectedSupplier = (Supplier) cmbSuppliers.getSelectedItem();
        
        
    }//GEN-LAST:event_cmbSuppliersActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        JPanel selectedPanel = (JPanel) cmbRoles.getSelectedItem();
        
        if (selectedPanel.getClass() ==SupplierWorkAreaJPanel.class){
            if (selectedSupplier == null) {
                JOptionPane.showMessageDialog(this, "Please Select a Supplier to Login Under Supplier Role.");
                return;
            } else {
                selectedPanel = new SupplierWorkAreaJPanel(mainWorkArea, selectedSupplier);
            }
        }
        
        mainWorkArea.add("WorkAreaJPanel",selectedPanel);
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.next(mainWorkArea);
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void cmbRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRolesActionPerformed
        // TODO add your handling code here:
        updateSupplierVisibility();
    }//GEN-LAST:event_cmbRolesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<Object> cmbRoles;
    private javax.swing.JComboBox<Supplier> cmbSuppliers;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables

    private void populateRoleCombo() {
        
        cmbRoles.removeAllItems();
        
        AdminWorkAreaJPanel adminPanel = new AdminWorkAreaJPanel(mainWorkArea, supplierDirectory);
        SupplierWorkAreaJPanel supplierPanel = new SupplierWorkAreaJPanel(mainWorkArea, selectedSupplier);
        
        cmbRoles.addItem(adminPanel);
        cmbRoles.addItem(supplierPanel);      

    }

    public void populateSupplierCombo() {
       
        cmbSuppliers.removeAllItems();
        
        for(Supplier supplier : supplierDirectory.getSupplierList()){
            cmbSuppliers.addItem(supplier);
        }
    }

    private void updateSupplierVisibility() {
        
        if((cmbRoles.getSelectedItem()==null) || (cmbRoles.getSelectedItem().getClass()== AdminWorkAreaJPanel.class)){
            selectedSupplier = null;
            lblSupplier.setVisible(false);
            cmbSuppliers.setVisible(false);
            return;
        }
        
        if(cmbRoles.getSelectedItem().getClass()==SupplierWorkAreaJPanel.class){
            lblSupplier.setVisible(true);
            cmbSuppliers.setVisible(true);
            
        }
         
    }
}
