package bank.enums;

public enum Status {
    SUCCESS('\u2713'),
    FAILURE('\u2717');

    private final char symbol;

    Status(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
