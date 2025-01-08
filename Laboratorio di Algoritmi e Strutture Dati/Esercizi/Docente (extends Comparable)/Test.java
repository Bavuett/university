import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Universita university = new Universita();

        university.insert("Matteo", "Cicolini", "CLMT001", 20);
        university.insert("Daniele", "Cieri", "CRDN001", 24);
        university.insert("Giovanna", "Melideo", "MLGV001", 20);
        university.insert("Maurizio", "Merluzzo", "MZMZ001", 25);
        university.insert("Dario", "Moccia", "MCDR001", 25);
        university.insert("Andrea", "De Amicis", "DMAD001", 25);

        List<Docente> sortedTeachers = new ArrayList<>(university.getSortedTeachers());
        List<Docente> minAgeTeachers = new ArrayList<>(university.getMinimumAgeTeachers());

        System.out.println(sortedTeachers.size());

        
        for (int i = 0; i < sortedTeachers.size(); i++) {
            System.out.println(sortedTeachers.get(i).getSurname() + " - " + minAgeTeachers.get(i).getName());
        }

        for (int i = 0; i < minAgeTeachers.size(); i++) {
            System.out.println(minAgeTeachers.get(i).getSurname() + " - " + minAgeTeachers.get(i).getAge());
        }
    }
}
