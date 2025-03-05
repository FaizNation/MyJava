import java.util.ArrayList;
import java.util.Scanner;

public class CashManagementApp {
    public static void main(String[] args) {

        // Nama aplikasi
        System.out.println("|==============================================|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|>>       Aplikasi Pendataan Kas Kelas       <<|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|==============================================|");

        // Deklarasi variabel
        ArrayList<String> namaSiswa = new ArrayList<>();
        ArrayList<Double> kasSiswa = new ArrayList<>();
        ArrayList<String> alasanPengeluaran = new ArrayList<>();
        ArrayList<Double> pengeluaranKas = new ArrayList<>();
        boolean running = true;
        try (Scanner scanner = new Scanner(System.in)) {
            double totalKas = 0;
            double totalPemasukan = 0;
            double totalPengeluaran = 0;

            // Looping aplikasi (while)
            while (running) {

                // Tampilkan menu utama dalam format
                System.out.println("\n|==============================================|");
                System.out.println("|>>               Menu Utama                 <<|");
                System.out.println("|==============================================|");
                System.out.printf("| %-2s | %-39s |\n", "1", "Tambah data siswa");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "2", "Tambah kas pada siswa yang sama");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "3", "Pengeluaran kas");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "4", "Tampilkan rekap kas");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "5", "Hapus data siswa");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "6", "Tampilkan total kas");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "7", "Manipulasi String (Menarik!)");
                System.out.println("|----------------------------------------------|");
                System.out.printf("| %-2s | %-39s |\n", "8", "Keluar");
                System.out.println("|==============================================|");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();

                // Pilihan menu menggunakan switch case
                switch (pilihan) {

                    // Tambah data siswa
                    case 1 -> {
                        System.out.print("Masukkan nama siswa: ");
                        scanner.nextLine();
                        String nama = scanner.nextLine();
                        
                        // Manipulasi string
                        System.out.println("Nama disimpan dengan huruf kapital: " + nama.toUpperCase());
                        System.out.print("Masukkan jumlah kas " + nama.toUpperCase() + ": " );
                        double kas = scanner.nextDouble();
                        
                        // Tambahkan data ke ArrayList
                        namaSiswa.add(nama.toUpperCase());
                        kasSiswa.add(kas);
                        totalKas += kas; // Tambahkan ke total kas
                        totalPemasukan += kas; // Tambahkan ke total pemasukan
                        System.out.println("Data berhasil ditambahkan!");
                    }

                    // Tambah kas pada siswa yang sama
                    case 2 -> {
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            System.out.println("\nDaftar Siswa:");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("%d. %s - Kas: Rp %.2f\n", (i + 1), namaSiswa.get(i), kasSiswa.get(i));
                            }

                            System.out.print("Masukkan nomor siswa yang ingin menambah kas: ");
                            int nomorSiswa = scanner.nextInt();

                            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                                System.out.print("Masukkan jumlah kas tambahan: ");
                                double tambahanKas = scanner.nextDouble();

                                // Tambahkan kas pada siswa yang dipilih
                                kasSiswa.set(nomorSiswa - 1, kasSiswa.get(nomorSiswa - 1) + tambahanKas);
                                totalKas += tambahanKas; // Tambahkan ke total kas
                                totalPemasukan += tambahanKas; // Tambahkan ke total pemasukan
                                System.out.println("Kas berhasil ditambahkan untuk siswa " + namaSiswa.get(nomorSiswa - 1) + ".");
                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }
                        }
                    }

                    // Pengeluaran kas
                    case 3 -> {
                        System.out.print("Masukkan jumlah pengeluaran kas: ");
                        double pengeluaranKasAmount = scanner.nextDouble();
                        scanner.nextLine();
                        
                        System.out.print("Masukkan keterangan pengeluaran: ");
                        String keteranganPengeluaran = scanner.nextLine();

                        if (pengeluaranKasAmount <= totalKas) {
                            // Kurangi total kas
                            totalKas -= pengeluaranKasAmount;
                            totalPengeluaran += pengeluaranKasAmount; // Tambahkan ke total pengeluaran
                            pengeluaranKas.add(pengeluaranKasAmount);
                            alasanPengeluaran.add(keteranganPengeluaran);
                            System.out.println("Pengeluaran sebesar Rp " + pengeluaranKasAmount + " berhasil dicatat.");
                            System.out.println("Keterangan: " + keteranganPengeluaran);
                            System.out.println("Total kas sekarang: Rp " + totalKas);
                        } else {
                            System.out.println("Total kas tidak mencukupi untuk pengeluaran sebesar itu.");
                        }
                    }

                    // Tampilkan rekap kas
                    case 4 -> {
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            System.out.println("|==========================================================================|");
                            System.out.println("|    |            PEMASUKAN               |            PENGELUARAN         |");
                            System.out.println("|==========================================================================|");
                            System.out.println("| NO | NAMA SISWA          |    JUMLAH    | KETERANGAN        |   JUMLAH   |");
                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            
                            // Tampilkan Pemasukan
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                // Format untuk nama dan kas
                                System.out.printf("| %-2d | %-19s | %-12.2f | %-17s | %-10s |\n", 
                                                  (i + 1), 
                                                  namaSiswa.get(i), 
                                                  kasSiswa.get(i), 
                                                  "", 
                                                  "");
                            }
                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            // Tampilkan Pengeluaran
                            for (int i = 0; i < alasanPengeluaran.size(); i++) {
                                // Format untuk pengeluaran
                                System.out.printf("| %-2s | %-19s | %-12s | %-17s | %-10.2f |\n", 
                                (i + 1), 
                                                  "", 
                                                  "", 
                                                  alasanPengeluaran.get(i), 
                                                  pengeluaranKas.get(i));
                            }

                            System.out.println("|----|---------------------|--------------|-------------------|------------|");
                            System.out.printf("| %-24s | %-45.2f |\n", "TOTAL PEMASUKAN:", totalPemasukan);
                            System.out.printf("| %-24s | %-45.2f |\n", "TOTAL PENGELUARAN:", totalPengeluaran);
                            System.out.println("|--------------------------|-----------------------------------------------|");
                            System.out.printf("| %-24s | %-45.2f |\n", "JUMLAH KAS SEKARANG:", totalKas);
                            System.out.println("|==========================================================================|");
                        }
                    }

                    // Hapus data siswa (menghapus siswa sepenuhnya)
                    case 5 -> {

                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa untuk dihapus.");
                        } else {
                            System.out.println("\nDaftar Siswa:");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("%d. %s - Kas: Rp %.2f\n", (i + 1), namaSiswa.get(i), kasSiswa.get(i));
                            }

                            System.out.print("Masukkan nomor siswa yang ingin dihapus: ");
                            int nomorSiswa = scanner.nextInt();

                            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                                // Kurangi total kas dengan kas siswa yang dihapus
                                double kasDihapus = kasSiswa.get(nomorSiswa - 1);
                                totalKas -= kasDihapus;

                                // Hapus siswa dari ArrayList
                                namaSiswa.remove(nomorSiswa - 1);
                                kasSiswa.remove(nomorSiswa - 1);

                                System.out.println("Data berhasil dihapus. Kas dikurangi sebesar Rp " + kasDihapus);
                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }
                        }
                    }

                    // Tampilkan total kas
                    case 6 -> 
                        System.out.println("Total kas yang terkumpul saat ini: Rp " + totalKas);

                    // Menu untuk manipulasi string
                    case 7 -> {
                        System.out.println("\n|==============================================|");
                        System.out.println("|>>           Menu Manipulasi String         <<|");
                        System.out.println("|==============================================|");
                        
                        // Manipulasi String
                        if (!namaSiswa.isEmpty()) {
                            // Contoh manipulasi string 1: Gabung nama siswa menjadi satu string
                            String gabunganNama = String.join(", ", namaSiswa);
                            System.out.println("Gabungan nama siswa: " + gabunganNama);

                            // Contoh manipulasi string 2: Potong nama siswa pertama
                            if (namaSiswa.get(0).length() > 5) {
                                String potongNama = namaSiswa.get(0).substring(0, 5);
                                System.out.println("Potongan nama siswa pertama: " + potongNama);
                            }

                            // Contoh manipulasi string 3: Cari siswa berdasarkan substring
                            System.out.print("Masukkan nama yang ingin dicari (substring): ");
                            scanner.nextLine(); // Kosongkan buffer
                            String cariNama = scanner.nextLine();
                            for (String siswa : namaSiswa) {
                                if (siswa.contains(cariNama.toUpperCase())) {
                                    System.out.println("Siswa ditemukan: " + siswa);
                                }
                            }

                            // Contoh manipulasi string 4: Mengganti nama siswa
                            System.out.print("Masukkan nomor siswa yang ingin diganti namanya: ");
                            int nomorSiswaUbah = scanner.nextInt();
                            scanner.nextLine(); // Kosongkan buffer
                            if (nomorSiswaUbah > 0 && nomorSiswaUbah <= namaSiswa.size()) {
                                System.out.print("Masukkan nama baru: ");
                                String namaBaru = scanner.nextLine();
                                namaSiswa.set(nomorSiswaUbah - 1, namaBaru.toUpperCase());
                                System.out.println("Nama berhasil diganti!");
                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }

                            // Contoh manipulasi string 5: Hitung panjang nama siswa terpanjang
                            int maxLength = namaSiswa.stream().mapToInt(String::length).max().orElse(0);
                            System.out.println("Panjang nama siswa terpanjang: " + maxLength);

                            // Contoh manipulasi string 6: Tampilkan nama siswa secara terbalik
                            for (String siswa : namaSiswa) {
                                StringBuilder sb = new StringBuilder(siswa);
                                System.out.println("Nama terbalik: " + sb.reverse().toString());
                            }

                            // Contoh manipulasi string 7: Cek apakah ada nama siswa dengan panjang tertentu
                            System.out.print("Masukkan panjang nama untuk dicek: ");
                            int panjangCek = scanner.nextInt();
                            boolean adaNamaDenganPanjangTertentu = namaSiswa.stream().anyMatch(n -> n.length() == panjangCek);
                            System.out.println("Apakah ada nama siswa dengan panjang " + panjangCek + "? " + (adaNamaDenganPanjangTertentu ? "Ya" : "Tidak"));

                            // Contoh manipulasi string 8: Tampilkan nama siswa dalam urutan abjad
                            ArrayList<String> namaSiswaSorted = new ArrayList<>(namaSiswa);
                            namaSiswaSorted.sort(String::compareTo);
                            System.out.println("Nama siswa dalam urutan abjad: " + String.join(", ", namaSiswaSorted));

                            // Contoh manipulasi string 9: Ganti spasi dengan karakter lain
                            System.out.print("Masukkan karakter untuk mengganti spasi pada nama siswa: ");
                            scanner.nextLine(); // Kosongkan buffer
                            String karakterPengganti = scanner.nextLine();
                            for (String siswa : namaSiswa) {
                                System.out.println("Nama siswa dengan spasi diganti: " + siswa.replace(" ", karakterPengganti));
                            }

                            // Contoh manipulasi string 10: Hitung jumlah huruf vokal pada nama siswa
                            int totalVokal = 0;
                            for (String siswa : namaSiswa) {
                                for (char c : siswa.toLowerCase().toCharArray()) {
                                    if ("aeiou".indexOf(c) != -1) {
                                        totalVokal++;
                                    }
                                }
                            }
                            System.out.println("Jumlah total huruf vokal di semua nama siswa: " + totalVokal);
                        } else {
                            System.out.println("Belum ada data siswa untuk dimanipulasi.");
                        }
                    }

                    // Keluar dari aplikasi
                    case 8 -> {
                        running = false;
                        System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    }

                    default -> System.out.println("Pilihan tidak valid, coba lagi.");
                }
            }

            scanner.close();
        }
    }
}
