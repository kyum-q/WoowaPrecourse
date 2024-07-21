package menu.validator;

import menu.constants.ErrorMessage;
import menu.constants.RecommendConstants;

import java.util.Collections;
import java.util.List;

public class CoachNamesValidator {
    private List<String> names;
    private ErrorMessage errorMessage;
    private int minName, maxName, minCoach, maxCoach;

    public CoachNamesValidator() {
        minName = RecommendConstants.COACH_MIN_NAME_LEN.getNumber();
        maxName = RecommendConstants.COACH_MAX_NAME_LEN.getNumber();
        minCoach = RecommendConstants.COACH_MIN_COUNT.getNumber();
        maxCoach = RecommendConstants.COACH_MAX_COUNT.getNumber();
    }
    public boolean valid(String s) {
        return validCoachCount(s) && validCoachNameLen() && validOverlapNames();
    }

    private boolean validCoachCount(String s) {
        try {
            names = List.of(s.split(",", -1));
            if(names.size() < minCoach || names.size() > maxCoach) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_COACH_COUNT;
            return false;
        }
        return true;
    }

    private boolean validCoachNameLen() {
        try {
            if(names.stream().anyMatch(this::checkNameLen)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_COACH_NAME;
            return false;
        }
        return true;
    }
    private boolean checkNameLen(String s) {
        return s.length() < minName || s.length() > maxName;
    }

    private boolean validOverlapNames() {
        try {
            if(names.stream().distinct().count() != names.size()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            errorMessage = ErrorMessage.ERROR_COACH_NAME_OVERLAP;
            return false;
        }
        return true;
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }

    @Override
    public String toString() {
        return errorMessage.toString();
    }
}
