import java.util.Scanner;

public class Luaspersegi {
    public static void main(String[] args) throws Exception {
       try (Scanner input = new Scanner(System.in)) {
        System.out.println("Input the Lenght: "); 
        double Lenght = input.nextDouble();
        
        System.out.println("Input the Widht: ");
        double Widht = input.nextDouble();

        double Area = Lenght * Widht;
        System.out.println("= " + Area);

        }
    }
}