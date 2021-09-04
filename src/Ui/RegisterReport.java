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

public class RegisterReport extends javax.swing.JDialog {

    Connection connection;

    public RegisterReport(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        connection = Db.db_connection.getConnection();
    }

    RegisterReport(boolean rootPaneCheckingEnabled, boolean b) {
        initComponents();
        this.setVisible(true);
        connection = Db.db_connection.getConnection();
    }

    RegisterReport(boolean rootPaneCheckingEnabled, boolean b, String nic) {
        initComponents();
        this.setVisible(true);
        connection = Db.db_connection.getConnection();

        if (nic != null) {
            nicText.setText(nic);
            generateReport();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        nicText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
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
        jButton1.setBounds(801, 18, 73, 40);
        jPanel2.add(nicText);
        nicText.setBounds(673, 21, 120, 33);

        jLabel1.setText("Employee NIC :");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(570, 20, 100, 33);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 900, 80);
        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 100, 880, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(916, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generateReport();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void generateReport() {
        String nic = nicText.getText();
        if (nic.equals("")) {
            JOptionPane.showMessageDialog(null, "ErrorMsg", "User NIC is need for print !", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean registered = false;
            String query = "SELECT id FROM hris_system.emp_details where nic = '" + nic + "'";
            PreparedStatement ps;
            try {
                ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    registered = true;
                }

            } catch (SQLException ex) {
                Logger.getLogger(RegisterReport.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!registered) {
                JOptionPane.showMessageDialog(null, "ErrorMsg", "The entered user NIC has not registered", JOptionPane.ERROR_MESSAGE);
            } else {
                String reportpath = "C:\\Users\\Shamal Wassana\\JaspersoftWorkspace\\MyReports\\HRIS\\Registration.jrxml";

                //parameters
                Map params = new HashMap<String, Object>();
                params.put("userNIC", nic);

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
            java.util.logging.Logger.getLogger(RegisterReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegisterReport dialog = new RegisterReport(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nicText;
    // End of variables declaration//GEN-END:variables
}
