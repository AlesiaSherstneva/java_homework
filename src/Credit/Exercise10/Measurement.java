package Credit.Exercise10;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collection;

public class Measurement {
    Collection<String> c;
    long elementsCount;

    public Measurement(Collection<String> c, long elementsCount) {
        this.c = c;
        this.elementsCount = elementsCount;
    }


    public class Result {
        String colType = c.getClass().getSimpleName();
        String dataType = "String";
        Long amount = elementsCount;
        Operation operation;
        int time;

        public String toString() {
            return String.format("Тип коллекции: %s, тип данных: %s, количество элементов: %d, " +
                    "операция: %s, время: %d ms", colType, dataType, amount, operation.getDisplayName(), time);
        }
    }

    Result measureAdd() {
        Result result = new Result();
        result.operation = Operation.ADD_ELEMENT;
        long start = System.currentTimeMillis();
        while (c.size() != elementsCount) {
            int size = (int) (Math.random() * 30 + 10);
            SecureRandom random = new SecureRandom();
            String randomStr = new BigInteger(size, random).toString(32);
            c.add(randomStr);
        }
        long finish = System.currentTimeMillis();
        result.time = (int) (finish - start);
        return result;
    }

    Result measureRemove() {
        Result result = new Result();
        result.operation = Operation.REMOVE_ELEMENT;
        long start = System.currentTimeMillis();
        c.clear();
        long finish = System.currentTimeMillis();
        result.time = (int) (finish - start);
        return result;
    }


    Result measureSearch() {
        Result result = new Result();
        result.operation = Operation.SEARCH_ELEMENT;
        long start = System.currentTimeMillis();
        //noinspection ResultOfMethodCallIgnored
        c.contains("Any element");
        long finish = System.currentTimeMillis();
        result.time = (int) (finish - start);
        return result;
    }

}
