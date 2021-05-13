package verteilte_systeme.uebung_06;

import java.util.Date;

import verteilte_systeme.uebung_05.interfaces.IRoentgenbild;

public class Roentgenbild implements IRoentgenbild {
    Date aufnahmeVom;
    Byte[] rawData;

    // Do not serialize
    transient String patientenName;

    public Roentgenbild(Date aufnahmeVon, String patientenName, Byte[] rawData) {
        this.aufnahmeVom = aufnahmeVon;
        this.patientenName = patientenName;
    }

    public String getPatientenName() {
        return patientenName;
    }
}
