package verteilte_systeme.uebung_06_3;

import java.rmi.RemoteException;
import java.util.Date;

import verteilte_systeme.uebung_06_3.interfaces.IBericht;

public class Bericht implements IBericht {
    Date datum;
    String diagnose;
    String weiteresVorgehen;

    public Bericht(Date datum, String diagnose, String weiteresVorgehen) {
        this.datum = datum;
        this.diagnose = diagnose;
        this.weiteresVorgehen = weiteresVorgehen;
    }

    @Override
    public String getWeiteresVorgehen() throws RemoteException {
        return weiteresVorgehen;
    }
}
