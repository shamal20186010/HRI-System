package Model;

import DTO.UserDetailsDTO;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class RegistrationModel {

    Connection connection;

    public RegistrationModel() {
        connection = Db.db_connection.getConnection();
    }
    private String epf;

    public String getEpf() {
        return epf;
    }

    public void setEpf(String epf) {
        this.epf = epf;
    }

    public String register(UserDetailsDTO userDTO) throws SQLException {

        String msg = null;

        String query = "INSERT INTO `hris_system`.`emp_details`(`initials`,`useName`,`surname`,`nic`,"
                + "`dateOfBirth`,`fullName`,`country`,`civilStatus`,`gender`,`nationalty`,`race`,`religion`,"
                + "`epfNumber`,`dateOfJoin`,`position`,`department`,`isAuthorizer`,`user_category_id`"
                + ")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, userDTO.getInitials());
            ps.setString(2, userDTO.getUseName());
            ps.setString(3, userDTO.getSurName());
            ps.setString(4, userDTO.getNicNo());
            ps.setString(5, userDTO.getDateOfBirth());
            ps.setString(6, userDTO.getFullName());
            ps.setString(7, userDTO.getCountry());
            ps.setString(8, userDTO.getCivilStatus());
            ps.setString(9, userDTO.getGender());
            ps.setString(10, userDTO.getNationalty());
            ps.setString(11, userDTO.getRace());
            ps.setString(12, userDTO.getRiligion());
            ps.setInt(13, userDTO.getEpf());
            ps.setDate(14, new java.sql.Date(userDTO.getDateOfJoin().getTime()));
            ps.setString(15, userDTO.getPosition());//position
            ps.setString(16, "HR");
            ps.setInt(17, userDTO.getAuthrozers());
            ps.setInt(18, userDTO.getUserCategory());

            ps.execute();

            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();

            msg = "Error" + e.getMessage();

        }

        String userId = null;
        String queryid = "SELECT id FROM hris_system.emp_details ORDER BY id DESC LIMIT 1";
        PreparedStatement prs = connection.prepareStatement(queryid);
        ResultSet rs = prs.executeQuery();
        if (rs.next()) {
            userId = (rs.getString("id"));

        }

        String sqlQuery = "INSERT INTO `hris_system`.`permanent_address`(`permanentAddress`,`city`,"
                + "`province`,`district`,`electorate`,`gnDivision`,`telHome`,`telMobile`,`contactName`,"
                + "`distance`,`emp_details_id`)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, userDTO.getPermanentAddress());
            ps.setString(2, userDTO.getCity());
            ps.setString(3, userDTO.getProvince());
            ps.setString(4, userDTO.getDistrict());
            ps.setString(5, userDTO.getElectorate());
            ps.setString(6, userDTO.getGnDivision());
            ps.setString(7, userDTO.getTelHome());
            ps.setString(8, userDTO.getTelMobile());
            ps.setString(9, userDTO.getContactName());
            ps.setString(10, userDTO.getDistance());
            ps.setString(11, userId);

            ps.execute();

            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();

            msg = "Error" + e.getMessage();

        }

        String temporaryAddInsert = "INSERT INTO `hris_system`.`temporary_address`(`temporaryAddress`,`city`,"
                + "`tel`,`contactNameTemp`,`distance`,`emp_details_id`)VALUES(?,?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(temporaryAddInsert);
            ps.setString(1, userDTO.getTemporaryAddress());
            ps.setString(2, userDTO.getCityTemp());
            ps.setString(3, userDTO.getTelTemp());
            ps.setString(4, userDTO.getContactNameTemp());
            ps.setString(5, userDTO.getDistance());
            ps.setString(6, userId);

            ps.execute();

            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();

            msg = "Error" + e.getMessage();

        }

        return msg;

    }

    public int getLastEPFNo() throws SQLException {
        String queryEpf = "SELECT epfNumber FROM hris_system.emp_details ORDER BY id DESC LIMIT 1";
        PreparedStatement ps = connection.prepareStatement(queryEpf);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            setEpf(rs.getString("epfNumber"));
            System.out.println(epf);

        }
        return Integer.parseInt(epf);
    }

    public TableModel lodeTableEmp(String nic, DefaultTableModel empTableModel) {
        empTableModel.setRowCount(0);
        String lodeDataByID = "SELECT * FROM hris_system.emp_details WHERE nic LIKE '" + nic + "%'";

        try {
            PreparedStatement ps = connection.prepareStatement(lodeDataByID);
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            empTableModel.setRowCount(0);
            String[] dataRow = new String[12];
            while (rs.next()) {
                String id = rs.getString("id");
                String fullName = rs.getString("fullName");
                String epfNo = rs.getString("epfNumber");
                String nicNo = rs.getString("nic");
                String position = rs.getString("position");
                String dateOfbirth = rs.getString("dateOfBirth");
                String dateOfjoin = rs.getString("dateOfJoin");

                rowData = new Object[]{id, fullName, epfNo, nicNo, position, dateOfbirth, dateOfjoin};
                empTableModel.addRow(rowData);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empTableModel;
    }

    public String getId() throws SQLException {
        String id = null;
        String queryEpf = "SELECT id FROM hris_system.emp_details ORDER BY id DESC LIMIT 1";
        PreparedStatement ps = connection.prepareStatement(queryEpf);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            id = (rs.getString("id"));
        }
        return id;
    }

    public String setUserLogin(String username, String password, String id) throws SQLException {
        String msg = null;
        String query = "INSERT INTO `hris_system`.`user_credential`(`username`,`password`,`emp_details_id`)VALUES(?,?,?)";
        try {
            PreparedStatement pss = connection.prepareStatement(query);
            pss.setString(1, username);
            pss.setString(2, password);
            pss.setString(3, id);

            pss.execute();

            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();

            msg = "Error" + e.getMessage();

        }

        return msg;
    }

}
