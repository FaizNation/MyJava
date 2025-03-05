import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            {
            System.out.print("Masukkan besar jari-jari:");
            int r = scanner.nextInt();
            double L, K, d;
            
            d = 2 * r;

            double phi;
            if (r % 7 == 0 && r % 3 == 0) {
             phi = 22.0 / 7.0;
            }
            else {
             phi = 3.14;
            }

            L = phi * r * r;
            K = phi * d;

            System.out.println("luas = " + L);
            System.out.println("Keliling = " + K);
            }
        }
    }
}
