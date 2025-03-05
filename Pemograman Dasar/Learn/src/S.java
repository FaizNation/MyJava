import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.DateTimeException;

public class S {
    public static void main(String[] args) throws Exception {
        // Create a Scanner object for input
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for their name
            System.out.print("Write your name: ");  
            String name = scanner.nextLine();  

            System.out.println(">>>>> Welcome sir <<<<<");
            System.out.println("Hello, " + name );  
            System.out.println("Can you enter your birthday " + name + "?");

            // Initialize date validation loop
            boolean validDate = false;
            LocalDate birthDate = null;
            
            // Repeat until the user inputs a valid date
            while (!validDate) {
                try {
                    // Prompt the user for birth date (day, month, year)
                    System.out.print("Enter your birth day (1-31): ");
                    int day = scanner.nextInt();
                    
                    System.out.print("Enter your birth month (1-12): ");
                    int month = scanner.nextInt();
                    
                    System.out.print("Enter your birth year (e.g., 1990): ");
                    int year = scanner.nextInt();
                    
                    // Create birthDate object
                    birthDate = LocalDate.of(year, month, day);
                    
                    // Get the current date
                    LocalDate currentDate = LocalDate.now();
                    
                    // Check if birth date is in the future
                    if (birthDate.isAfter(currentDate)) {
                        System.out.println("Invalid birth date. It is in the future!");
                    } else {
                        validDate = true;  // Date is valid, exit the loop
                    }
                    
                } catch (DateTimeException e) {
                    System.out.println("Invalid date entered. Please try again.");
                    scanner.nextLine(); // clear the input buffer
                }
            }
            
            // Get the current date
            LocalDate currentDate = LocalDate.now();
            
            // Calculate the age in years, months, and days
            Period age = Period.between(birthDate, currentDate);
            long totalDays = ChronoUnit.DAYS.between(birthDate, currentDate);
            
            // Output the result
            System.out.println("You are " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");
            System.out.println("Total days since your birth: " + totalDays + " days.");
            System.out.println("Today's date is: " + currentDate);
        }
    }
}
