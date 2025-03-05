import java.util.Scanner;

public class GajiKaryawan{
    public static void main(String[] args) {
        
   
        System.out.println(">>>Aplikasi Penghitung Gaji<<<");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Your Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Your Jabatan: ");
            String Jabatan = scanner.nextLine();
            System.out.print("Enter Your gaji pokok: ");
            int gajiPokok = scanner.nextInt();
            System.out.println("apakah anda mendapatkan tunjangan? ");
            boolean dapat = scanner.nextBoolean();
            double tunjangan = 0;
            double pajak = 0.05 * gajiPokok;
            if (dapat) {
                tunjangan = 0.10 * gajiPokok;
            }
            double gajiBersih = gajiPokok + tunjangan - pajak;
            System.out.println("\n>>> Hasil Perhitungan <<<");
            System.out.println("Name: " + name);
            System.out.println("Jabatan: " + Jabatan);
            System.out.println("Gaji Pokok: " + gajiPokok);
            System.out.println("Tunjangan: " + tunjangan);
            System.out.println("Pajak: " + pajak);
            System.out.println("Gaji Bersih: " + gajiBersih);
            System.out.println("\n>>> Kategori Jabatan <<<");
            switch (Jabatan.toLowerCase()) {
                case "Manager":
                    System.out.println("Anda adalah seorang Manager.");
                    break;
                case "staf":
                    System.out.println("Anda adalah seorang staf.");
                    break;
                case "direktur":
                    System.out.println("Anda adalah seorang direktur.");
                    break;
                default:
                System.out.println("jabatan tdk diketahui.");
                break;
            }
            System.out.println(">>> BY faiz nation <<<");

        
            
        }
    }
}