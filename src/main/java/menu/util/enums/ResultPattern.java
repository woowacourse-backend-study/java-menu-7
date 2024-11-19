package menu.util.enums;

public enum ResultPattern {
    CATEGORY_PATTERN("[ 카테고리 | %s ]\n"),
    RECOMMENDATION_MENUS_PATTERN("[ %s | %s ]\n"),
    RESULT_DELIMITER(" | ");

    private final String pattern;

    ResultPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
