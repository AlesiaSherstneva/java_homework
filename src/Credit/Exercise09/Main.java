package Credit.Exercise09;

import java.util.*;

import Credit.Exercise09.Properties.Appointment;
import Credit.Exercise09.Properties.Size;
import Credit.Exercise09.Technics.*;

public class Main {
    public static void main(String[] args) {
        List<Household> myHouse = new ArrayList<>();
        myHouse.add(new Refrigerator());
        myHouse.add(new Microwave());
        myHouse.add(new Multicooker());
        myHouse.add(new Kettle());
        myHouse.add(new WashingMachine());
        myHouse.add(new AirConditioner());
        myHouse.add(new VacuumCleaner());
        myHouse.add(new Iron());

        int allPower = 0;
        System.out.println("Включение приборов в розетку:");
        for (Household device : myHouse) {
            if (device.turnOn()) {
                allPower += device.getPower();
            }
        }
        System.out.println("\nОбщая потребляемая мощность включённых приборов: " + allPower + " Вт*ч\n");

        System.out.println("Сортировка приборов по мощности:");
        myHouse.sort(Comparator.comparing(Household::getPower));
        for (Household device : myHouse) {
            System.out.println(device.getName() + " - потребляемая мощность " + device.getPower() + " Вт");
        }

        // принцип сортировки приборов по входному напряжению ничем не будет отличаться от сортировки по мощности

        System.out.println("\nСортировка приборов по размеру:");
        myHouse.sort(Comparator.comparing(Household::getSIZE));
        for (Household device : myHouse) {
            System.out.print(device.getName());
            if (device.getSIZE() == Size.LARGE) {
                System.out.println(" - крупная бытовая техника");
            } else {
                System.out.println(" - мелкая бытовая техника");
            }
        }

        // сортировка по назначению производилась бы по такому же принципу, сортировка по имени - просто по алфавиту

        System.out.println("""

                Найдём прибор, соответствующий заданным параметрам -\s
                входное напряжение 220 В, кухонный, максимальный по мощности:""");
        myHouse.stream()
                .filter((device -> device.getVoltage() == 220))
                .filter((device -> device.getAPP() == Appointment.FOR_KITCHEN))
                .sorted(Comparator.comparing(Household::getPower).reversed())
                .limit(1)
                .forEach((device) -> System.out.println(device.getName() + " - входное напряжение "
                        + device.getVoltage() + " , потребляемая мощность " + device.getPower() + " Вт*ч"));
    }
}
