package DTO;

public class AuthorizerRecordInputDTO {

    private String startTime;
    private String endTime;
    private String breakTim;
    private String midnightTime;

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
}
