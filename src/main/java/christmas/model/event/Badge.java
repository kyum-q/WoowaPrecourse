package christmas.model.event;

import christmas.constant.event.BadgeName;
import christmas.constant.event.EventConstant;

public class Badge {
    private final BadgeName badgeName;
    public Badge(int eventCost) {
        badgeName = getBadgeName(eventCost);
    }

    private BadgeName getBadgeName(int eventCost) {
        if(eventCost < EventConstant.BADGE_LEVEL_1_VALUE.value())
            return BadgeName.NO_BADGE;
        if(eventCost < EventConstant.BADGE_LEVEL_2_VALUE.value())
            return BadgeName.LEVEL_1;
        if(eventCost < EventConstant.BADGE_LEVEL_3_VALUE.value())
            return BadgeName.LEVEL_2;
        return BadgeName.LEVEL_3;
    }

    public String getBadgeName() {
        return badgeName.badgeName();
    }
}
