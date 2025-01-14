public class Teacher implements Comparable<Teacher> {
    private String name;
    private String surname;
    private String fiscal_code;

    public Teacher(String name, String surname, String fiscal_code) {
        this.name = name;
        this.surname = surname;
        this.fiscal_code = fiscal_code;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getFiscalCode() {
        return this.fiscal_code;
    }

    @Override
    public int compareTo(Teacher arg0) throws NullPointerException {
        if (arg0 == null) throw new NullPointerException("No valid Teacher given as argument.");

        if (this.surname.compareTo(arg0.getSurname()) != 0) return this.surname.compareTo(arg0.getSurname());

        return this.name.compareTo(arg0.getName());
    }

}