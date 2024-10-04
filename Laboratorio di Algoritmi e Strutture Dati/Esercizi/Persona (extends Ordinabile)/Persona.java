class Persona implements Ordinabile {
    String name;
    String surname;
    int age;    

    public Persona(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int confronta(Ordinabile obj) {
        Persona p;
        if (obj == null) throw new NullPointerException("L'oggetto specificato è null");
        if (obj instanceof Persona) p = (Persona) obj;
        else throw new ClassCastException("L'oggetto specificato non è confrontabile con questo oggetto");

        if (this.age > p.age) return 1;
        if (this.age < p.age) return -1;

        return 0;
    }    
}
