package oncall.validator;

import oncall.constants.NicNameConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequenceValidator {
    private List<String> weekly;
    private List<String> weekend;
    private int minStaff, maxStaff, minName, maxName;

    public SequenceValidator() {
        minStaff = NicNameConstants.STAFF_MIN_COUNT.getNum();
        maxStaff = NicNameConstants.STAFF_MAX_COUNT.getNum();
        minName = NicNameConstants.MIN_NAME_LEN.getNum();
        maxName = NicNameConstants.MAX_NAME_LEN.getNum();
    }

    public boolean validWeekly(String s) {
        weekly = validStaffCount(s);

        if(weekly == null)
            return false;
        return  validNicNameLen(weekly) && validOverlapNames(weekly);
    }

    public boolean validWeekend(String s) {
        weekend = validStaffCount(s);

        if(weekend == null)
            return false;
        return validNicNameLen(weekend) && validOverlapNames(weekend) && validNotContainWeekly();
    }

    private List<String> validStaffCount(String s) {
        List<String> names;
        try {
            names = List.of(s.split(",", -1));
            if (names.size() < minStaff || names.size() > maxStaff) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return null;
        }
        return names;
    }

    private boolean validNicNameLen(List<String> names) {
        try {
            if (names.stream().anyMatch(this::checkNameLen)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean checkNameLen(String s) {
        return s.length() < minName || s.length() > maxName;
    }

    private boolean validOverlapNames(List<String> names) {
        try {
            if (names.stream().distinct().count() != names.size()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private boolean validNotContainWeekly() {
        try {
            List<String> checkList = new ArrayList<>();
            checkList.addAll(weekly);
            checkList.addAll(weekend);
            if (checkList.stream().distinct().count() != weekly.size()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public List<List<String>> getResult() {
        return List.of(Collections.unmodifiableList(weekly), Collections.unmodifiableList(weekend));
    }
}

