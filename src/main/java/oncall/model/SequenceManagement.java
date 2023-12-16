package oncall.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SequenceManagement {
    private MonthWeek monthWeek;
    private List<String> weekly;
    private int weeklyNum = 0;
    private List<String> weekend;
    private int weekendNum = 0;
    private String preStaff = "";
    private Queue<String> nextWeekend;
    private Queue<String> nextWeekly;

    private List<String> result;

    public SequenceManagement(MonthWeek monthWeek, List<String> weekly, List<String> weekend) {
        this.monthWeek = monthWeek;
        this.weekly = weekly;
        this.weekend = weekend;

        nextWeekend = new LinkedList<>();
        nextWeekly = new LinkedList<>();
    }

    public void setOnCall() {
        result = new ArrayList<>();
        do {
            preStaff = holidayCheckAndSetName();
            result.add(monthWeek.toString() + " " + preStaff);
        } while (monthWeek.next());
    }


    private String holidayCheckAndSetName() {
        if (monthWeek.checkHoliday()) {
            String name = getNextWeekendStaff();
            weekendNum = (weekendNum + 1) % weekend.size();
            return name;
        }

        String name = getNextWeeklyStaff();
        weeklyNum = (weeklyNum + 1) % weekly.size();
        return name;
    }

    private String getNextWeekendStaff() {
        if(!nextWeekend.isEmpty()) {
            return nextWeekend.poll();
        }
        String name = weekend.get(weekendNum);
        if(name.equals(preStaff)) {
            nextWeekend.add(name);
            return weekend.get(weekendNum+1);
        }
        return name;
    }

    private String getNextWeeklyStaff() {
        if(!nextWeekly.isEmpty()) {
            return nextWeekly.poll();
        }
        String name = weekly.get(weeklyNum);
        if(name.equals(preStaff)) {
            nextWeekly.add(name);
            return weekly.get(weeklyNum+1);
        }
        return name;
    }

    @Override
    public String toString() {
        String resultString = "";
        for (int i = 0; i < result.size(); i++) {
            resultString += result.get(i) + "\n";
        }
        return resultString;
    }
}
