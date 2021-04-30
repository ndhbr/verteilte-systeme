package verteilte_systeme.uebung_05;

import java.io.Serializable;
import java.util.Date;

public class Roentgenbild implements Serializable {
    Date aufnahmeVom;
    Byte[] rawData;

    // Do not serialize
    transient String patientenName;

    public Roentgenbild(Date aufnahmeVon, String patientenName, Byte[] rawData) {
        this.aufnahmeVom = aufnahmeVon;
        this.patientenName = patientenName;
    }
}
