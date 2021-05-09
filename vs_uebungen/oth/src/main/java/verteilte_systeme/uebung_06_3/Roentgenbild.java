package verteilte_systeme.uebung_06_3;

import java.rmi.RemoteException;
import java.util.Date;

import verteilte_systeme.uebung_06_3.interfaces.IRoentgenbild;

public class Roentgenbild implements IRoentgenbild {
    Date aufnahmeVom;
    Byte[] rawData;

    // Do not serialize
    transient String patientenName;

    public Roentgenbild(Date aufnahmeVon, String patientenName, Byte[] rawData) {
        this.aufnahmeVom = aufnahmeVon;
        this.patientenName = patientenName;
    }

    @Override
    public String getPatientenName() throws RemoteException {
        return patientenName;
    }

    @Override
    public Date getDate() throws RemoteException {
        return aufnahmeVom;
    }
}
