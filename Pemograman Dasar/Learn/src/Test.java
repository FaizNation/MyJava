import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        System.out.println("|==============================================|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|>>       Aplikasi Pendataan Kas Kelas       <<|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|==============================================|");

        ArrayList<String> namaSiswa = new ArrayList<>();
        ArrayList<Double> kasSiswa = new ArrayList<>();
        ArrayList<String> alasanPengeluaran = new ArrayList<>();
        ArrayList<Double> pengeluaranKas = new ArrayList<>();
        boolean running = true;
        try (Scanner scanner = new Scanner(System.in)) {
            double totalKas = 0;

            DecimalFormat formatter = new DecimalFormat("#,###");

            while (running) {
                System.out.println("\n|==============================================|");
                System.out.println("|>>               Menu Utama                 <<|");
                System.out.println("|==============================================|");
                System.out.printf("| %-2s | %-39s |\n", "1", "Tambah data siswa");
                System.out.printf("| %-2s | %-39s |\n", "2", "Tambah kas pada siswa yang sama");
                System.out.printf("| %-2s | %-39s |\n", "3", "Pengeluaran kas");
                System.out.printf("| %-2s | %-39s |\n", "4", "Tampilkan rekap kas");
                System.out.printf("| %-2s | %-39s |\n", "5", "Hapus data siswa");
                System.out.printf("| %-2s | %-39s |\n", "6", "Tampilkan total kas");
                System.out.printf("| %-2s | %-39s |\n", "7", "Keluar");
                System.out.println("|==============================================|");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Masukkan nama siswa: ");
                        String nama = scanner.nextLine();

                        // Menghapus angka dalam input nama
                        nama = nama.replaceAll("[0-9]", "");

                        // Validasi format nama
                        if (!nama.matches("^[a-zA-Z ]+$")) {
                            System.out.println("Nama hanya boleh mengandung huruf dan spasi.");
                            continue;
                        }

                        // Inisialisasi singkatan nama
                        String singkatan = "";
                        for (String part : nama.split(" ")) {
                            if (!part.isEmpty()) singkatan += part.charAt(0);
                        }
                        singkatan = singkatan.toUpperCase();

                        System.out.print("Masukkan jumlah kas: ");
                        double kas = scanner.nextDouble();

                        // Menambahkan emoji berdasarkan jumlah kas
                        String emoji = kas > 50000 ? "🤑" : "🙂";

                        namaSiswa.add(nama + " (" + singkatan + ") " + emoji);
                        kasSiswa.add(kas);
                        totalKas += kas;
                        System.out.println("Data berhasil ditambahkan!");
                    }

                    case 2 -> {
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("%d. %s - Kas: Rp %s\n", i + 1, namaSiswa.get(i), formatter.format(kasSiswa.get(i)));
                            }

                            System.out.print("Masukkan nomor siswa yang ingin menambah kas: ");
                            int nomorSiswa = scanner.nextInt();
                            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                                System.out.print("Masukkan jumlah kas tambahan: ");
                                double tambahanKas = scanner.nextDouble();
                                kasSiswa.set(nomorSiswa - 1, kasSiswa.get(nomorSiswa - 1) + tambahanKas);
                                totalKas += tambahanKas;
                                System.out.println("Kas berhasil ditambahkan untuk " + namaSiswa.get(nomorSiswa - 1) + ".");
                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }
                        }
                    }

                    case 3 -> {
                        System.out.print("Masukkan jumlah pengeluaran kas: ");
                        double pengeluaranKasAmount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Masukkan keterangan pengeluaran: ");
                        String keteranganPengeluaran = scanner.nextLine();

                        if (pengeluaranKasAmount <= totalKas) {
                            totalKas -= pengeluaranKasAmount;
                            pengeluaranKas.add(pengeluaranKasAmount);
                            alasanPengeluaran.add(keteranganPengeluaran);
                            System.out.println("Pengeluaran sebesar Rp " + formatter.format(pengeluaranKasAmount) + " berhasil dicatat.");
                        } else {
                            System.out.println("Total kas tidak mencukupi.");
                        }
                    }

                    case 4 -> {
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            System.out.println("| NO | NAMA SISWA               | JUMLAH KAS     |");
                            System.out.println("|----|--------------------------|----------------|");
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("| %-2d | %-24s | Rp %-12s |\n", i + 1, namaSiswa.get(i), formatter.format(kasSiswa.get(i)));
                            }
                        }
                    }

                    case 5 -> {
                        if (namaSiswa.isEmpty()) {
                            System.out.println("Belum ada data siswa.");
                        } else {
                            for (int i = 0; i < namaSiswa.size(); i++) {
                                System.out.printf("%d. %s - Kas: Rp %s\n", i + 1, namaSiswa.get(i), formatter.format(kasSiswa.get(i)));
                            }
                            System.out.print("Masukkan nomor siswa yang ingin dihapus: ");
                            int nomorSiswa = scanner.nextInt();
                            if (nomorSiswa > 0 && nomorSiswa <= namaSiswa.size()) {
                                totalKas -= kasSiswa.get(nomorSiswa - 1);
                                namaSiswa.remove(nomorSiswa - 1);
                                kasSiswa.remove(nomorSiswa - 1);
                                System.out.println("Data siswa berhasil dihapus.");
                            } else {
                                System.out.println("Nomor siswa tidak valid.");
                            }
                        }
                    }

                    case 6 -> System.out.println("Total kas: Rp " + formatter.format(totalKas));

                    case 7 -> {
                        running = false;
                        System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    }

                    default -> System.out.println("Pilihan tidak valid, coba lagi.");
                }
            }
        }
    }
}
