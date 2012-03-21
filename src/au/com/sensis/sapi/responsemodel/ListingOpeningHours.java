package au.com.sensis.sapi.responsemodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListingOpeningHours {

    private Map<ListingOpeningHoursDay, Day> days;

    public ListingOpeningHours() {
        this.days = new HashMap<ListingOpeningHoursDay, Day>();
    }

    public void setDay(ListingOpeningHoursDay day, Day value) {
        this.days.put(day, value);
    }

    public void setMonday(Day day) {
        days.put(ListingOpeningHoursDay.MONDAY, day);
    }

    public Day getMonday() {
        return days.get(ListingOpeningHoursDay.MONDAY);
    }

    public void setTuesday(Day day) {
        days.put(ListingOpeningHoursDay.TUESDAY, day);
    }

    public Day getTuesday() {
        return days.get(ListingOpeningHoursDay.TUESDAY);
    }

    public void setWednesday(Day day) {
        days.put(ListingOpeningHoursDay.WEDNESDAY, day);
    }

    public Day getWednesday() {
        return days.get(ListingOpeningHoursDay.WEDNESDAY);
    }

    public void setThursday(Day day) {
        days.put(ListingOpeningHoursDay.THURSDAY, day);
    }

    public Day getThursday() {
        return days.get(ListingOpeningHoursDay.THURSDAY);
    }

    public void setFriday(Day day) {
        days.put(ListingOpeningHoursDay.FRIDAY, day);
    }

    public Day getFriday() {
        return days.get(ListingOpeningHoursDay.FRIDAY);
    }

    public void setSaturday(Day day) {
        days.put(ListingOpeningHoursDay.SATURDAY, day);
    }

    public Day getSaturday() {
        return days.get(ListingOpeningHoursDay.SATURDAY);
    }

    public void setSunday(Day day) {
        days.put(ListingOpeningHoursDay.SUNDAY, day);
    }

    public Day getSunday() {
        return days.get(ListingOpeningHoursDay.SUNDAY);
    }

    public void setPublicHolidays(Day day) {
        days.put(ListingOpeningHoursDay.PUBLIC_HOLIDAYS, day);
    }

    public Day getPublicHolidays() {
        return days.get(ListingOpeningHoursDay.PUBLIC_HOLIDAYS);
    }
    
    public static class Times {

        private String open;
        private String close;

        public Times() {
        }

        public Times(String open, String close) {
            this.open = open;
            this.close = close;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public String getClose() {
            return close;
        }

        public void setClose(String close) {
            this.close = close;
        }
    }

    public static class Day {

        private ListingOpeningHoursStatus status;
        private List<Times> times;

        public ListingOpeningHoursStatus getStatus() {
            return status;
        }

        public void setStatus(ListingOpeningHoursStatus status) {
            this.status = status;
        }

        public List<Times> getTimes() {
            return times;
        }

        public void setTimes(List<Times> times) {
            this.times = times;
        }
    }
}
