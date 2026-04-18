import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainManagement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        String trainRegex = "TRN-\\d{4}";
        String cargoRegex = "PET-[A-Z]{2}";

        Pattern trainPattern = Pattern.compile(trainRegex);
        Pattern cargoPattern = Pattern.compile(cargoRegex);

        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        boolean isTrainValid = trainMatcher.matches();
        boolean isCargoValid = cargoMatcher.matches();

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        if (!isTrainValid) {
            System.out.println("❌ Invalid Train ID format. Expected: TRN-1234");
        }

        if (!isCargoValid) {
            System.out.println("❌ Invalid Cargo Code format. Expected: PET-AB");
        }

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}