package Credit.Exercise11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class MyNewQueue extends ArrayDeque<Integer> implements MyQueue {
    private final ArrayList<Integer> maxList = new ArrayList<>();

    @Override
    public void push(Integer number) {
        maxList.add(number);
        Collections.sort(maxList);
        super.push(number);
    }

    @Override
    public Integer pop() {
        maxList.remove(super.getFirst());
        return super.pop();
    }

    @Override
    public Integer max() {
        if (maxList.isEmpty()) {
            return null;
        }
        return maxList.get(maxList.size() - 1);
    }
}
