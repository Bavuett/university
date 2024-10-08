public class VettoreOrdinabile<T extends Comparable<? super T>> {
    private Comparable<?> array[];

    private int maxDimension;
    private int currentDimension;

    public VettoreOrdinabile(int maxDimension) {
        this.maxDimension = maxDimension;
        this.currentDimension = 0;

        this.array = new Comparable<?>[this.maxDimension];
    }

    public boolean add(T item) {
        if (item == null || this.currentDimension >= this.maxDimension) return false;

        // Usiamo il post incremento per mantenere il codice pulito e comprensibile.
        // Infatti prima si assegna, poi si effettua l'incremento nell'Array.
        this.array[currentDimension++] = item;
        return true; 
    }

    public T read(int index) {
        if (index < 0 || index > currentDimension) return null;

        return (T)(this.array[index]);
    }

    public int size() {
        return this.currentDimension;
    }

    public void sort() {
        int s, i, j, num = this.currentDimension;
        T temp;

        for (s = num / 2; s > 0; s /= 2) {
            for (i = s; i < num; i++) {
                for (j = i - s; j >= 0; j -= s) {
                    if ((T)array[j]).compareTo((T)array[j + s]) {
                        temp = (T)(array[j]);
                        array[j] = array[j + s];
                        array[j + s] = temp;
                    }
                }
            }
        }
    }
}
