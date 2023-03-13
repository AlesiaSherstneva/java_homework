package Extra.RomanNumerals;

public class RomanNumerals {
    public static void main(String[] args) {
        StringBuilder table = new StringBuilder();
        table.append("-".repeat(77)).append("\n")
                .append(String.valueOf(String.format("|%s| %s ", "Арабские", "Римские")).repeat(4))
                .append("|\n")
                .append(String.valueOf(String.format("|%6s  | %6s  ", "числа", "числа")).repeat(4))
                .append("|\n").append("-".repeat(77)).append("\n");

        int counter = 1;
        while (counter <= 25) {
            for (int i = counter; i <= 100; i += 25) {
                table.append(String.format("|%5d%3s|%8s ", i, "",
                        getRomanDigit(i / 10 * 10) + getRomanDigit(i % 10)));
            }
            table.append("|\n");
            counter++;
        }
        table.append("-".repeat(77)).append("\n");
        System.out.print(table);
    }

    public static String getRomanDigit(int number) {
        StringBuilder result = new StringBuilder();
        switch (number) {
            case 1 -> result.append("I");
            case 2 -> result.append(getRomanDigit(1)).append(getRomanDigit(1));
            case 3 -> result.append(getRomanDigit(1)).append(getRomanDigit(2));
            case 4 -> result.append(getRomanDigit(1)).append(getRomanDigit(5));
            case 5 -> result.append("V");
            case 6 -> result.append(getRomanDigit(5)).append(getRomanDigit(1));
            case 7 -> result.append(getRomanDigit(5)).append(getRomanDigit(2));
            case 8 -> result.append(getRomanDigit(5)).append(getRomanDigit(3));
            case 9 -> result.append(getRomanDigit(1)).append(getRomanDigit(10));
            case 10 -> result.append("X");
            case 20 -> result.append(getRomanDigit(10)).append(getRomanDigit(10));
            case 30 -> result.append(getRomanDigit(10)).append(getRomanDigit(20));
            case 40 -> result.append(getRomanDigit(10)).append(getRomanDigit(50));
            case 50 -> result.append("L");
            case 60 -> result.append(getRomanDigit(50)).append(getRomanDigit(10));
            case 70 -> result.append(getRomanDigit(50)).append(getRomanDigit(20));
            case 80 -> result.append(getRomanDigit(50)).append(getRomanDigit(30));
            case 90 -> result.append(getRomanDigit(10)).append(getRomanDigit(100));
            case 100 -> result.append("C");
        }
        return result.toString();
    }
}
