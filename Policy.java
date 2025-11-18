public class Policy {
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder; // Composition
    private static int policyCount = 0; // Track number of Policy objects

    // Constructors
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
        this.policyHolder = new PolicyHolder("", "", 0, "non-smoker", 0.0, 0.0);
        policyCount++;
    }

    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        policyCount++;
    }

    // Getters and setters
    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public PolicyHolder getPolicyHolder() { return policyHolder; }
    public void setPolicyHolder(PolicyHolder policyHolder) { this.policyHolder = policyHolder; }

    public static int getPolicyCount() { return policyCount; }

    // Calculate policy price
    public double calculatePolicyPrice() {
        double price = 600.0;

        if (policyHolder.getAge() > 50) {
            price += 75.0;
        }

        if (policyHolder.getSmokingStatus().equals("smoker")) {
            price += 100.0;
        }

        double bmi = policyHolder.calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + "\n" +
               "Provider: " + providerName + "\n" +
               "PolicyHolder: " + policyHolder.toString() + "\n" +
               String.format("Policy Price: $%.2f", calculatePolicyPrice());
    }
}
