package verteilte_systeme.uebung_06_3.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBericht extends Remote {
    public String getWeiteresVorgehen() throws RemoteException;
}
