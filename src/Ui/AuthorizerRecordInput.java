package Ui;

import DTO.AuthorizerRecordInputDTO;
import Model.AuthorizerModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AuthorizerRecordInput extends javax.swing.JFrame {

    AuthorizerModel authorizerModel;
    DefaultTableModel holidayTableModel;

    public AuthorizerRecordInput() {
        initComponents();
        authorizerModel = new AuthorizerModel();
        holidayTableModel = (DefaultTableModel) jTable1.getModel();

        jTable1.setModel(authorizerModel.lodeTableHoliday(holidayTableModel));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userNICText = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        startHours = new javax.swing.JComboBox<>();
        startMinutes = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        endMinutes = new javax.swing.JComboBox<>();
        endHours = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        breakTimeHours = new javax.swing.JComboBox<>();
        breakTimeMinutes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        midnightBreakTimeHours = new javax.swing.JComboBox<>();
        midnightBreakTimeMinutes = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        reasonField = new javax.swing.JTextField();
        holidayDateChooser = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(74, 159, 159));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Register HR Basic Data");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 20, 330, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 900, 80);

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setName(""); // NOI18N

        jPanel5.setLayout(null);

        jLabel2.setText("Employee NIC :");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(10, 20, 100, 33);

        userNICText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userNICTextKeyTyped(evt);
            }
        });
        jPanel5.add(userNICText);
        userNICText.setBounds(110, 20, 140, 33);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel6.setText("Start Time :");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(10, 10, 80, 40);

        startHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "01", "02", "03", "04", "05", "06", "07", "08" }));
        jPanel6.add(startHours);
        startHours.setBounds(120, 10, 50, 40);

        startMinutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " ", " " }));
        jPanel6.add(startMinutes);
        startMinutes.setBounds(200, 10, 50, 40);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(30, 130, 270, 60);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel7.setText("Closing Time :");
        jPanel7.add(jLabel7);
        jLabel7.setBounds(10, 10, 100, 40);

        endMinutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " ", " " }));
        jPanel7.add(endMinutes);
        endMinutes.setBounds(200, 10, 50, 40);

        endHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "18", "19", "20", "21", "22", "23", "24", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17" }));
        endHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endHoursActionPerformed(evt);
            }
        });
        jPanel7.add(endHours);
        endHours.setBounds(120, 10, 50, 40);

        jPanel5.add(jPanel7);
        jPanel7.setBounds(30, 200, 270, 60);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel8.setText("Break Time :");
        jPanel8.add(jLabel8);
        jLabel8.setBounds(10, 10, 80, 40);

        breakTimeHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        jPanel8.add(breakTimeHours);
        breakTimeHours.setBounds(120, 10, 50, 40);

        breakTimeMinutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " ", " " }));
        jPanel8.add(breakTimeMinutes);
        breakTimeMinutes.setBounds(200, 10, 50, 40);

        jPanel5.add(jPanel8);
        jPanel8.setBounds(30, 270, 270, 60);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Schedule Attendance", "Break TIme", "Mid Break Time"
            }
        ));
        jScrollPane1.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Break TIme");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Mid Break Time");
        }

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(342, 30, 490, 402);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel9.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel4.setText("Midnight Break Time :");
        jPanel9.add(jLabel4);
        jLabel4.setBounds(10, 10, 110, 40);

        midnightBreakTimeHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        jPanel9.add(midnightBreakTimeHours);
        midnightBreakTimeHours.setBounds(120, 10, 50, 40);

        midnightBreakTimeMinutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " ", " " }));
        jPanel9.add(midnightBreakTimeMinutes);
        midnightBreakTimeMinutes.setBounds(200, 10, 50, 40);

        jPanel5.add(jPanel9);
        jPanel9.setBounds(30, 340, 270, 60);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(120, 430, 90, 40);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList1);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(30, 70, 270, 50);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Employe Contract Data", jPanel3);

        jPanel4.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Holiday Date :");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(50, 90, 90, 33);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Reason :");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(50, 140, 100, 33);

        reasonField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reasonFieldKeyTyped(evt);
            }
        });
        jPanel4.add(reasonField);
        reasonField.setBounds(150, 140, 160, 33);
        jPanel4.add(holidayDateChooser);
        holidayDateChooser.setBounds(150, 90, 160, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(130, 220, 90, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Reason"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(370, 30, 490, 402);

        jTabbedPane1.addTab("Holidays", jPanel4);
        jPanel4.getAccessibleContext().setAccessibleName("");

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 80, 880, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(916, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void endHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endHoursActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        AuthorizerRecordInputDTO authorizerDTO = new AuthorizerRecordInputDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        String sDate = new StringBuilder(startHours.getSelectedItem().toString()).append(":")
                .append(startMinutes.getSelectedItem().toString()).toString();
        String eDate = new StringBuilder(endHours.getSelectedItem().toString()).append(":")
                .append(endMinutes.getSelectedItem().toString()).toString();
        Date startDate = null;
        try {
            startDate = sdf.parse(sDate);
        } catch (ParseException ex) {
            Logger.getLogger(AuthorizerRecordInput.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date endDate = null;
        try {
            endDate = sdf.parse(eDate);
        } catch (ParseException ex) {
            Logger.getLogger(AuthorizerRecordInput.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (startDate.compareTo(endDate) >= 0) {
            JOptionPane.showConfirmDialog(rootPane, "Start date should be less than end date !", "Error", -1, 1);
        } else {
            authorizerDTO.setStartTime(sDate);
            authorizerDTO.setEndTime(eDate);

            authorizerDTO.setBreakTim(new StringBuilder(breakTimeHours.getSelectedItem().toString()).append(":")
                    .append(breakTimeMinutes.getSelectedItem().toString()).toString());
            authorizerDTO.setMidnightTime(new StringBuilder(midnightBreakTimeHours.getSelectedItem().toString()).append(":")
                    .append(midnightBreakTimeMinutes.getSelectedItem().toString()).toString());
            String userNic = userNICText.getText();
            try {
                String register = authorizerModel.saveContractData(authorizerDTO, userNic);
            } catch (SQLException ex) {
                Logger.getLogger(AuthorizerRecordInput.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showConfirmDialog(rootPane, "Success", "Message", -1, 1);

        }

    }//GEN-LAST:event_jButton1ActionPerformed


    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked

    }//GEN-LAST:event_jList1MouseClicked

    private void userNICTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNICTextKeyTyped
        DefaultListModel<String> model = new DefaultListModel<>();
        String keyword = userNICText.getText();

        try {
            jList1.setModel(authorizerModel.lodeTableEmpData(keyword, model));
        } catch (SQLException ex) {
            Logger.getLogger(AuthorizerRecordInput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userNICTextKeyTyped

    private void reasonFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reasonFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_reasonFieldKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String holidayDate = dateFormat.format(holidayDateChooser.getDate());

        String reason = reasonField.getText();

        String register = authorizerModel.saveHoliday(holidayDate, reason);
        jTable1.setModel(authorizerModel.lodeTableHoliday(holidayTableModel));
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AuthorizerRecordInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthorizerRecordInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthorizerRecordInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthorizerRecordInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthorizerRecordInput().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> breakTimeHours;
    private javax.swing.JComboBox<String> breakTimeMinutes;
    private javax.swing.JComboBox<String> endHours;
    private javax.swing.JComboBox<String> endMinutes;
    private com.toedter.calendar.JDateChooser holidayDateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> midnightBreakTimeHours;
    private javax.swing.JComboBox<String> midnightBreakTimeMinutes;
    private javax.swing.JTextField reasonField;
    private javax.swing.JComboBox<String> startHours;
    private javax.swing.JComboBox<String> startMinutes;
    private javax.swing.JTextField userNICText;
    // End of variables declaration//GEN-END:variables
}
