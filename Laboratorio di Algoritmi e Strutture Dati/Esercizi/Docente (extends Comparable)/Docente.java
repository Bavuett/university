public class Docente implements Comparable<Docente> {
    private String name;
    private String surname;
    private String id;
    private int age;
    
    public Docente(String name, String surname, String id, int age) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }
    public String getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(Docente teacher) throws NullPointerException {
        if (teacher == null) throw new NullPointerException("Object specified is null.");

        return this.id.compareTo(teacher.getId());
    }
}
