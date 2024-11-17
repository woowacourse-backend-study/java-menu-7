package menu.enums;

public enum RecommendResultSign {

    OPEN_PARENTHESES("[ "),
    CATEGORY("카테고리"),
    DAY_SEPARATOR(" | "),
    CLOSE_PARENTHESES(" ]"),
    LINE_CHANGE("\n");

    private final String sign;

    RecommendResultSign(String sign) {
        this.sign = sign;
    }

    public String valueOf() {
        return sign;
    }
}
