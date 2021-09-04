package Model;

import DTO.AttendanceRecordInputDTO;
import Ui.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AttendanceModel {

    Connection connection;
    private String ID = null;
    private String scheduleAtte = null;
    private String breakTime = null;
    public Object getSA;

    public AttendanceModel() {
        connection = Db.db_connection.getConnection();
    }

    public TableModel lodeTableAttendanceDetails(DefaultTableModel attendanceTableMOdel, String monthCho,
            int yearCho, int userId, String place) throws SQLException, ParseException {
        String schAtt = null;
        String brkTime = null;
        String monthDate = null;

        attendanceTableMOdel.setRowCount(0);
        String Query1 = "SELECT scheduleAttendance,breakTime FROM hris_system.emp_contract_data "
                + "where emp_details_id = '" + Attendance.userId + "'";
        PreparedStatement ps = connection.prepareStatement(Query1);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            schAtt = rs.getString("scheduleAttendance");
            brkTime = rs.getString("breakTime");

        }

        String monthString = yearCho + "-" + monthCho;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Date date = dateFormat.parse(monthString);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int myMonth = cal.get(Calendar.MONTH);

        ArrayList<String> otherHolidays = new ArrayList<>();
        String query = "SELECT date FROM hris_system.others_holidays WHERE date LIKE '" + yearCho + "%'";
        PreparedStatement pss = connection.prepareStatement(query);
        ResultSet rss = pss.executeQuery();
        while (rss.next()) {
            String dateSplit[] = rss.getString("date").split("-");
            otherHolidays.add(dateSplit[1] + "-" + dateSplit[2]);
        }
        while (myMonth == cal.get(Calendar.MONTH)) {
            String[] split = cal.getTime().toString().split(" ");

            monthDate = monthCho + "-" + split[2];
            String attnCls = null;
            for (String otherHoliday : otherHolidays) {
                if (monthDate.equals(otherHoliday)) {
                    attnCls = "Holiday";
                }
            }

            String setdate = null;
            setdate = yearCho + "-" + monthDate;

            String startTime = null;
            String endTime = null;
            String breakTim = null;
            String midnightTime = null;
            String approStatus = null;
            String actualWorkingHours = null;

            String markedAttendanceData = "SELECT ea.startTime,ea.endTime,ea.breakTime,ea.midNightBreakTime,ea.approvalStatus,ea.actualWorkingHours,aty.attendanceType "
                    + "FROM emp_attendance AS ea, attendance_type AS aty "
                    + "where ea.date = '" + setdate + "' AND ea.emp_details_id = '" + Attendance.userId + "' AND ea.attendance_type_id = aty.id";
            PreparedStatement prss = connection.prepareStatement(markedAttendanceData);
            ResultSet ress = prss.executeQuery();
            while (ress.next()) {
                startTime = ress.getString("startTime");
                endTime = ress.getString("endTime");
                breakTim = ress.getString("breakTime");
                midnightTime = ress.getString("midNightBreakTime");
                approStatus = ress.getString("approvalStatus");
                actualWorkingHours = ress.getString("actualWorkingHours");
                attnCls = ress.getString("attendanceType");

            }

            Object[] rowData = new Object[]{monthDate, split[0], schAtt, brkTime, "00.00", attnCls, "Click",
                startTime, endTime, breakTim, midnightTime, actualWorkingHours, approStatus};
            System.out.println("Row Data" + rowData[0]);
            attendanceTableMOdel.addRow(rowData);

            cal.add(Calendar.DAY_OF_MONTH, 1);

        }
        return attendanceTableMOdel;

    }

    public int getContractData(int userId) throws SQLException {
        String Query1 = "SELECT id,scheduleAttendance,breakTime FROM hris_system.emp_contract_data where "
                + "emp_details_id = '" + Attendance.userId + "'";
        PreparedStatement ps = connection.prepareStatement(Query1);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            setID(rs.getString("id"));
            setscheduleAtte(rs.getString("scheduleAttendance"));
            setbreakTime(rs.getString("breakTime"));

        }
        return userId;
    }

    private void setID(String ID) {
        this.ID = ID;
    }

    private void setscheduleAtte(String scheduleAtte) {
        this.scheduleAtte = scheduleAtte;
    }

    private void setbreakTime(String breakTime) {
        this.breakTime = breakTime;
    }

    public String getID() {
        return ID;
    }

    public String getscheduleAtte() {
        return scheduleAtte;
    }

    public String getbreakTime() {
        return breakTime;

    }

    public String registerAtt(AttendanceRecordInputDTO attendanceDTO, int id) throws SQLException, ParseException {
        String[] conData = getSchData();
        String scheduleAttendance = null;
        String schBreakTime = null;
        String schMidNightBreakTime = null;
        if (conData.length == 3) {
            scheduleAttendance = conData[0];
            schBreakTime = conData[1];
            schMidNightBreakTime = conData[2];
        }

        String msg = null;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        String[] schAttSplit = scheduleAttendance.split("-");
        String[] spltSchBreakTime = schBreakTime.split(":");
        String[] spltActBreakTime = attendanceDTO.getBreakTim().split(":");
        String[] spltActMidNightBreakTime = attendanceDTO.getMidnightTime().split(":");

        int schBrkHourValue = Integer.parseInt(spltSchBreakTime[0]);
        int schBrkMinuteValue = Integer.parseInt(spltSchBreakTime[1]);

        int actBrkHourValue = Integer.parseInt(spltActBreakTime[0]);
        int actBrkMinuteValue = Integer.parseInt(spltActBreakTime[1]);
        int actMidNightBrkHourValue = Integer.parseInt(spltActMidNightBreakTime[0]);
        int actMidNightBrkMinuteValue = Integer.parseInt(spltActMidNightBreakTime[1]);

        Date schStart = sdf.parse(schAttSplit[0]);
        Date schEnd = sdf.parse(schAttSplit[1]);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(schStart);
        calendar.add(Calendar.HOUR_OF_DAY, schBrkHourValue);
        calendar.add(Calendar.MINUTE, schBrkMinuteValue);
        schStart = calendar.getTime();
        long schWorkingHours = schEnd.getTime() - schStart.getTime();

        Date actualStart = sdf.parse(attendanceDTO.getStartTime());
        Date actualEnd = sdf.parse(attendanceDTO.getEndTime());
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(actualStart);
        calendar1.add(Calendar.HOUR_OF_DAY, actBrkHourValue + actMidNightBrkHourValue);
        calendar1.add(Calendar.MINUTE, actBrkMinuteValue + actMidNightBrkMinuteValue);
        actualStart = calendar1.getTime();
        long actualWorkingHours = actualEnd.getTime() - actualStart.getTime();

        String overTime = null;
        String lessTime = null;
        if (actualWorkingHours > schWorkingHours) {
            overTime = parseToHourMinuteFormat(actualWorkingHours - schWorkingHours);
        } else {
            lessTime = parseToHourMinuteFormat(schWorkingHours - actualWorkingHours);
        }
        String textActualWorkingHours = parseToHourMinuteFormat(actualWorkingHours);

        String uuserDetails = "";
        String query = "INSERT INTO `hris_system`.`emp_attendance`(`date`,`conSchAttendance`,"
                + "`conBreakTime`,`conMidNightBreakTime`,`startTime`,`endTime`,`breakTime`,`midNightBreakTime`,"
                + "`actualWorkingHours`,`overTime`,`lessTime`,`approvalStatus`,`attendance_type_id`,"
                + "`authrozers_id`,`emp_details_id`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, attendanceDTO.getDate());
            ps.setString(2, attendanceDTO.getConSchAttendance());
            ps.setString(3, schBreakTime);
            ps.setString(4, "00.00");
            ps.setString(5, attendanceDTO.getStartTime());
            ps.setString(6, attendanceDTO.getEndTime());
            ps.setString(7, attendanceDTO.getBreakTim());
            ps.setString(8, attendanceDTO.getMidnightTime());
            ps.setString(9, (String.valueOf(textActualWorkingHours)));
            ps.setString(10, overTime);
            ps.setString(11, lessTime);
            ps.setString(12, String.valueOf(DTO.ApprovalStatus.Applied));
            ps.setInt(13, attendanceDTO.getAttendanceType());
            ps.setInt(14, Attendance.authorizer);
            ps.setInt(15, Attendance.userId);

            ps.execute();
            msg = "Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error" + e.getMessage();
        }

        return msg;
    }

    private String parseToHourMinuteFormat(long millis) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)));

    }

    private String[] getSchData() throws SQLException {
        String[] conData = new String[3];
        String queryEmpContractData = "SELECT * FROM hris_system.emp_contract_data where emp_details_id = '" + Attendance.userId + "'";
        PreparedStatement prs = connection.prepareStatement(queryEmpContractData);
        ResultSet rs = prs.executeQuery();
        if (rs.next()) {
            conData[0] = (rs.getString("scheduleAttendance"));
            conData[1] = (rs.getString("breakTime"));
            conData[2] = (rs.getString("midBreakTime"));
        }
        return conData;
    }
}
