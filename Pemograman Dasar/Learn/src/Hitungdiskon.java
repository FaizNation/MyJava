import java.util.Scanner;
public class Hitungdiskon {
    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println( "===== Aplikasi Hitung Diskon =====");
            System.out.print("Masukkan nomor antrian: ");
            int noAntrian = input.nextInt();

            System.out.print("Masukkan nama customer: ");
            String namaCustomer = input.nextLine();

            System.out.print("Masukkan total belanja: ");
            double totalBelanja = input.nextDouble();

            double diskon = 0;
            boolean isDisc50 = totalBelanja > 500000;
            boolean isDisc25 = totalBelanja > 250000;

            if(isDisc50) {
                diskon = 0.5;
            }else if(isDisc25){
                diskon = 0.25;
            }

            double totalDiskon = totalBelanja + diskon;
            double grandTotal  = totalBelanja + totalDiskon;

            System.out.println("Hello,"+ namaCustomer);
            System.out.print("Nomor Antrian: "+ noAntrian);
            System.out.print("Total Belanja: "+ totalBelanja);
            System.out.print("Dapat Diskon: "+ (diskon*100) + "%");
            System.out.print("Total Diskon: Rp"+ totalDiskon);
            System.out.print("Total Diskon: Rp"+ grandTotal);
            System.out.println("By sarah");
        }
    }
}

