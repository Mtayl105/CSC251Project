public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height; // in inches
    private double weight; // in pounds

    // Constructor
    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus,
                        double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus.toLowerCase();
        this.height = height;
        this.weight = weight;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    // Calculate BMI
    public double calculateBMI() {
        if (height == 0) return 0;
        return (weight * 703) / (height * height);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age +
               ", Smoking Status: " + smokingStatus +
               ", Height: " + height + " in, Weight: " + weight + " lbs, BMI: " + String.format("%.2f", calculateBMI());
    }
}
