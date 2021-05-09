package verteilte_systeme.uebung_05.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRoentgenbild extends Remote {
    String getPatientenName() throws RemoteException;
}
