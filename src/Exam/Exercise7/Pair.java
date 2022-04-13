package Exam.Exercise7;

public class Pair<T, K> {
    private T firstGeneric;
    private K lastGeneric;

    public Pair(T firstGeneric, K lastGeneric) {
        this.firstGeneric = firstGeneric;
        this.lastGeneric = lastGeneric;
    }

    public T first() {
        return firstGeneric;
    }

    public K last() {
        return lastGeneric;
    }

    public Pair<K, T> swap() {
        return new Pair<>(this.lastGeneric, this.firstGeneric);
    }

    public void replaceFirst(T newFirstGeneric) {
        this.firstGeneric = newFirstGeneric;
    }

    public void replaceLast(K newLastGeneric) {
        this.lastGeneric = newLastGeneric;
    }
}
