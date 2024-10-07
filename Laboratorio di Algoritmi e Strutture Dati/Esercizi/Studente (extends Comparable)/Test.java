import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Studente> studenti = new ArrayList<Studente>();

        studenti.add(new Studente("Lorenzo", "Barretta", 5.1));
        studenti.add(new Studente("Sto", "Cazzo", 2.8));
        studenti.add(new Studente("Daniele", "Cieri", 8.1));

        studenti.sort(Comparator.naturalOrder());

        for (int i = 0; i < studenti.size(); i++) {
            System.out.println(studenti.get(i).name);
        };
    }    
}
