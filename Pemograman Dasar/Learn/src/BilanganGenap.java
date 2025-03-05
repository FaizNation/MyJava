import java.util.Scanner;

public class BilanganGenap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan batas bawah: ");
        int batasBawah = scanner.nextInt();

        System.out.print("Masukkan batas atas: ");
        int batasAtas = scanner.nextInt();

        int jumlahGenap = 0;

        System.out.println("Bilangan genap antara " + batasBawah + " dan " + batasAtas + " adalah:");
        
        for (int i = batasBawah; i <= batasAtas; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                jumlahGenap++;  // Menambah jumlah bilangan genap
            }
        }

        System.out.println("Jumlah bilangan genap: " + jumlahGenap);
        
        scanner.close();
    }
}


