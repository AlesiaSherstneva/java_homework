package Credit.Exercise9.Technics;

import Credit.Exercise9.Properties.*;

public abstract class Household {
    protected String name;
    protected int voltage;
    protected int power;
    protected final Size SIZE;
    protected final Appointment APP;

    public Household(String name, int voltage, int power, Size SIZE, Appointment APP) {
        this.name = name;
        this.voltage = voltage;
        this.power = power;
        this.SIZE = SIZE;
        this.APP = APP;
    }

    public String getName() {
        return name;
    }

    public int getVoltage() {
        return voltage;
    }

    public int getPower() {
        return power;
    }

    public Size getSIZE() {
        return SIZE;
    }

    public Appointment getAPP() {
        return APP;
    }

    public boolean turnOn () {
        if (this.voltage == 220) {
            System.out.println(this.name + " включён в розетку");
            return true;
        } else {
            return false;
        }
    }
}
