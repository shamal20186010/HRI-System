package Ui;

import DTO.AttendanceRecordInputDTO;
import DTO.AttendanceTypeDTO;
import Model.AttendanceModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AttendanceRecordInput extends javax.swing.JDialog {

    AttendanceModel attendanceModel;
    int dateValue;
    Connection connection;

    private ArrayList<AttendanceTypeDTO> attendanceCatList = new ArrayList<>();

    public AttendanceRecordInput(java.awt.Frame parent, boolean modal, int index, String date, String conSchAttendance) throws SQLException {
        super(parent, modal);

        initComponents();
        connection = Db.db_connection.getConnection();
        System.out.println("Index " + index);
        dateValue = index + 1;
        attendanceModel = new AttendanceModel();

        dateField.setText(date);

        int getContractData = attendanceModel.getContractData(Attendance.userId);
        scheduledAttendanceField.setText(conSchAttendance);
        String schAtt = attendanceModel.getscheduleAtte();
        String[] schAttSplit = schAtt.split("-");
        String[] schAttSplitStart = schAttSplit[0].split(":");
        startHours.setSelectedItem(schAttSplitStart[0]);
        startMinutes.setSelectedItem(schAttSplitStart[1]);
        String[] schAttSplitEnd = schAttSplit[1].split(":");
        endHours.setSelectedItem(schAttSplitEnd[0]);
        endMinutes.setSelectedItem(schAttSplitEnd[1]);
        String breakTim = attendanceModel.getbreakTime();
        String[] breakTime = breakTim.split(":");
        breakTimeHours.setSelectedItem(breakTime[0]);
        breakTimeMinutes.setSelectedItem(breakTime[1]);

        loadAttendanceTypeList();
    }

    private void loadAttendanceTypeList() throws SQLException {
        attendanceCatList = new ArrayList<>();
        String queryAttendanceType = "SELECT * FROM hris_system.attendance_type";
        PreparedStatement ps = connection.prepareStatement(queryAttendanceType);
        ResultSet rs = ps.executeQuery();
        int x = 0;
        while (rs.next()) {
            AttendanceTypeDTO aDTO = new AttendanceTypeDTO();
            aDTO.setIndex(x);
            aDTO.setId(rs.getInt("id"));
            aDTO.setValue(rs.getString("attendanceType"));

            attendanceCatList.add(aDTO);

            ++x;
            System.out.println(aDTO.getValue());
            jComboBox1.addItem(aDTO.getValue());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        scheduledAttendanceField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
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
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        midnightBreakTimeHours = new javax.swing.JComboBox<>();
        midnightBreakTimeMinutes = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Attendance Record Input");

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(74, 159, 159));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Attendance Record Input");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(170, 20, 240, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 560, 60);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(null);
        jPanel3.add(scheduledAttendanceField);
        scheduledAttendanceField.setBounds(350, 10, 200, 40);

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel5.setText("Scheduled  Att :");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(270, 10, 80, 40);
        jPanel3.add(dateField);
        dateField.setBounds(57, 10, 200, 40);

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel9.setText("Date :");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 10, 40, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 90, 560, 60);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel2.setText("Attendance Classification :");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(10, 10, 170, 40);

        jPanel5.add(jComboBox1);
        jComboBox1.setBounds(190, 10, 360, 40);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(10, 160, 560, 60);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel6.setText("Start Time :");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(10, 10, 80, 40);

        startHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        jPanel6.add(startHours);
        startHours.setBounds(120, 10, 50, 40);

        startMinutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " ", " " }));
        jPanel6.add(startMinutes);
        startMinutes.setBounds(200, 10, 50, 40);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(10, 230, 270, 60);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel7.setText("Closing Time :");
        jPanel7.add(jLabel7);
        jLabel7.setBounds(10, 10, 100, 40);

        endMinutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " ", " " }));
        jPanel7.add(endMinutes);
        endMinutes.setBounds(200, 10, 50, 40);

        endHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        endHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endHoursActionPerformed(evt);
            }
        });
        jPanel7.add(endHours);
        endHours.setBounds(120, 10, 50, 40);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(300, 230, 270, 60);

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

        jPanel1.add(jPanel8);
        jPanel8.setBounds(10, 300, 270, 60);

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

        jPanel1.add(jPanel9);
        jPanel9.setBounds(300, 300, 270, 60);

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveButton.setText("Register");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        printButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        printButton.setText("Cancel");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(printButton)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10);
        jPanel10.setBounds(10, 390, 560, 50);

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

        setSize(new java.awt.Dimension(599, 494));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_printButtonActionPerformed

    private void endHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endHoursActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            AttendanceRecordInputDTO attendanceDTO = new AttendanceRecordInputDTO();
            attendanceDTO.setDate(dateField.getText());
            attendanceDTO.setConSchAttendance(scheduledAttendanceField.getText());

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

            String sDate = new StringBuilder(startHours.getSelectedItem().toString()).append(":")
                    .append(startMinutes.getSelectedItem().toString()).toString();
            String eDate = new StringBuilder(endHours.getSelectedItem().toString()).append(":")
                    .append(endMinutes.getSelectedItem().toString()).toString();
            Date startDate = sdf.parse(sDate);
            Date endDate = sdf.parse(eDate);

            if (startDate.compareTo(endDate) >= 0) {
                JOptionPane.showConfirmDialog(rootPane, "Start date should be less than end date !", "Error", -1, 1);
            } else {
                attendanceDTO.setStartTime(sDate);
                attendanceDTO.setEndTime(eDate);

                attendanceDTO.setBreakTim(new StringBuilder(breakTimeHours.getSelectedItem().toString()).append(":")
                        .append(breakTimeMinutes.getSelectedItem().toString()).toString());
                attendanceDTO.setMidnightTime(new StringBuilder(midnightBreakTimeHours.getSelectedItem().toString()).append(":")
                        .append(midnightBreakTimeMinutes.getSelectedItem().toString()).toString());

                int index = jComboBox1.getSelectedIndex();
                attendanceCatList.forEach(cat -> {
                    if (cat.getIndex() == index) {
                        attendanceDTO.setAttendanceType(cat.getId());
                    }
                });
                int classificatioco = jComboBox1.getSelectedIndex();
                int classificatioNumber = classificatioco + 1;

                try {
                    try {
                        String register = attendanceModel.registerAtt(attendanceDTO, Attendance.userId);
                    } catch (ParseException ex) {
                        Logger.getLogger(AttendanceRecordInput.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AttendanceRecordInput.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showConfirmDialog(rootPane, "Success", "Message", -1, 1);
                //refresh
                setVisible(false);
                setVisible(false);

                Attendance a = new Attendance();

                a.setVisible(true);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AttendanceRecordInput.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AttendanceRecordInput.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AttendanceRecordInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceRecordInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceRecordInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceRecordInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AttendanceRecordInput dialog = null;
                try {
                    dialog = new AttendanceRecordInput(new javax.swing.JFrame(), true, 0, null, null);
                } catch (SQLException ex) {
                    Logger.getLogger(AttendanceRecordInput.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JComboBox<String> breakTimeHours;
    private javax.swing.JComboBox<String> breakTimeMinutes;
    private javax.swing.JTextField dateField;
    private javax.swing.JComboBox<String> endHours;
    private javax.swing.JComboBox<String> endMinutes;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JComboBox<String> midnightBreakTimeHours;
    private javax.swing.JComboBox<String> midnightBreakTimeMinutes;
    private javax.swing.JButton printButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField scheduledAttendanceField;
    private javax.swing.JComboBox<String> startHours;
    private javax.swing.JComboBox<String> startMinutes;
    // End of variables declaration//GEN-END:variables
}
