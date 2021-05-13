package verteilte_systeme.uebung_06_2.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface IRoentgenbild extends Remote {
    String getPatientenName() throws RemoteException;
    Date getDate() throws RemoteException;
}
