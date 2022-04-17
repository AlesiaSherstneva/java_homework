package Credit.Exercise9.Technics;

import Credit.Exercise9.Properties.Appointment;
import Credit.Exercise9.Properties.Size;

public class WashingMachine extends Household {
    public WashingMachine() {
        super("Стиральная машина", 220, 600, Size.LARGE, Appointment.FOR_HOUSE);
    }
}
