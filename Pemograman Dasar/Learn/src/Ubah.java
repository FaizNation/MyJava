import java.util.Scanner;

public class Ubah {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            //Nilai Default pada Variable String
            String smk = "smk plus ashabulyamin";
            String web = "WILDAN TECHNO ART";

            //Nilai Yang DImanipulasi Menjadi Kapital dan Kecil
            String UpSMK = smk.toUpperCase();
            String DownWEB = web.toLowerCase();

            //Mencetak Hasil
            System.out.println(UpSMK);
            System.out.println(DownWEB);

            System.out.println("=================================================");

            System.out.print("Input nama: ");
            String namaLengkap = scanner.nextLine();

            String namaBelakang = namaLengkap.substring(3, 12);
            System.out.println(namaBelakang); 
            // output : Izzatul
        }
    }
}