package Credit.Exercise10;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Measurement.Result> results = new ArrayList<>();

        ArrayList<String> arrayList = new ArrayList<>();
        Measurement measure = new Measurement(arrayList, 100);
        measures(results, measure);
        measure = new Measurement(arrayList, 10_000);
        measures(results, measure);
        measure = new Measurement(arrayList, 1_000_000);
        measures(results, measure);


        LinkedList<String> linkedList = new LinkedList<>();
        measure = new Measurement(linkedList,100);
        measures(results,measure);
        measure = new Measurement(linkedList,10_000);
        measures(results,measure);
        measure = new Measurement(linkedList,1_000_000);
        measures(results,measure);

        Set<String> hashSet = new HashSet<>();
        measure = new Measurement(hashSet, 100);
        measures(results,measure);
        measure = new Measurement(hashSet, 10_000);
        measures(results,measure);
        measure = new Measurement(hashSet, 1_000_000);
        measures(results,measure);

        TreeSet<String> treeSet = new TreeSet<>();
        measure = new Measurement(treeSet, 100);
        measures(results,measure);
        measure = new Measurement(treeSet, 10_000);
        measures(results,measure);
        measure = new Measurement(treeSet, 1_000_000);
        measures(results,measure);

        for (Measurement.Result element : results) {
            System.out.println(element);
        }
    }

    public static void measures(ArrayList<Measurement.Result> results, Measurement measure) {
        results.add(measure.measureAdd());
        results.add(measure.measureSearch());
        results.add(measure.measureRemove());
    }
}
