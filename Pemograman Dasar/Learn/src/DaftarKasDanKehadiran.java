import java.util.ArrayList;
import java.util.Scanner;

class Anggota {
    String nama;
    String statusBayar;
    String statusKehadiran;

    Anggota(String nama) {
        this.nama = nama;
        this.statusBayar = "Belum Bayar"; // default status
        this.statusKehadiran = "Tidak Hadir"; // default status
    }

    public void ubahStatusBayar(String statusBaru) {
        this.statusBayar = statusBaru;
    }

    public void ubahStatusKehadiran(String statusBaru) {
        this.statusKehadiran = statusBaru;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Status Bayar: " + statusBayar + ", Status Kehadiran: " + statusKehadiran;
    }
}

public class DaftarKasDanKehadiran {
    public static void main(String[] args) {
        ArrayList<Anggota> daftarAnggota = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan beberapa anggota secara manual
        daftarAnggota.add(new Anggota("Aldo"));
        daftarAnggota.add(new Anggota("Bella"));
        daftarAnggota.add(new Anggota("Citra"));

        // Menampilkan daftar anggota dengan status awal
        System.out.println("Daftar Anggota dan Status:");
        for (Anggota anggota : daftarAnggota) {
            System.out.println(anggota);
        }

        // Mengubah status bayar atau kehadiran
        System.out.print("\nMasukkan nama anggota yang ingin diubah statusnya: ");
        String namaCari = scanner.nextLine();

        boolean ditemukan = false;
        for (Anggota anggota : daftarAnggota) {
            if (anggota.nama.equalsIgnoreCase(namaCari)) {
                ditemukan = true;
                System.out.println("\nPilih opsi untuk mengubah status:");
                System.out.println("1. Ubah Status Bayar");
                System.out.println("2. Ubah Status Kehadiran");
                System.out.print("Pilihan Anda: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // membersihkan buffer

                if (pilihan == 1) {
                    System.out.print("Masukkan status baru (Sudah Bayar/Belum Bayar): ");
                    String statusBayar = scanner.nextLine();
                    anggota.ubahStatusBayar(statusBayar);
                } else if (pilihan == 2) {
                    System.out.print("Masukkan status kehadiran baru (Hadir/Tidak Hadir): ");
                    String statusKehadiran = scanner.nextLine();
                    anggota.ubahStatusKehadiran(statusKehadiran);
                }
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Anggota dengan nama " + namaCari + " tidak ditemukan.");
        }

        // Menampilkan daftar anggota setelah perubahan status
        System.out.println("\nDaftar Anggota dan Status Terbaru:");
        for (Anggota anggota : daftarAnggota) {
            System.out.println(anggota);
        }

        scanner.close();
    }
}
