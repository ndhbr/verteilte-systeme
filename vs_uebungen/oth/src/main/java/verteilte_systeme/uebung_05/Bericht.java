package verteilte_systeme.uebung_05;

import java.io.Serializable;
import java.util.Date;

public class Bericht implements Serializable {
    Date datum;
    String diagnose;
    String weiteresVorgehen;

    public Bericht(Date datum, String diagnose, String weiteresVorgehen) {
        this.datum = datum;
        this.diagnose = diagnose;
        this.weiteresVorgehen = weiteresVorgehen;
    }
}
