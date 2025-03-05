import java.util.Scanner;

public class p {

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

        System.out.print("Masukkan Budget Anda : ");
        double budgetAnda = input.nextDouble();

        // Data Paket dan Destinasi
        String[] paketWisata = {"Paket Exclusive", "Paket Simple", "Paket Murah"};
        double[] hargaPaket = {100000, 70000, 50000};

        String[] destinasi = {"Gunung", "Pantai", "Kota"};
        double[] hargaDestinasi = {50000, 35000, 25000};

        System.out.println("\n|>>> Rekomendasi Berdasarkan Budget <<<|");

        // Menampilkan Rekomendasi Berdasarkan Budget
        boolean adaRekomendasi = false;

        // Memeriksa semua kombinasi paket dan destinasi
        for (int i = 0; i < paketWisata.length; i++) {
            for (int j = 0; j < destinasi.length; j++) {
                // Hitung total biaya untuk kombinasi paket dan destinasi
                double totalBiaya = (hargaPaket[i] + hargaDestinasi[j]) * jumlahOrang;

                // Jika sesuai budget, tampilkan rekomendasi
                if (totalBiaya <= budgetAnda) {
                    adaRekomendasi = true;
                    System.out.printf("Paket: %s, Destinasi: %s, Total Biaya: Rp %.2f\n", 
                                      paketWisata[i], destinasi[j], totalBiaya);
                }
            }
        }

        // Jika tidak ada rekomendasi yang sesuai budget
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

        // Validasi input
        if (pilihanPaket < 1 || pilihanPaket > 3 || pilihanDestinasi < 1 || pilihanDestinasi > 3) {
            System.out.println("Pilihan tidak valid!");
            input.close();
            return;
        }

        // Menanyakan Pemandu Wisata (Opsional)
        System.out.print("Apakah Anda Memerlukan Pemandu Wisata? (true/false): ");
        boolean pemanduWisata = input.nextBoolean();
        double biayaPemandu = 100000;

        // Menghitung Total Biaya Akhir
        double totalHargaPaket = hargaPaket[pilihanPaket - 1] * jumlahOrang;
        double totalHargaDestinasi = hargaDestinasi[pilihanDestinasi - 1] * jumlahOrang;
        double totalBiaya = totalHargaPaket + totalHargaDestinasi;

        if (pemanduWisata) {
            totalBiaya += biayaPemandu;
        }

        // Menampilkan Detail Rincian
        System.out.println("\n|>>> Detail Rincian <<<|");
        System.out.println("| Nama                   : " + nama);
        System.out.println("| Jumlah Orang           : " + jumlahOrang);
        System.out.println("| Paket Wisata           : " + paketWisata[pilihanPaket - 1]);
        System.out.println("| Harga Paket per Orang  : Rp " + hargaPaket[pilihanPaket - 1]);
        System.out.println("| Destinasi              : " + destinasi[pilihanDestinasi - 1]);
        System.out.println("| Harga Destinasi per Orang: Rp " + hargaDestinasi[pilihanDestinasi - 1]);
        System.out.println("| Pemandu Wisata         : " + (pemanduWisata ? "Ya" : "Tidak"));
        System.out.println("| Biaya Pemandu          : Rp " + (pemanduWisata ? biayaPemandu : 0));
        System.out.println("| Total Biaya Keseluruhan: Rp " + totalBiaya);
        System.out.println("|=========================================|");

        input.close();
    }
}
