package oncall.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SequenceManagement {
    private MonthWeek monthWeek;
    private List<String> weekly, weekend, result;
    private int weeklyNum = 0, weekendNum = 0;
    private String preStaff = "";
    private Queue<String> nextWeekend, nextWeekly;

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
        return getNextStaff(nextWeekend, weekend, weekendNum);
    }

    private String getNextWeeklyStaff() {
        return getNextStaff(nextWeekly, weekly, weeklyNum);
    }

    private String getNextStaff(Queue<String> nextQueue, List<String> staff, int staffNum) {
        if (!nextQueue.isEmpty()) {
            return nextQueue.poll();
        }
        String name = staff.get(staffNum);
        if (name.equals(preStaff)) {
            nextQueue.add(name);
            return staff.get((staffNum + 1) % staff.size());
        }
        return name;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        for (String s : result) {
            resultString.append(s).append("\n");
        }
        return resultString.toString();
    }
}
