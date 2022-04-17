package Credit.Exercise9.Technics;

import Credit.Exercise9.Properties.Appointment;
import Credit.Exercise9.Properties.Size;

public class Refrigerator extends Household {
    public Refrigerator() {
        super("Холодильник", 220, 250, Size.LARGE, Appointment.FOR_KITCHEN);
    }
}
