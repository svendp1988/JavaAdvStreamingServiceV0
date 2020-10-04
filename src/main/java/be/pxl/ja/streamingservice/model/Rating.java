package be.pxl.ja.streamingservice.model;

public enum Rating {
    LITTLE_KIDS ("Little Kids", 0),
    OLDER_KIDS ("Older Kids", 7),
    TEENS ("Teens", 12),
    MATURE ("Mature", 16);

    private final String label;
    private final int minimumAge;

    Rating(String label, int minimumAge) {
        this.label = label;
        this.minimumAge = minimumAge;
    }

    public String getLabel() {
        return label;
    }

    public int getMinimumAge() {
        return minimumAge;
    }
}
