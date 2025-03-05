import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.DateTimeException;

public class AgeChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Declare variables for day, month, and year
        int day, month, year;
        boolean validDate = true;
        
        // Prompt the user for birth date (day, month, year)
        System.out.print("Enter your birth day (1-31): ");
        day = scanner.nextInt();
        
        System.out.print("Enter your birth month (1-12): ");
        month = scanner.nextInt();
        
        System.out.print("Enter your birth year (e.g., 1990): ");
        year = scanner.nextInt();
        
        // Validate the birth date
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            System.out.println("Invalid date entered. Please check the day, month, and year.");
            validDate = false;
        }
        
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // If the date is valid, proceed with the age calculation
        if (validDate && birthDate != null) {
            // Check if the birth date is in the future
            if (birthDate.isAfter(currentDate)) {
                System.out.println("Invalid birth date. It is in the future!");
            } else {
                // Calculate the age in years, months, and days
                Period age = Period.between(birthDate, currentDate);
                long totalDays = ChronoUnit.DAYS.between(birthDate, currentDate);
                
                // Output the result
                System.out.println("You are " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");
                System.out.println("Total days since your birth: " + totalDays + " days.");
                System.out.println("Today's date is: " + currentDate);
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}
