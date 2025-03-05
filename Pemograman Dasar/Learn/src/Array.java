import java.util.ArrayList;

public class Array {
    public static void main(String[] args) {
        //Array1
        String [] arrayNama = new String[6];
        arrayNama[0] = "Akbar";
        arrayNama[1] = "Faiz";
        arrayNama[2] = "Faqih";
        arrayNama[3] = "Febriana";
        arrayNama[4] = "leony";
        arrayNama[5] = "Manda";

        int nameX = 5;
        System.out.println("Jumlah nama " + arrayNama.length);
        System.out.println("Nama Ke-" + nameX + " = " + arrayNama[nameX]);

        System.out.println("========================");
        //Array2
        String [] names = {"Akbar", "Faiz", "Faqih", "Febriana", "leony"};
        int nameY = 4;
        System.out.println("Jumlah nama " + names.length);
        System.out.println("Nama Ke-" + nameY + " = " + names[nameY]);

        System.out.println("========================");
        //ArrayList
        ArrayList<String> namaA = new ArrayList<>();
        namaA.add("Akbar");
        namaA.add("Faiz");
        namaA.add("Faqih");
        namaA.add("Febriana");
        namaA.add("Leony");
        for (int i = 0; i < namaA.size(); i++) {
            System.out.println("Nama Ke-" + (i+1) + " " + namaA.get(i));
        }

    }
}
