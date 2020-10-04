package be.pxl.ja.streamingservice.model;

public enum StreamingPlan {
    BASIC ("Basic", 1, 7.99),
    STANDARD ("Standard", 2, 11.99),
    PREMIUM ("Premium", 4, 15.99);

    private String label;
    private int numberOfProfiles;
    private double price;

    StreamingPlan(String label, int numberOfProfiles, double price) {
        this.label = label;
        this.numberOfProfiles = numberOfProfiles;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public int getNumberOfProfiles() {
        return numberOfProfiles;
    }

    public double getPrice() {
        return price;
    }

}
