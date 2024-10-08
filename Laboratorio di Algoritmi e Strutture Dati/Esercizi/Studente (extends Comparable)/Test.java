import java.util.*;

public class Test {
    public static void main(String[] args) {
        VettoreOrdinabile<Studente> array = new VettoreOrdinabile<Studente>(10);

        array.add(new Studente("Lorenzo", "Barretta", 5.1));
        array.add(new Studente("Sto", "Cazzo", 2.8));
        array.add(new Studente("Daniele", "Cieri", 8.1));

        array.sort();

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.read(i).name);
        };
    }    
}
