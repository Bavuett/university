import java.util.List;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

    }

    public static <T> int itemsWithoutDuplication(List<T> array) {
        HashMap<T, Integer> itemCounts = new HashMap<>();
        int itemsWithoutDuplication = 0;

        for (int i = 0; i < array.size(); i++) itemCounts.put(array.get(i), itemCounts.getOrDefault(array.get(i), 0) + 1);
        

        return itemsWithoutDuplication;
    }
}
