/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.HospitalAdminRole;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import static Business.Organization.Organization.Type.Doctor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HealthEventWorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anish Gupta
 */
public class ViewDoctorsRegisteredJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewDoctorsRegisteredJPanel
     */
    JPanel userProcessContainer;
    HealthEventWorkRequest request;
    
    Enterprise enterprise;
    
    public ViewDoctorsRegisteredJPanel(JPanel userProcessContainer, HealthEventWorkRequest request, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.enterprise =enterprise;
        populateApprovedTable();
        
    }
    
    public void populateApprovedTable(){
        DefaultTableModel model = (DefaultTableModel)approvedEmployeeJTable.getModel();
        
        model.setRowCount(0);
        
        for(Employee emp : request.getDoctorList()){
            if(request.getEnterpriseList().size()>0){
                for(String enterpriseName : request.getEnterpriseList()){
                    if(enterpriseName == enterprise.getName() ){                                  

                        Object[] row = new Object[1];
                        row[0] = emp;
                        
                        model.addRow(row);
                    }
                }
            }            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        approvedEmployeeJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backJButton3 = new javax.swing.JButton();

        approvedEmployeeJTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        approvedEmployeeJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Approved Doctors"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(approvedEmployeeJTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Doctor Registration Approval Status");

        backJButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backJButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Resources/back.png"))); // NOI18N
        backJButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        backJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(139, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(backJButton3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backJButton3)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton3ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        // TODO add your handling code here:
    }//GEN-LAST:event_backJButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable approvedEmployeeJTable;
    private javax.swing.JButton backJButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}