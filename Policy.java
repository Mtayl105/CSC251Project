public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String policyholderSmokingStatus;
    private double policyholderHeight; 
    private double policyholderWeight; 

    // No arg constructor
    public Policy() {
        policyNumber = 0;
        providerName = "";
        policyholderFirstName = "";
        policyholderLastName = "";
        policyholderAge = 0;
        policyholderSmokingStatus = "non-smoker";
        policyholderHeight = 0.0;
        policyholderWeight = 0.0;
    }

    // Full arg constructor
    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = firstName;
        this.policyholderLastName = lastName;
        this.policyholderAge = age;
        this.policyholderSmokingStatus = smokingStatus.toLowerCase();
        this.policyholderHeight = height;
        this.policyholderWeight = weight;
    }

    // Getters and Setters
    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public String getPolicyholderFirstName() { return policyholderFirstName; }
    public void setPolicyholderFirstName(String firstName) { this.policyholderFirstName = firstName; }

    public String getPolicyholderLastName() { return policyholderLastName; }
    public void setPolicyholderLastName(String lastName) { this.policyholderLastName = lastName; }

    public int getPolicyholderAge() { return policyholderAge; }
    public void setPolicyholderAge(int age) { this.policyholderAge = age; }

    public String getPolicyholderSmokingStatus() { return policyholderSmokingStatus; }
    public void setPolicyholderSmokingStatus(String smokingStatus) {
        this.policyholderSmokingStatus = smokingStatus.toLowerCase();
    }

    public double getPolicyholderHeight() { return policyholderHeight; }
    public void setPolicyholderHeight(double height) { this.policyholderHeight = height; }

    public double getPolicyholderWeight() { return policyholderWeight; }
    public void setPolicyholderWeight(double weight) { this.policyholderWeight = weight; }

    // Method to calculate BMI
    public double calculateBMI() {
        if (policyholderHeight == 0) return 0;
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }

    // Method to calculate policy price
    public double calculatePolicyPrice() {
        double price = 600.0;

        if (policyholderAge > 50) {
            price += 75.0;
        }

        if (policyholderSmokingStatus.equals("smoker")) {
            price += 100.0;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }
}



    