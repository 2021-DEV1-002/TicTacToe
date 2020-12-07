package bnp.kata.java.tictactoe;

public enum CellPosition {
    LEFT_TOP("LEFT_TOP"),
    MIDDLE_TOP("MIDDLE_TOP"),
    RIGHT_TOP("RIGHT_TOP"),
    LEFT_MIDDLE("LEFT_MIDDLE"),
    MIDDLE_MIDDLE("MIDDLE_MIDDLE"),
    RIGHT_MIDDLE("RIGHT_MIDDLE"),
    LEFT_BOTTOM("LEFT_BOTTOM"),
    MIDDLE_BOTTOM("MIDDLE_BOTTOM"),
    RIGHT_BOTTOM("RIGHT_BOTTOM");

    public String value;

    CellPosition(String value)
    {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
