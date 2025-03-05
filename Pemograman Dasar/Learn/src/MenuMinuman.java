import java.util.ArrayList;

public class MenuMinuman {
    public static void main(String[] args) {
        // Array untuk menyimpan nama minuman
        ArrayList<String> minumanList = new ArrayList<>();
        ArrayList<Integer> hargaList = new ArrayList<>();

        minumanList.add("Teh");
        minumanList.add("kopi");
        minumanList.add("Jus Jeruk");
        minumanList.add("Air Mineral");

        hargaList.add(4000);
        hargaList.add(5000);
        hargaList.add(5000);
        hargaList.add(3000);

        for (int i = 0; i < minumanList.size(); i++){
            System.out.println((i + 1) + minumanList.get(i) + hargaList.get(i));
        }
        
    }
}
