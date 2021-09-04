package Ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

public class AttendanceReport extends javax.swing.JFrame {

    Connection connection;

    public AttendanceReport() {
        initComponents();
        connection = Db.db_connection.getConnection();

    }

    AttendanceReport(boolean rootPaneCheckingEnabled, boolean b) {
        initComponents();
        this.setVisible(true);
        connection = Db.db_connection.getConnection();
    }

    AttendanceReport(boolean rootPaneCheckingEnabled, boolean b, String nic) {
        initComponents();
        this.setVisible(true);
        connection = Db.db_connection.getConnection();

        if (nic != null) {
            userNICText.setText(nic);
            generateReport();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userNICText = new javax.swing.JTextField();
        yearCho = new com.toedter.calendar.JYearChooser();
        monthCho = new com.toedter.calendar.JMonthChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(74, 159, 159));
        jPanel2.setLayout(null);

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 21, 73, 33);

        jLabel1.setText("Employee NIC :");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(510, 20, 100, 33);
        jPanel2.add(userNICText);
        userNICText.setBounds(606, 20, 110, 33);
        jPanel2.add(yearCho);
        yearCho.setBounds(720, 20, 60, 30);

        monthCho.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                monthChoPropertyChange(evt);
            }
        });
        jPanel2.add(monthCho);
        monthCho.setBounds(780, 20, 110, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 900, 80);
        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 100, 880, 540);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generateReport();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void generateReport() {
        String nic = userNICText.getText();
        String month = String.valueOf(monthCho.getMonth() + 1);

        if (Integer.parseInt(month) < 10) {
            month = "0" + month;
        }
        int yearCho = this.yearCho.getValue();
        String date = yearCho + "-" + month;
        if (date.equals("") & nic.equals("")) {
            JOptionPane.showMessageDialog(null, "ErrorMsg", "User NIC & date is need for print !", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean registered = false;
            String query = "SELECT id FROM hris_system.emp_details where nic = '" + nic + "'";

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    registered = true;
                }

            } catch (SQLException ex) {
                Logger.getLogger(RegisterReport.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!registered) {
                JOptionPane.showMessageDialog(null, "ErrorMsg", "The entered user NIC has not registered", JOptionPane.ERROR_MESSAGE);
            } else {
                String reportpath = "C:\\Users\\Shamal Wassana\\JaspersoftWorkspace\\MyReports\\HRIS\\Attendance.jrxml";

                //parameters
                Map params = new HashMap<String, Object>();
                params.put("userNIC", nic);
                params.put("date", date + "%");

                try {
                    //compile it
                    JasperReport jr = JasperCompileManager.compileReport(reportpath);
                    JasperPrint jp = JasperFillManager.fillReport(jr, params, Db.db_connection.getConnection());
                    JRViewer jv = new JRViewer(jp);

                    jTabbedPane1.add(jv);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void monthChoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_monthChoPropertyChange

    }//GEN-LAST:event_monthChoPropertyChange

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
            java.util.logging.Logger.getLogger(AttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JMonthChooser monthCho;
    private javax.swing.JTextField userNICText;
    private com.toedter.calendar.JYearChooser yearCho;
    // End of variables declaration//GEN-END:variables
}
