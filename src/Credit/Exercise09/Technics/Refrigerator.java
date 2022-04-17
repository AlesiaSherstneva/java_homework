package Credit.Exercise09.Technics;

import Credit.Exercise09.Properties.Appointment;
import Credit.Exercise09.Properties.Size;

public class Refrigerator extends Household {
    public Refrigerator() {
        super("Холодильник", 220, 250, Size.LARGE, Appointment.FOR_KITCHEN);
    }
}
