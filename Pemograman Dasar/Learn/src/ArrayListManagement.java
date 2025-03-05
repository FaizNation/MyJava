import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListManagement {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk mengambil input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Membuat ArrayList untuk menyimpan data
        ArrayList<String> list = new ArrayList<>();
        int pilihan;

        do {
            // Menampilkan menu
            System.out.println("\nMenu:");
            System.out.println("1. Tambah item");
            System.out.println("2. Hapus item");
            System.out.println("3. Hapus semua item");
            System.out.println("4. Tampilkan daftar");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");
            pilihan = scanner.nextInt();

            // Membersihkan buffer scanner
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    // Menambahkan item ke dalam ArrayList
                    System.out.print("Masukkan item yang ingin ditambahkan: ");
                    String itemBaru = scanner.nextLine();
                    list.add(itemBaru);
                    System.out.println("Item \"" + itemBaru + "\" telah ditambahkan.");
                    break;

                case 2:
                    // Menghapus item dari ArrayList
                    if (list.isEmpty()) {
                        System.out.println("Daftar kosong, tidak ada item untuk dihapus.");
                    } else {
                        System.out.println("Daftar item saat ini:");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println((i + 1) + ". " + list.get(i));
                        }
                        System.out.print("Masukkan nomor item yang ingin dihapus: ");
                        int indexToRemove = scanner.nextInt();
                        if (indexToRemove >= 1 && indexToRemove <= list.size()) {
                            String removedItem = list.remove(indexToRemove - 1);
                            System.out.println("Item \"" + removedItem + "\" telah dihapus.");
                        } else {
                            System.out.println("Nomor item tidak valid.");
                        }
                    }
                    break;

                case 3:
                    // Menghapus semua item dari ArrayList
                    if (list.isEmpty()) {
                        System.out.println("Daftar kosong, tidak ada item untuk dihapus.");
                    } else {
                        list.clear();  // Menghapus semua item
                        System.out.println("Semua item telah dihapus.");
                    }
                    break;

                case 4:
                    // Menampilkan daftar item
                    if (list.isEmpty()) {
                        System.out.println("Daftar kosong.");
                    } else {
                        System.out.println("Daftar saat ini:");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println((i + 1) + ". " + list.get(i));
                        }
                    }
                    break;

                case 5:
                    // Keluar dari program
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Opsi tidak valid. Coba lagi.");
                    break;
            }
        } while (pilihan != 5);

        // Menutup scanner
        scanner.close();
    }
}
