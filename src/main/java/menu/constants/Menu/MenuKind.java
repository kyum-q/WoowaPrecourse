package menu.constants.Menu;

public enum MenuKind {
    Japanese("일식"),
    Korean("한식"),
    Chinese("중식"),
    Asian("아시안"),
    Western("양식");

    private String kind;
    MenuKind(String s) {
        kind = s;
    }

    @Override
    public String toString() {
        return kind;
    }

    public static boolean isCheckContainMenu(String s) {
        return JapaneseFood.getMenuInfo(s) != null || KoreanFood.getMenuInfo(s) != null ||
                ChineseFood.getMenuInfo(s) != null || AsianFood.getMenuInfo(s) != null ||
                WesternFood.getMenuInfo(s) != null;
    }
}
