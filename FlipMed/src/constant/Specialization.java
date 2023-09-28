package constant;

public enum Specialization {
    CARDIO("cardiologist"),
    DERMA("dermalogist"),
    ORTHO("orthopadics"),
    GP("general physicion");

    private final String displayName;

    Specialization(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }


}
