package DTO;

public class AttendanceRecordInputDTO {

    private String date;
    private String startTime;
    private String endTime;
    private String breakTim;
    private String midnightTime;
    private int classificatioNumber;
    private String conSchAttendance;
    private int attendanceType;
    private int conSchAtt;

    public int getConSchAtt() {
        return conSchAtt;
    }

    public void setConSchAtt(int conSchAtt) {
        this.conSchAtt = conSchAtt;
    }

    public int getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(int attendanceType) {
        this.attendanceType = attendanceType;
    }

    public String getConSchAttendance() {
        return conSchAttendance;
    }

    public void setConSchAttendance(String conSchAttendance) {
        this.conSchAttendance = conSchAttendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBreakTim() {
        return breakTim;
    }

    public void setBreakTim(String breakTim) {
        this.breakTim = breakTim;
    }

    public String getMidnightTime() {
        return midnightTime;
    }

    public void setMidnightTime(String midnightTime) {
        this.midnightTime = midnightTime;
    }

    public int getClassificatioNumber() {
        return classificatioNumber;
    }

    public void setClassificatioNumber(int classificatioNumber) {
        this.classificatioNumber = classificatioNumber;
    }
}
