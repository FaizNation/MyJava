import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter total purchases: Rp "); // memasukan total belanjaan
            double TotalPrice = input.nextDouble();

            System.out.print("Enter Discount: "); // memasukan diskon
            double Discount = input.nextDouble();

            double diskon = TotalPrice * (Discount / 100); // total harga x (diskon/100)
            double beforediskon = TotalPrice - diskon; // total harga - diskon 

            System.out.println("Discount amount: Rp " + diskon);
            System.out.println("Price after discount: Rp " + beforediskon);
        }
    
    }
}
