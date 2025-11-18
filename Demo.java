import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            Scanner inputFile = new Scanner(new File("PolicyInformation.txt"));

            while (inputFile.hasNext()) {
                int policyNumber = inputFile.nextInt(); inputFile.nextLine();
                String providerName = inputFile.nextLine();
                String firstName = inputFile.nextLine();
                String lastName = inputFile.nextLine();
                int age = inputFile.nextInt(); inputFile.nextLine();
                String smokingStatus = inputFile.nextLine().trim();
                double height = inputFile.nextDouble();
                double weight = inputFile.nextDouble();
                if (inputFile.hasNextLine()) inputFile.nextLine(); // skip blank line

                PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
                Policy policy = new Policy(policyNumber, providerName, holder);
                policies.add(policy);

                if (smokingStatus.equalsIgnoreCase("smoker")) smokerCount++;
                else nonSmokerCount++;
            }

            inputFile.close();

            // Display all policies
            for (Policy p : policies) {
                System.out.println(p);
                System.out.println("----------------------------------------");
            }

            System.out.println("Number of Policy objects created: " + Policy.getPolicyCount());
            System.out.println("Number of smokers: " + smokerCount);
            System.out.println("Number of non-smokers: " + nonSmokerCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file PolicyInformation.txt was not found.");
        } catch (Exception e) {
            System.out.println("Error: Invalid data in the file.");
        }
    }
}
