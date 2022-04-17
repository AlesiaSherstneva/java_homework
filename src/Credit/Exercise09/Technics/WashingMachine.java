package Credit.Exercise09.Technics;

import Credit.Exercise09.Properties.Appointment;
import Credit.Exercise09.Properties.Size;

public class WashingMachine extends Household {
    public WashingMachine() {
        super("Стиральная машина", 220, 600, Size.LARGE, Appointment.FOR_HOUSE);
    }
}
