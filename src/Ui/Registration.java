package Ui;

import DTO.UserCategoryDTO;
import DTO.UserDetailsDTO;
import Model.RegistrationModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Registration extends javax.swing.JFrame {

    Connection connection;

    RegistrationModel registrationModel;

    private ArrayList<UserCategoryDTO> userCatList = new ArrayList<>();

    public Registration() throws SQLException {
        initComponents();
        connection = Db.db_connection.getConnection();
        registrationModel = new RegistrationModel();
        jDateChooser1.getJCalendar().setMinSelectableDate(new Date());
        setEPFNo();

        loadCategoryList();

    }

    private void setEPFNo() throws SQLException {
        epfField.setText(String.valueOf(registrationModel.getLastEPFNo() + 1));
    }

    private void loadCategoryList() throws SQLException {
        userCatList = new ArrayList<>();
        String queryUserCategory = "SELECT * FROM user_category";
        PreparedStatement ps = connection.prepareStatement(queryUserCategory);
        ResultSet rs = ps.executeQuery();
        int x = 0;
        while (rs.next()) {
            UserCategoryDTO uDTO = new UserCategoryDTO();
            uDTO.setIndex(x);
            uDTO.setId(rs.getInt("id"));
            uDTO.setValue(rs.getString("category"));

            userCatList.add(uDTO);

            ++x;
            userCategoryComboBox.addItem(uDTO.getValue());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        epfField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        initialsField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        useNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        surNameField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nicNoField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateOfBirthDataChoocer = new com.toedter.calendar.JDateChooser();
        permenenteAddressField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        civilStatusComboBox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        nationaltyComboBox = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        raceComboBox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        riligionComboBox = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        fullNameField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        provinceComboBox = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        districtComboBox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        electorateComboBox = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        gnDivisionComboBox = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        telMobileField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        contaktNameField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        policeDivisisionField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        temporaryAddressField = new javax.swing.JTextField();
        telHomeField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cityFieldTemp = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        telTemporaryField = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        contactNameTempField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        distanceFieldTemp = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        distanceField1 = new javax.swing.JTextField();
        userCategoryComboBox = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        authrozersCheck = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        positionField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registration");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(234, 234, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(74, 159, 159));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(1024, 768));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Company ABC");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 11, 100, 24);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("EPF :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(380, 10, 29, 30);

        epfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                epfFieldActionPerformed(evt);
            }
        });
        jPanel2.add(epfField);
        epfField.setBounds(410, 10, 92, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Date of join :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(530, 10, 90, 30);
        jPanel2.add(jDateChooser1);
        jDateChooser1.setBounds(620, 10, 160, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 800, 50);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(110, 110, 0, 2);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel1.setText("INITIALS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 70, 60, 15);

        initialsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initialsFieldActionPerformed(evt);
            }
        });
        jPanel1.add(initialsField);
        initialsField.setBounds(30, 90, 80, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel5.setText("USE NAME");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(170, 70, 80, 15);

        useNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useNameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(useNameField);
        useNameField.setBounds(170, 90, 100, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel6.setText("SURNAME");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(310, 70, 62, 15);

        surNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surNameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(surNameField);
        surNameField.setBounds(310, 90, 120, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel7.setText("NIC NO");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(480, 70, 45, 15);

        nicNoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicNoFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nicNoField);
        nicNoField.setBounds(480, 90, 100, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel8.setText("DATE OF BIRTH");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(630, 70, 101, 15);
        jPanel1.add(dateOfBirthDataChoocer);
        dateOfBirthDataChoocer.setBounds(630, 90, 150, 30);

        permenenteAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permenenteAddressFieldActionPerformed(evt);
            }
        });
        jPanel1.add(permenenteAddressField);
        permenenteAddressField.setBounds(190, 250, 520, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel9.setText("COUNTRY");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 180, 64, 15);

        countryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SRI LANKA", "INDIA", "AUSTRALIA", "JAPAN", " " }));
        jPanel1.add(countryComboBox);
        countryComboBox.setBounds(30, 200, 100, 30);

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel10.setText("CIVIL STATUS");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(150, 180, 88, 15);

        civilStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MARRIED", "UNMARRIED" }));
        jPanel1.add(civilStatusComboBox);
        civilStatusComboBox.setBounds(150, 200, 100, 30);

        jLabel11.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel11.setText("GENDER");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(280, 180, 51, 15);

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAIL", "FEMAIL" }));
        jPanel1.add(genderComboBox);
        genderComboBox.setBounds(280, 200, 110, 30);

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel12.setText("NATIONALTY");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(420, 180, 86, 15);

        nationaltyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sri Lankan", "Indian", "Chineese" }));
        jPanel1.add(nationaltyComboBox);
        nationaltyComboBox.setBounds(420, 200, 110, 30);

        jLabel13.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel13.setText("RACE");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(560, 180, 35, 15);

        raceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinhalese", "Tamil\t", "Muslim", "Burgher", "Malay" }));
        jPanel1.add(raceComboBox);
        raceComboBox.setBounds(560, 200, 100, 30);

        jLabel14.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel14.setText("RELIGION");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(690, 180, 70, 15);

        riligionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buddhist", "Christian", "Roman Catholic", "Hindu", "Islam" }));
        jPanel1.add(riligionComboBox);
        riligionComboBox.setBounds(690, 200, 110, 30);

        jLabel15.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel15.setText("FULL NAME :");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(30, 140, 90, 30);

        fullNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(fullNameField);
        fullNameField.setBounds(130, 140, 520, 30);

        jLabel16.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel16.setText("CITY");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(30, 300, 31, 15);

        jLabel17.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel17.setText("PROVINCE");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(150, 300, 64, 15);

        provinceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Central", "Eastern", "North", "North Central", "North Western", "Sabaragamuwa", "Southern", "Uva", "Western" }));
        jPanel1.add(provinceComboBox);
        provinceComboBox.setBounds(150, 320, 80, 30);

        jLabel18.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel18.setText("DISTRICT");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(280, 300, 61, 15);

        districtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ampara", "Kandy", "Mathale", "Nuwara Eliya", "Gampaha" }));
        jPanel1.add(districtComboBox);
        districtComboBox.setBounds(280, 320, 80, 30);

        jLabel19.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel19.setText("ELECTORATE");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(420, 300, 100, 15);

        electorateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ABC", "DEF" }));
        jPanel1.add(electorateComboBox);
        electorateComboBox.setBounds(420, 320, 80, 30);

        jLabel20.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel20.setText("G.N DIVISION");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(560, 300, 100, 15);

        gnDivisionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AB", "CD", "EF" }));
        jPanel1.add(gnDivisionComboBox);
        gnDivisionComboBox.setBounds(560, 320, 80, 30);

        jLabel21.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel21.setText("TEL [HOME]");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(30, 370, 80, 15);

        cityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFieldActionPerformed(evt);
            }
        });
        jPanel1.add(cityField);
        cityField.setBounds(30, 320, 110, 30);

        jLabel22.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel22.setText("TEL [MOBILE]");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(170, 370, 90, 15);

        telMobileField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telMobileFieldActionPerformed(evt);
            }
        });
        jPanel1.add(telMobileField);
        telMobileField.setBounds(170, 390, 120, 30);

        jLabel23.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel23.setText("CONTACT NAME");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(310, 370, 106, 15);

        contaktNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contaktNameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(contaktNameField);
        contaktNameField.setBounds(310, 390, 150, 30);

        jLabel24.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel24.setText("DISTANCE [KM]");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(480, 370, 97, 15);

        policeDivisisionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                policeDivisisionFieldActionPerformed(evt);
            }
        });
        jPanel1.add(policeDivisisionField);
        policeDivisisionField.setBounds(630, 390, 130, 30);

        jLabel25.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel25.setText("POLICE DIVISION");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(630, 370, 105, 15);

        jLabel26.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel26.setText("TEMPORARY ADDRESS :");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(30, 440, 160, 30);

        temporaryAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temporaryAddressFieldActionPerformed(evt);
            }
        });
        jPanel1.add(temporaryAddressField);
        temporaryAddressField.setBounds(190, 440, 520, 30);

        telHomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telHomeFieldActionPerformed(evt);
            }
        });
        jPanel1.add(telHomeField);
        telHomeField.setBounds(30, 390, 120, 30);

        jLabel27.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel27.setText("User Categorys");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(30, 550, 100, 15);

        cityFieldTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFieldTempActionPerformed(evt);
            }
        });
        jPanel1.add(cityFieldTemp);
        cityFieldTemp.setBounds(30, 500, 120, 30);

        jLabel28.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel28.setText("TEL [TEMPORARY]");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(190, 480, 120, 15);

        telTemporaryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telTemporaryFieldActionPerformed(evt);
            }
        });
        jPanel1.add(telTemporaryField);
        telTemporaryField.setBounds(190, 500, 130, 30);

        jLabel29.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel29.setText("Position");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(300, 550, 120, 15);

        contactNameTempField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNameTempFieldActionPerformed(evt);
            }
        });
        jPanel1.add(contactNameTempField);
        contactNameTempField.setBounds(370, 500, 140, 30);

        jLabel30.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel30.setText("DISTANCE [KM]");
        jPanel1.add(jLabel30);
        jLabel30.setBounds(550, 480, 97, 15);

        distanceFieldTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceFieldTempActionPerformed(evt);
            }
        });
        jPanel1.add(distanceFieldTemp);
        distanceFieldTemp.setBounds(550, 500, 120, 30);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(null);

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel3.add(saveButton);
        saveButton.setBounds(530, 10, 80, 30);

        printButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        jPanel3.add(printButton);
        printButton.setBounds(630, 10, 70, 30);

        closeButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        jPanel3.add(closeButton);
        closeButton.setBounds(720, 10, 70, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 610, 800, 50);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(30, 240, 770, 2);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(30, 430, 770, 2);

        jLabel31.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel31.setText("PERMANENT ADDRESS :");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(30, 250, 160, 30);

        distanceField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceField1ActionPerformed(evt);
            }
        });
        jPanel1.add(distanceField1);
        distanceField1.setBounds(480, 390, 100, 30);

        userCategoryComboBox.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jPanel1.add(userCategoryComboBox);
        userCategoryComboBox.setBounds(30, 570, 110, 30);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(30, 550, 770, 2);

        authrozersCheck.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        authrozersCheck.setText("Authrozers");
        authrozersCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authrozersCheckActionPerformed(evt);
            }
        });
        jPanel1.add(authrozersCheck);
        authrozersCheck.setBounds(170, 570, 120, 30);

        jLabel32.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel32.setText("CITY");
        jPanel1.add(jLabel32);
        jLabel32.setBounds(30, 480, 31, 15);

        jLabel33.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel33.setText("CONTACT NAME");
        jPanel1.add(jLabel33);
        jLabel33.setBounds(370, 480, 120, 15);
        jPanel1.add(positionField);
        positionField.setBounds(300, 570, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(835, 712));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void epfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_epfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_epfFieldActionPerformed

    private void initialsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initialsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initialsFieldActionPerformed

    private void useNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useNameFieldActionPerformed

    private void surNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surNameFieldActionPerformed

    private void nicNoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicNoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicNoFieldActionPerformed

    private void permenenteAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permenenteAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permenenteAddressFieldActionPerformed

    private void fullNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullNameFieldActionPerformed

    private void cityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityFieldActionPerformed

    private void telMobileFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telMobileFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telMobileFieldActionPerformed

    private void contaktNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contaktNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contaktNameFieldActionPerformed

    private void policeDivisisionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_policeDivisisionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_policeDivisisionFieldActionPerformed

    private void temporaryAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temporaryAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_temporaryAddressFieldActionPerformed

    private void telHomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telHomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telHomeFieldActionPerformed

    private void cityFieldTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFieldTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityFieldTempActionPerformed

    private void telTemporaryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telTemporaryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telTemporaryFieldActionPerformed

    private void contactNameTempFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNameTempFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNameTempFieldActionPerformed

    private void distanceFieldTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceFieldTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanceFieldTempActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        new RegisterReport(rootPaneCheckingEnabled, true).setVisible(true);
    }//GEN-LAST:event_printButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        UserDetailsDTO userDTO = new UserDetailsDTO();
        userDTO.setEpf(Integer.parseInt(epfField.getText()));
        userDTO.setDateOfJoin(jDateChooser1.getDate());
        userDTO.setInitials(initialsField.getText());
        userDTO.setUseName(useNameField.getText());
        userDTO.setSurName(surNameField.getText());
        userDTO.setNicNo(nicNoField.getText());
        String date = dateOfBirthDataChoocer.getDate().toString();
        userDTO.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirthDataChoocer.getDate()));
        userDTO.setFullName(fullNameField.getText());
        userDTO.setCountry(countryComboBox.getSelectedItem().toString());
        userDTO.setCivilStatus(civilStatusComboBox.getSelectedItem().toString());
        userDTO.setGender(genderComboBox.getSelectedItem().toString());
        userDTO.setNationalty(nationaltyComboBox.getSelectedItem().toString());
        userDTO.setRiligion(riligionComboBox.getSelectedItem().toString());
        userDTO.setPermanentAddress(permenenteAddressField.getText());
        userDTO.setCity(cityField.getText());
        userDTO.setProvince(provinceComboBox.getSelectedItem().toString());
        userDTO.setDistrict(districtComboBox.getSelectedItem().toString());
        userDTO.setElectorate(electorateComboBox.getSelectedItem().toString());
        userDTO.setGnDivision(gnDivisionComboBox.getSelectedItem().toString());
        userDTO.setTelHome(telHomeField.getText());
        userDTO.setTelMobile(telMobileField.getText());
        userDTO.setContactName(contaktNameField.getText());
        userDTO.setDistance(distanceField1.getText());
        userDTO.setPoliceDivision(policeDivisisionField.getText());
        userDTO.setTemporaryAddress(temporaryAddressField.getText());
        userDTO.setCityTemp(cityFieldTemp.getText());
        userDTO.setTelTemp(telTemporaryField.getText());
        userDTO.setContactNameTemp(contactNameTempField.getText());
        userDTO.setDistanceTemp(distanceFieldTemp.getText());
        userDTO.setRace(raceComboBox.getSelectedItem().toString());
        userDTO.setPosition(positionField.getText());
        int index = userCategoryComboBox.getSelectedIndex();
        userCatList.forEach(cat -> {
            if (cat.getIndex() == index) {
                userDTO.setUserCategory(cat.getId());
            }
        });
        userDTO.setAuthrozers((authrozersCheck.isSelected()) ? 1 : 0);

        if (!(nicNoField.getText().length() == 10 || nicNoField.getText().length() == 12)) {
            JOptionPane.showMessageDialog(null, "The NIC number length should be 10 or 12", "ErrorMsg", JOptionPane.ERROR_MESSAGE);
        } else {

            boolean registered = false;
            String query = "SELECT id FROM hris_system.emp_details where nic = '" + nicNoField.getText() + "'";
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

            if (registered) {
                JOptionPane.showMessageDialog(null, "The entered user NIC has alrady registered", "ErrorMsg", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    String registerEmp = registrationModel.register(userDTO);
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    String empId = registrationModel.getId();
                    GenarateLogin.id = empId;
                    GenarateLogin g = null;
                    g = new GenarateLogin();
                    g.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void distanceField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distanceField1ActionPerformed

    private void authrozersCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authrozersCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authrozersCheckActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Registration().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox authrozersCheck;
    private javax.swing.JTextField cityField;
    private javax.swing.JTextField cityFieldTemp;
    private javax.swing.JComboBox<String> civilStatusComboBox;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextField contactNameTempField;
    private javax.swing.JTextField contaktNameField;
    private javax.swing.JComboBox<String> countryComboBox;
    private com.toedter.calendar.JDateChooser dateOfBirthDataChoocer;
    private javax.swing.JTextField distanceField1;
    private javax.swing.JTextField distanceFieldTemp;
    private javax.swing.JComboBox<String> districtComboBox;
    private javax.swing.JComboBox<String> electorateComboBox;
    private javax.swing.JTextField epfField;
    private javax.swing.JTextField fullNameField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JComboBox<String> gnDivisionComboBox;
    private javax.swing.JTextField initialsField;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JComboBox<String> nationaltyComboBox;
    private javax.swing.JTextField nicNoField;
    private javax.swing.JTextField permenenteAddressField;
    private javax.swing.JTextField policeDivisisionField;
    private javax.swing.JTextField positionField;
    private javax.swing.JButton printButton;
    private javax.swing.JComboBox<String> provinceComboBox;
    private javax.swing.JComboBox<String> raceComboBox;
    private javax.swing.JComboBox<String> riligionComboBox;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField surNameField;
    private javax.swing.JTextField telHomeField;
    private javax.swing.JTextField telMobileField;
    private javax.swing.JTextField telTemporaryField;
    private javax.swing.JTextField temporaryAddressField;
    private javax.swing.JTextField useNameField;
    private javax.swing.JComboBox<String> userCategoryComboBox;
    // End of variables declaration//GEN-END:variables
}
