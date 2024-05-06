public enum Representation {

    EMPTY("   "),
    X(" X "),
    O(" O ");

    private final String representation;

    Representation(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}
