/**
 * The Policy class represents an insurance policy with details about
 * the policyholder, including personal information, health data, and
 * methods for calculating BMI and policy price.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String policyholderSmokingStatus;
    private double policyholderHeight; 
    private double policyholderWeight; 

      /**
     * No-argument constructor that initializes all fields to default values.
     */ // No arg constructor
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

       /**
     * Constructs a Policy object with the specified values.
     *
     * @param policyNumber the unique number identifying the policy
     * @param providerName the name of the insurance provider
     * @param firstName the first name of the policyholder
     * @param lastName the last name of the policyholder
     * @param age the age of the policyholder
     * @param smokingStatus the smoking status of the policyholder ("smoker" or "non-smoker")
     * @param height the height of the policyholder in inches
     * @param weight the weight of the policyholder in pounds
     */// Full arg constructor
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

   
    /**
     * Returns the policy number.
     *
     * @return the policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     *
     * @param policyNumber the new policy number
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Returns the provider name.
     *
     * @return the provider name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the provider name.
     *
     * @param providerName the name of the insurance provider
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Returns the first name of the policyholder.
     *
     * @return the policyholder's first name
     */
    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    /**
     * Sets the policyholder's first name.
     *
     * @param firstName the new first name of the policyholder
     */
    public void setPolicyholderFirstName(String firstName) {
        this.policyholderFirstName = firstName;
    }

    /**
     * Returns the last name of the policyholder.
     *
     * @return the policyholder's last name
     */
    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    /**
     * Sets the policyholder's last name.
     *
     * @param lastName the new last name of the policyholder
     */
    public void setPolicyholderLastName(String lastName) {
        this.policyholderLastName = lastName;
    }

    /**
     * Returns the age of the policyholder.
     *
     * @return the policyholder's age
     */
    public int getPolicyholderAge() {
        return policyholderAge;
    }

    /**
     * Sets the policyholder's age.
     *
     * @param age the new age of the policyholder
     */
    public void setPolicyholderAge(int age) {
        this.policyholderAge = age;
    }

    /**
     * Returns the smoking status of the policyholder.
     *
     * @return the smoking status ("smoker" or "non-smoker")
     */
    public String getPolicyholderSmokingStatus() {
        return policyholderSmokingStatus;
    }

    /**
     * Sets the smoking status of the policyholder.
     *
     * @param smokingStatus the smoking status ("smoker" or "non-smoker")
     */
    public void setPolicyholderSmokingStatus(String smokingStatus) {
        this.policyholderSmokingStatus = smokingStatus.toLowerCase();
    }

    /**
     * Returns the height of the policyholder.
     *
     * @return the policyholder's height in inches
     */
    public double getPolicyholderHeight() {
        return policyholderHeight;
    }

    /**
     * Sets the height of the policyholder.
     *
     * @param height the new height of the policyholder in inches
     */
    public void setPolicyholderHeight(double height) {
        this.policyholderHeight = height;
    }

    /**
     * Returns the weight of the policyholder.
     *
     * @return the policyholder's weight in pounds
     */
    public double getPolicyholderWeight() {
        return policyholderWeight;
    }

    /**
     * Sets the weight of the policyholder.
     *
     * @param weight the new weight of the policyholder in pounds
     */
    public void setPolicyholderWeight(double weight) {
        this.policyholderWeight = weight;
    }

    /**
     * Calculates the Body Mass Index (BMI) of the policyholder.
     *
     * @return the BMI value, or 0 if height is zero
     */
    public double calculateBMI() {
        if (policyholderHeight == 0) return 0;
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }

    /**
     * Calculates the total policy price based on the policyholder's
     * age, smoking status, and BMI.
     *
     * @return the calculated policy price
     */
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