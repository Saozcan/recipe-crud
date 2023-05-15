public class Step {
    private int number;
    private String description;

    public Step(int number, String description) {
        this.number = number;
        this.description = description;
    }

    // Getters and setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
