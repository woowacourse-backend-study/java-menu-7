package menu.util.enums;

public enum Delimiter {
    COMMA(",");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

}
