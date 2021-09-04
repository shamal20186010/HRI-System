package Model;

import DTO.AuthorizerRecordInputDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AuthorizerModel {

    Connection connection;

    public AuthorizerModel() {

        connection = Db.db_connection.getConnection();
    }

    public ListModel<String> lodeTableEmpData(String keyword, DefaultListModel<String> model) throws SQLException {
        String lodeDataByID = "SELECT * FROM hris_system.emp_details where nic = '" + keyword + "'";

        PreparedStatement ps = connection.prepareStatement(lodeDataByID);

        ResultSet rs = ps.executeQuery();
        Object[] rowData;
        String[] dataRow = new String[13];
        while (rs.next()) {
            model.addElement(rs.getString("fullName"));

        }

        return model;
    }

    public String saveContractData(AuthorizerRecordInputDTO authorizerDTO, String userNic) throws SQLException {
        String msg = null;
        String userID = null;
        String userId = "SELECT * FROM hris_system.emp_details where nic = '" + userNic + "'";
        PreparedStatement prs = connection.prepareStatement(userId);
        ResultSet rs = prs.executeQuery();
        if (rs.next()) {
            userID = (rs.getString("id"));

        }
        String query = "INSERT INTO `hris_system`.`emp_contract_data`(`scheduleAttendance`,`breakTime`,`midBreakTime`,`emp_details_id`)VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, authorizerDTO.getStartTime() + "-" + authorizerDTO.getEndTime());
            ps.setString(2, authorizerDTO.getBreakTim());
            ps.setString(3, authorizerDTO.getMidnightTime());
            ps.setString(4, userID);

            ps.execute();
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error" + e.getMessage();
        }

        return msg;
    }

    public TableModel lodeTableHoliday(DefaultTableModel holidayTableModel) {
        holidayTableModel.setRowCount(0);
        String lodeHolidays = "SELECT * FROM hris_system.others_holidays";

        try {
            PreparedStatement ps = connection.prepareStatement(lodeHolidays);
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            holidayTableModel.setRowCount(0);
            String[] dataRow = new String[12];
            while (rs.next()) {
                String id = rs.getString("date");
                String fullName = rs.getString("reason");

                rowData = new Object[]{id, fullName};
                holidayTableModel.addRow(rowData);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return holidayTableModel;
    }

    public String saveHoliday(String holidayDate, String reason) {
        String msg = null;
        String query = "INSERT INTO `hris_system`.`others_holidays`(`date`,`reason`)VALUES(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, holidayDate);
            ps.setString(2, reason);

            ps.execute();
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error" + e.getMessage();
        }

        return msg;
    }
}
