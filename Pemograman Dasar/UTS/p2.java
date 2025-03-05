import java.util.ArrayList;
import java.util.Scanner;

public class p2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Judul Aplikasi
        System.out.println("|=========================================|");
        System.out.println("|>>          HEALING RESERVATION        <<|");
        System.out.println("|>>         << PT Faiz Nation >>        <<|");
        System.out.println("|=========================================|");
        System.out.println(" ");

        // Input Nama, Jumlah Orang, dan Budget
        System.out.print("Masukkan Nama Anda   : ");
        String nama = input.nextLine();
 
        System.out.print("Masukkan Jumlah Orang: ");
        int jumlahOrang = input.nextInt();

        System.out.print("Masuokkan Budget Anda : ");
        double budgetAnda = input.nextDouble();

        // ArrayList Paket Wisata dan Harga
        ArrayList<String> paketWisata = new ArrayList<>();
        ArrayList<Double> hargaPaket = new ArrayList<>();
        paketWisata.add("Paket Exclusive");
        hargaPaket.add(100000.0);
        paketWisata.add("Paket Simple");
        hargaPaket.add(20000.0);
        paketWisata.add("Paket Murah");
        hargaPaket.add(50000.0);

        // ArrayList Destinasi dan Harga
        ArrayList<String> destinasi = new ArrayList<>();
        ArrayList<Double> hargaDestinasi = new ArrayList<>();
        destinasi.add("Gunung");
        hargaDestinasi.add(50000.0);
        destinasi.add("Pantai");
        hargaDestinasi.add(35000.0);
        destinasi.add("Kota");
        hargaDestinasi.add(25000.0);

        System.out.println("\n|>>> Rekomendasi Berdasarkan Budget <<<|");

        // Variabel untuk memantau apakah ada rekomendasi
        boolean adaRekomendasi = false;

        // Menggunakan switch case untuk memeriksa kombinasi paket dan destinasi
        for (int i = 0; i < paketWisata.size(); i++) {
            for (int j = 0; j < destinasi.size(); j++) {
                double totalBiaya = (hargaPaket.get(i) + hargaDestinasi.get(j)) * jumlahOrang;

                // Jika total biaya sesuai dengan budget, tampilkan rekomendasi
                switch ((int) (budgetAnda - totalBiaya >= 0 ? 1 : 0)) {
                    case 1:
                        adaRekomendasi = true;
                        System.out.printf("Paket: %s, Destinasi: %s, Total Biaya: Rp %.2f\n",
                                paketWisata.get(i), destinasi.get(j), totalBiaya);
                        break;
                    default:
                        // Tidak ada tindakan khusus untuk kasus ini
                        break;
                }
            }
        }

        // Jika tidak ada rekomendasi
        if (!adaRekomendasi) {
            System.out.println("Maaf, tidak ada paket dan destinasi yang sesuai dengan budget Anda.");
            input.close();
            return;
        }

        // Memilih Paket dan Destinasi setelah melihat rekomendasi
        System.out.print("\nMasukkan Nomor Paket (1-3): ");
        int pilihanPaket = input.nextInt();

        System.out.print("Masukkan Nomor Destinasi (1-3): ");
        int pilihanDestinasi = input.nextInt();

        // Validasi input paket dan destinasi
        if (pilihanPaket < 1 || pilihanPaket > 3 || pilihanDestinasi < 1 || pilihanDestinasi > 3) {
            System.out.println("Pilihan tidak valid!");
            input.close();
            return;
        }

        // Menanyakan apakah pengguna membutuhkan pemandu wisata
        System.out.print("Apakah Anda Memerlukan Pemandu Wisata? (true/false): ");
        boolean pemanduWisata = input.nextBoolean();
        double biayaPemandu = 100000.0;

        // Menghitung total biaya
        double totalHargaPaket = hargaPaket.get(pilihanPaket - 1) * jumlahOrang;
        double totalHargaDestinasi = hargaDestinasi.get(pilihanDestinasi - 1) * jumlahOrang;
        double totalBiaya = totalHargaPaket + totalHargaDestinasi;

        if (pemanduWisata) {
            totalBiaya += biayaPemandu;
        }

        // Menampilkan detail rincian
        System.out.println("\n|>>> Detail Rincian <<<|");
        System.out.println("| Nama                   : " + nama);
        System.out.println("| Jumlah Orang           : " + jumlahOrang);
        System.out.println("| Paket Wisata           : " + paketWisata.get(pilihanPaket - 1));
        System.out.println("| Harga Paket per Orang  : Rp " + hargaPaket.get(pilihanPaket - 1));
        System.out.println("| Destinasi              : " + destinasi.get(pilihanDestinasi - 1));
        System.out.println("| Harga Destinasi per Orang: Rp " + hargaDestinasi.get(pilihanDestinasi - 1));
        System.out.println("| Pemandu Wisata         : " + (pemanduWisata ? "Ya" : "Tidak"));
        System.out.println("| Biaya Pemandu          : Rp " + (pemanduWisata ? biayaPemandu : 0));
        System.out.println("| Total Biaya Keseluruhan: Rp " + totalBiaya);
        System.out.println("|=========================================|");

        input.close();
    }
}
