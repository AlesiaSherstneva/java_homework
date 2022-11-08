package Extra.Friendship;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Friendship {
    public static void main(String[] args) {
        Map<String, TreeSet<String>> friendship = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String first, second;
        while (scanner.hasNext()) {
            first = scanner.next();
            second = scanner.next();
            if (friendship.containsKey(first)) {
                friendship.get(first).add(second);
            } else {
                TreeSet<String> set = new TreeSet<>();
                set.add(second);
                friendship.put(first, set);
            }
            if (friendship.containsKey(second)) {
                friendship.get(second).add(first);
            } else {
                TreeSet<String> set = new TreeSet<>();
                set.add(first);
                friendship.put(second, set);
            }
        }
        for (String name : friendship.keySet()) {
            System.out.print(name + " дружит с : ");
            for (String friend: friendship.get(name)) {
                System.out.print(friend + " ");
            }
            System.out.println();
        }
    }
}
