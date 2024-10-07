import java.lang.Comparable;

public class Studente implements Comparable<Studente> {
    String name;
    String surname;
    double gradePointAverage;

    public Studente(String name, String surname, double gradePointAverage) {
        this.name = name;
        this.surname = surname;
        this.gradePointAverage = gradePointAverage;
    }

    @Override
    public int compareTo(Studente s) {
        if (s == null) throw new NullPointerException("L'oggetto specificato è null");

        return this.name.compareTo(s.name);
    }
    
}