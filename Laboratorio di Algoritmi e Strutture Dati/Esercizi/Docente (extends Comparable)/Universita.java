import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Universita {
    private List<Docente> teachers;

    Universita() {
        this.teachers = new ArrayList<>();
    }

    public boolean insert(String name, String surname, String id, int age) {
        for (Docente teacher : this.teachers) {
            if (teacher.getId() == id) return false;
        }

        this.teachers.add(new Docente(name, surname, id, age));
        return true;
    }

    public boolean remove(String id) {
        for (int i = 0; i < this.teachers.size(); i++) {
            if (this.teachers.get(i).getId() == id) {
                this.teachers.remove(i);
                return true;
            }
        }

        return false;
    }

    public int minimumAge() throws IllegalStateException {
        int min_age = Integer.MAX_VALUE;

        if (this.teachers.isEmpty()) throw new IllegalStateException("No teachers currently added in University.");

        for (Docente teacher: this.teachers) {
            if (min_age > teacher.getAge()) min_age = teacher.getAge();
        }

        return min_age;
    }

    public int mostRepresentedAge() throws IllegalStateException {
        int most_represented_age = 0;
        int most_represented_age_counter = 0;

        if (this.teachers.isEmpty()) throw new IllegalStateException("No teachers currently added in University.");

        // Le età sono le nostre chiavi, pertanto usiamo Integer come primo tipo. Integer sarà anche il secondo
        // tipo in quanto il secondo valore della HashMap sarà un contatore.
        HashMap<Integer, Integer> ages_counter = new HashMap<Integer, Integer>();

        // Usiamo le età come chiavi della Map. Il metodo getOrDefault() consente di partire da un valore di 
        // default in caso non esista in precedenza.
        for (Docente teacher: this.teachers) {
            ages_counter.put(teacher.getAge(), ages_counter.getOrDefault(teacher.getAge(), 0) + 1);
        }

        // Otteniamo le varie età, considerato che sono le chiavi della nostra Map.
        // Otteniamo i contatori usando il valore "age", che come detto prima costituiscono
        // le nostre chiavi. Possiamo quindi sovrascrivere i valori agevolmente.
        for (int age: ages_counter.keySet()) {                              
            if (ages_counter.get(age) > most_represented_age_counter) {     
                most_represented_age = age;                                 
                most_represented_age_counter = ages_counter.get(age);
            }
        }

        return most_represented_age;
    }

    public List<Docente> getSortedTeachers() throws IllegalStateException {
        List<Docente> orderedTeachers = new ArrayList<>(this.teachers);
        
        if (this.teachers.isEmpty()) throw new IllegalStateException("No teachers currently added in University.");

        // Creiamo un nuovo Comparatore ad-hoc per la funzione, specificando i criteri mediante la funzione compare()
        // appartente alla classe Comparator appena creata.
        orderedTeachers.sort(new Comparator<Docente>() {
            public int compare(Docente o1, Docente o2) {

                // Iniziamo la comparazione tenendo conto dell'età. Se fossero uguali, si procede al confronto utilizzando il cognome.
                // Qualora non dovesse bastare, si passa al nome. Si rammenta che, qualora il comparatore restituisca 0, si interpreta
                // che i valori comparati siano equivalenti. Siamo perciò in grado di usare questo valore per capire quando non basta  
                // una comparazione e si vede necesario procedere alla prossima.
                if (o1.getAge() != o2.getAge()) return Integer.compare(o1.getAge(), o2.getAge());
                if (o1.getSurname().compareTo(o2.getSurname()) != 0) return o1.getSurname().compareTo(o2.getSurname());

                return o1.getName().compareTo(o2.getName());
            }
        });

        return orderedTeachers;
    }

    public List<Docente> getMinimumAgeTeachers() throws IllegalStateException {
        List<Docente> minimumAgeTeachers = new ArrayList<>();

        for (Docente teacher: this.teachers) {
            if (teacher.getAge() == this.minimumAge()) minimumAgeTeachers.add(teacher);
        }

        // In modo simile a quanto fatto in precedenza, 
        minimumAgeTeachers.sort(new Comparator<Docente>() {
            public int compare(Docente o1, Docente o2) {
                if (o1.getSurname().compareTo(o2.getSurname()) != 0) return o1.getSurname().compareTo(o2.getSurname());

                return o1.getName().compareTo(o2.getName());
            }
        });

        return minimumAgeTeachers;
    }
}
