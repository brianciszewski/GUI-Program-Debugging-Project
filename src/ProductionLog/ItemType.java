package ProductionLog;

public enum ItemType {
    AUDIO("AU"),
    VISUAL("VI"),
    AUDIO_MOBILE("AM"),
    VISUAL_MOBILE("VM");


    public final String label;

    ItemType(String label) {
        this.label = label;
    }

    // https://www.baeldung.com/java-enum-values

    public String itemType() {
        return label;
    }

}
