package util;

import java.sql.Timestamp;

public class TimestampSpan {
    private static final long TO_SECONDS = 1000L;
    private static final long TO_MINUTES = TO_SECONDS * 60;
    private static final long TO_HOURS = TO_MINUTES * 60;
    private static final long TO_DAYS = TO_HOURS * 24;
    private static final long TO_MONTHS = TO_DAYS * 30;
    private static final long TO_YEARS = TO_MONTHS * 12;

    private int years;
    private int months;
    private int days;
    private int hours;
    private int minutes;
    private int seconds;
    private long milliseconds;
    private long start;
    private long end;

    public TimestampSpan(Timestamp start) {
        this.start = start.getTime();
        end = System.currentTimeMillis();
        milliseconds = end - this.start;
        this.setYears();
        this.setMonths();
        this.setDays();
        this.setHours();
        this.setMinutes();
        this.setSeconds();
    }

    public int getYears() {
        return years;
    }

    public int getMonths() {
        return months;
    }

    public int getDays() {
        return days;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    private void setYears() {
        if(milliseconds > 0) {
            years = (int)(milliseconds / TimestampSpan.TO_YEARS);
            milliseconds -= (years * TimestampSpan.TO_YEARS);
        }
    }

    private void setMonths() {
        if(milliseconds > 0) {
            months = (int)(milliseconds / TimestampSpan.TO_MONTHS);
            milliseconds -= (months * TimestampSpan.TO_MONTHS);
        }
    }

    private void setDays() {
        if(milliseconds > 0) {
            days = (int)(milliseconds / TimestampSpan.TO_DAYS);
            milliseconds -= (days * TimestampSpan.TO_DAYS);
        }
    }

    private void setHours() {
        if(milliseconds > 0) {
            hours = (int)(milliseconds / TimestampSpan.TO_HOURS);
            milliseconds -= (hours * TimestampSpan.TO_HOURS);
        }
    }

    private void setMinutes() {
        if(milliseconds > 0) {
            minutes = (int)(milliseconds / TimestampSpan.TO_MINUTES);
            milliseconds -= (minutes * TimestampSpan.TO_MINUTES);
        }
    }

    private void setSeconds() {
        if(milliseconds > 0) {
            seconds = (int)(milliseconds / TimestampSpan.TO_SECONDS);
            milliseconds -= (seconds * TimestampSpan.TO_SECONDS);
        }
    }

    private void setStart() {
        this.start = start;
    }

    private void setEnd() {
        this.end = end;
    }
}
