import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Demo class to read Policy information from a text file
 * and display details for each Policy.
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();

        try {
            // Open the PolicyInformation.txt file
            File file = new File("PolicyInformation.txt");
            Scanner inputFile = new Scanner(file);

            // Keep reading until the end of the file
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

                // Check if there’s another line separating entries
                if (inputFile.hasNextLine()) {
                    inputFile.nextLine();
                }

                // Create a Policy object and add it to the list
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                            age, smokingStatus, height, weight);
                policies.add(policy);
            }

            inputFile.close();

            // Display all policy information
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

            System.out.println("Number of Policy objects created: " + policies.size());

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file was not found.");
        }
    }
}
