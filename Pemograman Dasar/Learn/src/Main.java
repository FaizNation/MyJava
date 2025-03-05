import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("write your name: ");  
            String name = input.nextLine();  

            System.out.println(">>>>> Wellcome sir <<<<<");
            System.out.println("Hello, " + name );  
            System.out.println("May can i help you " + name +"?");
           
        }
    }
    
}
