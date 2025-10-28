import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Demo class to read Policy information from a text file,
 * display details for each Policy, and count smokers and non-smokers.
 */
public class Demo {

    public static void main(String[] args) {
        // List to store Policy objects dynamically
        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            // Open the PolicyInformation.txt file
            File file = new File("PolicyInformation.txt");
            Scanner inputFile = new Scanner(file);

            // Read policies from the file
            while (inputFile.hasNext()) {
                int policyNumber = inputFile.nextInt();
                inputFile.nextLine(); // consume newline

                String providerName = inputFile.nextLine();
                String firstName = inputFile.nextLine();
                String lastName = inputFile.nextLine();
                int age = inputFile.nextInt();
                inputFile.nextLine(); // consume newline

                String smokingStatus = inputFile.nextLine();
                double height = inputFile.nextDouble();
                double weight = inputFile.nextDouble();

                // Skip any extra newline between entries
                if (inputFile.hasNextLine()) {
                    inputFile.nextLine();
                }

                // Create a Policy object and add it to the list
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                           age, smokingStatus, height, weight);
                policies.add(policy);

                // Count smokers and non-smokers
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }

            inputFile.close();

            // Display information for each policy
            for (Policy policy : policies) {
                System.out.println("Policy Number: " + policy.getPolicyNumber());
                System.out.println("Provider Name: " + policy.getProviderName());
                System.out.println("Policyholder: " + policy.getPolicyholderFirstName() + " " +
                                   policy.getPolicyholderLastName());
                System.out.println("Age: " + policy.getPolicyholderAge());
                System.out.println("Smoking Status: " + policy.getPolicyholderSmokingStatus());
                System.out.println("Height: " + policy.getPolicyholderHeight() + " inches");
                System.out.println("Weight: " + policy.getPolicyholderWeight() + " pounds");
                System.out.printf("BMI: %.2f\n", policy.calculateBMI());
                System.out.printf("Policy Price: $%.2f\n", policy.calculatePolicyPrice());
                System.out.println("----------------------------------------");
            }

            // Display totals
            System.out.println("Number of Policy objects created: " + policies.size());
            System.out.println("Number of smokers: " + smokerCount);
            System.out.println("Number of non-smokers: " + nonSmokerCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file PolicyInformation.txt was not found.");
        }
    }
}

