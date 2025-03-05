import java.util.Scanner;
import java.util.ArrayList;

public class uts {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            //Judul Aplikasi.
            System.out.println("|=================================================================|");
            System.out.println("|>>                                                             <<|");
            System.out.println("|>                      HEALING RESERVATION                      <|");
            System.out.println("|>>                     << PT Faiz Nation >>                    <<|");
            System.out.println("|=================================================================|");
            System.out.println(" ");
            System.out.println("<<<=============================================================>>>");
            System.out.println(" ");
            
            //Pengguna Memasukan Nama (Menggunakan String).
            System.out.print("Masukan Nama Anda   : " );
            String nama = input.nextLine();

            //Pengguna Memasukan Jumlah Orang yang Ikut Wisata (Menggunakan int).
            System.out.print("Masukan Jumlah Orang: ");
            int jumlahOrang = input.nextInt();

            //Pilihan Paket Wisata Beserta Harga Per Orang.
            System.out.println(" ");
            System.out.println("|=================================================================|");
            System.out.println("|>                     Pilihan Paket Wisata                      <|");
            System.out.println("|=================================================================|");
            System.out.println("| NO |  Paket Wisata:  |       Fasilitas:       | Harga Per Orang:|");
            System.out.println("|-----------------------------------------------------------------|");
            System.out.println("| 1. | Paket Exclusive | 1. Free sewa kendaraan | Rp 100000       |");
            System.out.println("|    |                 | 2. Asuransi perjalanan |                 |");
            System.out.println("|    |                 | 3. Costumer Support    |                 |");
            System.out.println("|-----------------------------------------------------------------|");
            System.out.println("| 2. | Paket Simple    | 1. Free sewa kendaraan | Rp 70000        |");
            System.out.println("|    |                 | 2. Costumer Support    |                 |");
            System.out.println("|-----------------------------------------------------------------|");
            System.out.println("| 3. | Paket Murah     | 1. Costumer Support    | Rp 50000        |");
            System.out.println("|=================================================================|");
            System.out.print("Masukan nomor Paket WIsata: ");// Pengguna Memillih Paket Wisata.
            int pilihanPaketWisata = input.nextInt();//Menggunakan int.

            //Variabel.
            String paketWisata;//variabel untuk tujuan wisata menggunakan string.
            double hargaPerOrang;//variabel untuk harga per orang menggunakan double.
            switch (pilihanPaketWisata) {//switch case untuk memilih paket wisata.
                case 1:
                    paketWisata = "Paket Exclusive";
                    hargaPerOrang = 100000;
                    break;
                case 2:
                    paketWisata = "Paket Simple";
                    hargaPerOrang = 70000;
                    break;
                case 3:
                    paketWisata = "Paket Murah";
                    hargaPerOrang = 50000;
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
                    return;// keluar dari program jika pilihan tidak valid.
            }

            //Menanyakan kepada pengguna apakah mebutuhkan pemandau wisata? jika iya true jika tidak false.
            System.out.print("Apakah Anda Memerlukan Pemandu Wisata? (true/false): ");
            boolean PemanduWisata = input.nextBoolean(); //menggunakan boolean.
            double biayaPemandu = 100000; //biaya pemandu jika menggunakan pemandu (menggunakan double).

            System.out.println(" ");

            //Array untuk menambahkan pilihan destinasi yang ingin dipiih pengguna.
            ArrayList<String> destinasi = new ArrayList<>();
            ArrayList<Integer> harga = new ArrayList<>();

            //ArrayList String.
            destinasi.add("Gunung");
            destinasi.add("Pantai");
            destinasi.add("Kota");

            //ArrayList Integer.
            harga.add(50000);
            harga.add(35000);
            harga.add(25000);

            //Daftar destinasi yang disediakan.
            System.out.println(" ");
            System.out.println("|>>>===========================================================<<<|");
            System.out.println(" ");
            System.out.println("|=================================================================|");
            System.out.println("|>             Daftar Destinasi dan Harga Per Orang:             <|");
            System.out.println("|=================================================================|");

            //Menampilkan Daftar destinassi.
            for (int i = 0; i < destinasi.size(); i++) {
                System.out.println("|" + (i + 1) + ". " + destinasi.get(i) + ": Rp " + harga.get(i));
            }

            System.out.println("|=================================================================|");
            System.out.print("Masukan nomor tujuan destinasi wisata: ");
            int destinasiPilihan = input.nextInt();//Pengguna memasukan pilihan destinasi.

            //Variabel
            String tujuanDestinasi;//Variabel untuk tujuan destinasi.
            double hargaDestinasi;//Variabel untuk harga destinasi.
            switch (destinasiPilihan) {//Switch case untuk memilih tujuan destinasi.
                case 1:
                    tujuanDestinasi = "Gunung";
                    hargaDestinasi = 50000;
                    break;
                case 2:
                    tujuanDestinasi = "Pantai";
                    hargaDestinasi = 35000;
                    break;
                case 3:
                    tujuanDestinasi = "Kota";
                    hargaDestinasi = 25000;
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    return;
            }

            //Menghitung total harga paket.
            double totalHargaPaket = hargaPerOrang * jumlahOrang;
            //Menghitung total harga destinasi.
            double totalHargaDestinasi = hargaDestinasi * jumlahOrang;
            //Menghitung total biaya keseluruhan.
            double totalBiaya = (hargaPerOrang * jumlahOrang) + (hargaDestinasi * jumlahOrang);//Menggunakan double.

            //Jika menggunakan pemandu wisata maka total biaya keseluruhan ditambah biaya pemandu.
            if (PemanduWisata) {
                totalBiaya += biayaPemandu;
            }

            //Menampilkan detail rician.
            System.out.println(" ");
            System.out.println("|>>>===========================================================<<<|");
            System.out.println(" ");
            System.out.println("|=================================================================|");
            System.out.println("|>                        Detail Rincian                         <|");
            System.out.println("|=================================================================|");
            System.out.println("|Nama                     : " + nama);
            System.out.println("|Jumlah Orang             : " + jumlahOrang);
            System.out.println("|Paket Wisata             : " + paketWisata);
            System.out.println("|Biaya Paket Per Orang    : Rp " + hargaPerOrang);
            System.out.println("|Total Harga Paket        : Rp " + totalHargaPaket);
            System.out.println("|Pemandu Wisata           : " + (PemanduWisata ? "Ya" : "Tidak"));
            System.out.println("|Biaya Pemandu            : Rp " + (PemanduWisata ? biayaPemandu : 0));
            System.out.println("|Tujuan Destinasi         : " + tujuanDestinasi);
            System.out.println("|Biaya Destinasi per Orang: Rp " + hargaDestinasi);
            System.out.println("|Total Harga Destinasi    : Rp " + totalHargaDestinasi);
            System.out.println("|=================================================================|");
            System.out.println("|Biaya Keseluruhan        : Rp " + totalBiaya);
            System.out.println("|=================================================================|");
            System.out.println("|                         BY FAIZ NATION                          |");
            System.out.println("|=================================================================|");

        }


    }
}